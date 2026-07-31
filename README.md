# ☕ Java Knowledge Base

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java" />
  <img src="https://img.shields.io/badge/Level-Beginner_to_Advanced-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Platform-IntelliJ_&_Obsidian-green?style=for-the-badge" />
</p>

---

## 📌 Overview

Welcome to the **Java Knowledge Base**! This repository is a structured educational resource and reference vault documenting core Java programming concepts, from basic syntax up to multi-threaded concurrency, object-oriented design patterns, and interactive mini-projects.

It is structured to serve dual roles:
1. **IntelliJ Developer Workspace:** Highly organized under the unified root namespace `javakb`.
2. **Obsidian Knowledge Vault:** Direct integration with concept notes organized separately inside the `docs/` folder, linking directly to source codes.

---

## 🚀 Learning Roadmap

```mermaid
graph TD
    A[Core Basics: Var, Math, Input] --> B[Control Flow & Loops]
    B --> C[Methods & Arrays]
    C --> D[Object-Oriented Programming OOP]
    D --> E[Inheritance, Abstraction & Polymorphism]
    E --> F[Encapsulation & Relationships]
    F --> G[Collections, Wrappers & Exceptions]
    G --> H[Advanced Basics: Generics, Concurrency, Files]
    H --> I[DSA & Design Patterns]
    I --> J[Spring Boot Prep]
```

---

## 🎯 Progress Tracker

- [x] **Phase 1: Procedural Fundamentals** (Chapters 01 - 06)
- [🔄] **Phase 2: Object-Oriented Programming** (Chapters 07 - 11 — OOP Basics Started)
- [🔄] **Phase 3: Core API & Ecosystem** (Chapters 12 - 16 — Collections Framework Active)
- [🔄] **Phase 4: Advanced Java Mechanics & Projects** (Beginner & Intermediate Projects Built)
- [🔄] **Phase 5: Data Structures & Algorithms** (Complexity Analysis & Core DSA Completed)
- [ ] **Phase 6: Object-Oriented Design Patterns** (Creational, Structural, Behavioral)

---

## 📂 Chapter Directory

All documentation is stored inside the `docs/` folder to keep the source tree clean. Use the links below to navigate between conceptual documentation and IntelliJ-runnable code.

📂 **Browse folders:** [All Java Notes](docs/java/) | [All Java Source Code](src/javakb/)

