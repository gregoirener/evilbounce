# EvilBounce — Rebrand Rules

---

## Name Changes

| Old | New |
|-----|-----|
| LiquidBounce | EvilBounce |
| CCBlueX | (keep as attribution in license/comments, change in branding) |
| liquidbounce (lowercase, config keys) | evilbounce |
| `archives_base_name=liquidbounce` in `gradle.properties` | `archives_base_name=evilbounce` |
| Window title | `EvilBounce` |
| In-game client name strings | `EvilBounce` |

**Do not rename Java package `net.ccbluex.liquidbounce`** — this would require renaming thousands of files and every import. Keep the internal package as-is; only visible branding strings change.

---

## Color Rules

### Primary Brand Color
- Old: CCBlueX blue — approximately `#1787D4`, `#5B9BD5`, or `#2196F3` depending on context
- New: **EvilBounce red — `#D41717`** (primary), `#FF3333` (lighter accent), `#8B0000` (dark variant)

### Where to Change Colors

**In `src-theme/` (Svelte/CSS):**
- Find CSS custom properties (`--color-primary`, `--accent`, `--brand`, etc.) in theme config files
- Replace all blue hex values with red equivalents
- Check `.scss` files for hardcoded blue values
- The theme config is likely at `src-theme/src/theme/` or similar — look for a central color definition file first before doing a broad find-replace

**In Kotlin render code:**
- `Color4b` instances using blue values in HUD/GUI rendering — search for `Color4b(` with blue-range RGB values
- The ClickGUI module (`ModuleClickGui`) may have a hardcoded color — update it
- Target box renderer, ESP colors, and nametag colors can be left as user-configurable (they already are)

**In resources:**
- Check `src/main/resources/assets/liquidbounce/` for any color-referencing JSON or config files

---

## Logo / Icon Rules

### Window Icon / Taskbar Icon
- The window icon is set via Fabric/LWJGL — find where `liquidbounce` icon file is referenced
- New icon: **flip the original LiquidBounce logo upside down** (180° rotation) and recolor all blue → red
- Save as `evilbounce_icon.png` (or replace the existing icon file in-place)
- Likely location: `src/main/resources/assets/liquidbounce/` or referenced in a Fabric mod init file

### In-Game Logo / Splash
- If the logo appears in the CEF GUI (`src-theme/`), replace the SVG/PNG source
- The original SVG is referenced from CCBlueX CDN in README — create a local copy, flip + recolor, and reference locally

### Favicon / Browser Tab Icon
- The CEF browser tab may show a favicon — update it to the new red/flipped icon

---

## CEF Theme Approach

The Svelte UI in `src-theme/` is kept entirely. The approach is:
1. Find the central theme/color definition file (one file should define the color system)
2. Swap blue values → red values there
3. If colors are scattered: do a project-wide search for the blue hex codes and replace

**Do NOT:**
- Restructure components
- Change routing or screen names
- Modify the REST bridge (`rest.js`, `events.js`, `types.js`) for branding — those are god nodes

**Do change:**
- Color variables
- Any hardcoded blue hex literals
- The logo/icon asset reference
- Page titles and visible brand name strings

---

## Mod Metadata

File: `src/main/resources/fabric.mod.json` (or equivalent)

Change:
```json
"name": "LiquidBounce" → "EvilBounce"
"description": "..." → update to EvilBounce description
"id": "liquidbounce" → can stay as "liquidbounce" to avoid breaking configs, OR change to "evilbounce" (breaking change for existing config files)
```

Recommendation: keep `"id": "liquidbounce"` for now to avoid breaking saved configs.

---

## gradle.properties

```properties
archives_base_name=evilbounce   # was: liquidbounce
mod_version=0.37.0              # keep or bump to 0.1.0-evil
maven_group=net.ccbluex         # keep — package rename is too costly
```
