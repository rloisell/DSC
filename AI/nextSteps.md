# Work Plan & Todo List — DSC (Java Legacy)

**Author**: Ryan Loiselle — Developer / Architect
**AI tool**: GitHub Copilot — AI pair programmer / code generation
**Updated**: February 2026

> **Structure**: Master TODO is always the first section — scan it at the start of every session.
> Session history follows in reverse chronological order (newest first). See `AI/WORKLOG.md` for
> full session narratives. Status: ✅ = done, ⬜ = pending.

---

## 📋 MASTER TODO

> Tasks are numbered T01–T33 for backward compatibility.
> Reference by number in a session prompt (e.g. "complete T09") to pick up where we left off.
>
> Priority codes: **P0** = blocking / security critical · **P1** = high · **P2** = medium · **P3** = nice-to-have

---

### 🟥 Tier 1 (Phase 1) — Environment Modernisation

Target branch: `feat/modernize-stack`

| Status | # | Priority | Task | Notes |
|--------|---|----------|------|-------|
| ⬜ | T01 | P1 | Create `feat/modernize-stack` branch; add `docs/modernisation-plan.md` | Java 8→21, Servlet 2.5→6.0, Hibernate 3→6, Tomcat 9→10.1, JSP→opt Jakarta |
| ⬜ | T02 | P1 | Upgrade project JDK target to Java 21 in `build.xml`; verify all code compiles | Temurin 21 via `sdk install java 21-tem` |
| ⬜ | T03 | P1 | Migrate `javax.*` imports → `jakarta.*` across all servlet and ORM classes | ~60 files; sed script candidate |
| ⬜ | T04 | P1 | Upgrade Hibernate ORM 3.x → 6.x; replace `hibernate.cfg.xml` legacy dialect | Remove deprecated `hibernate-mapping` XML; switch to annotation-only entity config |
| ⬜ | T05 | P2 | Replace Visual Paradigm–generated DAO boilerplate with Jakarta Persistence annotations | Removes dependency on VP generator |
| ⬜ | T06 | P2 | Upgrade Tomcat 9 → Tomcat 10.1 (required for Jakarta EE 10 / Servlet 6.0) | Co-ordinate with `javax→jakarta` migration |
| ⬜ | T07 | P2 | Evaluate Spring Boot 3.x migration path as alternative to standalone Tomcat | Document decision; proceed only with Ryan's approval |
| ⬜ | T08 | P3 | Replace Ant `build.xml` with Maven or Gradle build | Prerequisite for CI/CD |

---

### 🟥 Tier 2 (Phase 2) — Security

**T09 and T15 are critical — do not ship without them.**

| Status | # | Priority | Task | Notes |
|--------|---|----------|------|-------|
| ⬜ | T09 | P0 | **Hash passwords.** `user_auth.password` currently plaintext. Implement BCrypt in `LoginServlet` + one-time migration script | Add `jbcrypt-0.4.jar` to `WEB-INF/lib` |
| ⬜ | T10 | P0 | **Regenerate session ID on login** to prevent session fixation | `LoginServlet` — one-line fix |
| ⬜ | T11 | P1 | Add CSRF tokens to all POST forms | ~7 forms across activity, project, admin JSPs |
| ⬜ | T12 | P1 | Set `HttpOnly` and `Secure` flags on session cookie in `web.xml` | Prevents JS cookie theft |
| ⬜ | T13 | P1 | Server-side input validation and output escaping on all servlet parameters | Review all `request.getParameter()` calls; add ESAPI or manual sanitisation |
| ⬜ | T14 | P1 | Formalise role constants and enforce in `DSCFilter` | Define `Role.EMPLOYEE=1`, `Role.MANAGER=2`, `Role.ADMIN=3` enum |
| ⬜ | T15 | P0 | **Remove all plaintext credentials from committed config files.** `DSC.cfg.xml` / `database.cfg.xml` must source from env vars only | Audit all remaining hard-coded strings |
| ⬜ | T16 | P2 | Add account lock-out after N failed login attempts | Prevents brute-force; in-memory counter sufficient initially |
| ⬜ | T17 | P2 | Enforce HTTPS redirect at container / ingress level | BC Gov Emerald standard: TLS edge termination on Route |

---

### 🟧 Tier 3 (Phase 3) — CI/CD to OpenShift Emerald

