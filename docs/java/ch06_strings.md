# Chapter 6 — Java Strings

## Introduction & Intuition

In programming, almost every application deals with textual data — user names, email addresses, search queries, JSON API responses, and database records. In Java, text is represented using the `String` class (`java.lang.String`).

Unlike primitive types (`int`, `double`, `boolean`) which hold raw numeric or boolean values directly in stack memory, a `String` in Java is an **object**. Internally, Java represents a String as an array of characters (or bytes in modern compact string optimizations) wrapped with helper methods for manipulation.

> A **String** is a sequence of characters enclosed in double quotes (e.g., `"Java"`). In Java, String objects are **immutable** and stored using specialized memory management known as the **String Constant Pool (SCP)**.

---

## What is a String?

At the language level, `java.lang.String` is a `public final class`. Because it is `final`, no class can extend it.

Internally (since Java 9+ compact strings), Java stores characters using a byte array (`byte[] value`) along with an encoding flag (`byte coder`), optimizing memory footprint when strings contain only LATIN-1 characters:

```java
// Simplified conceptual view of String class internals
public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
    private final byte[] value; // Encoded char bytes
    private final byte coder;   // 0 for LATIN1, 1 for UTF16
    private int hash;           // Cached hash code value
    ...
}
```

---

## Why Strings are Immutable

**Immutability** means that once a `String` object is created in memory, its value **cannot be modified or changed**. Any operation that appears to modify a String (like `.toUpperCase()`, `.replace()`, or concatenation `+`) actually constructs and returns a **brand new `String` object** in memory.

```java
String str = "Hello";
str.concat(" World");

System.out.println(str); // Output: "Hello" (Original object was NOT changed!)
```

### Key Reasons Java Strings are Immutable:

1. **Security**: Strings are heavily used in network connections, database URLs, file paths, and security credentials (passwords). If strings were mutable, untrusted code could alter connection endpoints or parameters after authentication checks.
2. **Thread Safety**: Immutable objects are inherently thread-safe. Multiple threads can safely share String instances concurrently without requiring synchronization or locking overhead.
3. **String Constant Pool (SCP) Caching**: Because Strings cannot change, Java can safely share a single instance of `"Hello"` across hundreds of different references without risk of unexpected side effects.
4. **HashCode Caching**: The hash code of a String is calculated once during first use and cached (`private int hash`). This makes Strings extremely fast key objects for HashMaps and HashSets.

---

## String Constant Pool (SCP)

To save heap memory and minimize object creation overhead, Java maintains a special pool inside Heap memory known as the **String Constant Pool (SCP)**.

When you create a String literal (e.g., `String s = "Java";`), Java checks the SCP first:
- If `"Java"` already exists in the SCP, Java returns the reference to the existing instance.
- If `"Java"` does NOT exist in the SCP, Java creates a new object in the SCP and returns its reference.

When you use the `new` keyword (e.g., `String s = new String("Java");`), Java **always forces the creation of a new Object on the Heap**, outside of the SCP, regardless of whether `"Java"` exists in the SCP.

### ASCII Memory Layout Diagram:

```text
               HEAP MEMORY
+---------------------------------------------------+
|                                                   |
|   [ Heap Object ]                                 |
|   Address: 0x200                                  |
|   Value: "Java"                                   |
|       ^                                           |
|       |                                           |
|       +-------------------+                       |
|                           |                       |
|   +-----------------------+-------------------+   |
|   |          STRING CONSTANT POOL (SCP)       |   |
|   |                                           |   |
|   |   [ Pool Object ]                         |   |
|   |   Address: 0x100                          |   |
|   |   Value: "Java"                           |   |
|   +-------------------------------------------+   |
+---------------------------------------------------+

   STACK REFERENCES:
   s1 (Literal) --------> Points to SCP [0x100] ("Java")
   s2 (Literal) --------> Points to SCP [0x100] ("Java")
   s3 (new String) -----> Points to Heap [0x200] ("Java")
```

---

## Creating Strings

There are two primary ways to create String objects in Java:

