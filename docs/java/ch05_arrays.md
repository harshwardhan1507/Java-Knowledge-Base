# Chapter 05: Arrays

## Introduction to Arrays

Up to this chapter, we stored data in individual variables:

```java
int mark1 = 90;
int mark2 = 85;
int mark3 = 70;
```

This approach quickly breaks down when managing tens, hundreds, or thousands of values (e.g., 500 student grades or 10,000 product prices).

> An **Array** is a fixed-size, ordered collection of elements of the same data type stored in **contiguous memory locations**.

```text
Memory Index:     [0]   [1]   [2]   [3]   [4]
Array Values:   |  10 |  20 |  30 |  40 |  50 |
Memory Address: 0x100 0x104 0x108 0x10C 0x110
```

### Why Arrays Matter:
- **Contiguous Memory**: Elements sit right next to each other in memory, allowing constant time **O(1)** direct access by index.
- **Single Name**: Store and manage multiple related values under one variable name.
- **Gateway to Data Structures & Algorithms (DSA)**: Arrays form the foundation for Matrices, Strings, Stacks, Queues, Hash Tables, and Sorting algorithms.

---

# 1. [ArrayDeclaration.java](../../src/javakb/ch05_arrays/ArrayDeclaration.java) — Declaring & Initializing Arrays

Arrays can be declared and initialized in multiple ways:

```java
// Method 1: Declare size first, initialize elements later
int[] numbers = new int[5]; // Allocates memory for 5 integers (indexed 0 to 4)

// Method 2: Literal initialization (size inferred automatically)
int[] marks = {90, 85, 70, 92, 88};

// Method 3: Instantiate with explicit type and values
String[] fruits = new String[]{"Apple", "Banana", "Cherry"};
```

### Default Primitive & Reference Values:

When an array is allocated using `new DataType[size]`, Java automatically initializes all elements to default values:

| Data Type | Default Value |
|---|---|
| `int`, `byte`, `short`, `long` | `0` / `0L` |
| `float`, `double` | `0.0f` / `0.0` |
| `boolean` | `false` |
| `char` | `'\u0000'` (null character) |
| Object references (`String`, custom classes) | `null` |

---

# Accessing & Updating Elements

Array indexing is **0-based**. The first element is at index `0`, and the last element is at index `length - 1`.

```java
int[] arr = {10, 20, 30, 40, 50};

// Accessing elements (Reading)
System.out.println(arr[0]); // Outputs 10
System.out.println(arr[2]); // Outputs 30

// Updating elements (Writing)
arr[2] = 100; // Changes 30 to 100
```

### The Dreaded `ArrayIndexOutOfBoundsException`

Attempting to access an index outside `0` to `arr.length - 1` triggers a runtime exception:

```java
int[] marks = new int[5]; // Valid indices: 0, 1, 2, 3, 4
System.out.println(marks[5]); // Throws java.lang.ArrayIndexOutOfBoundsException!
```

---

# 2. [ArrayTraversal.java](../../src/javakb/ch05_arrays/ArrayTraversal.java) — Traversing Arrays

**Concept:** Traversal means visiting each element of an array sequentially.

```java
int[] scores = {45, 67, 89, 92, 74};

// Forward Traversal
for (int i = 0; i < scores.length; i++) {
    System.out.println("Score at index " + i + " = " + scores[i]);
}

// Backward / Reverse Traversal
for (int i = scores.length - 1; i >= 0; i--) {
    System.out.println("Reverse Score: " + scores[i]);
}
```

> **Note on `.length`**: `length` is a **final property** of arrays (not a method). Use `arr.length` without parentheses!

---

# 3. [EnhancedForLoop.java](../../src/javakb/ch05_arrays/EnhancedForLoop.java) — Enhanced For Loop (For-Each)

Introduced in Java 5, the **Enhanced For Loop** simplifies array traversal when index numbers are not needed:

```java
int[] numbers = {10, 20, 30, 40, 50};

for (int num : numbers) {
    System.out.println("Element: " + num);
}
```

### Traditional `for` vs Enhanced `for-each`:

| Feature | Traditional `for` loop | Enhanced `for-each` loop |
|---|---|---|
| **Index Access** | Yes (`arr[i]`) | No index available |
| **Modification** | Can modify original array elements | **Read-only** (modifies local copy) |
| **Direction** | Forward, Backward, or Step-based | Forward-only |
| **Syntax** | Verbose | Clean & readable |

---

# 4. [ArrayInput.java](../../src/javakb/ch05_arrays/ArrayInput.java) — User Input into Arrays

Populate arrays dynamically using `java.util.Scanner`:

```java
Scanner sc = new Scanner(System.in);
System.out.print("Enter size of array: ");
int n = sc.nextInt();

int[] arr = new int[n];

for (int i = 0; i < arr.length; i++) {
    System.out.print("Enter element " + (i + 1) + ": ");
    arr[i] = sc.nextInt();
}
```

---

# 5. [ArrayOperations.java](../../src/javakb/ch05_arrays/ArrayOperations.java) — Basic Array Operations

Building modular utility methods operating on arrays:

```java
// Calculate Sum
public static int sum(int[] arr) {
    int total = 0;
    for (int num : arr) total += num;
    return total;
}

// Calculate Average
public static double average(int[] arr) {
    return (double) sum(arr) / arr.length;
}

// Find Maximum
public static int findMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) max = arr[i];
    }
    return max;
}

// In-Place Reversal (Two Pointers)
public static void reverseInPlace(int[] arr) {
    int start = 0, end = arr.length - 1;
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}
```