| Status | # | Priority | Task | Notes |
|--------|---|----------|------|-------|
| ⬜ | T18 | P1 | Write `Containerfile` for the WAR (Tomcat 10.1 base image on port 8080) | Non-root `appuser`, `HEALTHCHECK /health`, `cap_drop: ALL` |
| ⬜ | T19 | P1 | Write GitHub Actions workflow: compile → test → build WAR → build image → push to Artifactory | Tag: `artifacts.developer.gov.bc.ca/<license>/dsc-app:<git-sha>` |
| ⬜ | T20 | P1 | Write `Containerfile` for MySQL init (seed SQL + schema DDL as init scripts) | Alternatively use managed DB on Emerald + Vault `DATABASE_URL` |
| ⬜ | T21 | P1 | Create Helm chart (`helm/dsc-app/`) with Deployment, Service, Route, ConfigMap, Secret shape, NetworkPolicy, resource limits | Follow Emerald Helm standards from `CODING_STANDARDS.md` §9 |
| ⬜ | T22 | P2 | Create GitOps repo (`dsc-gitops`) with ArgoCD Application CRDs for dev/test/prod | `syncPolicy.automated.selfHeal: true; prune: true` |
| ⬜ | T23 | P2 | Integrate Vault secret references for DB credentials | Vault path: `secret/<license>/dsc/<env>/db` |
| ⬜ | T24 | P2 | Add GitHub Actions status badges to `README.md` | |
| ⬜ | T25 | P3 | Add Trivy container image scan step to GitHub Actions | Fail on HIGH/CRITICAL CVEs |

---

### 🔲 Tier 4 (Phase 4) — Feature Enhancements

**Preserve the existing Activity page design and workflow — these tasks extend or improve supporting features only.**

| Status | # | Priority | Task | Notes |
|--------|---|----------|------|-------|
| ⬜ | T26 | P2 | Self-serve password change — `/ChangePasswordServlet` + `changepassword.jsp` | Prerequisite: T09 (password hashing) |
| ⬜ | T27 | P2 | User profile update — allow employees to update own email/display name | Admin retains ability to change any user |
| ⬜ | T28 | P2 | Enhanced weekly report — date-range picker + CSV export | Add date-range param to `UserReportGenerator` and `ManagerReportGenerator` |
| ⬜ | T29 | P2 | Project budget vs. actual — running totals on `ProjectServlet` / `project.jsp` | Aggregate query on `activity` joined to `project_activity` |
| ⬜ | T30 | P3 | Admin dashboard — single `/AdminServlet` landing page with tab navigation | Landing page only, not a full SPA refactor |
| ⬜ | T31 | P3 | Calendar-aware entry — highlight weekends and statutory holidays | `calendar_category type=0` = non-work; surface as disabled dates in JS calendar widget |
| ⬜ | T32 | P3 | Activity summary widget — total hours this week vs. standard hours on activity page header | Read `plannedDuration` sum for current ISO week |
| ⬜ | T33 | P3 | Supervisor delegation — activate `user_user` table; managers see direct reports' weekly totals | `UserReportGenerator` extension |

---

### How to continue

To action a task in a future session:
> "Please complete **T09** — hash passwords."

The agent will pick up from this file, implement the task, and append to `AI/WORKLOG.md` and `AI/CHANGES.csv` on completion.

---

## 📅 Session History (most recent first)

---

### 2026-02-22 — Document restructure

**Commits:** (pending — part of docs update batch)

**Files changed:** `AI/nextSteps.md`, `CODING_STANDARDS.md`, `.github/copilot-instructions.md` — restructured to follow new standard (Master TODO first with Status column, session history reversed/newest first).

**Key decisions:**
- Adopted unified nextSteps.md structure across DSC and DSC-modernization repos
- All tier tables now have `Status` as first column with ⬜/✅ checkboxes
- Session history is reverse-chronological (newest entry prepended at top)
- Document capped at ~600 lines; narrative details belong in `AI/WORKLOG.md`

---

### Earlier Sessions — February 2026

**Session 5** (`6a2b070`): Resolved ERD parse errors — varchar replaces reserved `string`; PK_FK → PK.

**Session 4** (`f31ab6d`): Updated `COMMIT_INFO.txt` with Session 5 hash.

**Session 3** (`0281a93`): Completed UML diagram suite and added initial next steps backlog.

*See `AI/WORKLOG.md` for full session narratives and `AI/CHANGES.csv` for per-file change log.*
