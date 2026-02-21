# AI Worklog

Date: 2026-02-17 / 2026-02-18

Summary of automated actions performed by the assistant in this repository:

- Redacted plaintext database passwords in `src/ormmapping/DSC.cfg.xml`, `src/ormmapping/database.cfg.xml`, and `build/classes/ormmapping/database.cfg.xml`.
- Redacted hardcoded test passwords in `src/mts/dsc/test/SecondTest.java`.
- Deleted private key files under `*/src/testsuite/ssl-test-certs/` (PEM files).
- Added `.gitignore` to exclude `.pem` and `.env` files going forward.
- Added `SECRETS_README.md` with instructions to rotate credentials and scrub history.
- Performed a local git-history rewrite to remove deleted key files and replace secret strings.
- Created a backup branch `pre-scrub-backup` before rewriting history.
- Cleaned reflogs and ran `git gc` to purge removed objects.

Notes:
- No secret values were reintroduced into these files; placeholders were used instead.
- Immediately rotate any affected credentials and certificates.

2026-02-18 — Push and confirmation

- Assistant attempted to force-push rewritten history but the execution environment's terminal closed; user ran the push locally.
- User confirmed collaborators have been notified and credentials rotated.
- Rewritten history was force-pushed to the remote and `pre-scrub-backup` was pushed as a branch.

Recorded output (user-provided):

```
origin  https://github.com/rloisell/DSC.git (fetch)
origin  https://github.com/rloisell/DSC.git (push)
 M AI/CHANGES.csv
 M AI/COMMANDS.sh
 M AI/COMMIT_INFO.txt
 M AI/WORKLOG.md
?? scripts/
remote: Enumerating objects: 1287, done.
remote: Total 1287 (delta 0), reused 0 (delta 0), pack-reused 1287 (from 1)
Receiving objects: 100% (1287/1287), 27.59 MiB | 27.14 MiB/s, done.
Resolving deltas: 100% (586/586), done.
From https://github.com/rloisell/DSC
 + 2966b19...d472c63 master     -> origin/master  (forced update)
Enumerating objects: 1306, done.
Counting objects: 100% (1306/1306), done.
Delta compression using up to 14 threads
Compressing objects: 100% (555/555), done.
Writing objects: 100% (1306/1306), 21.15 MiB | 1.19 MiB/s, done.
Total 1306 (delta 675), reused 1298 (delta 674), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (675/675), done.
To https://github.com/rloisell/DSC.git
 + d472c63...b342d0a master -> master (forced update)
 * [new branch]      pre-scrub-backup -> pre-scrub-backup
Everything up-to-date
```

Action items completed: push succeeded, collaborators notified, credentials rotated.

---

## Session 2 — 2026-02-19

**Objective**: Get the local development environment fully operational (MySQL 8, Tomcat 9, Java 8)
and fix the broken login flow.

### Actions taken
- Diagnosed MySQL 8 connection failure: custom instance running on port 4306 with socket
  `/opt/homebrew/var/mysql8/mysql8.sock`; updated `DSC.cfg.xml` in all three locations.
- Added `mysql-connector-java-5.1.45-bin.jar` to `WebContent/WEB-INF/lib/` root to override
  the bundled 2009 driver via alphabetical classloader ordering (`m` before `o`).
- Created schema and seed data: 4 test employees, departments, projects, activity containers.
- Diagnosed login failure (three root causes): session gate before credential check, null
  `userName` from wrong param name, missing `useraccount` join on login query.
- Rewrote `LoginServlet.doGet()` with credential-first authentication logic.
- Created `EnvironmentConfigListener.java` — reads `DB_*` env vars and injects into
  `DSCPersistentManager` before first ORM access.
- Authored `setenv.sh` template for Tomcat startup env vars.
- Compiled and deployed all classes; smoke-tested end-to-end login.

### Files created or modified
- `src/ormmapping/DSC.cfg.xml` — updated JDBC URL to port 4306 with useSSL=false
- `src/mts/dsc/servlet/LoginServlet.java` — credential-first auth rewrite
- `src/mts/dsc/utilities/EnvironmentConfigListener.java` — created; DB env var injection
- `WebContent/WEB-INF/lib/mysql-connector-java-5.1.45-bin.jar` — added driver override
- Mirror copies of all above under `WebContent/WEB-INF/src/` and `WebContent/WEB-INF/classes/`

