/*
 * CLAUDE.md
 * Ryan Loiselle — Developer / Architect
 * GitHub Copilot — AI pair programmer / code generation
 * June 2025
 *
 * AI-assisted: project-level Claude Code instructions created as part of
 * rl-agents-n-skills submodule migration; reviewed and directed by Ryan Loiselle.
 */

# CLAUDE.md — DSC (Daily Schedule Control)

This file provides project-level instructions for Claude Code.
Base instructions (shared personas, skills, subagents) are in `.github/agents/CLAUDE.md`
via the rl-agents-n-skills plugin.

## Project purpose

`DSC` (Daily Schedule Control) is a **legacy Java EE application** used as a
study and modernisation platform. It consists of:
- Java Servlets + JSP (Tomcat 9), Hibernate 3 ORM, MySQL 8.0
- Apache Ant build system (`build-dbva.xml`)
- A legacy codebase being brought to a clean, documented, and deployable state

The companion repo `DSC-modernization` tracks the re-platformed version.

## Primary goals for this repo

- Document and stabilise the legacy codebase as-is
- Perform incremental refactors without breaking core functionality
- Serve as a reference point for the DSC-modernization effort

## Submodule: rl-agents-n-skills

Agents and skills live at `.github/agents/` which is a git submodule pointing to
`https://github.com/rloisell/rl-agents-n-skills`.

To update:
```bash
cd .github/agents && git pull origin main && cd ../..
git add .github/agents
git commit -m "chore: update rl-agents-n-skills submodule"
```

Do NOT edit files inside `.github/agents/` directly — make changes in the
`rl-agents-n-skills` repo instead.
