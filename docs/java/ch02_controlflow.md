# Chapter 2: Control Flow

## Simple Intuition

Every program you write so far runs top to bottom, no choices made. Control flow is what lets your program **decide** — "if this is true, do A, otherwise do B." It's the difference between a program that always does the same thing and one that actually reacts to data.

Every decision in Java eventually boils down to one question: **is this boolean expression `true` or `false`?** Everything in this chapter — `if`, `switch`, ternary — is just a different way of asking that question and branching based on the answer.

---

## 1. [IfStatement.java](../../src/javakb/ch02_controlflow/IfStatement.java) — The Basic Decision

**Concept:** Run a block of code only if a condition is `true`. If it's `false`, skip the block entirely — nothing else happens.

```java
int age = 18;

if (age >= 18) {
    System.out.println("Eligible to vote");
}
```

**Comparison operators driving the condition:**

|Operator|Meaning|
|---|---|
|`>`|greater than|
|`<`|less than|
|`==`|equal to (value comparison, not assignment)|
|`!=`|not equal to|

**Common mistake:** Confusing `=` (assignment) with `==` (comparison). `if (age = 18)` won't even compile for a boolean condition with primitives — but in languages that allow it, it silently assigns instead of compares. Always double-check you're using `==` inside a condition.

---

## 2. [IfElseStatement.java](../../src/javakb/ch02_controlflow/IfElseStatement.java) — Two Paths

**Concept:** `if` alone only handles the "true" case. `else` gives you the "false" case — exactly one of the two blocks runs, never both, never neither.

```java
int marks = 45;

if (marks >= 50) {
    System.out.println("Pass");
} else {
    System.out.println("Fail");
}
```

**Why this matters:** `if` by itself answers "should I do this extra thing?" `if-else` answers "which of these two things should happen?" Different question, different use case.

---

## 3. [ElseIfLadder.java](../../src/javakb/ch02_controlflow/ElseIfLadder.java) — Multiple Conditions

**Concept:** When you have more than two possible outcomes, you chain conditions with `else if`. Java checks them **top to bottom** and stops at the first one that's `true` — it never checks the rest, even if they'd also be true.

```java
int marks = 82;

if (marks >= 90) {
    System.out.println("Grade A+");
} else if (marks >= 75) {
    System.out.println("Grade A");
} else if (marks >= 60) {
    System.out.println("Grade B");
} else {
    System.out.println("Grade F");
}
```

Output:

```
Grade A
```

**Common mistake:** Writing ranges in the wrong order. If you check `marks >= 60` _before_ `marks >= 90`, a mark of 95 will incorrectly print "Grade B" because the ladder stops at the first true condition — order matters, always go from the most specific/highest condition down to the most general.

---

## 4. [NestedIf.java](../../src/javakb/ch02_controlflow/NestedIf.java) — Decisions Inside Decisions

**Concept:** Sometimes a decision only makes sense _after_ another decision is already true. You put an `if` inside another `if`'s block.

```java
int age = 20;
boolean citizen = true;

if (age >= 18) {
    if (citizen) {
        System.out.println("Can vote");
    }
}
```

**Intuition:** This is the same as checking `age >= 18 && citizen` in one line (see Logical Operators below) — nesting and `&&` often solve the same problem. Nesting is more readable when each layer represents a genuinely separate stage of eligibility (e.g., you might want a different message at each nested level, like "Too young" vs "Not a citizen").

**Common mistake:** Nesting 4-5 levels deep when a single combined condition (`&&`) would do the same job in one line. Deep nesting hurts readability — if you're 3+ levels in, ask whether logical operators would simplify it.

---

## 5. [SwitchStatement.java](../../src/javakb/ch02_controlflow/SwitchStatement.java) — Traditional Switch

**Concept:** When you're checking the _same variable_ against many possible exact values, an `else-if` ladder gets repetitive. `switch` is built for exactly this case — match a value, run the matching block.

```java
int day = 3;

switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    default:
        System.out.println("Invalid day");
}
```

Output:

```
Wednesday
```

