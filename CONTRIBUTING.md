# Contributing to Java Knowledge Base

Thank you for taking the time to contribute to **Java Knowledge Base**! 🎉

This repository serves as a structured, double-purposed learning vault for Core Java:
1. An **IntelliJ Java project** containing clean, self-contained, and fully runnable Java source files (`src/javakb/`).
2. An **Obsidian documentation vault** featuring clear, intuition-first Markdown notes (`docs/`).

We welcome contributions from developers of all skill levels. Whether you are fixing a typo, adding code examples, refining documentation, or implementing Data Structures & Algorithms, your contributions help turn this repository into a premier Java learning resource.

---

## Goals

The primary goal of **Java Knowledge Base** is to provide an accessible, comprehensive, and high-quality Java resource where **code and documentation evolve together**. 

Every concept should have a matching, fully runnable Java file and a clear Markdown guide that explains *why* the code works, *how* to use it, and *what* common pitfalls to avoid.

---

## Before You Start

To ensure smooth collaboration, please follow these initial steps:

1. **Fork the Repository**: Click the **Fork** button at the top right of this repository to create your own copy.
2. **Clone Your Fork**:
   ```bash
   git clone https://github.com/harshwardhan1507/java-knowledge-base.git
   cd java-knowledge-base
   ```
3. **Create a Feature Branch**: Use a descriptive branch name for your work:
   ```bash
   git checkout -b feature/ch05-array-algorithms
   ```
4. **Keep Commits Focused**: Make small, incremental, and meaningful commits rather than one massive commit.

---

## Repository Structure

Understanding the layout helps keep contributions organized and aligned with the dual-vault setup:

```text
java-knowledge-base/
├── src/javakb/               # Executable Java Source Files (IntelliJ Project Root)
│   ├── ch01_basics/          # Chapter 1: Variables, data types, Scanner, formatting
│   ├── ch02_controlflow/     # Chapter 2: Conditionals, switch statements
│   ├── ch03_loops/           # Chapter 3: for, while, do-while, nested loops
│   ├── ch04_methods/         # Chapter 4: Declaration, pass-by-value, overloading, recursion, varargs
│   ├── ...                   # Additional Core Java chapter packages
│   ├── ch17_concurrency/     # Chapter 17: Threads, Executors, Synchronization
│   ├── projects/             # Practice projects (beginner, intermediate, advanced)
│   └── dsa/                  # Data Structures and Algorithms implementations
│
└── docs/                     # Obsidian Vault & Markdown Documentation
    ├── java/                 # Chapter-by-chapter concept notes (ch01_basics.md, etc.)
    └── dsa/                  # DSA concepts, complexity analysis, and solution notes
```

---

## Coding Standards

All Java source code in `src/javakb/` should adhere to the following standards:

- **Package Naming**: Follow the strict convention `javakb.chXX_topic` (e.g., `package javakb.ch04_methods;`).
- **One Concept per File**: Keep files focused on a single topic or sub-concept whenever practical.
- **Naming Conventions**:
  - Class names: `PascalCase` (e.g., `MethodOverloading.java`).
  - Method and variable names: `camelCase` (e.g., `calculateAverage()`).
  - Constants: `UPPER_SNAKE_CASE` (e.g., `MAX_RETRY_COUNT`).
- **Self-Documenting Code**: Prefer clear variable and method names over redundant comments. Use comments to explain *why* something is done, not *what* the Java syntax is doing.
- **Runnable & Educational**: Every `.java` file must include a `public static void main(String[] args)` method with clean console output showing the concept in action.
- **No Dead Code**: Remove commented-out code, unused variables, and unused methods.
- **Clean Imports**: Remove unused imports (`import java.util.*;` is discouraged; import explicitly).
- **Consistent Formatting**: Follow standard Java code indentation (4 spaces, standard bracket placement).

---

## Documentation Standards

Documentation in `docs/` is the core reading material of the vault. Every new or updated topic should maintain high educational value:

- **Corresponding Markdown Note**: New Java concepts must have a matching `.md` file in `docs/java/` or `docs/dsa/`.
- **Intuition-First Approach**: Start explanations with real-world intuition or problem statements before introducing formal Java syntax.
- **Runnable Code Snippets**: Include fenced Java code blocks (` ```java `) that match the source code in `src/`.
- **Beginner-Friendly Language**: Avoid overly academic jargon without explaining it first.
- **Common Mistakes & Pitfalls**: Highlight frequent beginner errors, compiler exceptions, or runtime traps (e.g., operator precedence, `NullPointerException`, `StackOverflowError`).
- **Relative Links**: Connect Markdown notes with corresponding Java files using relative links (e.g., `[BasicMethod.java](../../src/javakb/ch04_methods/BasicMethod.java)`).

---

## Commit Message Guidelines

We use conventional commit messages to keep the Git history readable and structured:

```text
<type>(<scope>): <short summary>
```

### Types:
- `feat`: A new Java example, chapter topic, or project feature.
- `docs`: Documentation updates, Markdown notes, or inline Javadoc additions.
- `fix`: Bug fixes in code examples or corrections in documentation.
- `refactor`: Code improvements that do not change external behavior.
- `style`: Formatting adjustments, whitespace changes, or lint fixes.

### Examples:
- `feat(ch05): add binary search example`
- `docs(ch04): improve method overloading notes`
- `fix(ch03): correct nested loop pattern example`
- `refactor(ch07): simplify class hierarchy demonstration`

---

## Pull Request Checklist

Before submitting a Pull Request (PR), please verify that you have completed the following steps:

- [ ] Code compiles cleanly without warnings or errors (`javac`).
- [ ] Documentation (`docs/`) has been added or updated to reflect code changes.
- [ ] All code examples are fully runnable with informative `main()` console outputs.
- [ ] Formatting standards are checked (4 spaces, clean imports, no dead code).
- [ ] No duplicate examples or redundant concept files exist.
- [ ] Commit history follows the commit message guidelines.
- [ ] Changes tested successfully in IntelliJ IDEA / command line.

---

## What Can You Contribute?

Looking for ways to help? Here are great ways to contribute:

- 💡 **New Java Examples**: Create practical, easy-to-understand code samples for missing concepts.
- 📖 **Documentation Improvements**: Enhance existing `.md` files with clearer diagrams, tables, or real-world examples.
- 🐛 **Bug Fixes & Corrections**: Fix logical bugs in source code or math/formatting mistakes in documentation.
- 🚀 **DSA Implementations**: Add data structures or classic algorithm implementations under `src/javakb/dsa/`.
- 🛠️ **Mini Projects**: Build beginner or intermediate console applications illustrating chapter concepts.
- ✏️ **Typo & Grammar Fixes**: Help polish text clarity throughout the documentation vault.

---

## Issues

Have you found a bug or do you have an idea for a new feature? 

- **Search Existing Issues**: Check if the bug or feature request has already been reported before opening a new issue.
- **Opening a Bug Report**: Describe the expected vs. actual behavior, provide steps to reproduce, and include sample code or error stack traces.
- **Suggesting Enhancements**: Clearly outline the concept or improvement, why it's beneficial, and how it aligns with the repository structure.

---

## Code of Conduct

We are committed to providing a welcoming, inclusive, and supportive environment for everyone:

- **Be Respectful**: Treat all contributors with kindness, courtesy, and empathy.
- **Be Constructive**: Give and receive feedback gracefully with a focus on learning and growth.
- **Welcome Beginners**: We all started somewhere. Encourage questions and mentor newer developers.
- **Focus on Learning**: Keep discussions aligned with creating the best Java learning vault possible.

Happy Coding! ☕