```java
// Method 1: String Literal (Uses String Constant Pool)
String s1 = "Hello"; 

// Method 2: 'new' Keyword (Always creates Heap Object)
String s2 = new String("Hello");

// Method 3: From Character Array
char[] charArray = {'J', 'a', 'v', 'a'};
String s3 = new String(charArray);
```

---

## Comparing Strings: `==` vs `.equals()`

Understanding the difference between `==` and `.equals()` is one of the most vital concepts in Java string handling.

- **`==` (Reference Comparison)**: Checks if both variable references point to the **exact same memory address**.
- **`.equals()` (Value Comparison)**: Checks if both strings contain the **same sequence of characters**.

```java
String s1 = "Java";
String s2 = "Java";
String s3 = new String("Java");

System.out.println(s1 == s2);      // true  (Both point to SCP address 0x100)
System.out.println(s1 == s3);      // false (s1 is SCP 0x100, s3 is Heap 0x200)
System.out.println(s1.equals(s3)); // true  (Both contain character sequence "Java")
```

### String Interning (`intern()`)
The `.intern()` method can be called on a Heap String to manual fetch or place its reference into the String Constant Pool:

```java
String s3 = new String("Java");
String s4 = s3.intern(); // Returns reference from SCP

System.out.println(s1 == s4); // true (Both refer to SCP instance!)
```

---

## 1. [StringBasics.java](../../src/javakb/ch06_strings/StringBasics.java) — Memory Model & Immutability

Refer to [`StringBasics.java`](../../src/javakb/ch06_strings/StringBasics.java) for runnable demonstrations of:
- Literal vs `new String()` memory behavior.
- `System.identityHashCode()` proof of memory addresses.
- Immutability verification.
- `intern()` mechanics.

---

## 2. [StringMethods.java](../../src/javakb/ch06_strings/StringMethods.java) — Common String Methods

The table below groups essential `java.lang.String` methods by purpose:

| Category | Method Signature | Description | Example Output |
|---|---|---|---|
| **Length & Access** | `int length()` | Returns total character count | `"Java".length()` $\rightarrow$ `4` |
| | `char charAt(int index)` | Returns character at index | `"Java".charAt(1)` $\rightarrow$ `'a'` |
| | `char[] toCharArray()` | Converts string into char array | `"Hi".toCharArray()` $\rightarrow$ `['H', 'i']` |
| **Search** | `int indexOf(String str)` | Index of first occurrence (-1 if absent) | `"hello".indexOf("l")` $\rightarrow$ `2` |
| | `int lastIndexOf(String str)` | Index of last occurrence | `"hello".lastIndexOf("l")` $\rightarrow$ `3` |
| | `boolean contains(CharSequence s)` | Checks if substring exists | `"code".contains("od")` $\rightarrow$ `true` |
| | `boolean startsWith(String prefix)`| Checks prefix | `"java".startsWith("ja")` $\rightarrow$ `true` |
| | `boolean endsWith(String suffix)` | Checks suffix | `"test.txt".endsWith(".txt")` $\rightarrow$ `true` |
| **Comparison** | `boolean equals(Object obj)` | Case-sensitive value match | `"a".equals("A")` $\rightarrow$ `false` |
| | `boolean equalsIgnoreCase(String s)`| Case-insensitive value match | `"a".equalsIgnoreCase("A")` $\rightarrow$ `true` |
| | `int compareTo(String another)` | Lexicographical ordering comparison | `"A".compareTo("B")` $\rightarrow$ `-1` |
| **Extraction** | `String substring(int begin, int end)`| Extracts substring from begin to end-1 | `"Power".substring(0, 3)` $\rightarrow$ `"Pow"` |
| **Case Conversion**| `String toLowerCase()` | Converts all chars to lowercase | `"JAVA".toLowerCase()` $\rightarrow$ `"java"` |
| | `String toUpperCase()` | Converts all chars to uppercase | `"java".toUpperCase()` $\rightarrow$ `"JAVA"` |
| **Replacement** | `String replace(char old, char new)`| Replaces all target char occurrences | `"cat".replace('c', 'b')` $\rightarrow$ `"bat"` |
| | `String replaceAll(String regex, String rep)`| Replaces regex matches | `"a1b2".replaceAll("\\d", "*")` $\rightarrow$ `"a*b*"` |
| **Trimming** | `String trim()` | Removes leading/trailing ASCII spaces | `"  hi  ".trim()` $\rightarrow$ `"hi"` |
| | `String strip()` | Removes leading/trailing Unicode spaces | `"  hi  ".strip()` $\rightarrow$ `"hi"` |
| | `boolean isBlank()` | Checks if string is empty or whitespace-only | `"   ".isBlank()` $\rightarrow$ `true` |
| | `boolean isEmpty()` | Checks if length == 0 | `"   ".isEmpty()` $\rightarrow$ `false` |
| **Split & Join** | `String[] split(String regex)` | Splits string into array by delimiter | `"a,b".split(",")` $\rightarrow$ `["a", "b"]` |
| | `static String join(CharSequence del, Iterable)` | Joins elements with delimiter | `String.join("-", "A","B")` $\rightarrow$ `"A-B"` |

