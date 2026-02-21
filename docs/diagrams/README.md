# Architecture Diagrams

Ryan Loiselle — Developer / Architect  
GitHub Copilot — AI pair programmer / code generation  
February 2026

AI-assisted: Mermaid diagram markup generated from codebase analysis;
reviewed and directed by Ryan Loiselle.

---

## 1. System Architecture

High-level component view — browser through servlet layer to ORM and database.

```mermaid
graph TD
    Browser["🌐 Browser"]

    subgraph Tomcat9["Apache Tomcat 9 — :8080"]
        Login["LoginServlet"]
        Activity["ActivityServlet"]
        Project["ProjectServlet"]
        Admin["Admin Servlets"]
        JSP["JSP Views\n(login.jsp, activity.jsp, …)"]
    end

    subgraph ORM["ORM Layer"]
        PM["DSCPersistentManager\n(Hibernate SessionFactory)"]
        CFG["DSC.cfg.xml\nHibernate Config"]
        Entities["Entity Classes\n(Employee, Activity, Project, …)"]
    end

    subgraph DB["MySQL 8 — :4306"]
        Schema["dsc schema\n24 tables"]
    end

    Browser -->|"HTTP POST /LoginServlet"| Login
    Browser -->|"HTTP GET /ActivityServlet"| Activity
    Login --> PM
    Activity --> PM
    Project --> PM
    Admin --> PM
    PM --> CFG
    PM --> Entities
    PM -->|"JDBC via\nmysql-connector 5.1.45"| Schema
    Login --> JSP
    Activity --> JSP
```

---

## 2. Login Authentication Flow

Sequence diagram showing the fixed credential-first login path (post commit `27c68c9`).

```mermaid
sequenceDiagram
    participant Browser
    participant login.jsp
    participant LoginServlet
    participant DSCPersistentManager
    participant MySQL8

    Browser->>login.jsp: GET /DSC/jsp/login.jsp
    login.jsp-->>Browser: Render login form

    Browser->>LoginServlet: POST /DSC/LoginServlet<br/>(username, password)
    LoginServlet->>LoginServlet: Check username + password params present

    LoginServlet->>DSCPersistentManager: getSession()
    DSCPersistentManager->>MySQL8: JDBC connect (port 4306, charset UTF-8)
    MySQL8-->>DSCPersistentManager: Connection OK

    DSCPersistentManager->>MySQL8: HQL: SELECT user WHERE username=? AND password=?
    MySQL8-->>DSCPersistentManager: UserAccount row (or null)
    DSCPersistentManager-->>LoginServlet: UserAccount / null

    alt Credentials valid
        LoginServlet->>LoginServlet: Invalidate old session
        LoginServlet->>LoginServlet: Create new session, store UserAccount
        LoginServlet-->>Browser: 302 → /DSC/ActivityServlet
        Browser->>LoginServlet: GET /DSC/ActivityServlet (with session cookie)
        LoginServlet-->>Browser: 200 Activities page
    else Credentials invalid
        LoginServlet-->>Browser: 302 → /DSC/jsp/login.jsp?error=1
        login.jsp-->>Browser: Render form with error message
    end
```

---

## 3. Local Deployment Topology

How the macOS development services are wired together.

```mermaid
graph LR
    subgraph macOS["macOS — Developer Machine"]
        subgraph Homebrew["Homebrew Services"]
            Tomcat["tomcat@9\nbrew services\n:8080"]
        end

        subgraph LaunchAgent["LaunchAgents"]
            MySQL8["com.local.mysql8\n(custom data dir)\n:4306"]
        end

        subgraph Filesystem["Filesystem"]
            SetEnv["/opt/homebrew/Cellar/tomcat@9/…/bin/setenv.sh\nDB_HOST, DB_PORT, DB_NAME, DB_PASSWORD"]
            DSCCfg["src/ormmapping/DSC.cfg.xml\nHibernate connection URL"]
            WLIB["WebContent/WEB-INF/lib/\nmysql-connector-java-5.1.45-bin.jar\norm.jar"]
            WebApp["/opt/homebrew/…/webapps/DSC/\nexploded WAR"]
        end
    end

    Tomcat -->|reads| SetEnv
    Tomcat -->|serves| WebApp
    WebApp -->|classpath loads m before o| WLIB
    WebApp -->|reads at startup| DSCCfg
    WebApp -->|JDBC :4306| MySQL8
```

---

## Diagram Inventory

Status against the required full UML suite (see `CODING_STANDARDS.md` §7).

| # | Diagram | UML Type | Perspective | Status |
|---|---------|----------|-------------|--------|
| 1 | System architecture | Component | Structural | ✅ Done (above) |
| 2 | Domain class model | Class | Structural | ⏳ Pending |
| 3 | Package / module organisation | Package | Structural | ⏳ Pending |
| 4 | Use case overview | Use Case | Behavioural | ⏳ Pending |
| 5 | Login sequence | Sequence | Behavioural | ✅ Done (above) |
| 5b | Time entry / activity sequence | Sequence | Behavioural | ⏳ Pending |
| 5c | Admin CRUD sequence | Sequence | Behavioural | ⏳ Pending |
| 6 | Authentication workflow | Activity | Behavioural | ⏳ Pending |
| 7 | Session lifecycle | State | Behavioural | ⏳ Pending |
| 8 | Entity-Relationship Diagram (ERD) | ERD | Data | ⏳ Pending |
| 9 | Physical schema (24 tables) | Schema | Data | ⏳ Pending |
| 10 | Local deployment topology | Deployment | Infrastructure | ✅ Done (above) |

Pending diagrams should be added incrementally as features are developed.
The ERD and class diagram are the highest priority — they document the
existing domain model before the modernisation effort begins.
