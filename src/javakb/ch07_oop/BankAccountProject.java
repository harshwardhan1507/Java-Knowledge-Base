package javakb.ch07_oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Chapter 7 Capstone Mini-Project: Interactive Bank Account Management System.
 *
 * This project synthesizes ALL Chapter 7 OOP concepts into a practical application:
 * 1. Classes & Objects: BankAccount, Transaction, and BankSystem blueprints.
 * 2. Object State & Behavior: Balance management, deposits, withdrawals, fund transfers.
 * 3. Constructors & Chaining: Default, basic, and full constructors using this(...).
 * 4. 'this' Keyword: Variable shadowing, internal method delegation, fluent configuration chaining.
 * 5. Static Members & Constants: Bank-wide constants, shared account counters, static utility methods.
 * 6. Static vs Instance Initializers: Metaspace loading vs per-object ID generation.
 * 7. Pass-by-Value with Object References: Inter-account fund transfers modifying caller and target states.
 */

// Class 1: Transaction (Records individual deposit, withdrawal, or transfer)
class Transaction {
    private final String transactionId;
    private final String type;
    private final double amount;
    private final double postBalance;
    private final String description;

    public Transaction(String transactionId, String type, double amount, double postBalance, String description) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.postBalance = postBalance;
        this.description = description;
    }

    public void printRecord() {
        System.out.printf("   [%s] %-10s | Amount: %10s | Balance: %10s | Note: %s%n",
                this.transactionId,
                this.type,
                String.format("$%.2f", this.amount),
                String.format("$%.2f", this.postBalance),
                this.description);
    }
}

// Class 2: BankAccount (Core Domain Model)
class BankAccount {
    // Static Constants (Bank Policy)
    public static final String BANK_NAME = "Apex National Reserve";
    public static final String ROUTING_NUMBER = "021000089";
    public static final double DEFAULT_ANNUAL_INTEREST_RATE = 4.5; // 4.5%
    public static final double MIN_OPENING_BALANCE = 25.00;

    // Static Variables (Shared across all accounts)
    private static int accountCounter = 0;
    private static double totalBankDeposits = 0.0;

    // Instance Variables (Specific to this account)
    private final int accountNumber;
    private String accountHolder;
    private String accountType; // "SAVINGS" or "CHECKING"
    private double balance;
    private double annualInterestRate;
    private boolean isFrozen;
    private final List<Transaction> transactionHistory;
    private int transactionCounter;

    // Static Initializer Block (Runs ONCE when class is loaded into memory)
    static {
        System.out.println(">>> [System Boot] Initializing " + BANK_NAME + " Core Banking Engine...");
        System.out.println(">>> [System Boot] Standard Routing: " + ROUTING_NUMBER);
    }

    // Instance Initializer Block (Runs before every constructor)
    {
        accountCounter++;
        this.accountNumber = 10000 + accountCounter;
        this.transactionHistory = new ArrayList<>();
        this.transactionCounter = 0;
        this.isFrozen = false;
    }

    // 1. Minimal Constructor (Chains to Full Constructor)
    public BankAccount(String accountHolder) {
        this(accountHolder, "CHECKING", MIN_OPENING_BALANCE, DEFAULT_ANNUAL_INTEREST_RATE);
    }

    // 2. Standard Constructor (Chains to Full Constructor)
    public BankAccount(String accountHolder, String accountType, double initialDeposit) {
        this(accountHolder, accountType, initialDeposit, DEFAULT_ANNUAL_INTEREST_RATE);
    }

    // 3. Full Master Constructor
    public BankAccount(String accountHolder, String accountType, double initialDeposit, double annualInterestRate) {
        this.accountHolder = accountHolder;
        this.accountType = accountType.toUpperCase();
        this.annualInterestRate = annualInterestRate;

        double validInitialDeposit = Math.max(initialDeposit, MIN_OPENING_BALANCE);
        this.balance = validInitialDeposit;
        totalBankDeposits += validInitialDeposit;

        // Record initial opening transaction
        this.recordTransaction("OPENING", validInitialDeposit, "Initial account opening deposit");
    }

