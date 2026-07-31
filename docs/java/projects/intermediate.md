# 🚀 Intermediate Java Projects

This document catalogs intermediate-level projects within the **Java Knowledge Base**. These projects bridge foundational procedural Java concepts with object-oriented software design, standard collection data structures, and interactive CLI interfaces.

---

## 🛠️ Intermediate Projects Catalog

### 1. 🎓 Student Management System
* **Location:** [`src/javakb/projects/intermediate/studentmanagement/`](../../../src/javakb/projects/intermediate/studentmanagement/)
* **Project Documentation:** [Student Management README](../../../src/javakb/projects/intermediate/studentmanagement/readme.md)
* **Source Code:**
  - [`Main.java`](../../../src/javakb/projects/intermediate/studentmanagement/Main.java) — Application entry point & interactive CLI menu loop.
  - [`Student.java`](../../../src/javakb/projects/intermediate/studentmanagement/Student.java) — Encapsulated student data model.
  - [`StudentManager.java`](../../../src/javakb/projects/intermediate/studentmanagement/StudentManager.java) — Business logic & `ArrayList<Student>` CRUD controller.
* **Key Topics:** `ArrayList`, Collections Framework, CRUD Operations, Custom Comparators, Sorting by Name & GPA, Encapsulation, CLI Menu Loop.

---

### 2. 🛒 Console Vending Machine
* **Location:** [`src/javakb/projects/intermediate/VendingMachine.java`](../../../src/javakb/projects/intermediate/VendingMachine.java)
* **Key Topics:** Retail transaction state machine, stock inventory tracking, payment validation, denomination change calculation, Scanner input handling.

---

### 3. 📦 Inventory Management System (Chapter 05 Mini-Project)
* **Location:** [`src/javakb/ch05_arrays/InventoryManagement.java`](../../../src/javakb/ch05_arrays/InventoryManagement.java)
* **Key Topics:** Parallel array tracking (Product IDs, Names, Stock levels), stock update operations, low-stock alert reporting.

---

### 4. 🔤 Text Analyzer Project (Chapter 06 Mini-Project)
* **Location:** [`src/javakb/ch06_strings/TextAnalyzerProject.java`](../../../src/javakb/ch06_strings/TextAnalyzerProject.java)
* **Key Topics:** String manipulation, word & character statistics, vowel/consonant distribution analysis, palindrome evaluation, string replacement.

---

## 💻 Compilation & Running Instructions

From the workspace root directory:

```bash
# Compile and run Student Management System
javac -d out -sourcepath src src/javakb/projects/intermediate/studentmanagement/*.java
java -cp out javakb.projects.intermediate.studentmanagement.Main

# Compile and run Console Vending Machine
javac -d out -sourcepath src src/javakb/projects/intermediate/VendingMachine.java
java -cp out javakb.projects.intermediate.VendingMachine
```
