# 🏆 Java Knowledge Base — Projects Hub

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java" />
  <img src="https://img.shields.io/badge/Projects-Beginner_•_Intermediate_•_Advanced-blue?style=for-the-badge" />
</p>

---

## 📌 Overview

Welcome to the **Projects Hub** of the **Java Knowledge Base**! This directory contains practical, runnable Java applications designed to apply language concepts learned across all chapters.

The projects are structured into three progressive tiers:
1. 🟢 **Beginner Projects**: Procedural basics, math logic, conditions, loops, static methods, and 1D arrays.
2. 🔵 **Intermediate Projects**: Object-Oriented Programming (OOP), encapsulated models, CRUD business logic, Collections Framework (`ArrayList`, custom `Comparator` sorting), and state machines.
3. 🟣 **Advanced Projects**: Multithreading, Concurrent Collections, Network Socket programming, and File I/O.

---

## 📂 Projects Master Table

| Tier | Project Name | Description | Source Code Link | Documentation Link |
| :--- | :--- | :--- | :--- | :--- |
| 🟢 **Beginner** | **💰 Compound Interest Calculator** | Computes accrued compound interest using floating-point math formulas. | [`CompInterest.java`](beginner/CompInterest.java) | [Beginner README](beginner/README.md) |
| 🟢 **Beginner** | **🧮 Console Calculator** | Multi-function calculator with static methods and varargs summation. | [`ConsoleCalculator.java`](beginner/ConsoleCalculator.java) | [Beginner README](beginner/README.md) |
| 🟢 **Beginner** | **📊 Student Marks Analyzer** | Array scores analyzer computing avg, max, min, and pass/fail counts. | [`StudentMarksAnalyzer.java`](beginner/StudentMarksAnalyzer.java) | [Beginner README](beginner/README.md) |
| 🔵 **Intermediate** | **🎓 Student Management System** | Full CRUD student manager with `ArrayList`, custom sorting by Name & GPA, and list reversal. | [`studentmanagement/`](intermediate/studentmanagement/) | [Student Management README](intermediate/studentmanagement/readme.md) |
| 🔵 **Intermediate** | **🏛️ Apex Banking System** | Full console banking application with constructor chaining, static vault tracking, inter-account transfers, and interest engines. | [`bankingsystem/`](intermediate/bankingsystem/) | [Banking System README](intermediate/bankingsystem/readme.md) |
| 🔵 **Intermediate** | **🛒 Console Vending Machine** | Retail vending simulation with inventory management and change calculation. | [`VendingMachine.java`](intermediate/VendingMachine.java) | [Intermediate README](intermediate/README.md) |
| 🔵 **Intermediate** | **📦 Inventory Management System** | Parallel array inventory tracker with low-stock threshold alerts. | [`InventoryManagement.java`](intermediate/InventoryManagement.java) | [Intermediate README](intermediate/README.md) |
| 🔵 **Intermediate** | **🔤 Text Analyzer Project** | Text statistics tool evaluating words, chars, vowels, and palindromes. | [`TextAnalyzer.java`](intermediate/TextAnalyzer.java) | [Intermediate README](intermediate/README.md) |
| 🟣 **Advanced** | **Concurrent File Storage & Indexer** | Parallel file scanner building searchable inverted indexes (*Planned*). | [`advanced/`](advanced/) | [Advanced README](advanced/README.md) |

---

## 🛠️ General Running Instructions

Run commands from the workspace root directory (`d:\Programming\Java Knowledge Base`):

```bash
# Student Management System
javac -d out -sourcepath src src/javakb/projects/intermediate/studentmanagement/*.java
java -cp out javakb.projects.intermediate.studentmanagement.Main

# Apex Banking System
javac -d out -sourcepath src src/javakb/projects/intermediate/bankingsystem/*.java
java -cp out javakb.projects.intermediate.bankingsystem.Main

# Console Vending Machine
javac -d out -sourcepath src src/javakb/projects/intermediate/VendingMachine.java
java -cp out javakb.projects.intermediate.VendingMachine

# Inventory Management System
javac -d out -sourcepath src src/javakb/projects/intermediate/InventoryManagement.java
java -cp out javakb.projects.intermediate.InventoryManagement

# Text Analyzer Project
javac -d out -sourcepath src src/javakb/projects/intermediate/TextAnalyzer.java
java -cp out javakb.projects.intermediate.TextAnalyzer

# Compound Interest Calculator
javac -d out -sourcepath src src/javakb/projects/beginner/CompInterest.java
java -cp out javakb.projects.beginner.CompInterest

# Console Calculator
javac -d out -sourcepath src src/javakb/projects/beginner/ConsoleCalculator.java
java -cp out javakb.projects.beginner.ConsoleCalculator

# Student Marks Analyzer
javac -d out -sourcepath src src/javakb/projects/beginner/StudentMarksAnalyzer.java
java -cp out javakb.projects.beginner.StudentMarksAnalyzer
```