### Commits
- `dfd2f7b` — chore: initial local dev environment setup files
- `27c68c9` — fix: resolve login servlet authentication failures

### Outcomes / Notes
- Login works end-to-end for all four test users (rloisel1, dmcgregor, kduma, mammeter)
- ActivityServlet smoke test returns 200 after successful login

---

## Session 3 — 2026-02-20

**Objective**: Document all local environment work, create architecture diagrams, and open a PR.

### Actions taken
- Rewrote `docs/local-development/README.md` — complete 253-line guide covering all fixes,
  setenv.sh template, driver workaround, test credentials, smoke tests, known issues.
- Rewrote `README.md` — professional project overview with tech stack, quick start, repo
  structure, and branch strategy.
- Added Session 2 to `docs/development-history.md` with three root causes and verification commands.
- Created `docs/diagrams/README.md` with three Mermaid diagrams: system architecture,
  login sequence, and deployment topology.
- Committed as `9c34b1d`; pushed branch `chore/local-dev-env` to GitHub.
- Created PR #1 via GitKraken MCP: "chore: local dev environment setup and foundational fixes".
- Ran AI code review per CODING_STANDARDS.md §9.13; posted review to PR #1.
- Review identified 4 issues to fix (see Session 4).

### Files created or modified
- `docs/local-development/README.md` — complete rewrite
- `docs/development-history.md` — Session 2 added
- `docs/diagrams/README.md` — created with 3 Mermaid diagrams
- `README.md` — rewritten

### Commits
- `9c34b1d` — docs: complete local dev guide, diagrams, and project README

### Outcomes / Notes
- PR #1 open: https://github.com/rloisell/DSC/pull/1
- AI review posted: https://github.com/rloisell/DSC/pull/1#pullrequestreview-3836124235

---

## Session 4 — 2026-02-21

**Objective**: Implement all issues flagged in the AI review; make the AI directory mandatory
across this project and the template repo.

### Actions taken
- Fixed `buildJdbcUrl()` default port `"3306"` → `"4306"` in `EnvironmentConfigListener`.
- Added `useSSL=false&characterEncoding=UTF-8` to the built JDBC URL for consistency with
  `DSC.cfg.xml`.
- Added file header, per-method purpose comments, section labels, and
  `} // end EnvironmentConfigListener` per CODING_STANDARDS.md.
- Replaced hardcoded `http://localhost:8080/DSC/ActivityServlet` with
  `request.getContextPath() + "/ActivityServlet"` in `LoginServlet`.
- Added file header and `} // end LoginServlet` to `LoginServlet`.
- Generalised README branch strategy table to naming conventions rather than a specific branch.
- Recompiled both classes; deployed to Tomcat; smoke-tested (LoginServlet returned 302).
- Pushed commit `ef49e3d` to `chore/local-dev-env`.
- Made `AI/` directory mandatory in `CODING_STANDARDS.md` (§3 and §5) and
  `.github/copilot-instructions.md` in both DSC and `rl-project-template`.
- Created stub `AI/` directory in `rl-project-template` (WORKLOG.md, CHANGES.csv,
  COMMANDS.sh, COMMIT_INFO.txt).
- Updated this WORKLOG, CHANGES.csv, COMMANDS.sh, and COMMIT_INFO.txt with all sessions.

### Files created or modified
- `src/mts/dsc/utilities/EnvironmentConfigListener.java` — port fix + coding standards
- `src/mts/dsc/servlet/LoginServlet.java` — relative URL + coding standards
- `WebContent/WEB-INF/src/mts/dsc/utilities/EnvironmentConfigListener.java` — mirror sync
- `WebContent/WEB-INF/src/mts/dsc/servlet/LoginServlet.java` — mirror sync
- `README.md` — branch strategy generalised
- `CODING_STANDARDS.md` — AI/ mandatory (§3 and §5)
- `.github/copilot-instructions.md` — AI tracking added to ALWAYS
- `AI/WORKLOG.md` — this file (sessions 2–4 added)
- `AI/CHANGES.csv` — sessions 2–4 rows added
- `AI/COMMANDS.sh` — sessions 2–4 commands added
- `AI/COMMIT_INFO.txt` — sessions 2–4 commits added

### Commits
- `ef49e3d` — fix: address PR review issues and coding standards gaps
- Pending: commit for AI mandatory standard + worklog update

### Outcomes / Notes
- All four AI review issues resolved and deployed
- AI directory now mandatory in both repos per coding standards
