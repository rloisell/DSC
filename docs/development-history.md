# Development History

This file captures session-by-session notes so the root README can stay focused
on the product, not the build process.

For detailed command history and decision logs, see `AI/WORKLOG.md`.

---

## Session 1 — 2026-02-21

**Objective**: Establish local dev environment, DB isolation, and initial deployment.

### What was completed
- Installed Java 8 (Temurin), Ant, Tomcat 9, and set up a custom MySQL 8 instance on port `4306`
  using a dedicated LaunchAgent to isolate it from any system MariaDB on `3306`.
- Created `scripts/DSC_mysql8.ddl` — MySQL 8-compatible schema for all 24 tables.
- Created `src/mts/dsc/test/ModernSeedData.java` — ORM-based seeder populating Users, Categories,
  Activities, Projects, Budgets, and all lookup tables.
- Added `src/mts/dsc/utilities/EnvironmentConfigListener.java` — reads DB connection details from
  environment variables (`DB_HOST`, `DB_PORT`, `DB_NAME`, etc.) injected via Tomcat `setenv.sh`.
- Fixed `WEB-INF/web.xml` welcome-file entries.
- Applied coding standards: `.github/copilot-instructions.md`, `CODING_STANDARDS.md`, `docs/`.

### Files changed
- `scripts/DSC_mysql8.ddl` *(new)*
- `src/mts/dsc/test/ModernSeedData.java` *(new)*
- `src/mts/dsc/utilities/EnvironmentConfigListener.java` *(new)*
- `WebContent/WEB-INF/web.xml`
- `.github/copilot-instructions.md` *(new)*
- `CODING_STANDARDS.md` *(new)*
- `docs/local-development/README.md` *(new)*
- `docs/development-history.md` *(new)*

---

## Session 2 — 2026-02-21

**Objective**: Diagnose and fix login authentication failure (POST → login.jsp loop).

### Root causes found and fixed

#### 1. Wrong DB name and missing port in `DSC.cfg.xml`
The Hibernate connection URL was `jdbc:mysql://localhost/dscdev` — no port (defaulted to 3306,
hitting MariaDB instead of MySQL 8 on 4306), and the wrong database name (`dscdev` vs `dsc`).  
**Fix**: `jdbc:mysql://localhost:4306/dsc?useSSL=false&amp;characterEncoding=UTF-8`

Files updated:
- `src/ormmapping/DSC.cfg.xml`
- `WebContent/WEB-INF/src/ormmapping/DSC.cfg.xml`
- `WebContent/WEB-INF/classes/ormmapping/DSC.cfg.xml`

Also corrected `setenv.sh` (deployment artifact): `DB_NAME=dscdev` → `DB_NAME=dsc`.

#### 2. `orm.jar` bundles an incompatible MySQL driver
`orm.jar` contains MySQL connector classes built in 2009. MySQL 8's default collation
(`utf8mb4_0900_ai_ci`) returns charset index `255` on connection, which the ancient driver
cannot handle (`Unknown initial character set index '255'`).

**Fix**: Added `mysql-connector-java-5.1.45-bin.jar` to `WebContent/WEB-INF/lib/` root.  
Tomcat's classloader loads JARs alphabetically — `m` before `o` — so 5.1.45 shadows the
bundled driver inside `orm.jar`.

File added: `WebContent/WEB-INF/lib/mysql-connector-java-5.1.45-bin.jar`

#### 3. `LoginServlet` broken session gate
The original `doGet` method had a three-branch session check:
1. No session → create session + redirect to login.jsp
2. Session exists but no `visited` attribute → invalidate + redirect to login.jsp
3. Session with `visited=true` → evaluate credentials

A direct browser POST from `login.jsp` always hit branch 1 (no cookies sent on first request),
creating a new session and redirecting back to login without ever checking the credentials.

**Fix**: Rewrote `doGet` with credential-first logic — if `username` and `password` parameters
are present, authenticate immediately regardless of session state. Also fixed hardcoded port
`8081` → `8080` in the success redirect.

Files updated:
- `src/mts/dsc/servlet/LoginServlet.java`
- `WebContent/WEB-INF/src/mts/dsc/servlet/LoginServlet.java`
- `WebContent/WEB-INF/classes/mts/dsc/servlet/LoginServlet.class`

### Verification
```bash
curl -s -v -X POST \
  -d "username=rloisel1&password=test-password" \
  http://localhost:8080/DSC/LoginServlet
# Result: HTTP/1.1 302 → Location: http://localhost:8080/DSC/ActivityServlet ✅

curl -L -s http://localhost:8080/DSC/ActivityServlet ... | grep '<title>'
# Result: <title>Activities</title> ✅
```

### Commits
- `27c68c9` — fix: resolve login authentication for MySQL 8 local dev


