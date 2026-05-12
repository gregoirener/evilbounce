---
tags: [rebrand, task]
---

# Rebrand: LiquidBounce → EvilBounce

Full rules in [`docs/evilbounce/rebrand.md`](../rebrand.md). This note is the vault quick-reference.

## Name

| Old | New |
|-----|-----|
| LiquidBounce | EvilBounce |
| liquidbounce (config id) | keep as-is to not break configs |
| archives_base_name | evilbounce |

## Color

- Primary: **#D41717** (red)
- Accent: **#FF3333** (lighter red)
- Dark: **#8B0000**
- Replace all blues: `#1787D4`, `#5B9BD5`, `#2196F3`

## Logo

- Original LiquidBounce logo → flip 180° + recolor all blue to red
- Window/taskbar icon: same treatment
- CEF browser favicon: update to red/flipped version

## Files to Change

| File / Location | What to Change |
|-----------------|---------------|
| `gradle.properties` | `archives_base_name=evilbounce` |
| `src/main/resources/fabric.mod.json` | name, description |
| `src-theme/` color variables | blue → red |
| `src-theme/` brand name strings | LiquidBounce → EvilBounce |
| Window icon file (resources) | replace with flipped red version |
| README.md | project name, links |

## Relations

- [[Systems-CEF]] — where all the color/logo changes happen in practice
- [[Modules-Render]] — ClickGui and some render modules have hardcoded colors
