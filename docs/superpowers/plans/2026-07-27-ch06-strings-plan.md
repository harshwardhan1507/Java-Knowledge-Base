# Chapter 6: Strings Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Build out Chapter 6 (Strings) with 6 standalone runnable Java files in `src/javakb/ch06_strings/`, exhaustive concept documentation in `docs/java/ch06_strings.md`, and update the progress tracker in `README.md`.

**Architecture:** IntelliJ Java source files in root package `javakb.ch06_strings`, paired with intuition-first Obsidian markdown notes in `docs/java/ch06_strings.md`.

**Tech Stack:** Java 15+ (Core Java: `java.lang.String`, `java.lang.StringBuilder`, `java.lang.StringBuffer`, Text Blocks, `java.util.Scanner`).

## Global Constraints

- Package declaration MUST be `package javakb.ch06_strings;` for all Java files in `src/javakb/ch06_strings/`.
- Every Java file MUST contain a runnable `public static void main(String[] args)` method with clear section headers in console output.
- All code MUST compile cleanly using `javac` with zero warnings or errors.
- Relative links in markdown notes MUST point to the actual `.java` files using relative paths (`../../src/javakb/ch06_strings/...`).
- Progress tracker in `README.md` is updated ONLY in the final task after verification of compilation and documentation.

---

### Task 1: Create `StringBasics.java`

**Files:**
- Create: `src/javakb/ch06_strings/StringBasics.java`

**Interfaces:**
- Produces: Runnable main class `javakb.ch06_strings.StringBasics` demonstrating memory allocation, SCP vs Heap, immutability, `==` vs `.equals()`, and `intern()`.

- [ ] **Step 1: Write `StringBasics.java`**

Create `src/javakb/ch06_strings/StringBasics.java` containing:
- Demonstrations of literal string creation vs `new String()` constructor.
- SCP (String Constant Pool) vs Heap object memory allocation details.
- Immutability demonstration (showing that string operations produce new objects).
- Reference comparison (`==`) vs value comparison (`.equals()`).
- String interning (`intern()`) to move dynamic strings into the SCP.
- Print statements using `System.identityHashCode(str)` to verify memory addresses.

- [ ] **Step 2: Compile `StringBasics.java`**

Run: `javac -d bin src/javakb/ch06_strings/StringBasics.java`
Expected: Clean compilation with 0 errors.

- [ ] **Step 3: Run `StringBasics`**

Run: `java -cp bin javakb.ch06_strings.StringBasics`
Expected: Output showing identity hashcodes, true/false comparisons for `==` vs `.equals()`, and SCP behavior.

- [ ] **Step 4: Commit**

```bash
git add src/javakb/ch06_strings/StringBasics.java
git commit -m "feat(ch06): add StringBasics demonstration"
```

---

### Task 2: Create `StringMethods.java`

**Files:**
- Create: `src/javakb/ch06_strings/StringMethods.java`

**Interfaces:**
- Produces: Runnable main class `javakb.ch06_strings.StringMethods` grouped logically by category for easy revision.

- [ ] **Step 1: Write `StringMethods.java`**

Create `src/javakb/ch06_strings/StringMethods.java` grouping String methods by purpose:
1. Length & Access (`length()`, `charAt()`, `toCharArray()`)
2. Search (`indexOf()`, `lastIndexOf()`, `contains()`, `startsWith()`, `endsWith()`)
3. Comparison (`equals()`, `equalsIgnoreCase()`, `compareTo()`, `compareToIgnoreCase()`)
4. Extraction (`substring()`)
5. Case Conversion (`toLowerCase()`, `toUpperCase()`)
6. Replacement (`replace()`, `replaceAll()`, `replaceFirst()`)
7. Trim & Strip (`trim()`, `strip()`, `stripLeading()`, `stripTrailing()`, `isEmpty()`, `isBlank()`)
8. Split & Join (`split()`, `String.join()`)
9. Conversion (`String.valueOf()`, `Integer.parseInt()`, `Double.parseDouble()`)
10. Method Chaining (Fluent operations)

- [ ] **Step 2: Compile `StringMethods.java`**

Run: `javac -d bin src/javakb/ch06_strings/StringMethods.java`
Expected: Clean compilation with 0 errors.

- [ ] **Step 3: Run `StringMethods`**

Run: `java -cp bin javakb.ch06_strings.StringMethods`
Expected: Clean output demonstrating all grouped method outputs.

- [ ] **Step 4: Commit**