| Chapter  | Topic                                       | Concept Notes                            | Code Folder                                 | Status |
| :------- | :------------------------------------------ | :--------------------------------------- | :------------------------------------------ | :----: |
| **ch01** | Java Basics (Syntax, Printf, Input)         | [Notes](docs/java/ch01_basics.md)        | [Code](src/javakb/ch01_basics)              | `[x]`  |
| **ch02** | Control Flow (If-Else, Switch)              | [Notes](docs/java/ch02_controlflow.md)   | [Code](src/javakb/ch02_controlflow)         | `[x]`  |
| **ch03** | Loops (While, For, Nested)                  | [Notes](docs/java/ch03_loops.md)         | [Code](src/javakb/ch03_loops)               | `[x]`  |
| **ch04** | Methods (Scope, Overloading, Varargs)       | [Notes](docs/java/ch04_methods.md)       | [Code](src/javakb/ch04_methods)             | `[x]`  |
| **ch05** | Arrays (1D, 2D, Linear Search)              | [Notes](docs/java/ch05_arrays.md)        | [Code](src/javakb/ch05_arrays)              | `[x]`  |
| **ch06** | Strings (Manipulation, Builders)            | [Notes](docs/java/ch06_strings.md)       | [Code](src/javakb/ch06_strings)             | `[x]`  |
| **ch07** | Object-Oriented Basics (Classes, Statics)   | [Notes](docs/java/ch07_oop.md)           | [Code](src/javakb/ch07_oop)                 | `[🔄]` |
| **ch08** | Inheritance (Subclassing, Super, Overrides) | [Notes](docs/java/ch08_inheritance.md)   | [Code](src/javakb/ch08_inheritance)         | `[ ]`  |
| **ch09** | Abstraction (Interfaces, Polymorphism)      | [Notes](docs/java/ch09_abstraction.md)   | [Code](src/javakb/ch09_abstraction)         | `[ ]`  |
| **ch10** | Encapsulation (Accessors, Data Hiding)      | [Notes](docs/java/ch10_encapsulation.md) | [Code](src/javakb/ch10_encapsulation)       | `[ ]`  |
| **ch11** | Object Relationships (Aggregation, Comp)    | [Notes](docs/java/ch11_relationships.md) | [Code](src/javakb/ch11_relationships)       | `[ ]`  |
| **ch12** | Collections Framework (Lists, Maps, Sets)   | [Notes](docs/java/ch12_collections.md)   | [Code](src/javakb/ch12_collections)         | `[🔄]` |
| **ch13** | Exception Handling (Try-Catch, Custom)      | [Notes](docs/java/ch13_exceptions.md)    | [Code](src/javakb/ch13_exceptions)          | `[ ]`  |
| **ch14** | File Handling (Streams, Reader/Writer)      | [Notes](docs/java/ch14_filehandling.md)  | [Code](src/javakb/ch14_filehandling)        | `[ ]`  |
| **ch15** | Generics (Type safety, Bounds)              | [Notes](docs/java/ch15_generics.md)      | [Code](src/javakb/ch15_generics)            | `[ ]`  |
| **ch16** | Date & Time API (Modern Time APIs)          | [Notes](docs/java/ch16_datetime.md)      | [Code](src/javakb/ch16_datetime)            | `[ ]`  |
| **ch17** | Concurrency (Threads, Executors)            | [Notes](docs/java/ch17_concurrency.md)   | [Code](src/javakb/ch17_concurrency)         | `[ ]`  |

---

## 🏆 Projects Showcase

Hands-on console applications categorized by complexity:

📂 **Browse folder:** [Projects Source Code](src/javakb/projects/) | [Intermediate Projects README](src/javakb/projects/intermediate/README.md)

| Level | Project | Description | Code Link | Specs Link |
| :--- | :--- | :--- | :--- | :--- |
| **Beginner** | **Compound Interest Calculator** | Computes compound interest based on standard principal and rate user inputs. | [Code](src/javakb/projects/beginner/CompInterest.java) | [Doc Notes](docs/java/projects/beginner.md) |
| **Beginner** | **Console Calculator** | Multi-function CLI calculator utilizing static methods and varargs. | [Code](src/javakb/ch04_methods/ConsoleCalculator.java) | [Doc Notes](docs/java/projects/beginner.md) |
| **Beginner** | **Student Marks Analyzer** | Array statistics analyzer (total, average, max, min, pass/fail thresholds). | [Code](src/javakb/ch05_arrays/StudentMarksAnalyzer.java) | [Doc Notes](docs/java/projects/beginner.md) |
| **Intermediate** | **🎓 Student Management System** | Full CRUD student management application built with `ArrayList`, custom sorting (Name/GPA), and reversed views. | [Code](src/javakb/projects/intermediate/studentmanagement/) | [Project README](src/javakb/projects/intermediate/studentmanagement/readme.md) |
| **Intermediate** | **Console Vending Machine** | Retail vending machine simulation with inventory tracking, payment validation, and change calculation. | [Code](src/javakb/projects/intermediate/VendingMachine.java) | [Doc Notes](docs/java/projects/intermediate.md) |
| **Intermediate** | **Inventory Management System** | Multi-array inventory tracking application with low-stock alert monitoring. | [Code](src/javakb/ch05_arrays/InventoryManagement.java) | [Doc Notes](docs/java/projects/intermediate.md) |
| **Intermediate** | **Text Analyzer Project** | Text metrics analyzer with word/character counts, vowel breakdown, and palindrome validation. | [Code](src/javakb/ch06_strings/TextAnalyzerProject.java) | [Doc Notes](docs/java/projects/intermediate.md) |
| **Advanced** | *Placeholder* | Future multi-threaded file storage & concurrency applications | [Code](src/javakb/projects/advanced) | [Doc Notes](docs/java/projects/advanced.md) |