    // Fluent Configuration Methods (Returning 'this' for Method Chaining)
    public BankAccount setAnnualInterestRate(double rate) {
        if (rate >= 0) {
            this.annualInterestRate = rate;
            System.out.printf("   [Account #%d] Annual interest rate updated to %.2f%%%n", this.accountNumber, this.annualInterestRate);
        }
        return this; // Enables chaining
    }

    public BankAccount setAccountType(String type) {
        this.accountType = type.toUpperCase();
        System.out.printf("   [Account #%d] Account type changed to %s%n", this.accountNumber, this.accountType);
        return this; // Enables chaining
    }

    // Business Behavior: Deposit
    public boolean deposit(double amount) {
        if (isFrozen) {
            System.out.println("   [ERROR] Account #" + this.accountNumber + " is FROZEN. Deposit rejected.");
            return false;
        }
        if (amount <= 0) {
            System.out.println("   [ERROR] Deposit amount must be positive.");
            return false;
        }

        this.balance += amount;
        totalBankDeposits += amount;
        this.recordTransaction("DEPOSIT", amount, "Standard cash/transfer deposit");
        System.out.printf("   -> Successfully deposited $%.2f into Account #%d. New Balance: $%.2f%n",
                amount, this.accountNumber, this.balance);
        return true;
    }

    // Business Behavior: Withdraw
    public boolean withdraw(double amount) {
        if (isFrozen) {
            System.out.println("   [ERROR] Account #" + this.accountNumber + " is FROZEN. Withdrawal rejected.");
            return false;
        }
        if (amount <= 0) {
            System.out.println("   [ERROR] Withdrawal amount must be positive.");
            return false;
        }
        if (amount > this.balance) {
            System.out.printf("   [ERROR] Insufficient funds in Account #%d! Requested: $%.2f, Available: $%.2f%n",
                    this.accountNumber, amount, this.balance);
            return false;
        }

        this.balance -= amount;
        totalBankDeposits -= amount;
        this.recordTransaction("WITHDRAW", amount, "ATM/Counter withdrawal");
        System.out.printf("   -> Successfully withdrew $%.2f from Account #%d. Remaining Balance: $%.2f%n",
                amount, this.accountNumber, this.balance);
        return true;
    }

    // Business Behavior: Inter-Account Transfer (Demonstrates Pass-by-Value with Object References)
    public boolean transferTo(BankAccount destinationAccount, double amount) {
        if (destinationAccount == null) {
            System.out.println("   [ERROR] Destination account does not exist.");
            return false;
        }
        if (destinationAccount == this) {
            System.out.println("   [ERROR] Cannot transfer money to the same account.");
            return false;
        }

        System.out.printf("   [Transfer Initiated] Sending $%.2f from Account #%d (%s) to Account #%d (%s)...%n",
                amount, this.accountNumber, this.accountHolder, destinationAccount.accountNumber, destinationAccount.accountHolder);

        if (this.withdraw(amount)) {
            destinationAccount.deposit(amount);
            System.out.printf("   [Transfer Complete] $%.2f transferred successfully.%n", amount);
            return true;
        } else {
            System.out.println("   [Transfer Failed] Transfer aborted due to withdrawal failure.");
            return false;
        }
    }

    // Business Behavior: Apply Monthly Interest
    public void applyMonthlyInterest() {
        if ("SAVINGS".equals(this.accountType) && this.balance > 0) {
            double monthlyRate = (this.annualInterestRate / 100.0) / 12.0;
            double interestAccrued = this.balance * monthlyRate;
            this.balance += interestAccrued;
            totalBankDeposits += interestAccrued;
            this.recordTransaction("INTEREST", interestAccrued, String.format("Monthly interest @ %.2f%% APY", this.annualInterestRate));
            System.out.printf("   -> Account #%d accrued $%.2f monthly interest. Balance: $%.2f%n",
                    this.accountNumber, interestAccrued, this.balance);
        } else {
            System.out.printf("   -> Account #%d (%s): No interest applied (Checking or zero balance).%n",
                    this.accountNumber, this.accountType);
        }
    }

    // Helper Method to record transaction internally
    private void recordTransaction(String type, double amount, String note) {
        this.transactionCounter++;
        String txId = String.format("TX-%d-%03d", this.accountNumber, this.transactionCounter);
        Transaction tx = new Transaction(txId, type, amount, this.balance, note);
        this.transactionHistory.add(tx);
    }

