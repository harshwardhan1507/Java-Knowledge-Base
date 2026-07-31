# 🚀 Intermediate Java Projects

Welcome to the **Intermediate Projects** section of the **Java Knowledge Base**.

These applications are designed to solidify Object-Oriented Programming (OOP), Java Collections (`ArrayList`, `List`, `Collections` utility methods), state management, and menu-driven CLI application patterns.

---

## 📂 Projects Overview

| Project Name | Primary Focus & Features | Code Link | Documentation |
| :--- | :--- | :--- | :--- |
| **🎓 Student Management System** | Full CRUD student management, `ArrayList`, custom sorting by Name & GPA, list reversal, menu CLI. | [Source Folder](studentmanagement/) | [Project README](studentmanagement/readme.md) |
| **🛒 Console Vending Machine** | Retail item purchasing, inventory updates, coin validation, exact change calculation. | [`VendingMachine.java`](VendingMachine.java) | [Doc Notes](../../../../docs/java/projects/intermediate.md) |
| **📦 Inventory Management System** | Chapter 05 Array project: parallel array inventory tracking, low-stock threshold alerts. | [`InventoryManagement.java`](../../ch05_arrays/InventoryManagement.java) | [Doc Notes](../../../../docs/java/projects/intermediate.md) |
| **🔤 Text Analyzer Project** | Chapter 06 String project: text metrics, word/char counts, vowel breakdown, palindrome check. | [`TextAnalyzerProject.java`](../../ch06_strings/TextAnalyzerProject.java) | [Doc Notes](../../../../docs/java/projects/intermediate.md) |

---

## 🛠️ How to Compile and Run

From the root directory of the workspace (`d:\Programming\Java Knowledge Base`):

### 1. Student Management System
```bash
javac -d out -sourcepath src src/javakb/projects/intermediate/studentmanagement/*.java
java -cp out javakb.projects.intermediate.studentmanagement.Main
```

### 2. Console Vending Machine
```bash
javac -d out -sourcepath src src/javakb/projects/intermediate/VendingMachine.java
java -cp out javakb.projects.intermediate.VendingMachine
```