---

## 📊 DSA Notes

📂 **Browse folder:** [All DSA Notes](docs/dsa/)

Detailed analysis and implementations of Data Structures and Algorithms:

| Topic | Notes Link | Status |
| :--- | :--- | :---: |
| **Space-Time Complexity** | [Time & Space Complexity](docs/dsa/space-time%20complexity/time_space_complexity.md) | `[x]` |
| **Recursive Space-Time Complexity** | [Recursive Time & Space Complexity](docs/dsa/space-time%20complexity/recursive_time_space_complexity.md) | `[x]` |

> 🚧 **In Progress:** More Data Structures (Arrays, Linked Lists, Trees, Graphs) and Algorithmic paradigms are currently under development.

---

## 🎨 Design Patterns

📂 **Browse folder:** [Design Patterns Folder](docs/design_patterns/)

Object-Oriented Design Patterns and their clean implementations in Java:

> 🚧 **In Progress:** Notes and Java examples for Creational, Structural, and Behavioral patterns are in planning and development.

---

## 🧠 Obsidian Vault Setup

This project is optimized to be used as an **Obsidian Knowledge Vault**. To set up the vault locally:

1. **Download Obsidian:** Download and install Obsidian from [obsidian.md](https://obsidian.md) (free, cross-platform).
2. **Open Vault:** Launch Obsidian, select **"Open folder as vault"**, and choose the [docs/](docs/) directory specifically (do not select the repository root folder).
   * **Why only `docs/`?** This ensures Obsidian only indexes the markdown concept notes and ignores raw Java source code or build folders. Notes can still link to code folder paths relatively (`../../src/`), but your Obsidian vault environment remains clean and focused solely on note-taking.
3. **Core Plugins Recommended:**
   * **Graph View:** Turn this on to visualize how different Java chapters, DSA concepts, and projects connect with each other.
   * **Outline / Bookmarks:** Helpful for navigating long concept sheets.
   * **Tags Pane:** Displays properties and tags configured across notes.
   
*Note: All files are standard GitHub-Flavored Markdown. Relative links and formatting will render correctly directly on GitHub, but features like interactive graphs and visual canvas boards are best experienced inside Obsidian.*

---

## 🛠️ IntelliJ Setup & Compilation

To run the examples in this repository using IntelliJ IDEA:

1. Import the root `java-knowledge-base` folder into IntelliJ.
2. Mark the `src` folder as the **Sources Root** (Right-click `src` $\rightarrow$ *Mark Directory As* $\rightarrow$ *Sources Root*).
3. If packages show errors, run a project build/reindex (*Build* $\rightarrow$ *Rebuild Project*).

### Manual Compilation from Command Line
Because the code uses the base namespace package `javakb`, compile and run from the root folder:

```bash
# Compile a chapter file
javac -d out -sourcepath src src/javakb/ch07_oop/ClassesAndObjects.java

# Run the compiled file
java -cp out javakb.ch07_oop.ClassesAndObjects
```

---

## 🔮 Future Roadmap & Expansion

This repository is built to scale into these domains, combining ongoing expansions and planned modules:
* **DSA ([docs/dsa/](docs/dsa/)):** Expanding from complexity analysis into core Data Structures (Arrays, LinkedLists, Trees, Graphs) & Algorithmic paradigms.
* **Design Patterns ([docs/design_patterns/](docs/design_patterns/)):** Documenting Creational, Structural, and Behavioral patterns (structure initiated).
* **Advanced Java (`src/javakb/advanced_java/`):** Advanced stream APIs, Lambdas, JVM profiling.
* **JDBC (`src/javakb/jdbc/`):** Database integration patterns.
* **Spring Boot ([docs/spring_boot/](docs/spring_boot/)):** REST API creation and enterprise configurations.

---

## 👨‍💻 Author

**Harsh Wardhan**
* GitHub: [@harshwardhan1507](https://github.com/harshwardhan1507)
* Focus: Core Java • Software Architecture • DSA