---

# 6. [ArraySearching.java](../../src/javakb/ch05_arrays/ArraySearching.java) — Linear Search & Time Complexity

**Linear Search** checks every element sequentially from start to end until the target is found:

```java
public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i; // Found at index i
        }
    }
    return -1; // Target not found
}
```

### Time Complexity:
- **Best Case**: **O(1)** (Target is at the very first index `[0]`).
- **Worst Case**: **O(n)** (Target is at the last index or not present).
- **Average Case**: **O(n)**.

---

# 7. [MultiDimensionalArrays.java](../../src/javakb/ch05_arrays/MultiDimensionalArrays.java) — 2D Arrays & Matrices

A 2D array is an **"array of arrays"**, representing rows and columns (matrix):

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Nested loop traversal
for (int row = 0; row < matrix.length; row++) {
    for (int col = 0; col < matrix[row].length; col++) {
        System.out.print(matrix[row][col] + "\t");
    }
    System.out.println();
}
```

### Jagged / Ragged Arrays:
In Java, 2D sub-arrays do not have to be of equal length:
```java
int[][] jagged = new int[3][];
jagged[0] = new int[]{1, 2};       // 2 elements
jagged[1] = new int[]{3, 4, 5, 6}; // 4 elements
jagged[2] = new int[]{7};          // 1 element
```

---

# 8. [ArraysUtilityClass.java](../../src/javakb/ch05_arrays/ArraysUtilityClass.java) — `java.util.Arrays` Utility Class

Java provides built-in helper methods in `java.util.Arrays`:

```java
import java.util.Arrays;

int[] nums = {42, 15, 8, 99, 23};

// 1. Format array as String
System.out.println(Arrays.toString(nums)); // [42, 15, 8, 99, 23]

// 2. Sort array ascending
Arrays.sort(nums); // [8, 15, 23, 42, 99]

// 3. Binary Search (Requires SORTED array!)
int index = Arrays.binarySearch(nums, 23); // Returns 2

// 4. Fill array elements
int[] filled = new int[5];
Arrays.fill(filled, 7); // [7, 7, 7, 7, 7]

// 5. Copy array
int[] copy = Arrays.copyOf(nums, 3); // [8, 15, 23]

// 6. Check equality element-by-element
boolean isEqual = Arrays.equals(arr1, arr2);
```

---

# Common Beginner Mistakes

### 1. Using Invalid Index (`ArrayIndexOutOfBoundsException`)
```java
int[] arr = new int[5];
arr[5] = 100; // ERROR! Valid indices are 0 to 4.
```

### 2. Confusing `.length` Property with `.length()` Method
- **Arrays**: `arr.length` (Property, no parentheses).
- **Strings**: `str.length()` (Method, with parentheses).

### 3. Going Past the Last Index in Loops
```java
// INCORRECT (Triggers OutOfBounds on last iteration)
for (int i = 0; i <= arr.length; i++) { ... }

// CORRECT
for (int i = 0; i < arr.length; i++) { ... }
```

### 4. Direct Printing of Arrays (`[I@15db9742`)
```java
int[] arr = {1, 2, 3};
System.out.println(arr); // Prints hashcode address!
System.out.println(Arrays.toString(arr)); // Correct: [1, 2, 3]
```

---

# Mini Projects

### 1. [StudentMarksAnalyzer.java](../../src/javakb/ch05_arrays/StudentMarksAnalyzer.java) *(Beginner)*
- Takes subject marks input into an array.
- Computes Total, Average, Highest Mark, Lowest Mark.
- Counts Passed (>= 40) and Failed subjects.

### 2. [InventoryManagement.java](../../src/javakb/ch05_arrays/InventoryManagement.java) *(Intermediate)*
- Tracks Product IDs, Names, and Stock Quantities using parallel arrays.
- Features item searching, stock updates, and low-stock alert reporting (< 10).

---

# Practice Problems

1. **Reverse an Array**: Reverse an array in-place without creating a new array.
2. **Find Second Largest**: Find the second largest element in an unsorted array.
3. **Count Even & Odd**: Count how many even and odd numbers exist in an array.
4. **Merge Two Arrays**: Combine two integer arrays into a third merged array.
5. **Remove Duplicates**: Remove duplicate elements from a sorted array without using Collections.
6. **Rotate Left by 1**: Shift all elements left by 1 position (first element moves to end).
7. **Rotate Right by 1**: Shift all elements right by 1 position (last element moves to start).
8. **Check Sorted**: Verify whether an array is sorted in non-decreasing order.
9. **Array Copying**: Manually copy all elements from source array to destination array.
10. **Frequency Count**: Count the frequency of each distinct element in an array.

---

# Transition to DSA

Arrays mark your transition from basic programming syntax into **Data Structures & Algorithms**:
- **Fixed Size Constraint**: Because arrays cannot grow dynamically, later chapters introduce **ArrayList** (`ch12_collections`).
- **Time Complexity Focus**: Operations like Linear Search (**O(n)**) vs Direct Index Access (**O(1)**) teach you how to analyze algorithm performance.
- **Problem Solving Habit**: Writing modular methods that accept and return arrays prepares you directly for LeetCode / DSA problem solving.

---

## Code Folder
- [ch05_arrays](../../src/javakb/ch05_arrays)