```bash
git add src/javakb/ch06_strings/StringMethods.java
git commit -m "feat(ch06): add StringMethods demonstration grouped by category"
```

---

### Task 3: Create `StringBuilderAndBuffer.java`

**Files:**
- Create: `src/javakb/ch06_strings/StringBuilderAndBuffer.java`

**Interfaces:**
- Produces: Runnable main class `javakb.ch06_strings.StringBuilderAndBuffer` demonstrating mutable strings and performance comparisons.

- [ ] **Step 1: Write `StringBuilderAndBuffer.java`**

Create `src/javakb/ch06_strings/StringBuilderAndBuffer.java` containing:
- Loop concatenation problem demo (showing why `String + String` in loops creates `O(N^2)` waste).
- `StringBuilder` vs `StringBuffer` distinction (unsynchronized vs synchronized).
- Internal capacity (`capacity()`) vs length (`length()`).
- Core operations: `append()`, `insert()`, `delete()`, `deleteCharAt()`, `reverse()`, `replace()`, `setCharAt()`.
- Benchmarking string concatenation vs `StringBuilder.append()` over 50,000 iterations measuring execution time in milliseconds (`System.currentTimeMillis()`).

- [ ] **Step 2: Compile `StringBuilderAndBuffer.java`**

Run: `javac -d bin src/javakb/ch06_strings/StringBuilderAndBuffer.java`
Expected: Clean compilation with 0 errors.

- [ ] **Step 3: Run `StringBuilderAndBuffer`**

Run: `java -cp bin javakb.ch06_strings.StringBuilderAndBuffer`
Expected: Output showing method operations and benchmark performance timing numbers.

- [ ] **Step 4: Commit**

```bash
git add src/javakb/ch06_strings/StringBuilderAndBuffer.java
git commit -m "feat(ch06): add StringBuilderAndBuffer performance and API examples"
```

---

### Task 4: Create `StringFormatting.java`

**Files:**
- Create: `src/javakb/ch06_strings/StringFormatting.java`

**Interfaces:**
- Produces: Runnable main class `javakb.ch06_strings.StringFormatting` demonstrating format specifiers and Java 15+ Text Blocks.

- [ ] **Step 1: Write `StringFormatting.java`**

Create `src/javakb/ch06_strings/StringFormatting.java` containing:
- Specifiers (`%s`, `%d`, `%f`, `%.2f`, `%10s`, `%-10s`, `%n`, `%b`, `%c`).
- `String.format()` and `System.out.printf()`.
- Java 15+ `.formatted(...)` method call.
- Escape sequences (`\n`, `\t`, `\"`, `\\`).
- Java Text Blocks (`""" ... """`) with multi-line JSON payload, HTML template, and SQL query formatting.

- [ ] **Step 2: Compile `StringFormatting.java`**

Run: `javac -d bin src/javakb/ch06_strings/StringFormatting.java`
Expected: Clean compilation with 0 errors.

- [ ] **Step 3: Run `StringFormatting`**

Run: `java -cp bin javakb.ch06_strings.StringFormatting`
Expected: Cleanly formatted tables, escape sequence demonstrations, and raw text block outputs.

- [ ] **Step 4: Commit**

```bash
git add src/javakb/ch06_strings/StringFormatting.java
git commit -m "feat(ch06): add StringFormatting and Text Blocks demonstration"
```

---

### Task 5: Create `StringAlgorithms.java`

**Files:**
- Create: `src/javakb/ch06_strings/StringAlgorithms.java`

**Interfaces:**
- Produces: Runnable main class `javakb.ch06_strings.StringAlgorithms` containing static algorithm methods for interview practice.

- [ ] **Step 1: Write `StringAlgorithms.java`**

Create `src/javakb/ch06_strings/StringAlgorithms.java` with static helper methods and test invocations in `main()`:
1. `reverseString(String input)` — using two-pointer approach and StringBuilder.
2. `isPalindrome(String input)` — ignoring case and non-alphanumeric chars.
3. `countVowelsAndConsonants(String input)` — array counter approach.
4. `countWords(String input)` — handling multiple spaces cleanly.
5. `getCharacterFrequency(String input)` — using ASCII array / Map.
6. `removeDuplicates(String input)` — preserving character insertion order.
7. `isAnagram(String s1, String s2)` — character array frequency match.
8. `toggleCase(String input)` — converting uppercase to lowercase and vice versa.

