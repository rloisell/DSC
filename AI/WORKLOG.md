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
