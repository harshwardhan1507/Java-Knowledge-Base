# Chapter 12.1: The List Interface

## Simple Intuition

A **List** in Java is an ordered collection (often called a sequence). Unlike a `Set`, which rejects duplicates, or a `Map`, which matches keys to values, a `List` behaves like a dynamic paper list: it maintains elements in the exact order you add them, lets you access items by their index (position starting at 0), and has no problem storing the exact same item multiple times.

---

## 1. [ListInterfaceDemo.java](../../../src/javakb/ch12_collections/list/ListInterfaceDemo.java) — The Core Interface

**Concept:** `List` is an interface (`java.util.List`). You cannot instantiate it directly (`new List()`). Instead, it defines the standard API contract that implementations must follow.

```java
List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add("Apple"); // Duplicates allowed
String item = list.get(1); // Index-based access
```

### Common List Methods:
| Method                      | Description                                              | Time Complexity (ArrayList)      |
| --------------------------- | -------------------------------------------------------- | -------------------------------- |
| `add(E e)`                  | Appends element to the end of the list                   | Amortized $O(1)$                 |
| `add(int index, E element)` | Inserts element at a specific index                      | $O(N)$ (due to element shifting) |
| `get(int index)`            | Retrieves the element at the specified index             | $O(1)$                           |
| `set(int index, E element)` | Replaces the element at the specified index              | $O(1)$                           |
| `remove(int index)`         | Removes the element at the specified index               | $O(N)$ (due to element shifting) |
| `indexOf(Object o)`         | Returns the index of the first occurrence of the element | $O(N)$                           |

---

## 2. [ArrayListDemo.java](../../../src/javakb/ch12_collections/list/ArrayListDemo.java) — Dynamic Array

**Concept:** `ArrayList` is backed by a standard Java array. When the array fills up, `ArrayList` automatically handles allocating a larger array (usually 1.5x of the previous size) and copies all elements over.

### Internal Mechanics:
* **Default capacity:** `10`
* **Growth formula:** `newCapacity = oldCapacity + (oldCapacity >> 1)` (grows by 50%).
* **Pros:** Random access is extremely fast ($O(1)$) because it directly maps to an array index.
* **Cons:** Inserting or removing from the middle/beginning is slow ($O(N)$) because all subsequent elements must be shifted in memory.

---

## 3. [LinkedListDemo.java](../../../src/javakb/ch12_collections/list/LinkedListDemo.java) — Doubly-Linked List

**Concept:** `LinkedList` does not use an array. Instead, it is composed of node objects, where each Node contains the data, a pointer to the `next` node, and a pointer to the `previous` node.

```
       [Node 1]           [Node 2]           [Node 3]
    [prev|data|next] <-> [prev|data|next] <-> [prev|data|next]
```

### Internal Mechanics:
* **Pros:** Inserting or deleting at the ends (head or tail) is extremely fast ($O(1)$) because it only requires changing two pointers.
* **Cons:** Random access is slow ($O(N)$) because Java must traverse nodes one by one starting from the head or tail to find the requested index.

---

## 4. [VectorDemo.java](../../../src/javakb/ch12_collections/list/VectorDemo.java) — Legacy Thread-Safe Array

**Concept:** `Vector` is a legacy class from Java 1.0 that was retrofitted to implement the `List` interface. It is similar to `ArrayList` but all its structural modifications are **synchronized** (thread-safe).

### Key Differences from ArrayList:
* **Thread Safety:** Methods are synchronized, making it safe for multi-threaded applications but significantly slower in single-threaded environments.
* **Capacity Growth:** Doubles in size (100% growth) by default when it runs out of capacity.

---

## 5. [StackDemo.java](../../../src/javakb/ch12_collections/list/StackDemo.java) — Last-In-First-Out (LIFO)

**Concept:** `Stack` represents a LIFO (Last-In-First-Out) stack of objects. It extends `Vector`, which means it inherits all the thread-safe array characteristics.

### Core Stack Operations:
* `push(E item)`: Pushes an item onto the top of the stack.
* `pop()`: Removes and returns the object at the top of the stack.
* `peek()`: Looks at the object at the top of the stack without removing it.

> [!NOTE]
> In modern Java, `Deque` (e.g., `ArrayDeque`) is preferred over the legacy `Stack` class for stack operations because `Stack` inherits from `Vector` (unnecessary synchronization overhead and exposed vector indices violate strict stack integrity).

---

## ArrayList vs. LinkedList

| Feature | ArrayList | LinkedList |
|---|---|---|
| **Underlying Structure** | Resizable Dynamic Array | Doubly-Linked List |
| **Get (by index)** | $O(1)$ - Constant time | $O(N)$ - Linear time |
| **Add (to end)** | Amortized $O(1)$ | $O(1)$ |
| **Insert / Delete (middle)** | $O(N)$ (requires shifting) | $O(N)$ (requires finding node first) |
| **Insert / Delete (at head)** | $O(N)$ (shifts all elements) | $O(1)$ (no shifting, pointer update) |
| **Memory Overhead** | Low (only elements and array capacity) | High (stores 2 pointers per element Node) |

---

## Common Developer Mistakes

1. **Choosing LinkedList by default for "fast inserts":** Developers often hear LinkedList has $O(1)$ inserts and use it everywhere. However, unless you are inserting specifically at the head or tail, or using a `ListIterator` already positioned at the target node, you first have to traverse to the insertion index, which takes $O(N)$ time. In practice, `ArrayList` performs better for most scenarios due to CPU cache locality.
2. **Forgetting to set initial capacity:** If you know your `ArrayList` will hold 100,000 elements, instantiate it as `new ArrayList<>(100000)`. Otherwise, Java will resize the array multiple times, triggering expensive copy operations.
3. **Using `Stack` in new code:** Standard legacy `Stack` is synchronized. Use `ArrayDeque` instead:
   ```java
   // Avoid:
   Stack<Integer> stack = new Stack<>();
   // Prefer:
   Deque<Integer> stack = new ArrayDeque<>();
   ```
