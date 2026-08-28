package javakb.projects.intermediate.bankingsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Encapsulates a Bank Account with full state, validation, constructor chaining,
 * fluent setters, transaction history, and static bank-level accounting.
 */
public class BankAccount {
    // Static Constants (Bank Policies)
    public static final String BANK_NAME = "Apex National Reserve";
    public static final String ROUTING_NUMBER = "021000089";
    public static final double DEFAULT_ANNUAL_INTEREST_RATE = 4.5; // 4.5%
    public static final double MIN_OPENING_BALANCE = 25.00;

    // Static Variables (Shared across all accounts)
    private static int accountCounter = 0;
    private static double totalBankDeposits = 0.0;

    // Instance Variables
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

    // Business Behavior: Inter-Account Transfer (Pass-by-Value with Object References)
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
        if ("SAVINGS".equalsIgnoreCase(this.accountType) && this.balance > 0) {
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

    // Getters & Setters
    public int getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public void setAccountHolder(String accountHolder) { this.accountHolder = accountHolder; }
    public String getAccountType() { return accountType; }
    public double getBalance() { return balance; }
    public double getAnnualInterestRate() { return annualInterestRate; }
    public boolean isFrozen() { return isFrozen; }
    public void setFrozen(boolean frozen) { isFrozen = frozen; }
    public List<Transaction> getTransactionHistory() {
        return Collections.unmodifiableList(transactionHistory);
    }
}
