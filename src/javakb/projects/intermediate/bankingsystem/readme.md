# 🏛️ Apex National Reserve — Banking System Simulation

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java" />
  <img src="https://img.shields.io/badge/Level-Intermediate-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Topic-OOP_Basics_%26_State_Management-green?style=for-the-badge" />
</p>

---

## 📌 Overview

The **Apex National Reserve Banking System** is an interactive, multi-class console simulation application designed to demonstrate and synthesize all core **Object-Oriented Programming (OOP)** fundamentals in Java.

This project bridges procedural coding and object-oriented domain modeling by implementing realistic banking operations—account creation, constructor chaining, deposit/withdrawal validation, inter-account fund transfers via object references, interest calculations, and bank-level audit reporting using static members.

---

## 🚀 Features

- 🏦 **Multi-Tier Account Creation**: Support for Checking and Savings accounts with overloaded constructors and `this(...)` chaining.
- 🔗 **Fluent Configuration**: Method chaining by returning `this` (e.g. `acc.setAccountType("SAVINGS").setAnnualInterestRate(4.5)`).
- 💰 **Deposits & Withdrawals**: Guard clauses preventing invalid operations (negative amounts, overdrafts, frozen accounts).
- 🔄 **Inter-Account Transfers**: Demonstrates Java's **Pass-by-Value with Object References** to safely transfer balances across account entities.
- 📈 **Interest Calculation Engine**: Monthly interest accrual applied to eligible Savings accounts based on APY.
- 📜 **Transaction History Ledger**: Every deposit, withdrawal, interest credit, or transfer is recorded in an immutable ledger with unique transaction IDs (`TX-10001-001`).
- 🏛️ **Static Bank-Level Audit**: Shared class-level metrics tracking total accounts created, total bank capital reserves, and routing numbers.
- 🤖 **Automated Showcase Demo**: Built-in automated end-to-end execution showcasing all OOP mechanisms in one click.

---

## 🧱 Project Architecture & Class Structure

```
bankingsystem/
├── Main.java               # Application entry point & interactive CLI menu loop
├── BankAccount.java        # Core domain model with state, behavior, & static counters
├── Transaction.java        # Individual transaction ledger record
├── BankManager.java        # Controller managing account repositories & operations
└── readme.md               # Project documentation
```

### 1. `Transaction.java` (Record Model)
Encapsulates an individual financial event.
- **Fields:** `transactionId`, `type`, `amount`, `postBalance`, `description`
- **Method:** `printRecord()` for tabular statement rendering.

### 2. `BankAccount.java` (Domain Entity)
Encapsulates account attributes, business rules, and static policies.
- **Static Members:** `BANK_NAME`, `ROUTING_NUMBER`, `accountCounter`, `totalBankDeposits`.
- **Instance Members:** `accountNumber`, `accountHolder`, `accountType`, `balance`, `annualInterestRate`, `isFrozen`, `transactionHistory`.
- **Key Mechanics:**
  - Static Initializer block (`static {}`) & Instance Initializer block (`{}`).
  - Constructor Chaining via `this(...)`.
  - Fluent Setters returning `this`.
  - Transfer logic invoking `withdraw()` and `deposit()` on distinct object references.

### 3. `BankManager.java` (Controller / Service Layer)
Manages the collection of active accounts and coordinates transactions.
- **Responsibilities:** Account registration, account lookup by ID, executing transfers between distinct accounts, bulk interest calculations, and bank audits.

### 4. `Main.java` (User Interface / Entry Point)
Interactive terminal interface providing a 10-option menu loop.

---

## 📚 Core Java Concepts Practiced

| Concept | Implementation in Project |
| :--- | :--- |
| **Classes & Objects** | Separation of concerns between `BankAccount`, `Transaction`, and `BankManager`. |
| **Constructors & Chaining** | 3-tier overloaded constructors chained using `this(holder, "CHECKING", MIN_BALANCE, DEFAULT_RATE)`. |
| **The `this` Keyword** | Disambiguating shadowed fields, delegating methods, returning `this` for fluent chaining. |
| **`static` Members** | Metaspace constants (`BANK_NAME`), shared vault capital counter (`totalBankDeposits`), static audit methods. |
| **Static vs Instance Blocks** | Static block loads bank policies once; instance block auto-increments account IDs per instantiation. |
| **Pass-by-Value Proof** | Inter-account transfers pass reference copies by value to mutate caller & receiver heap state. |

---

## 🖥️ Interactive Console Menu

```
==========================================================
    WELCOME TO APEX NATIONAL RESERVE BANKING SYSTEM       
==========================================================

----------------- MAIN BANKING MENU -----------------
1. Open New Bank Account
2. Deposit Funds
3. Withdraw Funds
4. Transfer Funds Between Accounts
5. Apply Monthly Interest to Savings Accounts
6. View Account Details & Statement
7. List All Accounts
8. Bank Financial Audit Report
9. Run Automated OOP Showcase Demo
10. Exit
Select an option (1-10): 
```

### Sample Account Statement Output
```
   ======================================================
   Apex National Reserve | Account #10001
   ------------------------------------------------------
   Holder       : Harsh Wardhan
   Type         : SAVINGS
   Balance      : $1,656.88
   Interest Rate: 5.00%
   Status       : ACTIVE
   ======================================================
   TRANSACTION HISTORY:
   [TX-10001-001] OPENING    | Amount:   $1500.00 | Balance:   $1500.00 | Note: Initial account opening deposit
   [TX-10001-002] DEPOSIT    | Amount:    $500.00 | Balance:   $2000.00 | Note: Standard cash/transfer deposit
   [TX-10001-003] WITHDRAW   | Amount:    $350.00 | Balance:   $1650.00 | Note: ATM/Counter withdrawal
   [TX-10001-004] INTEREST   | Amount:      $6.88 | Balance:   $1656.88 | Note: Monthly interest @ 5.00% APY
   ======================================================
```

---

## 🛠️ How to Compile and Run

From the root repository directory (`d:\Programming\Java Knowledge Base`):

```bash
# Compile all classes in the banking system package
javac -d out -sourcepath src src/javakb/projects/intermediate/bankingsystem/*.java

# Run the application
java -cp out javakb.projects.intermediate.bankingsystem.Main
```

---

## 🎯 Learning Outcomes

- Designing multi-class modular domain architectures.
- Using constructor chaining to enforce clean initialization rules.
- Leveraging static fields and methods for global state tracking without violating instance isolation.
- Understanding object references and side-effects during multi-object interactions.
