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
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// No-op: avoid instantiating the persistent manager during shutdown.
	}

	private static String getEnv(String name) {
		String value = System.getenv(name);
		if (value == null) {
			return null;
		}
		value = value.trim();
		return value.isEmpty() ? null : value;
	}

	private static String buildJdbcUrl(String host, String port, String name) {
		if (name == null) {
			return null;
		}
		String resolvedHost = host == null ? "localhost" : host;
		String resolvedPort = port == null ? "3306" : port;
		return "jdbc:mysql://" + resolvedHost + ":" + resolvedPort + "/" + name;
	}
}
