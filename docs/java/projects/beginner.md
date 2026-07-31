# 🎯 Beginner Java Projects

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java" />
  <img src="https://img.shields.io/badge/Level-Beginner-green?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Focus-Procedural_%26_Arrays-blue?style=for-the-badge" />
</p>

---

## 📌 Overview

This document catalogs beginner-level projects in the **Java Knowledge Base**. Beginner projects focus on mastering procedural programming fundamentals: primitive data types, basic arithmetic formulas, control flow (`if-else`, `switch`), loops (`for`, `while`, `do-while`), static methods, and 1D arrays.

---

## 🛠️ Beginner Projects Catalog

### 1. 💰 Compound Interest Calculator
* **Location:** [`src/javakb/projects/beginner/CompInterest.java`](../../../src/javakb/projects/beginner/CompInterest.java)
* **Description:** Console-based financial calculator that computes accrued compound interest using the formula:
  \[
  A = P \times \left(1 + \frac{r}{n}\right)^{n \times t}
  \]
* **Key Topics:** `Scanner` input, `Math.pow()`, double floating-point arithmetic, variable declarations.

---

### 2. 🧮 Console Calculator (Chapter 04 Mini-Project)
* **Location:** [`src/javakb/ch04_methods/ConsoleCalculator.java`](../../../src/javakb/ch04_methods/ConsoleCalculator.java)
* **Description:** Menu-driven multi-purpose CLI calculator using static modular methods for core arithmetic operations and multi-operand varargs summation.
* **Key Topics:** Static methods, method overloading, varargs (`double...`), zero-division validation, interactive `switch` menu loop.

---

### 3. 📊 Student Marks Analyzer (Chapter 05 Mini-Project)
* **Location:** [`src/javakb/ch05_arrays/StudentMarksAnalyzer.java`](../../../src/javakb/ch05_arrays/StudentMarksAnalyzer.java)
* **Description:** Array-driven performance analyzer that processes student exam scores to calculate sum, average, max mark, min mark, and pass/fail distribution counts.
* **Key Topics:** 1D Arrays, array traversal, linear min/max search, accumulator patterns, pass/fail threshold evaluation (40 marks).

---

## 💻 Compilation & Running Instructions

Execute the following commands from the workspace root directory (`d:\Programming\Java Knowledge Base`):

```bash
# Compile and run Compound Interest Calculator
javac -d out -sourcepath src src/javakb/projects/beginner/CompInterest.java
java -cp out javakb.projects.beginner.CompInterest

# Compile and run Console Calculator
javac -d out -sourcepath src src/javakb/ch04_methods/ConsoleCalculator.java
java -cp out javakb.ch04_methods.ConsoleCalculator

# Compile and run Student Marks Analyzer
javac -d out -sourcepath src src/javakb/ch05_arrays/StudentMarksAnalyzer.java
java -cp out javakb.ch05_arrays.StudentMarksAnalyzer
```