---

## 3. [StringBuilderAndBuffer.java](../../src/javakb/ch06_strings/StringBuilderAndBuffer.java) — Mutable Strings & Performance

### Why String Concatenation (`+`) in Loops is Slow

Because String is immutable, performing concatenation inside a loop creates a temporary `StringBuilder` and a **new String object on every single iteration**:

```java
// BAD PRACTICE: O(N^2) time & memory overhead!
String result = "";
for (int i = 0; i < 100000; i++) {
    result += "a"; // Creates 100,000 intermediate String objects in memory!
}
```

### `StringBuilder` vs `StringBuffer`

For frequent string modifications, use Java's mutable buffer classes:

| Feature | `String` | `StringBuilder` | `StringBuffer` |
|---|---|---|---|
| **Mutability** | Immutable | **Mutable** | **Mutable** |
| **Thread Safety** | Thread-Safe | **Not Thread-Safe** | **Thread-Safe** (Synchronized) |
| **Performance** | Slow (concatenation) | **Fastest** | Moderate (sync overhead) |
| **Introduced** | Java 1.0 | **Java 1.5** | Java 1.0 |
| **Use Case** | Read-only text / Constants | Single-threaded modifications | Multi-threaded shared buffers |

### Key Operations:
- `append(data)` — Appends text to buffer.
- `insert(offset, data)` — Inserts text at specified index.
- `delete(start, end)` — Deletes character range.
- `reverse()` — Reverses string buffer in-place.
- `setCharAt(index, char)` — Mutates single character at index.

---

## 4. [StringFormatting.java](../../src/javakb/ch06_strings/StringFormatting.java) — Formatting & Text Blocks

### Format Specifiers (`String.format` & `printf`)

- `%s` : String
- `%d` : Integer (decimal)
- `%f` : Floating-point number (`%.2f` rounds to 2 decimal places)
- `%b` : Boolean
- `%c` : Character
- `%n` : Platform-neutral newline
- `%-15s` : Left-align string in 15-character column width

### Modern `.formatted(...)` Method (Java 15+)
Instead of static `String.format(...)`, Java 15+ allows calling `.formatted()` directly on string template instances:

```java
String info = "User: %s, ID: %d".formatted("Harsh", 101);
```

### Multi-Line Text Blocks (`""" ... """`) (Java 15+)

Java Text Blocks eliminate ugly escape characters (`\n`, `\"`, `+`) for multi-line text such as JSON payloads or SQL queries:

```java
String sql = """
    SELECT id, username, email
    FROM users
    WHERE status = 'ACTIVE'
    ORDER BY id DESC;
    """;
```

---

## 5. [StringAlgorithms.java](../../src/javakb/ch06_strings/StringAlgorithms.java) — Coding Interview References

Refer to [`StringAlgorithms.java`](../../src/javakb/ch06_strings/StringAlgorithms.java) for clean reference implementations of essential string interview problems:
1. **String Reversal** (Two-pointer array swap).
2. **Palindrome Check** (Case-insensitive alphanumeric check).
3. **Vowels & Consonants Counter**.
4. **Word Count Engine** (Handling multiple spaces).
5. **Character Frequency Distribution** (`LinkedHashMap` preservation).
6. **Remove Duplicates** (Order-preserving ASCII tracking).
7. **Anagram Validation** (Sorted character matching).
8. **Toggle Case Converter**.

