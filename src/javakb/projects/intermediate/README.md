# 🚀 Intermediate Java Projects

Welcome to the **Intermediate Projects** section of the **Java Knowledge Base**.

These applications are designed to solidify Object-Oriented Programming (OOP), Java Collections (`ArrayList`, `List`, `Collections` utility methods), state management, and menu-driven CLI application patterns.

---

## 📂 Projects Overview

| Project Name | Primary Focus & Features | Code Link | Documentation |
| :--- | :--- | :--- | :--- |
| **🎓 Student Management System** | Full CRUD student management, `ArrayList`, custom sorting by Name & GPA, list reversal, menu CLI. | [Source Folder](studentmanagement/) | [Project README](studentmanagement/readme.md) |
| **🏛️ Apex Banking System** | Complete banking simulation with constructor chaining, static vault tracking, inter-account transfers, and interest engine. | [Source Folder](bankingsystem/) | [Project README](bankingsystem/readme.md) |
| **🛒 Console Vending Machine** | Retail item purchasing, inventory updates, coin validation, exact change calculation. | [`VendingMachine.java`](VendingMachine.java) | [Doc Notes](../../../../docs/java/projects/intermediate.md#3--console-vending-machine) |
| **📦 Inventory Management System** | Parallel array inventory tracking, low-stock threshold alerts. | [`InventoryManagement.java`](InventoryManagement.java) | [Doc Notes](../../../../docs/java/projects/intermediate.md#4--inventory-management-system) |
| **🔤 Text Analyzer Project** | Text metrics, word/char counts, vowel breakdown, palindrome check. | [`TextAnalyzer.java`](TextAnalyzer.java) | [Doc Notes](../../../../docs/java/projects/intermediate.md#5--text-analyzer-project) |

---

## 🛠️ How to Compile and Run

From the root directory of the workspace (`d:\Programming\Java Knowledge Base`):

### 1. Student Management System
```bash
javac -d out -sourcepath src src/javakb/projects/intermediate/studentmanagement/*.java
java -cp out javakb.projects.intermediate.studentmanagement.Main
```

### 2. Apex Banking System
```bash
javac -d out -sourcepath src src/javakb/projects/intermediate/bankingsystem/*.java
java -cp out javakb.projects.intermediate.bankingsystem.Main
```

### 3. Console Vending Machine
```bash
javac -d out -sourcepath src src/javakb/projects/intermediate/VendingMachine.java
java -cp out javakb.projects.intermediate.VendingMachine
```

### 4. Inventory Management System
```bash
javac -d out -sourcepath src src/javakb/projects/intermediate/InventoryManagement.java
java -cp out javakb.projects.intermediate.InventoryManagement
```

### 5. Text Analyzer
```bash
javac -d out -sourcepath src src/javakb/projects/intermediate/TextAnalyzer.java
java -cp out javakb.projects.intermediate.TextAnalyzer
```
