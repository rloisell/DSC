/*
 * EnvironmentConfigListener.java
 * Ryan Loiselle — Developer / Architect
 * GitHub Copilot — AI pair programmer / code generation
 * February 2026
 *
 * AI-assisted: reads DB connection env vars (DB_URL, DB_HOST, DB_PORT, DB_NAME, DB_USER,
 * DB_PASSWORD) at webapp startup and applies them to DSCPersistentManager before the ORM
 * is first accessed; reviewed and directed by Ryan Loiselle.
 */
package mts.dsc.utilities;

import java.util.Properties;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import mts.dsc.orm.department_user.DSCPersistentManager;
import org.orm.PersistentException;

public class EnvironmentConfigListener implements ServletContextListener {
	private static final String ENV_DB_URL = "DB_URL";
	private static final String ENV_DB_USER = "DB_USER";
	private static final String ENV_DB_PASSWORD = "DB_PASSWORD";
	private static final String ENV_DB_HOST = "DB_HOST";
	private static final String ENV_DB_PORT = "DB_PORT";
	private static final String ENV_DB_NAME = "DB_NAME";

	// ── LIFECYCLE ─────────────────────────────────────────────────────────────

	// reads DB env vars and sets Hibernate connection properties before first ORM use;
	// no-ops silently if no env vars are set (falls back to DSC.cfg.xml values)
	@Override
	public void contextInitialized(ServletContextEvent event) {
		Properties properties = new Properties();
		String url = getEnv(ENV_DB_URL);
		String user = getEnv(ENV_DB_USER);
		String password = getEnv(ENV_DB_PASSWORD);
		String host = getEnv(ENV_DB_HOST);
		String port = getEnv(ENV_DB_PORT);
		String name = getEnv(ENV_DB_NAME);

		if (url == null) {
			url = buildJdbcUrl(host, port, name);
		}

		if (url != null) {
			properties.setProperty("connection.url", url);
		}
		if (user != null) {
			properties.setProperty("connection.username", user);
		}
		if (password != null) {
			properties.setProperty("connection.password", password);
		}

		if (properties.isEmpty()) {
			return;
		}

		try {
			DSCPersistentManager.setHibernateProperties(properties);
		} catch (PersistentException e) {
			throw new IllegalStateException("Failed to apply DB environment overrides", e);
		}
	} // end contextInitialized

	// no-op on shutdown to avoid triggering ORM initialisation during container teardown
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// No-op: avoid instantiating the persistent manager during shutdown.
	} // end contextDestroyed

	// ── HELPERS ───────────────────────────────────────────────────────────────

	// returns the trimmed env var value, or null if unset or blank
	private static String getEnv(String name) {
		String value = System.getenv(name);
		if (value == null) {
			return null;
		}
		value = value.trim();
		return value.isEmpty() ? null : value;
	} // end getEnv

	// builds a JDBC URL from individual host/port/name components;
	// returns null if name is not set; defaults host=localhost, port=4306
	private static String buildJdbcUrl(String host, String port, String name) {
		if (name == null) {
			return null;
		}
		String resolvedHost = host == null ? "localhost" : host;
		String resolvedPort = port == null ? "4306" : port;
		return "jdbc:mysql://" + resolvedHost + ":" + resolvedPort + "/" + name
				+ "?useSSL=false&characterEncoding=UTF-8";
	} // end buildJdbcUrl

} // end EnvironmentConfigListener
