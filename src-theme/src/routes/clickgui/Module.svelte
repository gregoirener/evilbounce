<script lang="ts">
    import {onMount} from "svelte";
    import {
        getModuleSettings,
        setModuleSettings,
        setModuleEnabled,
    } from "../../integration/rest";
    import type {ConfigurableSetting} from "../../integration/types";
    import GenericSetting from "./setting/common/GenericSetting.svelte";
    import {slide} from "svelte/transition";
    import {quintOut} from "svelte/easing";
    import {description as descriptionStore, highlightModuleName} from "./clickgui_store";
    import {setItem} from "../../integration/persistent_storage";
    import {convertToSpacedString, spaceSeperatedNames} from "../../theme/theme_config";
    import {scaleFactor} from "./clickgui_store";

    export let name: string;
    export let enabled: boolean;
    export let description: string;
    export let aliases: string[];

    let moduleNameElement: HTMLElement;
    let configurable: ConfigurableSetting;
    const path = `clickgui.${name}`;
    let expanded = false;
    let hasSettings = false;

    onMount(async () => {
        await fetchModuleSettings();

        setTimeout(() => {
            expanded = localStorage.getItem(path) === "true"
        }, 500);
    });

    highlightModuleName.subscribe((m) => {
        if (name !== m) {
            return;
        }

        setTimeout(() => {
            if (!moduleNameElement) {
                return;
            }
            moduleNameElement.scrollIntoView({
                behavior: "smooth",
                block: "center",
            });
        }, 1000);
    });

    async function fetchModuleSettings() {
        configurable = await getModuleSettings(name);
        hasSettings = configurable.value.filter(v => v.name !== "Bind" && v.name !== "Hidden").length > 0;
    }

    async function updateModuleSettings() {
        await setModuleSettings(name, configurable);
        await fetchModuleSettings();
    }

    async function toggleModule() {
        await setModuleEnabled(name, !enabled);
    }

    function setDescription() {
        if (!moduleNameElement) return;

        const boundingRect = moduleNameElement.getBoundingClientRect();
        const y = (boundingRect.top + (moduleNameElement.clientHeight / 2)) * (2 / $scaleFactor);

        let moduleDescription = description;
        if (aliases.length > 0) {
            moduleDescription += ` (aka ${aliases.map(name => $spaceSeperatedNames ? convertToSpacedString(name) : name).join(", ")})`;
        }

        // If element is less than 300px from the right, display description on the left
        if (window.innerWidth - boundingRect.right > 300) {
            const x = boundingRect.right * (2 / $scaleFactor);
            descriptionStore.set({
                x,
                y,
                anchor: "right",
                description: moduleDescription
            });
        } else {
            const x = boundingRect.left * (2 / $scaleFactor);

            descriptionStore.set({
                x,
                y,
                anchor: "left",
                description: moduleDescription
            });
        }
    }

    async function toggleExpanded() {
        expanded = !expanded;
        await setItem(path, expanded.toString());
    }
</script>

<!-- svelte-ignore a11y-no-static-element-interactions -->
<div
        class="module"
        class:expanded
        class:has-settings={hasSettings}
        in:slide={{ duration: 500, easing: quintOut }}
        out:slide={{ duration: 500, easing: quintOut }}
>
    <!-- svelte-ignore a11y-click-events-have-key-events -->
    <div
            class="name"
            on:contextmenu|preventDefault={toggleExpanded}
            on:click={toggleModule}
            on:mouseenter={setDescription}
            on:mouseleave={() => descriptionStore.set(null)}
            bind:this={moduleNameElement}
            class:enabled
            class:highlight={name === $highlightModuleName}
    >
        <span class="label">{$spaceSeperatedNames ? convertToSpacedString(name) : name}</span>
    </div>

    {#if expanded && configurable}
        <div class="settings">
            {#each configurable.value as setting (setting.name)}
                <GenericSetting {path} bind:setting on:change={updateModuleSettings}/>
            {/each}
        </div>
    {/if}
</div>

<style lang="scss">
  @use "../../colors" as *;
  @use "./icon-settings-expand" as *;

  .module {
    position: relative;

    .name {
      cursor: pointer;
      transition: ease background-color 0.2s,
      ease color 0.2s,
      ease box-shadow 0.2s;

      color: $clickgui-text-dimmed-color;
      text-align: center;
      font-size: 12px;
      font-weight: 500;
      position: relative;
      padding: 10px;

      /* Highlight border uses ::before — ::after is reserved for the expand icon */
      &.highlight::before {
        content: "";
        position: absolute;
        top: 0;
        left: 0;
        width: calc(100% - 4px);
        height: calc(100% - 4px);
        border: solid 2px $accent-color;
        pointer-events: none;
      }

      &:hover {
        background-color: rgba($clickgui-base-color, 0.85);
        color: $clickgui-text-color;
      }

      &.enabled {
        color: $accent-color;
        /* Outer glow only — no inset, no overlay */
        box-shadow: 0 0 10px $accent-glow-color;
        text-shadow: 0 0 8px $accent-glow-color;
      }

      /* The shine lives on the text span only */
      .label {
        position: relative;
        display: inline-block;
        overflow: hidden;

        &::before {
          content: "";
          position: absolute;
          top: 0;
          left: -80%;
          width: 80%;
          height: 100%;
          background: linear-gradient(
            90deg,
            transparent 0%,
            rgba(255, 140, 140, 0.35) 50%,
            transparent 100%
          );
          pointer-events: none;
          animation: evilbounce-shine 3.5s ease-in-out infinite;
        }
      }
    }

    @keyframes evilbounce-shine {
      0%   { transform: translateX(0%); }
      100% { transform: translateX(280%); }
    }

    .settings {
      background-color: rgba($clickgui-base-color, 0.5);
      border-left: solid 4px $accent-color;
      padding: 0 11px 0 7px;
    }

    &.has-settings {
      .name::after {
        @include icon-settings-expand($right: 15px);
        opacity: 0.5;
      }

      &.expanded .name::after {
        transform: translateY(-50%) rotate(0);
        opacity: 1;
      }
    }
  }
</style>
