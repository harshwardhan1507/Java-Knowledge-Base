# Chapter 4: Java Methods

## Introduction & Simple Intuition

As your programs grow beyond simple sequential scripts, writing all logic inside `public static void main(String[] args)` becomes messy, repeated, and impossible to maintain.

Imagine building a banking system where you need to format currency, validate account numbers, and compute interest in twenty different places. Copy-pasting the same lines of code creates massive duplication, increases bugs, and makes updates tedious.

This is where **Methods** help.

> A **Method** is a named, reusable block of code that performs a specific task. You define a method once and invoke (call) it whenever and wherever needed.

Methods enable:
- **Reusability (DRY - Don't Repeat Yourself)**: Write logic once, run it anywhere.
- **Abstraction**: Use a method knowing *what* it does without cluttering your code with *how* it does it.
- **Modularity**: Break complex problems into smaller, manageable, and readable functions.
- **Maintainability & Testing**: Update or debug logic in one central place.

---

# Anatomy of a Java Method

A method definition in Java consists of several key components:

```java
public static int calculateSum(int a, int b) {
    int result = a + b;
    return result;
}
```

### Components Breakdown:

1. **Access Modifier (`public`, `private`, `protected`, package-private)**: Defines where the method can be called from.
2. **Non-Access Modifier (`static`, `final`, `abstract`)**: Optional keyword. `static` means the method belongs to the class itself rather than instances of the class.
3. **Return Type (`void`, `int`, `double`, `boolean`, `String`, etc.)**: Specifies the type of data returned to the caller. Use `void` if no value is returned.
4. **Method Name (`calculateSum`)**: Descriptive, lowerCamelCase name representing the method's action.
5. **Parameter List (`(int a, int b)`)**: Comma-separated list of formal parameters (inputs) accepted by the method.
6. **Method Body (`{ ... }`)**: The block of code executed when the method is invoked.
7. **Return Statement (`return result;`)**: Yields the output value back to the caller and terminates method execution.

---

# 1. [BasicMethod.java](../../src/javakb/ch04_methods/BasicMethod.java) — Declaration & Invocation

**Concept:** Methods must be declared inside a class body (outside of other methods) and called from within `main()` or other methods.

```java
package javakb.ch04_methods;

public class BasicMethod {

    // Static method defined outside main()
    public static void greet() {
        System.out.println("Hello! You are inside the greet() method.");
    }

    public static void greetUser(String name) {
        System.out.println("Welcome to Java Methods, " + name + "!");
    }

    public static void main(String[] args) {
        // Invoking greet() method multiple times
        greet();
        greet();

        // Invoking method with arguments
        greetUser("Harsh");
    }
}
```

### Key Takeaways:
- **Why `static`?** The `main()` entry point is `static`. Static methods can directly call other `static` methods in the same class without instantiating an object (`new ClassName()`).
- **Method Execution Flow**: Execution begins in `main()`. When `greet()` is called, control jumps to `greet()`, runs its body, and returns control back to `main()`.

---

# 2. [MethodParameters.java](../../src/javakb/ch04_methods/MethodParameters.java) — Parameters & Pass-by-Value

**Concept:** 
- **Formal Parameters**: Variables declared in the method definition signature (e.g., `int a, int b`).
- **Actual Arguments**: Concrete values or variables passed to the method during invocation (e.g., `add(10, 20)`).

### Crucial Java Rule: Java is STRICTLY Pass-by-Value

Java NEVER uses Pass-by-Reference. Whenever you pass an argument into a method, Java creates a **copy** of the value.

| Data Type | What gets copied into parameter? | Modifying parameter inside method affects caller? |
|---|---|---|
| **Primitive Types** (`int`, `double`, `boolean`) | A copy of the primitive value | **No**. Changes in method are lost upon exit. |
| **Reference Types** (Objects, Arrays) | A copy of the memory address (reference) | **Elements/Fields**: Yes (both references point to the same object in heap).<br>**Reference Reassignment**: No. |

```java
// Primitive Pass-by-Value
public static void modifyPrimitive(int number) {
    number = 999; // Modifies local copy only
}

// Reference Pass-by-Value: Mutating array contents
public static void modifyArrayElements(int[] arr) {
    arr[0] = 777; // Mutates element in the shared heap object
}

// Reference Pass-by-Value: Reference reassignment
public static void reassignReference(int[] arr) {
    arr = new int[]{100, 200, 300}; // Reassigns local reference copy only
}
```

---

# 3. [ReturnValues.java](../../src/javakb/ch04_methods/ReturnValues.java) — Return Types & Guard Clauses

**Concept:** Methods can compute and return data back to the caller. The return type in the method signature must match (or be compatible with) the returned value's data type.

```java
// Returns an int
public static int add(int a, int b) {
    return a + b;
}

// Returns a double with correct parenthesis precedence
public static double average(double a, double b, double c) {
    return (a + b + c) / 3.0; // Correct: (a + b + c) / 3.0
}
```

### Early Returns / Guard Clauses

The `return` keyword instantly exits the method. In `void` methods, `return;` can be used without a value to break out of execution early when encountering invalid input or boundary conditions:

```java
public static void printEligibility(int age) {
    if (age < 0) {
        System.out.println("Invalid age!");
        return; // Guard clause: Exit early
    }
    System.out.println("Valid age: " + age);
}
```

---

# 4. [MethodOverloading.java](../../src/javakb/ch04_methods/MethodOverloading.java) — Compile-Time Polymorphism

**Concept:** **Method Overloading** occurs when multiple methods in the same class share the exact same name but have different parameter lists.

### Rules for Method Overloading:
1. Methods MUST have the **same name**.
2. Methods MUST have **different parameter lists** (differ by number of parameters, parameter data types, or parameter order).
3. Return type **CANNOT** be used to distinguish overloaded methods. Changing only the return type produces a compile error.

```java
public class MethodOverloading {

    // Overload 1: Two int params
    public static int add(int a, int b) { return a + b; }

    // Overload 2: Three int params (different parameter count)
    public static int add(int a, int b, int c) { return a + b + c; }

    // Overload 3: Two double params (different data type)
    public static double add(double a, double b) { return a + b; }

    // Overload 4 & 5: Different parameter order
    public static void display(String text, int num) {}
    public static void display(int num, String text) {}
}
```

### Automatic Type Promotion:
If an exact parameter type match is not found, Java automatically promotes smaller types to larger compatible types (e.g., `byte` → `short` → `int` → `long` → `float` → `double`).

---

# 5. [VariableScope.java](../../src/javakb/ch04_methods/VariableScope.java) — Scopes & Variable Shadowing

**Concept:** Scope defines the boundary within which a declared variable is accessible and valid.

```text
+-----------------------------------------------------------+
| Class Scope (Static variables - accessible class-wide)   |
|   +---------------------------------------------------+   |
|   | Method Local Scope (Accessible within method)     |   |
|   |   +-------------------------------------------+   |   |
|   |   | Block Scope ({ ... } inside loops/if)     |   |   |
|   |   +-------------------------------------------+   |   |
|   +---------------------------------------------------+   |
+-----------------------------------------------------------+
```

1. **Class / Static Scope**: Variables declared inside class with `static`. Alive for the duration of the application.
2. **Method / Local Scope**: Variables declared inside a method. Created when method is invoked, destroyed when method returns.
3. **Block Scope**: Variables declared inside `{ ... }` (e.g., `if`, `for`, `while`). Visible only inside that specific block.

### Variable Shadowing:
When a local or block variable shares the exact same name as a class-level variable, the local variable **shadows** (masks) the class variable within that scope. Access the class variable using `ClassName.variableName`.

---

# 6. [RecursionIntro.java](../../src/javakb/ch04_methods/RecursionIntro.java) — Fundamentals of Recursion

**Concept:** Recursion occurs when a method invokes itself to solve a smaller instance of the same problem.

### Anatomy of a Recursive Method:

Every valid recursive method requires two essential parts:
1. **Base Case**: The stopping condition that halts recursive calls.
2. **Recursive Step**: Calling the method with a modified (reduced) subproblem.

```java
// Factorial calculation: n! = n * (n - 1)!
public static int factorial(int n) {
    if (n <= 1) {
        return 1; // 1. Base Case
    }
    return n * factorial(n - 1); // 2. Recursive Step
}
```

### How the Call Stack Works:

For `factorial(3)`:
```text
Push factorial(3) -> 3 * factorial(2)
  Push factorial(2) -> 2 * factorial(1)
    Push factorial(1) -> returns 1 (Base Case Hit!)
  Pop factorial(1): returns 1
  Pop factorial(2): 2 * 1 = 2
Pop factorial(3): 3 * 2 = 6
```

> **Warning (`StackOverflowError`)**: If a recursive method lacks a base case or fails to reach it, stack frames fill up the JVM execution stack, causing a `java.lang.StackOverflowError`.

---

# 7. [VarargsDemo.java](../../src/javakb/ch04_methods/VarargsDemo.java) — Variable-Length Arguments

**Concept:** Introduced in Java 5, **Varargs** (Variable Arguments) allows a method to accept zero, one, or multiple arguments of a specified data type without explicitly creating an array at the call site.

### Syntax:
```java
public static int sum(int... numbers) {
    int total = 0;
    for (int n : numbers) {
        total += n;
    }
    return total;
}
```

### Under the Hood:
Java converts `int... numbers` into an array parameter (`int[] numbers`) behind the scenes.

### Rules for Varargs:
1. A method can have **at most ONE** varargs parameter.
2. The varargs parameter **MUST BE THE LAST** parameter in the parameter list.
   ```java
   // VALID
   public static void log(String tag, double... values) {}

   // INVALID (Compile Error)
   // public static void log(double... values, String tag) {}
   ```

---

# 8. [ConsoleCalculator.java](../../src/javakb/ch04_methods/ConsoleCalculator.java) — Chapter 4 Mini Project

**Project Objective:** Build a clean, method-driven, menu-based interactive console calculator application.

### Key Requirements Implemented:
- Separate calculations into individual methods: `add()`, `subtract()`, `multiply()`, `divide()`, and `sumVarargs()`.
- Safe division handling with explicit division-by-zero check.
- Interactive user loop with `Scanner` and modern `switch` expression/statement.

```java
// Method signature examples from ConsoleCalculator:
public static double add(double a, double b) { return a + b; }
public static double subtract(double a, double b) { return a - b; }
public static double multiply(double a, double b) { return a * b; }
public static double divide(double a, double b) {
    if (b == 0) {
        System.out.println("Error: Division by zero!");
        return Double.NaN;
    }
    return a / b;
}
public static double sumVarargs(double... numbers) { ... }
```

---

# Best Practices for Writing Methods

1. **Single Responsibility Principle (SRP)**: Each method should do **one thing well**. If a method calculates tax, formats receipt, and saves to database, split it into 3 separate methods.
2. **Meaningful & Action-Oriented Names**: Use verbs for method names (`calculateTotal`, `isEven`, `findUserById`).
3. **Keep Parameter Count Small**: Ideally 0 to 3 parameters. If a method requires 6+ parameters, consider passing an object.
4. **Avoid Side Effects**: A method should ideally compute and return a result without unexpectedly mutating global static state.
5. **Use Guard Clauses**: Return early on invalid parameters to keep code flat and avoid deep nested `if-else` blocks.

---

# Interview & DSA Relevance

Methods are central to Data Structures & Algorithms and Technical Interviews:

- **Stack Frames & Memory Allocation**: Each method invocation creates a Stack Frame on the Call Stack containing local variables and parameter values. Stack frames are popped upon method return.
- **Pass-by-Value Trap**: Common interview trick questions test whether primitive changes or reference reassignments in methods affect original variables in `main()`.
- **Recursion in DSA**: Recursion is fundamental for Tree Traversals (Inorder, Preorder, Postorder), Graph Traversal (DFS), Backtracking (N-Queens, Sudoku Solver), and Divide & Conquer (MergeSort, QuickSort).

---

# Practice Questions

1. Write a method `isPalindrome(String str)` that returns `true` if a string is a palindrome.
2. Create an overloaded method `calculateArea` that calculates the area of a circle (`radius`), rectangle (`width, height`), and triangle (`base, height, boolean isTriangle`).
3. Write a recursive method `power(int base, int exponent)` to compute base raised to exponent.
4. Create a varargs method `findMax(int... numbers)` that returns the maximum value among all arguments passed.
5. Write a method `reverseArray(int[] arr)` and verify whether changes persist in `main()`.

---

# Quick Summary

- **Method**: A named reusable block of code (`returnType name(params)`).
- **Static Methods**: Called without creating class instances.
- **Pass-by-Value**: Java passes copies of primitive values and copies of object references.
- **Return Statement**: Exits method and returns value (or exits early in `void`).
- **Overloading**: Same name, different parameter lists (resolved at compile-time).
- **Scope**: Local variables live only inside their method/block.
- **Recursion**: Method calls itself with a Base Case and Recursive Step.
- **Varargs (`type... name`)**: Accepts variable number of arguments as an array.

---

## Code Folder
- [ch04_methods](../../src/javakb/ch04_methods)
