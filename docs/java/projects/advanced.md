# ⚡ Advanced Java Projects

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java" />
  <img src="https://img.shields.io/badge/Level-Advanced-purple?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Focus-Concurrency_%26_I/O-red?style=for-the-badge" />
</p>

---

## 📌 Overview

The **Advanced Projects** module of the **Java Knowledge Base** is designed to explore complex production-grade Java concepts: Multithreading, Concurrency Utilities (`ReentrantLock`, `ExecutorService`, `AtomicInteger`), Non-blocking I/O (NIO), File Serialization, Exception Handling architectures, and Network Socket programming.

---

## 🚧 Planned Advanced Projects Roadmap

### 1. 📂 Concurrent File Storage & Indexing Engine
* **Target Location:** `src/javakb/projects/advanced/filestorage/`
* **Core Concepts:** Multithreading, Thread Pool Executors, File Streams (`java.nio.file`), File Locks, Concurrent Collections (`ConcurrentHashMap`).
* **Description:** Concurrent directory scanner and indexing service that parses log/text files in parallel and builds a searchable inverted keyword index.

---

### 2. 🏦 Multi-Threaded Banking & Transfer Simulator
* **Target Location:** `src/javakb/projects/advanced/bankingsim/`
* **Core Concepts:** Synchronization, Thread Deadlock Avoidance, `ReentrantLock`, Condition Variables, Atomic Counters.
* **Description:** High-concurrency banking engine simulating thousands of simultaneous inter-account transfers while enforcing atomic balances and strict transaction logging.

---

### 3. 🌐 Client-Server Socket Chat Application
* **Target Location:** `src/javakb/projects/advanced/socketchat/`
* **Core Concepts:** Java Networking (`ServerSocket`, `Socket`), Multi-client Dispatching, Thread Synchronization, I/O Buffering.
* **Description:** Real-time multi-threaded chat server supporting broadcast messaging, private user rooms, and connection lifecycle events.

---

## 📂 Source Code Workspace

* **Workspace Folder:** [`src/javakb/projects/advanced/`](../../../src/javakb/projects/advanced/)
