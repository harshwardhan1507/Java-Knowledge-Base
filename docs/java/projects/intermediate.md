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

### 2. 🏛️ Apex National Reserve Banking System
* **Location:** [`src/javakb/projects/intermediate/bankingsystem/`](../../../src/javakb/projects/intermediate/bankingsystem/)
* **Project Documentation:** [Banking System README](../../../src/javakb/projects/intermediate/bankingsystem/readme.md)
* **Source Code:**
  - [`Main.java`](../../../src/javakb/projects/intermediate/bankingsystem/Main.java) — Application entry point & interactive banking menu loop.
  - [`BankAccount.java`](../../../src/javakb/projects/intermediate/bankingsystem/BankAccount.java) — Domain model with constructor chaining, fluent setters, and static counters.
  - [`Transaction.java`](../../../src/javakb/projects/intermediate/bankingsystem/Transaction.java) — Financial record model.
  - [`BankManager.java`](../../../src/javakb/projects/intermediate/bankingsystem/BankManager.java) — Repository controller coordinating account operations and transfers.
* **Key Topics:** Classes & Objects, Constructor Chaining (`this(...)`), The `this` Keyword (fluent chaining), Static Members & Constants, Static/Instance Initializer Blocks, Pass-by-Value with Object References.

---

### 3. 🛒 Console Vending Machine
* **Location:** [`src/javakb/projects/intermediate/VendingMachine.java`](../../../src/javakb/projects/intermediate/VendingMachine.java)
* **Key Topics:** Retail transaction state machine, stock inventory tracking, payment validation, denomination change calculation, Scanner input handling.

---

### 4. 📦 Inventory Management System
* **Location:** [`src/javakb/projects/intermediate/InventoryManagement.java`](../../../src/javakb/projects/intermediate/InventoryManagement.java)
* **Key Topics:** Parallel array tracking (Product IDs, Names, Stock levels), stock update operations, low-stock alert reporting.

---

### 5. 🔤 Text Analyzer Project
* **Location:** [`src/javakb/projects/intermediate/TextAnalyzer.java`](../../../src/javakb/projects/intermediate/TextAnalyzer.java)
* **Key Topics:** String manipulation, word & character statistics, vowel/consonant distribution analysis, palindrome evaluation, string replacement.

---

## 💻 Compilation & Running Instructions

From the workspace root directory (`d:\Programming\Java Knowledge Base`):

```bash
# Compile and run Student Management System
javac -d out -sourcepath src src/javakb/projects/intermediate/studentmanagement/*.java
java -cp out javakb.projects.intermediate.studentmanagement.Main

# Compile and run Apex Banking System
javac -d out -sourcepath src src/javakb/projects/intermediate/bankingsystem/*.java
java -cp out javakb.projects.intermediate.bankingsystem.Main

# Compile and run Console Vending Machine
javac -d out -sourcepath src src/javakb/projects/intermediate/VendingMachine.java
java -cp out javakb.projects.intermediate.VendingMachine

# Compile and run Inventory Management System
javac -d out -sourcepath src src/javakb/projects/intermediate/InventoryManagement.java
java -cp out javakb.projects.intermediate.InventoryManagement

# Compile and run Text Analyzer
javac -d out -sourcepath src src/javakb/projects/intermediate/TextAnalyzer.java
java -cp out javakb.projects.intermediate.TextAnalyzer
```
