```bash
#!/bin/bash
# Commands used to scrub repository (do NOT run unless you understand history rewrite implications)

# 1. Commit redaction changes locally
# git add -A
# git commit -m "chore(secrets): redact committed plaintext passwords and remove private keys"

# 2. Create backup branch
# git branch pre-scrub-backup

# 3. Remove files from history (example using git-filter-repo preferred)
# git-filter-repo --path lib/mysql-connector-java-5.1.7/src/testsuite/ssl-test-certs/server-key.pem --path ...

# 4. Replace strings in history (example with git-filter-repo replace-text)
# git filter-repo --replace-text replacements.txt

# 5. If using filter-branch (legacy) the commands used were:
# git filter-branch --force --index-filter 'git rm -r --cached --ignore-unmatch <paths..>' --prune-empty --tag-name-filter cat -- --all
# ./scripts/replace-secrets.sh can be used with --tree-filter to replace strings

# 6. Clean up and gc
# rm -rf .git/refs/original/
# git reflog expire --expire=now --all
# git gc --prune=now --aggressive

## Push commands (run locally AFTER rotating credentials)

```bash
# verify remotes and working tree are clean
git remote -v
git status --porcelain

# fetch updates then force-push all branches and tags
git fetch --all --prune
git push --force --all
git push --force --tags
```

# Note: The assistant attempted to run these commands but the execution environment's terminal closed and the push could not be completed by the agent.

```
