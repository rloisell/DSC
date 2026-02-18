#!/bin/sh
# replace sensitive strings in the working tree
find . -type f -not -path './.git/*' -exec perl -pi -e 's/uofwmts1/REDACTED_DO_NOT_COMMIT/g; s/pentium120/REDACTED_DO_NOT_COMMIT/g; s/welcome/REDACTED_TEST_PASSWORD/g' {} + || true