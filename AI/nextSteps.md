/*
 * nextSteps.md
 * Ryan Loiselle — Developer / Architect
 * GitHub Copilot — AI pair programmer / code generation
 * July 2025
 *
 * AI-assisted: Prioritised modernisation backlog assembled from codebase review;
 * reviewed and directed by Ryan Loiselle.
 */

# DSC — Next Steps Backlog

Numbered task list across four strategic phases.
Reference a task by number (e.g. "complete T06") to pick up where we left off.

Priority codes: **P0** = blocking / security critical · **P1** = high · **P2** = medium · **P3** = nice-to-have

---

## Phase 1 — Environment Modernisation

Target branch: `feat/modernize-stack`

| # | Priority | Task | Notes |
|---|----------|------|-------|
| T01 | P1 | Create `feat/modernize-stack` branch; add `docs/modernisation-plan.md` documenting the full tech delta | Java 8→21, Servlet 2.5→6.0, Hibernate 3→6, Tomcat 9→10.1, JSP→opt Jakarta |
| T02 | P1 | Upgrade project JDK target to Java 21 in `build.xml`; verify all code compiles | Temurin 21 available via `sdk install java 21-tem` |
| T03 | P1 | Migrate `javax.*` imports → `jakarta.*` across all servlet and ORM classes | ~60 files; sed script candidate |
| T04 | P1 | Upgrade Hibernate ORM 3.x → 6.x; replace `hibernate.cfg.xml` legacy dialect with `org.hibernate.dialect.MySQLDialect` | Remove deprecated `hibernatemapping` XML; switch to annotation-only entity config |
| T05 | P2 | Replace Visual Paradigm–generated DAO boilerplate with Jakarta Persistence (`@Entity`, `@OneToMany`, etc.) annotations directly on domain classes | Removes dependency on VP generator |
| T06 | P2 | Upgrade Tomcat 9 → Tomcat 10.1 (required for Jakarta EE 10 / Servlet 6.0) | Co-ordinate with `javax→jakarta` migration; update `build.xml` classpath |
| T07 | P2 | Evaluate Spring Boot 3.x migration path as an alternative to standalone Tomcat | Document decision in `docs/modernisation-plan.md`; proceed only with Ryan's approval |
| T08 | P3 | Replace Ant `build.xml` with Maven or Gradle build | Enables standard dependency management; prerequisite for CI/CD |

---

## Phase 2 — Security

These tasks address real vulnerabilities in the current codebase. **T09 and T15 are critical — do not ship without them.**

| # | Priority | Task | Notes |
|---|----------|------|-------|
| T09 | P0 | **Hash passwords.** `user_auth.password` is currently stored as plaintext. Implement BCrypt (jBCrypt library) in `LoginServlet` verify path and add a one-time migration script | Add `jbcrypt-0.4.jar` to `WEB-INF/lib`; update `LoginServlet.doPost()` |
| T10 | P0 | **Regenerate session ID on login** (`request.getSession(false).invalidate(); request.getSession(true)`) to prevent session fixation | `LoginServlet` — one-line fix with high impact |
| T11 | P1 | Add CSRF tokens to all POST forms (hidden field generated in servlet, validated on submit) | ~7 forms across activity, project, admin JSPs |
| T12 | P1 | Set `HttpOnly` and `Secure` flags on the session cookie in `web.xml` (`<session-config><cookie-config>`) | Prevents JS cookie theft |
| T13 | P1 | Server-side input validation and output escaping on all servlet parameters (prevent SQLi / XSS) | Review all `request.getParameter()` calls; add `ESAPI` or manual sanitisation |
| T14 | P1 | Formalise role constants and enforce them in `DSCFilter` (or equivalent `Filter`) rather than per-servlet if-checks | Define `Role.EMPLOYEE=1`, `Role.MANAGER=2`, `Role.ADMIN=3` enum |
| T15 | P0 | **Remove all plaintext credentials from committed config files.** `DSC.cfg.xml` / `database.cfg.xml` must source values from environment variables only | Already partially addressed with `EnvironmentConfigListener`; audit all remaining hard-coded strings |
| T16 | P2 | Add account lock-out after N failed login attempts (in-memory counter per username sufficient initially) | Prevents brute-force on web-facing instances |
| T17 | P2 | Enforce HTTPS redirect at the container / ingress level; update Containerfile HEALTHCHECK and Route TLS accordingly | BC Gov Emerald standard: TLS edge termination on Route |

