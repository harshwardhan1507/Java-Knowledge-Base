# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build and Execution Commands

This repository is a standard Java project without external build tools (like Maven/Gradle) at the root level. All code compiles to the `out/` directory using standard JDK tools (`javac` / `java`).

### Compile Commands
- **Compile a single file:**
  ```bash
  javac -d out -sourcepath src src/javakb/ch01_basics/HelloWorld.java
  ```
- **Compile an entire chapter package:**
  ```bash
  javac -d out -sourcepath src src/javakb/ch06_strings/*.java
  ```
- **Compile a multi-file project:**
  ```bash
  javac -d out -sourcepath src src/javakb/projects/intermediate/studentmanagement/*.java
  ```
- **Compile all source files:**
  ```bash
  javac -d out -sourcepath src $(find src -name "*.java")
  ```

### Run Commands
- **Run a chapter example:**
  ```bash
  java -cp out javakb.ch01_basics.HelloWorld
  ```
- **Run a multi-file project entry point:**
  ```bash
  java -cp out javakb.projects.intermediate.studentmanagement.Main
  ```

---

## Architecture & Codebase Structure

The repository serves a dual role:
1. **IntelliJ Developer Workspace (`src/javakb/`)**: Standalone, runnable Java source files grouped under the root package `javakb`.
2. **Obsidian Knowledge Vault (`docs/`)**: Conceptual markdown notes structured for Obsidian (with `[[wikilinks]]` or relative file links connecting documentation to source code).

```text
├── src/javakb/               # Executable Java source code
│   ├── ch01_basics/          # Procedural basics (Ch01 - Ch06)
│   ├── ch02_controlflow/
│   ├── ch03_loops/
│   ├── ch04_methods/
│   ├── ch05_arrays/
│   ├── ch06_strings/
│   ├── ch07_oop/             # OOP fundamentals & mechanics (Ch07 - Ch11)
│   ├── ch08_inheritance/
│   ├── ch09_abstraction/
│   ├── ch10_encapsulation/
│   ├── ch11_relationships/
│   ├── ch12_collections/     # Collections Framework (list, set, queue, map)
│   ├── ch13_exceptions/      # Error handling & custom exceptions
│   ├── ch14_filehandling/    # File I/O & streams
│   ├── ch15_generics/        # Generics & type parameters
│   ├── ch16_datetime/        # Modern Date/Time APIs
│   ├── ch17_concurrency/     # Threads, synchronization, executors
│   ├── projects/             # Practice projects categorized by level
│   │   ├── beginner/         # Single-class console utilities (e.g., CompInterest)
│   │   ├── intermediate/     # Multi-class OOP / Collections apps (e.g., studentmanagement, VendingMachine)
│   │   └── advanced/         # Multi-threaded / file storage apps
│   └── dsa/                  # Data Structures and Algorithms implementations
│
└── docs/                     # Markdown notes (Obsidian vault root)
    ├── java/                 # Chapter notes (ch01_basics.md, ch12_collections/, etc.)
    │   └── projects/         # Project documentation and specifications
    ├── dsa/                  # Complexity analysis and DSA theory
    ├── design_patterns/      # Creational, structural, and behavioral pattern notes
    └── spring_boot/          # Spring Boot lecture notes
```

---

## Conventions & Standards

- **Package Naming:** Strict package namespace format: `package javakb.chXX_topic;` or `package javakb.projects.<level>.<projectname>;`.
- **File & Class Coupling:**
  - Every concept file must contain an executable `public static void main(String[] args)` demonstrating the concept with informative console output.
  - New concept implementations in `src/javakb/` should have a matching documentation file in `docs/java/` linking back to the source code using relative paths (e.g. `[ClassName.java](../../src/javakb/chXX_topic/ClassName.java)`).
- **Imports:** Explicit imports only (avoid wildcard imports like `import java.util.*;`).
- **Formatting:** 4-space indentation, standard Java brace style.
- **Commit Messages:** Conventional commit format: `<type>(<scope>): <summary>` (e.g., `feat(ch08): implement inheritance examples and notes`, `docs(ch12): add map interface documentation`).
