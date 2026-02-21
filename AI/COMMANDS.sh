#!/bin/bash
# AI/COMMANDS.sh
# Record of significant shell commands run by the AI in this repository.
# Append one commented block per session. Do not remove previous entries.

# ── SESSION 1 — 2026-02-17/18 — Secrets scrub ────────────────────────────────

# Commit redaction changes locally
# git add -A
# git commit -m "chore(secrets): redact committed plaintext passwords and remove private keys"

# Create backup branch
# git branch pre-scrub-backup

# Remove files from history (using git-filter-repo)
# git-filter-repo --path lib/mysql-connector-java-5.1.7/src/testsuite/ssl-test-certs/server-key.pem --path ...

# Replace strings in history
# git filter-repo --replace-text replacements.txt

# Legacy filter-branch equivalent
# git filter-branch --force --index-filter 'git rm -r --cached --ignore-unmatch <paths..>' --prune-empty --tag-name-filter cat -- --all

# Clean up and gc
# rm -rf .git/refs/original/
# git reflog expire --expire=now --all
# git gc --prune=now --aggressive

# Verify remotes and force-push rewritten history (run locally after rotating credentials)
# git remote -v && git status --porcelain
# git fetch --all --prune
# git push --force --all && git push --force --tags

# NOTE: The agent attempted to run the push but the terminal closed; user ran it locally.

# ── SESSION 2 — 2026-02-19 — Local dev environment ───────────────────────────

# Compile EnvironmentConfigListener and LoginServlet
# javac -cp "build/classes:/opt/homebrew/Cellar/tomcat@9/9.0.115/libexec/lib/servlet-api.jar:WebContent/WEB-INF/lib/orm.jar" \
#   -d build/classes \
#   src/mts/dsc/utilities/EnvironmentConfigListener.java \
#   src/mts/dsc/servlet/LoginServlet.java

# Copy compiled classes to deployed webapp
# cp build/classes/mts/dsc/utilities/EnvironmentConfigListener.class \
#    /opt/homebrew/Cellar/tomcat@9/9.0.115/libexec/webapps/DSC/WEB-INF/classes/mts/dsc/utilities/
# cp build/classes/mts/dsc/servlet/LoginServlet.class \
#    /opt/homebrew/Cellar/tomcat@9/9.0.115/libexec/webapps/DSC/WEB-INF/classes/mts/dsc/servlet/

# Copy driver jar to lib root for classloader ordering fix
# cp WebContent/WEB-INF/lib/mysql-connector-java-5.1.45/mysql-connector-java-5.1.45-bin.jar \
#    /opt/homebrew/Cellar/tomcat@9/9.0.115/libexec/webapps/DSC/WEB-INF/lib/

# Restart Tomcat and smoke test
# brew services restart tomcat@9
# curl -s -o /dev/null -w "%{http_code}" http://localhost:8080/DSC/LoginServlet

# ── SESSION 4 — 2026-02-21 — Review fixes + AI mandatory ─────────────────────

# Recompile after review fixes
# javac -cp "build/classes:/opt/homebrew/Cellar/tomcat@9/9.0.115/libexec/lib/servlet-api.jar:WebContent/WEB-INF/lib/orm.jar" \
#   -d build/classes \
#   src/mts/dsc/utilities/EnvironmentConfigListener.java \
#   src/mts/dsc/servlet/LoginServlet.java

# Deploy and restart
# cp build/classes/mts/dsc/utilities/EnvironmentConfigListener.class \
#    /opt/homebrew/Cellar/tomcat@9/9.0.115/libexec/webapps/DSC/WEB-INF/classes/mts/dsc/utilities/
# cp build/classes/mts/dsc/servlet/LoginServlet.class \
#    /opt/homebrew/Cellar/tomcat@9/9.0.115/libexec/webapps/DSC/WEB-INF/classes/mts/dsc/servlet/
# brew services restart tomcat@9

# Commit and push review fixes
# git add src/mts/dsc/utilities/EnvironmentConfigListener.java src/mts/dsc/servlet/LoginServlet.java \
#         WebContent/WEB-INF/src/mts/dsc/utilities/EnvironmentConfigListener.java \
#         WebContent/WEB-INF/src/mts/dsc/servlet/LoginServlet.java README.md
# git commit -F /tmp/dsc_commit_msg.txt
# git push


# ── SESSION 5 — 2025-07-14 ─────────────────────────────────────────────────
# Completed all pending UML diagrams; created nextSteps.md backlog

# (All changes made via editor tools — no compilation required for documentation)

git add docs/diagrams/README.md AI/nextSteps.md AI/WORKLOG.md AI/CHANGES.csv AI/COMMANDS.sh AI/COMMIT_INFO.txt
git commit -m "docs: complete UML diagram suite and add next steps backlog"
git push
