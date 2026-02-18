This repository had sensitive values committed. Actions taken locally:

- Replaced plaintext database passwords with the placeholder `REDACTED_DO_NOT_COMMIT` in:
  - `src/ormmapping/DSC.cfg.xml`
  - `src/ormmapping/database.cfg.xml`
  - `build/classes/ormmapping/database.cfg.xml`

- Redacted hardcoded test passwords in `src/mts/dsc/test/SecondTest.java`.
- Deleted private key files under `*/src/testsuite/ssl-test-certs/`.
- Added `.gitignore` to prevent committing `.pem` and `.env` files.

Recommended next steps to scrub history (pick one):

1) Using `git filter-repo` (preferred):

```bash
# Install git-filter-repo if needed (platform package or pip)
# Example (macOS with homebrew): brew install git-filter-repo

# Remove files by path from history
git filter-repo --path lib/mysql-connector-java-5.1.7/src/testsuite/ssl-test-certs/server-key.pem --path lib/mysql-connector-java-5.1.7/src/testsuite/ssl-test-certs/ca-key.pem --path WebContent/WEB-INF/lib/mysql-connector-java-5.1.45/src/testsuite/ssl-test-certs/client-key.pem --path WebContent/WEB-INF/lib/mysql-connector-java-5.1.45/src/testsuite/ssl-test-certs/mykey.pem --path WebContent/WEB-INF/lib/mysql-connector-java-5.1.45/src/testsuite/ssl-test-certs/server-key.pem --path WebContent/WEB-INF/lib/mysql-connector-java-5.1.45/src/testsuite/ssl-test-certs/ca-key.pem

# Additionally replace sensitive strings (e.g., passwords) in history
git filter-repo --replace-text <(printf "REDACTED_DO_NOT_COMMIT==REDACTED_DO_NOT_COMMIT
REDACTED_DO_NOT_COMMIT==REDACTED_DO_NOT_COMMIT
REDACTED_TEST_PASSWORD==REDACTED_TEST_PASSWORD
")

# After rewriting history, force-push to remote (careful):
git push --force --all
git push --force --tags
```

2) Using the BFG Repo-Cleaner:

```bash
# Example using BFG to delete all .pem and specific files
java -jar bfg.jar --delete-files "*.pem" --delete-files "lib/mysql-connector-java-5.1.7/src/testsuite/ssl-test-certs/server-key.pem" --delete-files "..." repo.git
# then follow BFG instructions to clean reflogs and force-push
```

Notes:
- Rewriting history will change commit hashes; coordinate with your team and back up the repo first.
- Rotate/replace the affected credentials (DB, certificates) immediately with new ones.
- Verify CI/CD and other integrations after history rewrite.
