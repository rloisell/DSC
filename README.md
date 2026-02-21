# DSC — Daily Schedule Control

**Ryan Loiselle** — Developer / Architect  
**GitHub Copilot** — AI pair programmer / code generation  

---

## Overview

DSC (Daily Schedule Control) is a legacy Java EE web application for employee timesheet and
activity tracking. It is built on Servlet/JSP, Hibernate 3 ORM, and MySQL, deployed as an
exploded WAR on Apache Tomcat.

This repository is used as a study and modernisation platform — the codebase represents a
real-world legacy system with the goal of bringing it to a clean, documented, and
deployable state.

---

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 8 |
| Web tier | Java Servlets + JSP (Tomcat 9) |
| ORM | Hibernate 3 (via Visual Paradigm `orm.jar`) |
| Database | MySQL 8.0 |
| Build | Apache Ant (`build-dbva.xml`) |
| UI | HTML/CSS/JSP + legacy JS calendar widget |

---

## Documentation

| Document | Purpose |
|----------|---------|
| [docs/local-development/README.md](docs/local-development/README.md) | Full local environment setup, service config, known issues, test credentials |
| [docs/development-history.md](docs/development-history.md) | Session-by-session change log |
| [CODING_STANDARDS.md](CODING_STANDARDS.md) | Coding conventions and AI collaboration guardrails |
| [SECRETS_README.md](SECRETS_README.md) | Credential rotation instructions |

---

## Quick Start (macOS)

Prerequisites: Java 8 (Temurin), Ant, Tomcat 9, MySQL 8 on port 4306.  
See [docs/local-development/README.md](docs/local-development/README.md) for full setup.

```bash
# Build
JAVA_HOME=$(/usr/libexec/java_home -v 1.8) ant -f build-dbva.xml clean compile

# Deploy
rsync -a --delete WebContent/ /opt/homebrew/opt/tomcat@9/libexec/webapps/DSC/
brew services restart tomcat@9

# Smoke test
curl -s -o /dev/null -w "%{http_code}" http://localhost:8080/DSC/jsp/login.jsp
# Expected: 200
```

---

## Repository Structure

```
src/                  Java source — servlets, ORM entities, utilities
  mts/dsc/
    servlet/          HTTP request handlers
    employee/         Domain model classes
    orm/              Hibernate session management
    utilities/        Shared helpers
    test/             Development-time seed data (not compiled by Ant)
src/ormmapping/       Hibernate config and entity XML mappings
WebContent/           Deployable webapp root (WEB-INF, JSP, CSS, JS)
scripts/              DB DDL and utility scripts
docs/                 Project documentation
AI/                   Copilot session logs and work history
lib/                  Third-party JARs
```

---

## Branch Strategy

| Branch | Purpose |
|--------|---------|
| `master` | Stable baseline — no broken builds |
| `chore/local-dev-env` | Local environment setup and foundational fixes |