    // Display Account Summary
    public void printAccountSummary() {
        System.out.println("\n   ======================================================");
        System.out.printf("   %s | Account #%d%n", BANK_NAME, this.accountNumber);
        System.out.println("   ------------------------------------------------------");
        System.out.printf("   Holder       : %s%n", this.accountHolder);
        System.out.printf("   Type         : %s%n", this.accountType);
        System.out.printf("   Balance      : $%,.2f%n", this.balance);
        System.out.printf("   Interest Rate: %.2f%%%n", this.annualInterestRate);
        System.out.printf("   Status       : %s%n", (this.isFrozen ? "FROZEN" : "ACTIVE"));
        System.out.println("   ======================================================");
    }

    // Display Full Statement with Statement Transactions
    public void printStatement() {
        printAccountSummary();
        System.out.println("   TRANSACTION HISTORY:");
        if (this.transactionHistory.isEmpty()) {
            System.out.println("   (No transactions recorded)");
        } else {
            for (Transaction tx : this.transactionHistory) {
                tx.printRecord();
            }
        }
        System.out.println("   ======================================================\n");
    }

    // Static Utility & Monitoring Methods
    public static int getTotalAccountsCreated() {
        return accountCounter;
    }

    public static double getTotalBankDeposits() {
        return totalBankDeposits;
    }

    public static void printBankHealthReport() {
        System.out.println("\n   ======================================================");
        System.out.println("   🏛️  " + BANK_NAME.toUpperCase() + " FINANCIAL AUDIT");
        System.out.println("   ------------------------------------------------------");
        System.out.println("   Total Active Accounts   : " + accountCounter);
        System.out.printf("   Total Vault Capital     : $%,.2f%n", totalBankDeposits);
        System.out.println("   Federal Routing Number  : " + ROUTING_NUMBER);
        System.out.println("   ======================================================\n");
    }

    // Getters
    public int getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }
}

// Driver / Main Application Class
public class BankAccountProject {

    // Automated Demonstration Mode
    public static void runAutomatedDemo() {
        System.out.println("\n========================================================");
        System.out.println("      AUTOMATED APEX RESERVE OOP DEMONSTRATION");
        System.out.println("========================================================");

        // 1. Creating accounts using overloaded constructors & chaining
        System.out.println("\n[Step 1: Creating Accounts using Overloaded Constructors]");
        BankAccount acc1 = new BankAccount("Harsh Wardhan", "SAVINGS", 1500.0, 5.0);
        BankAccount acc2 = new BankAccount("Sophia Loren", "CHECKING", 800.0);
        BankAccount acc3 = new BankAccount("Liam Smith"); // No-arg initial balance chained

        // 2. Demonstrating Fluent Method Chaining (Returning 'this')
        System.out.println("\n[Step 2: Fluent Method Chaining configuration]");
        acc3.setAccountType("SAVINGS")
            .setAnnualInterestRate(4.25);

        // 3. Performing Transactions
        System.out.println("\n[Step 3: Performing Deposits & Withdrawals]");
        acc1.deposit(500.0);
        acc2.withdraw(200.0);
        acc2.withdraw(1000.0); // Insufficient funds demonstration

        // 4. Inter-Account Transfer (Pass-by-Value with Object References)
        System.out.println("\n[Step 4: Inter-Account Transfer]");
        acc1.transferTo(acc2, 350.0);

        // 5. Applying Monthly Interest
        System.out.println("\n[Step 5: Applying Monthly Interest]");
        acc1.applyMonthlyInterest();
        acc2.applyMonthlyInterest(); // Checking -> No interest
        acc3.applyMonthlyInterest();

        // 6. Printing Account Statements
        System.out.println("\n[Step 6: Account Statements & Transaction History]");
        acc1.printStatement();
        acc2.printStatement();

        // 7. Bank-Level Financial Report using Static Methods
        System.out.println("[Step 7: Bank Financial Audit Report]");
        BankAccount.printBankHealthReport();
    }

    public static void main(String[] args) {
        System.out.println("=== Chapter 7: Bank Account Management Capstone System ===");

        // Run automated comprehensive demonstration
        runAutomatedDemo();
    }
}
