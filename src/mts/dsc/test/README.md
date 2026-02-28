<!--
 * README.md — src/mts/dsc/test/
 * Ryan Loiselle — Developer / Architect
 * GitHub Copilot — AI pair programmer / code generation
 * February 2026
 *
 * AI-assisted: documented seed data structure from ModernSeedData.java;
 * reviewed and directed by Ryan Loiselle.
-->

# Test Data — DSC Local Development

This document describes the data inserted by `ModernSeedData.java`.  
Run it once after loading the schema to bring the database to a known good state.

> **Activities are seeded for the day the seed is run.** If you need to see data
> in the UI today, re-run the seed or note which date the seed was last executed
> (check the `Activity` table: `SELECT DISTINCT Calendardate FROM Activity;`).

---

## How to Re-Run the Seed

```bash
# Compile
/Library/Java/JavaVirtualMachines/temurin-8.jdk/Contents/Home/bin/javac \
  -encoding UTF-8 \
  -cp "lib/mysql-connector-java-5.1.7/mysql-connector-java-5.1.7-bin.jar:\
lib/commons-logging.jar:lib/dom4j-1.6.1.jar:lib/hibernate3.jar:lib/orm.jar:\
build/classes" \
  -d build/classes \
  src/mts/dsc/test/ModernSeedData.java

# Run
/Library/Java/JavaVirtualMachines/temurin-8.jdk/Contents/Home/bin/java \
  -cp "lib/mysql-connector-java-5.1.7/mysql-connector-java-5.1.7-bin.jar:\
lib/commons-logging.jar:lib/dom4j-1.6.1.jar:lib/hibernate3.jar:lib/orm.jar:\
build/classes" \
  mts.dsc.test.ModernSeedData
```

All `ensure*` methods are idempotent — re-running adds missing rows and skips
existing ones. Activities are only inserted once per user/date/description
combination, so re-running on a new day adds that day's activities without
touching earlier ones.

---

## Login Credentials

All seed users share the same password.

| Username   | Password        | Employee ID | Role              | Notes                    |
|------------|-----------------|-------------|-------------------|--------------------------|
| `rloisel1` | `test-password` | 15298       | Team Lead (`-1`)  | Primary dev test account |
| `dmcgregor`| `test-password` | 10101       | Project Manager (`2`) | Manager-flow testing |
| `kduma`    | `test-password` | 15299       | Software Developer (`1`) | Engineering dept     |
| `mammeter` | `test-password` | 99901       | QA Analyst (`1`)  | QA dept                  |

> Role code `4` = Project Manager (exempt from required-hours calculation in
> `Employee.setRequiredHours()`). Role codes `1`/`-1` follow union required-hours rules.

---

## Users

| Emp ID | Name             | Email                    | Start Date   | Department           | Position           | Union          |
|--------|------------------|--------------------------|--------------|----------------------|--------------------|----------------|
| 15298  | Ryan Loiselle    | ryan@example.com         | 2020-01-02   | Engineering          | Team Lead          | CUPE Local 500 |
| 10101  | Duncan McGregor  | duncan@example.com       | 2018-06-12   | OSS Operations       | Project Manager    | Non-Union      |
| 15299  | Keith Duma       | keith@example.com        | 2021-03-15   | Engineering          | Software Developer | IBEW Local 2085|
| 99901  | Matthew Ammeter  | matthew@example.com      | 2019-09-30   | Quality Assurance    | QA Analyst         | CUPE Local 500 |

### Required Hours (per day)
Calculated dynamically in `Employee.setRequiredHours()` based on union and employment status.
All seed users are Full-Time (`FT`).

| Union              | ID | Required Hours/Day |
|--------------------|----|--------------------|
| IBEW Local 2085    | 0  | **7.5 h**          |
| CUPE Local 500     | 1  | **7.38 h**         |
| Non-Union          | 2  | **–** (no rule)    |

Project Managers (position ID `4`) are exempt — `setRequiredHours` is not called for them.

---

## Departments

| Dept ID | Name                | Department Head  |
|---------|---------------------|------------------|
| 1       | Engineering         | Ryan Loiselle    |
| 2       | OSS Operations      | Duncan McGregor  |
| 3       | Quality Assurance   | Matthew Ammeter  |
| 4       | Product Management  | Keith Duma       |

---

## Positions

| Position ID | Code | Title                    | Status | Union           |
|-------------|------|--------------------------|--------|-----------------|
| 1           | 1001 | Software Developer       | FT     | IBEW Local 2085 |
| 2           | 1002 | Senior Developer         | FT     | IBEW Local 2085 |
| 3           | 1003 | Team Lead                | FT     | CUPE Local 500  |
| 4           | 1004 | Project Manager          | FT     | Non-Union       |
| 5           | 1005 | QA Analyst               | FT     | CUPE Local 500  |
| 6           | 1006 | Database Administrator   | FT     | Non-Union       |

---

## Activities (Seeded Data)

Activities are inserted for `today` (the date `ModernSeedData` is executed).
To confirm the seeded date:

```sql
SELECT DISTINCT Calendardate FROM Activity;
```

### Ryan Loiselle (`rloisel1`, emp 15298)

| # | Description          | Type    | Budget  | Project    | Category    | Network | Act. Code | Duration |
|---|----------------------|---------|---------|------------|-------------|---------|-----------|----------|
| 1 | Development Sprint   | Project | Capital | P00002     | Development | 1000    | 10 (DEV)  | 480 min (8 h) |
| 2 | Training Conference  | Expense | Expense | —          | Support     | —       | —         | 480 min (8 h) |