---

## 6. [TextAnalyzerProject.java](../../src/javakb/ch06_strings/TextAnalyzerProject.java) — Console Mini-Project

[`TextAnalyzerProject.java`](../../src/javakb/ch06_strings/TextAnalyzerProject.java) is a interactive console application tying all chapter concepts together. 

```text
==== JavaKB Text Analyzer ====
1. Count Characters (Total, Letters, Digits, Spaces)
2. Count Words & Average Word Length
3. Count Vowels & Consonants
4. Reverse Text
5. Check Palindrome
6. Character Frequency Breakdown
7. Find & Replace Word
8. Enter New Text
9. Exit
```

---

## Common Mistakes & Pitfalls

> [!WARNING]
> **1. Using `==` instead of `.equals()` for String Comparison**
> `s1 == s2` compares memory reference addresses, NOT string text! Always use `.equals()` or `.equalsIgnoreCase()` to compare text content.

> [!WARNING]
> **2. Concatenating Strings inside Loops with `+`**
> Using `+` in loops leads to massive memory overhead and slow execution. Use `StringBuilder` for loop operations.

> [!WARNING]
> **3. Expecting String methods to modify the original variable**
> Calling `str.toUpperCase()` does NOT alter `str`. You must assign the returned result: `str = str.toUpperCase();`.

> [!WARNING]
> **4. `NullPointerException` when calling methods on null references**
> Calling `nullStr.equals("Java")` throws `NullPointerException`. Instead, call equals on constant literals: `"Java".equals(nullStr)`.

---

## Conceptual Interview Questions

### Q1: Why is String immutable in Java?
**Answer:** For Security (file/network paths), Thread-Safety (safe concurrent sharing), Caching (String Constant Pool reuse), and HashCode Caching (fast key lookups in maps).

### Q2: What is the difference between `String`, `StringBuilder`, and `StringBuffer`?
**Answer:** `String` is immutable. `StringBuilder` is mutable and unsynchronized (fastest for single-threaded operations). `StringBuffer` is mutable and synchronized (thread-safe for multi-threaded access).

### Q3: How many objects are created by `String s = new String("Hello");`?
**Answer:** Up to **2 objects**: One in the String Constant Pool (if `"Hello"` wasn't already in the pool), and one on the Heap (always created by `new`).

---

## Practice Problems & Exercises

1. **Exercise 1 (Basic)**: Write a program that reads a full sentence from the user and counts how many words start with an uppercase letter.
2. **Exercise 2 (Intermediate)**: Write a method `String compressString(String str)` that compresses repeated characters (e.g., `"aabcccccaaa"` becomes `"a2b1c5a3"`). If compressed string is not smaller, return original.
3. **Exercise 3 (Advanced)**: Implement an anagram solver that takes a string input and searches an array of candidate words to return all valid anagrams.

---

## Related Source Files

- 📄 [`StringBasics.java`](../../src/javakb/ch06_strings/StringBasics.java) — Memory allocation, SCP, immutability, `intern()`.
- 📄 [`StringMethods.java`](../../src/javakb/ch06_strings/StringMethods.java) — Grouped String API reference guide.
- 📄 [`StringBuilderAndBuffer.java`](../../src/javakb/ch06_strings/StringBuilderAndBuffer.java) — Mutable buffers & loop benchmarking.
- 📄 [`StringFormatting.java`](../../src/javakb/ch06_strings/StringFormatting.java) — Format specifiers, `.formatted()`, and Text Blocks.
- 📄 [`StringAlgorithms.java`](../../src/javakb/ch06_strings/StringAlgorithms.java) — Interview algorithms reference implementations.
- 📄 [`TextAnalyzerProject.java`](../../src/javakb/ch06_strings/TextAnalyzerProject.java) — Interactive console text analyzer application.
