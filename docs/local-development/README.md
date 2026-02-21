# Local Development Setup

> This document covers the macOS local environment for the DSC legacy Java webapp.  
> All services run via Homebrew on the developer's machine; no Docker is used.

---

## Prerequisites

| Tool | Version | Install |
|------|---------|---------|
| Java | 8 (Temurin) | `brew install --cask temurin@8` |
| Ant | 1.10+ | `brew install ant` |
| Tomcat | 9.x | `brew install tomcat@9` |
| MySQL | 8.0 | Custom launchd instance — see below |

Verify:
```bash
/usr/libexec/java_home -v 1.8   # should print temurin-8 path
ant -version
brew services list | grep tomcat
```

---

## Services & Ports

| Service | Port | Start Command |
|---------|------|---------------|
| Tomcat 9 | `8080` | `brew services start tomcat@9` |
| MySQL 8 (DSC db) | `4306` | `launchctl load -w ~/Library/LaunchAgents/com.local.mysql8.plist` |

> MySQL 8 runs on a **separate data directory and port** (`4306`) to avoid conflicts with
> any system MariaDB/MySQL on `3306`. It is managed by a custom LaunchAgent, not `brew services`.

---

## MySQL 8 Setup

### Start / stop

```bash
# Start
launchctl load -w ~/Library/LaunchAgents/com.local.mysql8.plist

# Stop
launchctl unload ~/Library/LaunchAgents/com.local.mysql8.plist

# Connect (root, via socket)
/opt/homebrew/opt/mysql@8.0/bin/mysql \
  -u root --protocol=socket --socket=/opt/homebrew/var/mysql8/mysql8.sock
```

### Create the database and user (first-time only)

```sql
CREATE DATABASE IF NOT EXISTS dsc
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

CREATE USER IF NOT EXISTS 'dscdev'@'localhost' IDENTIFIED BY '<local-dev-password>';
GRANT ALL PRIVILEGES ON dsc.* TO 'dscdev'@'localhost';
FLUSH PRIVILEGES;
```

### Load schema

```bash
/opt/homebrew/opt/mysql@8.0/bin/mysql \
  -u dscdev -p \
  --protocol=socket --socket=/opt/homebrew/var/mysql8/mysql8.sock \
  dsc < scripts/DSC_mysql8.ddl
```

Use `scripts/DSC_mysql8.ddl` — the MySQL 8-compatible DDL (all 24 tables).  
Do **not** use the legacy `DSC.ddl` in the project root (Oracle/Sybase-era syntax).

### Run seed data

```bash
# Compile
/Library/Java/JavaVirtualMachines/temurin-8.jdk/Contents/Home/bin/javac \
  -encoding UTF-8 \
  -cp "lib/mysql-connector-java-5.1.7/mysql-connector-java-5.1.7-bin.jar:\
lib/commons-logging.jar:lib/dom4j-1.6.1.jar:lib/hibernate3.jar:lib/orm.jar:\
build/classes" \
  -d build/classes \
  src/mts/dsc/test/ModernSeedData.java

# Run
/Library/Java/JavaVirtualMachines/temurin-8.jdk/Contents/Home/bin/java \
  -cp "lib/mysql-connector-java-5.1.7/mysql-connector-java-5.1.7-bin.jar:\
lib/commons-logging.jar:lib/dom4j-1.6.1.jar:lib/hibernate3.jar:lib/orm.jar:\
build/classes" \
  mts.dsc.test.ModernSeedData
```

Expected row counts after seeding:

| Table | Rows |
|-------|------|
| User | 4 |
| Category | 5 |
| Activity | 5 |
| Project | 8 |
| Budget | 2 |

---

## Tomcat Configuration

### setenv.sh

Tomcat reads DB connection details from `setenv.sh`. This file is a **deployment artifact**
and must be created/updated manually if Tomcat is ever reinstalled or upgraded.

**Path:**
```
/opt/homebrew/Cellar/tomcat@9/<version>/libexec/bin/setenv.sh
```
(symlinked at `/opt/homebrew/opt/tomcat@9/libexec/bin/setenv.sh`)

**Required content:**
```bash
#!/bin/sh

export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)

export DB_HOST=localhost
export DB_PORT=4306
export DB_NAME=dsc
export DB_USER=dscdev
export DB_PASSWORD=<local-dev-password>
export DB_URL="jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_NAME}?useSSL=false&characterEncoding=UTF-8"
```

> **`characterEncoding=UTF-8` is required.** MySQL 8's default collation
> (`utf8mb4_0900_ai_ci`) returns charset index `255` on connect. The driver bundled
> inside `orm.jar` (2009-era) cannot parse this and throws
> `Unknown initial character set index '255'`. This parameter forces the handshake to
> use UTF-8 regardless of server charset negotiation.

### MySQL driver (WEB-INF/lib)

