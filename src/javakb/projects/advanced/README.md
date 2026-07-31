# ⚡ Advanced Java Projects

Welcome to the **Advanced Projects** workspace of the **Java Knowledge Base**.

This directory is designated for multi-threaded, asynchronous, file-storage, and network-socket applications.

---

## 📂 Planned Projects Showcase

| Project Title | Target Technologies & Concepts | Documentation Link | Status |
| :--- | :--- | :--- | :---: |
| **Concurrent File Storage & Indexer** | Multithreading, `ExecutorService`, File I/O (`NIO`), Concurrent Maps | [Doc Notes](../../../../docs/java/projects/advanced.md#1--concurrent-file-storage--indexing-engine) | `[Planned]` |
| **Banking Transfer Concurrency Simulator** | Multi-threading, Synchronization, `ReentrantLock`, Deadlock Avoidance | [Doc Notes](../../../../docs/java/projects/advanced.md#2--multi-threaded-banking--transfer-simulator) | `[Planned]` |
| **Client-Server Socket Chat App** | Networking (`ServerSocket`), Socket streams, Thread pool dispatchers | [Doc Notes](../../../../docs/java/projects/advanced.md#3--client-server-socket-chat-application) | `[Planned]` |

---

## 🛠️ Execution Standards

All future advanced projects in this directory will follow standard IntelliJ workspace structure and command-line compilation guidelines:

```bash
# General compilation command structure
javac -d out -sourcepath src src/javakb/projects/advanced/<project_folder>/*.java
java -cp out javakb.projects.advanced.<project_folder>.Main
```
