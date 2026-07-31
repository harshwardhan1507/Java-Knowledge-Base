# 🎓 Student Management System

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java" />
  <img src="https://img.shields.io/badge/Level-Intermediate-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Topic-Collections_%26_OOP-green?style=for-the-badge" />
</p>

---

## 📌 Overview

The **Student Management System** is a menu-driven Java console application designed to practice the **Java Collections Framework** (specifically `ArrayList`) alongside fundamental **Object-Oriented Programming (OOP)** principles.

This project forms an integral part of the **Java Knowledge Base** interactive projects suite, bridging the gap between basic collection manipulation and real-world CRUD (Create, Read, Update, Delete) application structure.

---

## 🚀 Features

- ➕ **Add Student**: Register new students with unique IDs, name, age, and GPA.
- 📋 **Display All Students**: List all stored student records with formatted card outputs.
- 🔍 **Search Student**: Lookup student details instantly using their unique Student ID.
- ✏️ **Update Student**: Modify name, age, and GPA of existing student records.
- ❌ **Delete Student**: Remove student records from memory by ID.
- 🔤 **Sort by Name**: Sort student list alphabetically using custom `Comparator`.
- 📊 **Sort by GPA**: Sort student list by academic performance (GPA).
- 🔄 **Reverse List**: Invert the current ordering of student records.
- 👥 **Total Students**: View current count of active student records.
- 🚪 **Exit**: Terminate application gracefully.

---

## 🧱 Project Architecture & Class Structure

```
studentmanagement/
├── Main.java               # Application entry point & interactive CLI menu loop
├── Student.java            # Encapsulated Student data model
├── StudentManager.java     # Business logic & ArrayList operations
└── readme.md               # Project documentation
```

### 1. `Student.java` (Data Model)
Encapsulates individual student entity fields and validation.
- **Fields:** `id` (String, immutable), `name` (String), `age` (int), `gpa` (double)
- **Responsibilities:**
  - Encapsulated getters & setters with validation logic (`age > 0`, `0.0 <= gpa <= 10.0`).
  - Multi-line card formatting via overridden `toString()`.

### 2. `StudentManager.java` (Business Logic Controller)
Manages the internal list of students using an `ArrayList<Student>`.
- **Responsibilities:**
  - Prevents duplicate Student IDs on insertion.
  - Implements CRUD operations (`addStudent`, `displayStudents`, `searchStudentById`, `updateStudent`, `deleteStudent`).
  - Implements sorting using `Comparator.comparing()` and `Comparator.comparingDouble()`.
  - Implements `Collections.reverse()` and `Collections.unmodifiableList()`.

### 3. `Main.java` (User Interface / Entry Point)
Handles terminal interaction and menu loop using `java.util.Scanner`.

---

## 📚 Core Java Concepts Practiced

| Category | Concepts Implemented |
| :--- | :--- |
| **Collections Framework** | `ArrayList<E>`, `Collections.sort()`, `Collections.reverse()`, `Collections.unmodifiableList()` |
| **List Operations** | `add()`, `get()`, `remove()`, `size()`, `isEmpty()` |
| **OOP Design** | Encapsulation, Data Hiding, Constructors, Getters/Setters, Method Separation |
| **Java Fundamentals** | `Scanner` input parsing, `switch-case` branching, `do-while` loops, formatted text blocks |

---

## 🖥️ Interactive Console Menu

```
========== Student Management System ==========
1. Add Student
2. Display Students
3. Search Student
4. Update Student
5. Delete Student
6. Sort by Name
7. Sort by GPA
8. Reverse Students
9. Total Students
10. Exit
===============================================
Enter your choice: 
```

### Sample Output Card
```
+---------------------------+
|      Student Details      |
+---------------------------+
| ID   : STU-101            |
| Name : Alice Smith        |
| Age  : 20                 |
| GPA  : 3.85               |
+---------------------------+
```

---

## 🛠️ How to Run

### Command Line Execution
Run from the root directory (`d:\Programming\Java Knowledge Base`):

```bash
# Compile project
javac -d out -sourcepath src src/javakb/projects/intermediate/studentmanagement/*.java

# Run main class
java -cp out javakb.projects.intermediate.studentmanagement.Main
```

---

## 🎯 Learning Outcomes

- Storing custom object instances in Java collections.
- Designing modular, multi-class console applications with decoupled responsibilities.
- Using Java `Comparator` for flexible sorting criteria.
- Defensive data validation within encapsulated setters.

---

## 📄 License

This project is part of the **Java Knowledge Base** repository and is maintained for educational purposes.