`orm.jar` bundles an ancient MySQL JDBC driver (circa 2009) incompatible with MySQL 8.
To override it, `mysql-connector-java-5.1.45-bin.jar` is placed directly in
`WebContent/WEB-INF/lib/`. Tomcat's classloader loads JARs alphabetically — `m` sorts
before `o` — so the 5.1.45 driver class is found first, shadowing the one inside `orm.jar`.

**Do not remove `WebContent/WEB-INF/lib/mysql-connector-java-5.1.45-bin.jar`.**

---

## ORM Connection Config

The Hibernate connection URL lives in `src/ormmapping/DSC.cfg.xml` and must match `setenv.sh`:

```xml
<property name="connection.url">
  jdbc:mysql://localhost:4306/dsc?useSSL=false&amp;characterEncoding=UTF-8
</property>
```

All copies must stay in sync:

| Copy | Purpose |
|------|---------|
| `src/ormmapping/DSC.cfg.xml` | Source of record |
| `WebContent/WEB-INF/src/ormmapping/DSC.cfg.xml` | WebContent mirror |
| `WebContent/WEB-INF/classes/ormmapping/DSC.cfg.xml` | Runtime classpath copy |

---

## Build & Deploy (Exploded WAR)

```bash
# 1. Compile
JAVA_HOME=$(/usr/libexec/java_home -v 1.8) \
  ant -f build-dbva.xml clean compile

# 2. Sync classes into WebContent
mkdir -p WebContent/WEB-INF/classes
rsync -a --delete build/classes/ WebContent/WEB-INF/classes/

# 3. Deploy to Tomcat
mkdir -p /opt/homebrew/opt/tomcat@9/libexec/webapps/DSC
rsync -a --delete WebContent/ /opt/homebrew/opt/tomcat@9/libexec/webapps/DSC/

# 4. Restart Tomcat
brew services restart tomcat@9
```

### Recompile a single servlet (faster for iterating)

```bash
/Library/Java/JavaVirtualMachines/temurin-8.jdk/Contents/Home/bin/javac \
  -encoding UTF-8 \
  -cp "lib/servlet-api.jar:\
lib/mysql-connector-java-5.1.7/mysql-connector-java-5.1.7-bin.jar:\
lib/commons-logging.jar:lib/dom4j-1.6.1.jar:lib/hibernate3.jar:lib/orm.jar:\
build/classes" \
  -d build/classes \
  src/mts/dsc/servlet/SomeServlet.java

cp build/classes/mts/dsc/servlet/SomeServlet.class \
   /opt/homebrew/Cellar/tomcat@9/9.0.115/libexec/webapps/DSC/WEB-INF/classes/mts/dsc/servlet/

brew services restart tomcat@9
```

---

## Test Credentials

All local seed users share the password `test-password`:

| Username | Employee ID | Role | Notes |
|----------|------------|------|-------|
| `rloisel1` | 15298 | Employee (`-1`) | Primary dev test account |
| `dmcgregor` | 10101 | Manager (`2`) | Manager-flow testing |
| `kduma` | 15299 | Employee (`1`) | `deptProd` department head |
| `mammeter` | 99901 | Employee (`1`) | Additional test user |

---

## Smoke Tests

| URL | Expected Result |
|-----|----------------|
| `http://localhost:8080/DSC/` | Redirects to login |
| `http://localhost:8080/DSC/jsp/login.jsp` | Login form renders |
| POST `LoginServlet` with valid creds | `302 → ActivityServlet` |
| `http://localhost:8080/DSC/ActivityServlet` | Activities page (requires session) |

Quick CLI test:
```bash
curl -s -v -X POST \
  -d "username=rloisel1&password=test-password" \
  http://localhost:8080/DSC/LoginServlet
# Expect: HTTP/1.1 302 / Location: http://localhost:8080/DSC/ActivityServlet
```

---

## Known Issues & Workarounds

| Issue | Root Cause | Workaround |
|-------|-----------|-----------|
| `Unknown initial character set index '255'` | `orm.jar` bundles a 2009 MySQL driver; MySQL 8 returns charset index 255 on connect | `mysql-connector-java-5.1.45-bin.jar` in `WEB-INF/lib/` root (loaded before `orm.jar`) |
| `GenericJDBCException: Cannot open connection` | Wrong port/DB name in `DSC.cfg.xml`, or missing `characterEncoding` | URL must be `localhost:4306/dsc?useSSL=false&characterEncoding=UTF-8` |
| MySQL 8 conflicts with system MariaDB | Both default to port 3306 | MySQL 8 runs on port `4306` with a separate data dir and dedicated LaunchAgent |
| `setenv.sh` lost after `brew upgrade tomcat@9` | Upgrade overwrites `libexec/bin/` | Re-create `setenv.sh` from the template above after any upgrade |
| Login always returns to `login.jsp` | Original `LoginServlet` had a session-gate bug requiring a pre-existing session | Fixed in commit `27c68c9` (credential-first auth) |
