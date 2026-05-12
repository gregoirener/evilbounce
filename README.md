<div align="center">
<p>
    <img width="300" src="https://raw.githubusercontent.com/gregoirener/evilbounce/master/docs/evilbounce/evilbounce-logo.png">
</p>

[GitHub](https://github.com/gregoirener/evilbounce)
</div>

**EvilBounce** is a blatant, combat-focused Minecraft hacked client — a fork of LiquidBounce nextgen optimized for PvP with unnecessary features stripped away. Built on the Fabric API using mixin injection for Minecraft.

## Issues

Found a bug or have a feature request? Open an issue [here](https://github.com/gregoirener/evilbounce/issues).

## License

This project is subject to the [GNU General Public License v3.0](https://www.gnu.org/licenses/gpl-3.0.en.html). This
does only apply for source code located directly in this clean repository. During the development and compilation
process, additional source code may be used to which we have obtained no rights. Such code is not covered by the GPL
license.

For those who are unfamiliar with the license, here is a summary of its main points. This is by no means legal advice
nor legally binding.

*Actions that you are allowed to do:*

- Use
- Share
- Modify

*If you do decide to use ANY code from the source:*

- **You must disclose the source code of your modified work and the source code you took from this project. This means
  you are not allowed to use code from this project (even partially) in a closed-source (or even obfuscated)
  application.**
- **Your modified application must also be licensed under the GPL**

## Setting up a Workspace

EvilBounce uses Gradle and Node.js. Make sure both are installed:
- [Gradle](https://gradle.org/install/)
- [Node.js](https://nodejs.org) (for the CEF theme)

1. Clone the repository: `git clone --recurse-submodules https://github.com/gregoirener/evilbounce.git`
2. Enter the directory: `cd evilbounce`
3. Generate Minecraft sources (optional): `./gradlew genSources`
4. Open as a Gradle project in your IDE
5. Run: `./gradlew runClient`

## Additional libraries

### Mixins

Mixins modify Minecraft classes at runtime before loading. EvilBounce uses Fabric Mixins to inject code into the Minecraft client without shipping Mojang's copyrighted code. Learn more: [Mixins Documentation](https://docs.spongepowered.org/5.1.0/en/plugin/internals/mixins.html).

## Contributing

Contributions welcome. Fork the repo, make changes, and submit a PR. Please read [CLAUDE.md](CLAUDE.md) for architecture and scope guidelines.

## Stats

![Alt](https://repobeats.axiom.co/api/embed/ad3a9161793c4dfe50934cd4442d25dc3ca93128.svg "Repobeats analytics image")

## Credits & License

**EvilBounce** is a fork of [LiquidBounce](https://github.com/CCBlueX/LiquidBounce) by CCBlueX, optimized for combat and stripped of unnecessary features.

Original LiquidBounce by **CCBlueX** — all credit for the base architecture, mixin system, and CEF integration goes to the original authors.

EvilBounce fork maintained at: [github.com/gregoirener/evilbounce](https://github.com/gregoirener/evilbounce)

This project is licensed under the **GNU General Public License v3.0**.