---

## Phase 3 — CI/CD to OpenShift Emerald

Target: one container image per component, deployed via GitOps to Emerald dev/test/prod.

| # | Priority | Task | Notes |
|---|----------|------|-------|
| T18 | P1 | Write `Containerfile` for the WAR (Tomcat 10.1 base image on port 8080) | Follow BC Gov standards: non-root `appuser`, `HEALTHCHECK /health`, `cap_drop: ALL` |
| T19 | P1 | Write GitHub Actions workflow: compile → unit test → build WAR → build image → push to Artifactory | Image tag: `artifacts.developer.gov.bc.ca/<license>/dsc-app:<git-sha>` |
| T20 | P1 | Write `Containerfile` for MySQL init (seed SQL + schema DDL as init scripts) | Alternatively use an external managed DB on Emerald and supply `DATABASE_URL` via Vault |
| T21 | P1 | Create Helm chart (`helm/dsc-app/`) with: `Deployment`, `Service` (ClusterIP), `Route` (TLS edge), `ConfigMap`, `Secret` shape, `NetworkPolicy`, resource limits | Follow Emerald Helm standards from `CODING_STANDARDS.md` §Deployment |
| T22 | P2 | Create GitOps repo (`dsc-gitops`) with ArgoCD `Application` CRDs for dev/test/prod | `syncPolicy.automated.selfHeal: true; prune: true` |
| T23 | P2 | Integrate Vault secret references (`secretKeyRef` from Vault-injected secret) for DB credentials, replacing env-var placeholders | Vault path: `secret/<license>/dsc/<env>/db` |
| T24 | P2 | Add GitHub Actions status badges to `README.md` | Tracks build health visibly |
| T25 | P3 | Add Trivy container image scan step to GitHub Actions workflow | Fail build on HIGH/CRITICAL CVEs |

---

## Phase 4 — Feature Enhancements

**Preserve the existing Activity page design and workflow** — these tasks extend or improve supporting features only.

| # | Priority | Task | Notes |
|---|----------|------|-------|
| T26 | P2 | **Self-serve password change.** Add `/ChangePasswordServlet` + `changepassword.jsp` — user enters current + new password; servlet validates and updates `user_auth` (BCrypt) | Prerequisite: T09 (password hashing) must be complete |
| T27 | P2 | **User profile update.** Allow employees to update their own email and display name via a new `/ProfileServlet` + `profile.jsp` | Admin retains ability to change any user |
| T28 | P2 | **Enhanced weekly report.** Add date-range picker to `weekly-report.jsp` and `weekly-report-user.jsp`; export to CSV via a new `/ExportReportServlet` | Backend: add date-range parameter to `UserReportGenerator` and `ManagerReportGenerator` |
| T29 | P2 | **Project budget vs. actual.** Add running totals (planned hours vs. actual hours) to `ProjectServlet` and `project.jsp` | Aggregate query on `activity` joined to `project_activity` |
| T30 | P3 | **Admin dashboard.** Consolidate user/dept/position management into a single `/AdminServlet` landing page with tab navigation | Currently separate servlet per entity — landing page only, not a full SPA refactor |
| T31 | P3 | **Calendar-aware entry.** Highlight weekends and statutory holidays on the date picker using the `calendar_category` data already in the DB | Calendar data `type=0` = non-work; surface as disabled dates in the JS calendar widget |
| T32 | P3 | **Activity summary widget.** Display total hours this week vs. standard hours on the activity page header | Read `plannedDuration` sum for current ISO week; compare to configurable weekly target |
| T33 | P3 | **Supervisor delegation.** Activate the existing `user_user` (supervisor/subordinate) table: managers see their direct reports' weekly totals on the manager report without manual department filtering | `UserReportGenerator` extension |

---

## How to Continue

To action a task in a future session, say:

> "Please complete **T09** — hash passwords."

The agent will pick up from this file, implement the task, and append to `AI/WORKLOG.md` and `AI/CHANGES.csv` on completion.