**Why `break` matters:** Without `break`, execution **falls through** to the next case below it, running that code too — even though its condition wasn't checked. This is one of Java's most infamous beginner bugs.

**Common mistake:** Forgetting `break` and accidentally running multiple cases. Try removing the `break` after `case 3` above and trace what prints — you'll see "Wednesday" followed by "Invalid day," because execution just falls into `default` next.

---

## 6. [SwitchExpression.java](../../src/javakb/ch02_controlflow/SwitchExpression.java) — Modern Switch (Java 14+)

**Concept:** The arrow (`->`) syntax fixes the fall-through problem entirely — each case is isolated, no `break` needed, and it can directly **return a value**, so you can assign a switch directly to a variable.

```java
String result = switch (day) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    case 3 -> "Wednesday";
    default -> "Invalid";
};
```

**Why this is better:** Old `switch` is a _statement_ (just runs code). New `switch` is an _expression_ (produces a value). That's a meaningful upgrade — no fall-through bugs, less boilerplate, and it reads closer to how you'd describe the logic in plain English.

**When to use which:** Prefer the arrow form for new code unless you're working in a codebase/course that specifically targets older Java syntax — it's strictly safer.

---

## 7. [TernaryOperator.java](../../src/javakb/ch02_controlflow/TernaryOperator.java) — Shorthand if-else

**Concept:** When an `if-else` exists purely to decide _what value to assign_, the ternary operator compresses it to one line.

```java
String result = age >= 18 ? "Adult" : "Minor";
```

Read it as: `condition ? valueIfTrue : valueIfFalse`.

This is identical in behavior to:

```java
String result;
if (age >= 18) {
    result = "Adult";
} else {
    result = "Minor";
}
```

**Common mistake:** Nesting ternaries inside ternaries to handle multiple conditions (`a ? b ? c : d : e`). It compiles, but it's unreadable. If you need more than one condition, use `else-if` or `switch` instead — ternary is for **simple, single-condition value assignment only**.

---

## 8. [LogicalOperators.java](../../src/javakb/ch02_controlflow/LogicalOperators.java) — Combining Conditions

**Concept:** Real decisions often depend on more than one fact at once. Logical operators combine boolean expressions into a single condition.

|Operator|Meaning|True when...|
|---|---|---|
|`&&`|AND|**both** sides are true|
|`\|`|OR|**at least one** side is true|
|`!`|NOT|flips true to false (and vice versa)|

```java
int age = 20;
boolean citizen = true;

if (age >= 18 && citizen) {
    System.out.println("Can vote");
}
```

**Why this matters for this chapter:** Every other concept above — `if`, nested `if`, even `switch` cases — is ultimately deciding based on a boolean expression. Logical operators are how you build _richer_ expressions instead of just nesting more `if` blocks. `age >= 18 && citizen` is doing the same job as the nested `if` in section 4, just flatter and more readable.

**Short-circuit behavior (important, often missed):** `&&` stops checking as soon as the first side is `false` — it won't even evaluate the second side. Same for `||`, it stops as soon as one side is `true`. This matters in real code:

```java
if (list != null && list.size() > 0) {
```

If `list` is `null`, `list.size()` is **never called**, so you avoid a `NullPointerException`. If you reversed the order (`list.size() > 0 && list != null`), it would crash on a null list — order matters with short-circuiting.

---

## Recap: Which tool for which job?

| Situation                                                  | Use                                |
| ---------------------------------------------------------- | ---------------------------------- |
| One condition, one action                                  | `if`                               |
| Exactly two outcomes                                       | `if-else`                          |
| Several ranges/conditions, in order                        | `else-if` ladder                   |
| A decision only relevant after another is true             | nested `if` (or combine with `&&`) |
| Matching one variable against many exact values            | `switch`                           |
| Switch but you want a returned value, no fall-through risk | `switch` expression (`->`)         |
| Simple true/false → pick one of two values                 | ternary `?:`                       |
| Combining multiple boolean conditions into one             | `&&`, `\|`, `!`                    |