Expense activity fields: Director `DIR001`, Reason `S1` (Technical Support), CPC `C300` (Development).

### Duncan McGregor (`dmcgregor`, emp 10101)

| # | Description                  | Type    | Budget  | Project | Category    | Network | Act. Code | Duration |
|---|------------------------------|---------|---------|---------|-------------|---------|-----------|----------|
| 1 | Security Hardening Planning  | Project | Capital | P00002  | Development | 1000    | 10 (DEV)  | 180 min (3 h) |

### Keith Duma (`kduma`, emp 15299)

| # | Description        | Type    | Budget  | Project | Category    | Network | Act. Code | Duration |
|---|--------------------|---------|---------|---------|-------------|---------|-----------|----------|
| 1 | Feature Development| Project | Capital | P00002  | Development | 1000    | 10 (DEV)  | 300 min (5 h) |

### Matthew Ammeter (`mammeter`, emp 99901)

| # | Description     | Type    | Budget  | Project | Category | Network | Act. Code | Duration |
|---|-----------------|---------|---------|---------|----------|---------|-----------|----------|
| 1 | Support Coverage| Expense | Expense | —       | Support  | —       | —         | 120 min (2 h) |

Expense activity fields: Director `DIR001`, Reason `S1` (Technical Support), CPC `C300` (Development).

---

## Reference Data

### Budgets

| Budget ID | Description |
|-----------|-------------|
| 1         | Expense     |
| 2         | Capital     |

### Projects

| Project No | Name                       |
|------------|----------------------------|
| P00001     | Website Redesign           |
| P00002     | Security Hardening ← used by seed activities |
| P00003     | Database Migration         |
| P00004     | Mobile App Development     |
| P00005     | Legacy System Integration  |
| P00006     | API Modernization          |
| P00007     | Performance Optimization   |
| P00008     | Documentation Update       |

### Categories

| Name          |
|---------------|
| Development   |
| Testing       |
| Documentation |
| Planning      |
| Support       |

### Activity Codes

| Code | Label                       |
|------|-----------------------------|
| 10   | DEV — Development work      |
| 11   | TEST — Testing and QA       |
| 12   | MEET — Meetings and planning|
| 13   | DOC — Documentation         |
| 14   | TRAIN — Training activities |
| 15   | PLAN — Project planning     |
| 16   | DEPLOY — Deployment/release |
| 17   | REVIEW — Code review        |
| 18   | RESEARCH — Research/discovery|
| 19   | BUG — Bug fixing            |
| 20   | SUPPORT — User support      |
| 21   | ADMIN — Administrative work |

### Network Numbers

| Number | Label        |
|--------|--------------|
| 1000   | Network 1000 |
| 1001   | Network 1001 |
| 1002   | Network 1002 |
| 1003   | Network 1003 |
| 1004   | Network 1004 |
| 1005   | Network 1005 |
| 1006   | Network 1006 |
| 1007   | Network 1007 |
| 1008   | Network 1008 |
| 1009   | Network 1009 |
| 1010   | Network 1010 |
| 1011   | Network 1011 |

### Director Codes

| Code   | Description                         |
|--------|-------------------------------------|
| DIR001 | Engineering Director Approval ← used by seed activities |
| DIR002 | Operations Director Approval        |
| DIR003 | Finance Director Approval           |
| DIR004 | Executive Director Approval         |

### Reason Codes

| Code | Description           |
|------|-----------------------|
| M1   | Equipment Maintenance |
| U1   | System Upgrade        |
| S1   | Technical Support ← used by seed activities |
| T1   | Staff Training        |
| B1   | Business Meeting      |

### CPC Codes

| Code | Description        |
|------|--------------------|
| C100 | General Operations |
| C200 | Infrastructure     |
| C300 | Development ← used by seed activities |
| C400 | Support            |
| C500 | Admin              |

---

## Calendar

All 365 days of the current year are present as **Workday** (category 1) by default.
The following specific dates override that:

| Date          | Category      |
|---------------|---------------|
| Jan 1         | Holiday       |
| Jul 1         | Holiday       |
| Dec 25        | Holiday       |
| Dec 26        | Holiday       |
| Mar 15        | Company Event |

The `Employee` constructor requires today's date to exist in the `Calendar` table —
if it is absent, login will fail with a `NullPointerException` in `setRequiredHours()`.
Running the seed (or re-running it after a year boundary) populates the table correctly.

---

## Quick SQL Reference

```sql
-- What activities exist and on which dates?
SELECT a.activityId, u.firstName, u.lastName, a.Calendardate, a.description,
       a.actualDuration, c.catName, b.budgetDescription
FROM Activity a
JOIN User u ON a.UserempId = u.empId
JOIN Category c ON a.CategorycatId = c.catId
JOIN Budget b ON a.BudgetBudgetId = b.BudgetId
ORDER BY a.Calendardate, u.lastName;

-- Which days have activities?
SELECT DISTINCT Calendardate FROM Activity ORDER BY Calendardate;

-- Check a specific user's activities
SELECT a.Calendardate, a.description, a.actualDuration
FROM Activity a
WHERE a.UserempId = 15298   -- replace with target empId
ORDER BY a.Calendardate;

-- Check Calendar table coverage
SELECT date, cc.calendarCatName
FROM Calendar cal
JOIN Calendar_Category cc ON cal.Calendar_CategorycalendarCategory = cc.calendarCategory
WHERE date >= CURDATE() - INTERVAL 7 DAY
ORDER BY date;
```