- [ ] **Step 2: Compile `StringAlgorithms.java`**

Run: `javac -d bin src/javakb/ch06_strings/StringAlgorithms.java`
Expected: Clean compilation with 0 errors.

- [ ] **Step 3: Run `StringAlgorithms`**

Run: `java -cp bin javakb.ch06_strings.StringAlgorithms`
Expected: Verified algorithm outputs for sample test cases.

- [ ] **Step 4: Commit**

```bash
git add src/javakb/ch06_strings/StringAlgorithms.java
git commit -m "feat(ch06): add StringAlgorithms interview reference file"
```

---

### Task 6: Create `TextAnalyzerProject.java`

**Files:**
- Create: `src/javakb/ch06_strings/TextAnalyzerProject.java`

**Interfaces:**
- Produces: Runnable interactive console application `javakb.ch06_strings.TextAnalyzerProject`.

- [ ] **Step 1: Write `TextAnalyzerProject.java`**

Create `src/javakb/ch06_strings/TextAnalyzerProject.java` implementing an interactive menu loop with `Scanner`:
```
==== JavaKB Text Analyzer ====
1. Count Characters (Total, Letters, Digits, Spaces)
2. Count Words & Average Word Length
3. Count Vowels & Consonants
4. Reverse Text
5. Check Palindrome
6. Character Frequency Breakdown
7. Find & Replace Word
8. Exit
```
Include input validation and clean error handling.

- [ ] **Step 2: Compile `TextAnalyzerProject.java`**

Run: `javac -d bin src/javakb/ch06_strings/TextAnalyzerProject.java`
Expected: Clean compilation with 0 errors.

- [ ] **Step 3: Verify non-interactive test run**

Run: `java -cp bin javakb.ch06_strings.TextAnalyzerProject` (providing simulated stdin or testing programmatically).
Expected: Clean console menu output.

- [ ] **Step 4: Commit**

```bash
git add src/javakb/ch06_strings/TextAnalyzerProject.java
git commit -m "feat(ch06): add TextAnalyzerProject interactive console utility"
```

---

### Task 7: Create Concept Notes `docs/java/ch06_strings.md`

**Files:**
- Overwrite: `docs/java/ch06_strings.md`

**Interfaces:**
- Produces: Exhaustive Markdown documentation linking to all 6 `.java` files.

- [ ] **Step 1: Write `docs/java/ch06_strings.md`**

Write `docs/java/ch06_strings.md` following the repo's chapter format:
- Overview & Introduction to Strings in Java.
- Why Strings are Immutable (Security, Thread-safety, HashCode caching, SCP).
- String Constant Pool (SCP) with ASCII memory diagrams showing Heap vs SCP.
- Creating Strings (Literals vs `new`).
- Comparing Strings (`==` vs `.equals()`, `intern()`).
- Common String Methods (Comprehensive grouped table).
- `StringBuilder` vs `StringBuffer` (Mutability, performance table, synchronized vs unsynchronized).
- String Formatting & Text Blocks (`String.format()`, `.formatted()`, `"""..."""`).
- Common Mistakes & Pitfalls (`NullPointerException`, `==` trap, loop concatenation).
- Conceptual Interview Questions & Answers.
- Practice Exercises with hints.
- Related Source Files (relative markdown links to `StringBasics.java`, `StringMethods.java`, `StringBuilderAndBuffer.java`, `StringFormatting.java`, `StringAlgorithms.java`, and `TextAnalyzerProject.java`).

- [ ] **Step 2: Commit documentation**

```bash
git add docs/java/ch06_strings.md
git commit -m "docs(ch06): complete exhaustive concept notes for Strings chapter"
```

---

### Task 8: Update Progress Tracker in `README.md` & Verification

**Files:**
- Modify: `README.md`

**Interfaces:**
- Updates: Marks `ch06` as `[x]` in `README.md` progress tracker table.

- [ ] **Step 1: Re-compile all 6 Java files in batch**

Run: `javac -d bin src/javakb/ch06_strings/*.java`
Expected: 0 errors.

- [ ] **Step 2: Update `README.md`**

In `README.md`, update row for `ch06`:
```markdown
| **ch06** | Strings (Manipulation, Builders)            | [Notes](docs/java/ch06_strings.md)       | [Code](src/javakb/ch06_strings)             | `[x]`  |
```

- [ ] **Step 3: Commit `README.md`**

```bash
git add README.md
git commit -m "docs: update progress tracker for ch06 completion"
```
