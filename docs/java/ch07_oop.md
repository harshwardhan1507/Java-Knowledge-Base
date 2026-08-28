# Chapter 7 — Object-Oriented Programming (OOP) Basics

## Introduction & Intuition

Up to this point in your Java journey (Chapters 01–06), you have written programs using a **procedural paradigm** — declaring variables, processing inputs with loops and conditionals, and calling standalone static methods.

While procedural programming works well for small scripts, real-world software (like banking systems, e-commerce platforms, video games, or operating systems) deals with hundreds of distinct entities. Trying to manage loose variables like `car1Speed`, `car2Speed`, `student1Name`, `student2Gpa` quickly leads to unmaintainable, error-prone spaghetti code.

**Object-Oriented Programming (OOP)** solves this by bundling **State (Data)** and **Behavior (Functions)** together into self-contained units called **Objects**.

---

## Procedural vs. Object-Oriented Paradigm

| Feature | Procedural Programming (C, Early Scripts) | Object-Oriented Programming (Java, C++, C#) |
| :--- | :--- | :--- |
| **Core Focus** | Actions & Sequence of steps (Functions) | Real-world Entities & Data Models (Objects) |
| **Data & Functions** | Data is separated from the functions that manipulate it | Data (fields) and behavior (methods) are tightly bundled together |
| **Data Security** | Data moves freely across global/local scopes | Data is encapsulated within objects |
| **Code Reusability** | Limited; relies on function calls | High; achieved via classes, inheritance, and composition |
| **Real-world Modeling**| Difficult to model complex systems | Natural representation of real-world objects |

---

## 1. Classes and Objects Anatomy

> A **Class** is a blueprint, template, or prototype from which individual objects are created. It defines what attributes (state) and actions (behavior) an object will have.
>
> An **Object** is a concrete instance of a class occupying physical memory on the **Heap**.

### Real-World Analogy:
- **Class (Blueprint)**: The architectural drawing of a house specifying rooms, dimensions, and wiring. You cannot live inside a blueprint.
- **Object (Instance)**: The physical house constructed on a plot of land with its own paint color, furniture, and address. You can build 50 distinct houses from 1 blueprint.

```java
// Blueprint (Class)
class Car {
    // 1. STATE (Instance Variables / Fields)
    String brand;
    String model;
    int year;
    double speed;
    boolean isEngineRunning;

    // 2. CONSTRUCTOR (Initializes new instances)
    Car(String brand, String model, int year, double speed) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.speed = speed;
        this.isEngineRunning = false;
    }

    // 3. BEHAVIOR (Instance Methods)
    void startEngine() {
        this.isEngineRunning = true;
        System.out.println(brand + " " + model + " engine started.");
    }

    void accelerate(double amount) {
        if (isEngineRunning) {
            speed += amount;
            System.out.println("Accelerated to " + speed + " km/h.");
        }
    }
}
```

---

## 2. Java Memory Model & Object Lifecycle

Understanding how Java allocates memory for objects is essential for mastering references, aliasing, and Garbage Collection.

### Stack vs. Heap Memory:
1. **Stack Memory**:
   - Stores local primitive variables (`int`, `double`, `boolean`).
   - Stores **reference variables** (which hold memory addresses pointing to Heap objects).
   - Fast, automatic allocation and deallocation tied to method call frames.
2. **Heap Memory**:
   - Stores all actual **object instances** and their instance variables.
   - Managed automatically by the Java Virtual Machine's **Garbage Collector (GC)**.

### ASCII Memory Allocation & Aliasing Diagram:

```text
    STACK MEMORY                                  HEAP MEMORY
+------------------------+            +------------------------------------+
|                        |            |                                    |
|  main() Frame          |            |  [ Object 1 at Address 0x100 ]     |
|                        |            |  Class: Device                     |
|  phone1 = 0x100  -----------------> |  deviceName: "iPhone 15 Pro"       |
|                        |     +----> |  batteryLevel: 65                  |
|  phone2 = 0x100  ------------+      |                                    |
|  (Alias of phone1)     |            +------------------------------------+
|                        |
|  phone3 = 0x200  -----------------> +------------------------------------+
|  (Distinct Object)     |            |  [ Object 2 at Address 0x200 ]     |
|                        |            |  Class: Device                     |
|                        |            |  deviceName: "iPhone 15 Pro"       |
|                        |            |  batteryLevel: 100                 |
|                        |            +------------------------------------+
+------------------------+
```

### Object Aliasing (Multiple References to One Object)
When you assign one reference variable to another (`Device phone2 = phone1;`), Java copies the **memory address (0x100)**, NOT the object.
Both variables now point to the exact same object on the Heap:

```java
Device phone1 = new Device("iPhone 15 Pro", 100);
Device phone2 = phone1; // phone2 is an alias for phone1

phone2.useDevice(35); // Mutates battery to 65%

System.out.println(phone1.batteryLevel); // 65% (Reflected through phone1!)
System.out.println(phone1 == phone2);    // true (Identical heap addresses)
```

### The `null` Reference & `NullPointerException`
If a reference variable does not point to any object in Heap memory, its value is `null`.
Attempting to access fields or invoke methods on a `null` reference results in a runtime **`NullPointerException` (NPE)**:

```java
Device unassignedPhone = null;

// Unsafe access -> Throws NullPointerException at runtime!
// unassignedPhone.useDevice(10); 

// Safe defensive check:
if (unassignedPhone != null) {
    unassignedPhone.useDevice(10);
} else {
    System.out.println("Reference is null; skipping invocation.");
}
```

### Object Lifecycle & Garbage Collection (GC)
An object on the Heap remains alive as long as there is at least one active stack reference pointing to it.
When an object loses all active references (by falling out of scope, reference reassignment, or being set to `null`), it becomes **unreachable** (an orphan object) and is automatically eligible for Garbage Collection.

```java
Device temp = new Device("Tablet", 50); // Object created on Heap
temp = null; // Object is now unreachable; JVM GC reclaims its memory
```

---

## 3. Constructors in Depth

A **Constructor** is a special member function invoked automatically when an object is instantiated using the `new` keyword. Its primary purpose is to initialize the newly allocated object's state.

### Constructor Characteristics:
1. Must have the **exact same name** as the class.
2. Has **NO return type** (not even `void`).
3. Cannot be `abstract`, `static`, `final`, or `synchronized`.

### Types of Constructors:

| Constructor Type | Definition & Purpose | Example |
| :--- | :--- | :--- |
| **Default Constructor** | Automatically generated by the Java compiler **only if no other constructors are defined**. Takes no arguments and initializes fields to default values (`0`, `null`, `false`). | `public SimpleBox() { super(); }` |
| **No-Arg Constructor** | Explicitly written constructor with 0 parameters. Often sets default application values. | `public AccountProfile() { ... }` |
| **Parameterized Constructor**| Accepts arguments to initialize instance variables with custom values upon instantiation. | `public AccountProfile(String user, String email)` |
| **Overloaded Constructors** | Multiple constructors in the same class differing in parameter count, types, or order. | `AccountProfile()`, `AccountProfile(u, e)`, `AccountProfile(u, e, t, p)` |
| **Copy Constructor** | Accepts an existing object of the same class and copies its state into a new, independent instance. | `public AccountProfile(AccountProfile other)` |

### Constructor Chaining using `this(...)`
Constructor chaining allows one constructor to call another overloaded constructor within the same class. This follows the **DRY (Don't Repeat Yourself)** principle by centralizing all initialization logic in a single "master" constructor.

```java
class AccountProfile {
    String username;
    String email;
    String tier;
    int points;

    // No-arg constructor chains to 4-parameter constructor
    AccountProfile() {
        this("Guest_User", "guest@example.com", "BRONZE", 0);
    }

    // 2-parameter constructor chains to 4-parameter constructor
    AccountProfile(String username, String email) {
        this(username, email, "STANDARD", 100);
    }

    // Master Constructor (Performs actual field assignments)
    AccountProfile(String username, String email, String tier, int points) {
        this.username = username;
        this.email = email;
        this.tier = tier;
        this.points = points;
    }
}
```

> [!IMPORTANT]
> `this(...)` **MUST be the very first statement** in the constructor body. Calling anything before `this(...)` results in a compilation error.

---

## 4. The `this` Keyword

In Java, `this` is a reference variable that points directly to the **current object instance** whose method or constructor is currently executing.

### 4 Primary Use Cases of `this`:

### 1. Resolving Variable Shadowing (Disambiguation)
When a constructor or method parameter has the identical name as an instance field, the parameter "shadows" (hides) the field. Use `this.fieldName` to explicitly reference the instance variable:

```java
class Order {
    int orderId;
    String customer;

    Order(int orderId, String customer) {
        this.orderId = orderId;   // this.orderId is the field; orderId is the parameter
        this.customer = customer;
    }
}
```

### 2. Invoking Current Class Methods
Explicitly stating that a method call belongs to the current instance (useful for code clarity):
```java
void processOrder() {
    this.validatePayment();
    this.notifyWarehouse();
}
```

### 3. Passing `this` as a Method Argument
Passes the current object reference to an external helper or logging utility:
```java
OrderAuditLogger.logOrderCreation(this); // Passes current Order object
```

### 4. Returning `this` for Fluent Method Chaining (Builder Pattern)
By returning `this` from mutator methods, callers can chain multiple method invocations together in a single fluid statement:

```java
class Order {
    Order addItem(String name, double price) {
        // add item logic...
        return this; // Return current object
    }

    Order applyDiscount(double percent) {
        // discount logic...
        return this; // Return current object
    }
}

// Fluent Method Chaining Usage:
myOrder.addItem("Keyboard", 120.00)
       .addItem("Mouse", 55.00)
       .applyDiscount(10.0);
```

---

## 5. `static` vs. Instance Members

The `static` keyword in Java indicates that a member (variable, method, block, or nested class) belongs to the **Class itself**, rather than to individual object instances.

### Comparison Table:

| Property | Instance Member | Static Member (`static`) |
| :--- | :--- | :--- |
| **Memory Location** | Stored in **Heap** inside each object | Stored in **Metaspace / Class Area** |
| **Copies** | Each object has its own separate copy | Single shared copy for the entire application |
| **Access Syntax** | Via object reference (`object.method()`) | Via Class name directly (`ClassName.method()`) |
| **Access to `this`** | Yes (has access to calling object) | **No** (`this` is illegal in static context) |
| **Access Capabilities** | Can access BOTH instance and static members | Can ONLY directly access other static members |
| **Lifetime** | Created with `new`, destroyed by GC | Loaded when class is loaded, persists for JVM life |

### Static vs. Instance Initializer Blocks

```java
class Employee {
    public static final String COMPANY_NAME = "NovaTech";
    private static int totalHired = 0;
    private int employeeId;

    // 1. STATIC INITIALIZER BLOCK (Executes ONCE when class is loaded into JVM)
    static {
        System.out.println("1. Static Block: Class loaded into Metaspace.");
    }

    // 2. INSTANCE INITIALIZER BLOCK (Executes on EVERY 'new', BEFORE constructor)
    {
        totalHired++;
        this.employeeId = 1000 + totalHired;
        System.out.println("2. Instance Block: Generated ID " + this.employeeId);
    }

    // 3. CONSTRUCTOR (Executes after Instance Block)
    Employee(String name) {
        System.out.println("3. Constructor: Employee initialized.");
    }
}
```

### Exact Initialization Order:
1. **Static Initializer Blocks & Static Field Init** *(Once per class loading)*.
2. **Instance Initializer Blocks & Field Init** *(Every `new` object creation)*.
3. **Constructor Body Execution** *(Immediately after Instance Block finishes)*.

---

## 6. Java Parameter Passing Mechanics (Pass-by-Value)

> [!NOTE]
> **Fundamental Rule:** Java is **100% PASS-BY-VALUE, ALWAYS**. Java never passes by reference.

### Case A: Passing Primitive Types (`int`, `double`, `boolean`)
When passing a primitive, Java creates an exact copy of the raw value in the called method's stack frame. Modifications inside the method have **zero effect** on the caller:

```java
void modify(int x) {
    x = x + 50; // Modifies local stack copy only
}

int num = 100;
modify(num);
System.out.println(num); // 100 (Unchanged!)
```

### Case B: Passing Object References
When passing an object, Java copies the **memory address (the reference value)** onto the parameter's stack frame.
1. **Mutating State (`obj.field = val` or `obj.method()`):** Modifies the actual object on the Heap because both the caller and parameter hold references to the same memory location.
2. **Reassigning Parameter (`obj = new Object()`):** Overwrites only the local parameter reference on the stack. The caller's reference remains unchanged!

```text
    CALLER STACK FRAME                   CALLED METHOD STACK FRAME
+--------------------------+          +-----------------------------+
| myWallet = 0x500 --------+          | wallet (param copy) = 0x500 |
+--------------------------+ \        +-----------------------------+
                              \                     /
                               v                   v
                        +---------------------------------+
                        |   HEAP OBJECT at 0x500          |
                        |   owner: "Harsh"                |
                        |   balance: $150.00 -> $225.00   |
                        +---------------------------------+
```

---

## 7. Capstone Mini-Project: Apex Reserve Banking System

The module includes a comprehensive banking domain application available both as a standalone chapter file ([`BankAccountProject.java`](../../src/javakb/ch07_oop/BankAccountProject.java)) and as a modular multi-class package in the projects hub ([`src/javakb/projects/intermediate/bankingsystem/`](../../src/javakb/projects/intermediate/bankingsystem/)) combining all Chapter 7 concepts:

### Key Design Features:
- **`BankAccount` & `Transaction` Classes**: Encapsulated state and behaviors.
- **Constructor Chaining (`this(...)`)**: Minimal, standard, and master account initialization.
- **Static Vault Tracking**: Centralized counter for unique account numbers (`10001`, `10002`) and bank capital auditing.
- **Fluent Method Chaining**: Builder-style configuration for interest rates and account types.
- **Inter-Account Transfers**: Pass-by-value reference manipulation between accounts.
- **Static vs Instance Blocks**: System boot initialization vs per-account ID generation.

---

## Common Mistakes & Pitfalls

> [!WARNING]
> **1. Attempting to use `this` or instance fields inside a `static` method**
> `static` methods belong to the class and run without any object instance. Calling `this.name` or non-static methods inside `public static void main()` causes a compiler error: *"non-static variable this cannot be referenced from a static context"*.

> [!WARNING]
> **2. Placing `this(...)` anywhere other than the first line in a constructor**
> Java enforces that constructor delegation via `this(...)` must execute before any custom statements. Putting statements before `this(...)` causes a compilation error.

> [!WARNING]
> **3. Variable Shadowing without `this`**
> In `Car(String brand) { brand = brand; }`, the parameter assigns to itself, leaving the instance field uninitialized (`null`). Always use `this.brand = brand;`.

> [!WARNING]
> **4. Assuming `obj1 = obj2` clones an object**
> Assignment copies only the reference address (aliasing). Changing `obj1` will unexpectedly mutate `obj2`. Use a copy constructor or manual copy method to create distinct instances.

> [!WARNING]
> **5. Dereferencing `null` references**
> Invoking methods on a variable holding `null` throws `NullPointerException`. Always ensure proper initialization or use defensive `!= null` checks.

---

## Conceptual Interview Questions & Answers

### Q1: What is the difference between a Class and an Object?
**Answer:** A Class is a compile-time blueprint or template defining the structure (fields) and capabilities (methods). An Object is a runtime instance of that blueprint that occupies physical memory in Heap space.

### Q2: Why is Java strictly "Pass-by-Value"?
**Answer:** In Java, arguments are always passed by copying their bit representation. For primitives, the primitive value is copied. For objects, the memory address (reference) is copied by value. Because reassigning the reference parameter does not alter the caller's reference variable, Java is purely pass-by-value.

### Q3: What happens if you define a constructor in a class? Does the compiler still generate a default constructor?
**Answer:** **No.** As soon as you define *any* explicit constructor (with or without arguments), the Java compiler immediately stops providing the automatic default no-arg constructor. If you still need a no-arg constructor, you must write it explicitly.

### Q4: What is Constructor Chaining?
**Answer:** Constructor chaining is the technique of calling one constructor from another overloaded constructor within the same class using `this(...)` (or from a subclass using `super(...)`). It centralizes initialization code and avoids duplicate logic.

### Q5: Can a static method be overridden in Java?
**Answer:** **No.** Static methods belong to the class and are resolved at compile-time (static binding / method hiding), whereas method overriding relies on dynamic dispatch at runtime based on the actual object instance.

---

## Practice Exercises

### Exercise 1 (Beginner — Library Book Model):
Create a `Book` class with fields: `title`, `author`, `isbn`, `isBorrowed`.
1. Provide a parameterized constructor.
2. Implement methods: `borrowBook()`, `returnBook()`, and `displayBookInfo()`.
3. In `main()`, instantiate 3 book objects and simulate borrowing/returning them.

### Exercise 2 (Intermediate — Constructor Chaining & Static Counter):
Create a `Product` class with fields: `productId`, `name`, `category`, `price`, `stockQuantity`.
1. Maintain a `private static int productCounter = 0` to auto-assign sequential IDs starting from `5001`.
2. Implement 3 overloaded constructors using `this(...)` chaining.
3. Add a static method `getTotalProductsCreated()`.

### Exercise 3 (Advanced — Fluent Profile Builder & Reference Transfer):
Create a `UserProfile` class supporting fluent method chaining:
`new UserProfile("alice").setEmail("alice@mail.com").setPhone("555-0199").activate();`
Implement a method `transferSettingsFrom(UserProfile other)` demonstrating reference manipulation and state copying.

---

## Related Source Files

- 📄 [`ClassesAndObjects.java`](../../src/javakb/ch07_oop/ClassesAndObjects.java) — Class blueprints, object instantiation, state mutation, and method invocation.
- 📄 [`ObjectMemoryAndLifecycle.java`](../../src/javakb/ch07_oop/ObjectMemoryAndLifecycle.java) — Stack vs Heap memory, reference aliasing, `null` safety, and GC lifecycle.
- 📄 [`ConstructorsDemo.java`](../../src/javakb/ch07_oop/ConstructorsDemo.java) — Default, no-arg, parameterized, overloading, copy constructor, and `this(...)` chaining.
- 📄 [`ThisKeywordDemo.java`](../../src/javakb/ch07_oop/ThisKeywordDemo.java) — Shadowing resolution, current method calling, passing `this`, and fluent method chaining.
- 📄 [`StaticVsInstanceDemo.java`](../../src/javakb/ch07_oop/StaticVsInstanceDemo.java) — Static vs instance fields/methods, static blocks, and execution ordering.
- 📄 [`PassByValueDemo.java`](../../src/javakb/ch07_oop/PassByValueDemo.java) — Proof of Pass-by-Value for primitives and object references.
- 📄 [`BankAccountProject.java`](../../src/javakb/ch07_oop/BankAccountProject.java) — Capstone console banking simulation synthesizing all Chapter 7 concepts.
- 📁 [`bankingsystem/`](../../src/javakb/projects/intermediate/bankingsystem/) — Modular multi-class banking system in the intermediate projects hub.
