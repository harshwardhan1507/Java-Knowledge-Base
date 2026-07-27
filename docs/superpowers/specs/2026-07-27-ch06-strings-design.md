# Chapter 6: Java Strings — Design Spec

**Date:** 2026-07-27  
**Module:** `javakb.ch06_strings` & `docs/java/ch06_strings.md`  
**Goal:** Create a comprehensive, revision-ready learning module for Java Strings, covering memory pool mechanics, immutability, core methods, StringBuilder/Buffer performance, modern text blocks & formatting, algorithm interview patterns, and a hands-on interactive console project.

---

## 1. Scope & Architecture

### Java Source Files (`src/javakb/ch06_strings/`)
1. **`StringBasics.java`**
   - Definition & String object anatomy.
   - String Literals vs `new String()` constructor.
   - String Constant Pool (SCP) vs Heap memory allocation.
   - Immutability explanation and demonstration.
   - Reference equality (`==`) vs Value equality (`.equals()`).
   - String interning (`intern()`).
   - Console outputs demonstrating memory identity (`System.identityHashCode()`).

2. **`StringMethods.java`**
   - Grouped API demonstrations:
     - **Length & Access:** `length()`, `charAt()`, `toCharArray()`, `getBytes()`.
     - **Search:** `indexOf()`, `lastIndexOf()`, `contains()`, `startsWith()`, `endsWith()`.
     - **Comparison:** `equals()`, `equalsIgnoreCase()`, `compareTo()`, `compareToIgnoreCase()`.
     - **Extraction:** `substring()`, `subSequence()`.
     - **Case Conversion:** `toLowerCase()`, `toUpperCase()`.
     - **Replacement:** `replace()`, `replaceAll()`, `replaceFirst()`.
     - **Trimming & Stripping:** `trim()`, `strip()`, `stripLeading()`, `stripTrailing()`, `isBlank()`, `isEmpty()`.
     - **Splitting & Joining:** `split()`, `String.join()`.
     - **Conversion:** `String.valueOf()`, `Integer.parseInt()`, `toCharArray()`.
     - **Method Chaining:** Fluent chained string manipulations.

3. **`StringBuilderAndBuffer.java`**
   - Immutability performance bottleneck demo (string concatenation in loops `+`).
   - Mutable string buffers: `StringBuilder` vs `StringBuffer`.
   - Thread safety / Synchronization differences (`StringBuffer` synchronized vs `StringBuilder` unsynchronized).
   - Internal capacity vs length management.
   - Key operations: `append()`, `insert()`, `delete()`, `deleteCharAt()`, `reverse()`, `replace()`, `setCharAt()`.
   - Execution time benchmark comparison (`String` vs `StringBuilder` in 100,000 iteration loop).

4. **`StringFormatting.java`**
   - Format specifiers (`%s`, `%d`, `%f`, `%c`, `%b`, `%n`, `%10s`, `%.2f`).
   - `String.format()` vs `System.out.printf()`.
   - Modern `.formatted()` instance method (Java 15+).
   - Common escape sequences (`\n`, `\t`, `\"`, `\\`).
   - Java Text Blocks (`""" ... """` triple-quote multi-line literals), stripIndent(), multi-line JSON/SQL examples.

5. **`StringAlgorithms.java`**
   - Reusable algorithm methods for interview reference:
     - `reverseString(String str)`
     - `isPalindrome(String str)`
     - `countVowelsAndConsonants(String str)`
     - `countWords(String str)`
     - `getCharacterFrequency(String str)`
     - `removeDuplicates(String str)`
     - `isAnagram(String str1, String str2)`
     - `toggleCase(String str)`

6. **`TextAnalyzerProject.java`**
   - Interactive console-based menu application:
     ```text
     ==== JavaKB Text Analyzer ====
     1. Count Characters (Total, Letters, Digits, Whitespace)
     2. Count Words & Average Word Length
     3. Count Vowels & Consonants
     4. Reverse Text
     5. Check Palindrome (Case & Space insensitive option)
     6. Character Frequency Breakdown
     7. Replace / Find Word
     8. Exit
     ```

### Concept Notes Documentation (`docs/java/ch06_strings.md`)
Structure:
- **Title & Overview**: Introduction to `java.lang.String`.
- **What is a String?**: Internal char/byte array representation.
- **Why Strings are Immutable**: Security, Thread Safety, HashCode Caching, SCP reuse.
- **String Constant Pool (SCP)**: Detailed explanation with ASCII memory diagrams showing Heap vs SCP.
- **Creating Strings**: Literal vs `new` keyword.
- **Comparing Strings**: `==` vs `.equals()`, `compareTo()`, `intern()`.
- **Common String Methods**: Clean markdown table grouped by category.
- **StringBuilder & StringBuffer**: Mutability, capacity, thread-safety comparison table, performance metrics.
- **Formatting & Text Blocks**: Modern Java multi-line formatting with SQL/JSON examples.
- **Common Pitfalls & Mistakes**: `NullPointerException`, `==` with strings, index out of bounds, loop concatenation.
- **Interview Questions**: Top conceptual and coding questions.
- **Practice Exercises**: Hands-on exercises with hints.
- **Related Source Files**: Direct relative links to all 6 Java source files.

---

## 2. Boundaries & Out-Of-Scope
- Advanced Regular Expressions (`java.util.regex.Pattern` / `Matcher`) — reserved for a dedicated chapter.
- Unicode normalization (`java.text.Normalizer`) & Locale-sensitive collation — out of scope.
- `README.md` progress tracker will ONLY be updated AFTER all code compiles and notes are validated.

---

## 3. Verification Plan
- Compile all Java files using `javac` without warnings or errors.
- Run each `.java` executable file to verify correct console outputs.
- Verify markdown relative links between `docs/java/ch06_strings.md` and `src/javakb/ch06_strings/*.java`.
- Once verified, update `README.md` progress table.
