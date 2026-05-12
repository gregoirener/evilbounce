# Design Spec: EvilBounce Agent Documentation

**Date:** 2026-05-12
**Status:** Implemented

---

## Problem

EvilBounce is a fork of LiquidBounce with a specific, non-obvious scope: strip dead weight while keeping all blatant PvP features and doing a full rebrand. Agents working on this codebase without context will make errors — deleting things that have dependents, touching the wrong files for rebrand, or not knowing which modules are sacred vs scheduled for removal.

## Goal

Every agent that opens this project should immediately know:
1. What EvilBounce is and what we're building toward
2. Exactly what to delete and in what order (with cascade warnings)
3. Exactly what to never touch
4. The rebrand rules (red, flipped logo, keep CEF)
5. The architecture well enough to make safe edits

## Solution Implemented

### Files Created

```
CLAUDE.md                                    ← auto-loaded every session, full context
docs/evilbounce/modules.md                   ← exhaustive keep/nuke list with paths
docs/evilbounce/dependencies.md              ← cascade map for every deletion
docs/evilbounce/rebrand.md                   ← color, logo, naming rules
docs/evilbounce/vault/EvilBounce.md          ← Obsidian hub
docs/evilbounce/vault/GodNodes.md            ← top 10 most-connected nodes
docs/evilbounce/vault/Systems-CEF.md
docs/evilbounce/vault/Systems-Events.md
docs/evilbounce/vault/Systems-Config.md
docs/evilbounce/vault/Systems-Mixins.md
docs/evilbounce/vault/Systems-Scripting.md
docs/evilbounce/vault/Systems-DeepLearn.md
docs/evilbounce/vault/Modules-Combat.md
docs/evilbounce/vault/Modules-World.md
docs/evilbounce/vault/Modules-Movement.md
docs/evilbounce/vault/Modules-Exploit.md
docs/evilbounce/vault/Modules-Player.md
docs/evilbounce/vault/Modules-Misc.md
docs/evilbounce/vault/Modules-Render.md
docs/evilbounce/vault/Rebrand.md
docs/evilbounce/vault/Deletions.md           ← checklist, update as deletions complete
```

### Key Design Decisions

- **CLAUDE.md is maximal** — contains the full picture so agents never start cold. Claude Code loads it automatically at session start.
- **Vault uses Obsidian wikilinks** — every node links to related nodes so agents can follow the dependency graph without reading code
- **Deletions.md is a living checklist** — agents update it as they complete removals; it's the source of truth for progress
- **Hard rules in CLAUDE.md** — explicit must-do steps (compile check after every deletion, read dependencies.md first)
- **God nodes are named and explained** — agents know not to rename `regular()` or touch `rest.js` carelessly

### What Agents Must Do Each Session

1. Read `CLAUDE.md` (automatic)
2. Check `docs/evilbounce/vault/` node relations before editing cross-file systems
3. Check `docs/evilbounce/dependencies.md` before any deletion
4. Run `./gradlew compileKotlin` after structural changes
5. Update `Deletions.md` when removing something

## Scope of EvilBounce (summary)

**Delete:** Online services (Marketplace, Cosmetics, Accounts), server crashers, dupe, kick, phase, clicktp, tpaura.

**Keep:** Everything combat, all movement, all world/utility, exploit/AC bypass, misc, render, scripting, deeplearn, CEF GUI.

**Rebrand:** Blue → red (#D41717), logo flipped 180° + recolored, name LiquidBounce → EvilBounce in all visible strings.
