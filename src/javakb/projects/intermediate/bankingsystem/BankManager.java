package javakb.projects.intermediate.bankingsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Controller class managing all accounts in the Bank system.
 */
public class BankManager {
    private final List<BankAccount> accounts;

    public BankManager() {
        this.accounts = new ArrayList<>();
    }

    public BankAccount createAccount(String holder, String type, double initialDeposit, double interestRate) {
        BankAccount account = new BankAccount(holder, type, initialDeposit, interestRate);
        accounts.add(account);
        return account;
    }

    public BankAccount createAccount(String holder, String type, double initialDeposit) {
        BankAccount account = new BankAccount(holder, type, initialDeposit);
        accounts.add(account);
        return account;
    }

    public BankAccount createAccount(String holder) {
        BankAccount account = new BankAccount(holder);
        accounts.add(account);
        return account;
    }

    public void addAccount(BankAccount account) {
        if (account != null) {
            accounts.add(account);
        }
    }

    public BankAccount findAccount(int accountNumber) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }
        return null;
    }

    public boolean deposit(int accountNumber, double amount) {
        BankAccount acc = findAccount(accountNumber);
        if (acc == null) {
            System.out.println("   [ERROR] Account #" + accountNumber + " not found!");
            return false;
        }
        return acc.deposit(amount);
    }

    public boolean withdraw(int accountNumber, double amount) {
        BankAccount acc = findAccount(accountNumber);
        if (acc == null) {
            System.out.println("   [ERROR] Account #" + accountNumber + " not found!");
            return false;
        }
        return acc.withdraw(amount);
    }

    public boolean transfer(int fromAccNumber, int toAccNumber, double amount) {
        BankAccount sender = findAccount(fromAccNumber);
        BankAccount receiver = findAccount(toAccNumber);

        if (sender == null) {
            System.out.println("   [ERROR] Source Account #" + fromAccNumber + " not found!");
            return false;
        }
        if (receiver == null) {
            System.out.println("   [ERROR] Destination Account #" + toAccNumber + " not found!");
            return false;
        }

        return sender.transferTo(receiver, amount);
    }

    public void applyInterestToAll() {
        System.out.println("\n--- Applying Monthly Interest to All Eligible Accounts ---");
        int count = 0;
        for (BankAccount acc : accounts) {
            if ("SAVINGS".equalsIgnoreCase(acc.getAccountType())) {
                acc.applyMonthlyInterest();
                count++;
            }
        }
        System.out.println("-> Interest applied to " + count + " savings account(s).");
    }

    public void listAllAccounts() {
        System.out.println("\n=========================================================================");
        System.out.printf("%-10s | %-20s | %-10s | %-12s | %-10s%n", "Acc Number", "Account Holder", "Type", "Balance", "Status");
        System.out.println("-------------------------------------------------------------------------");
        if (accounts.isEmpty()) {
            System.out.println("   (No active accounts in repository)");
        } else {
            for (BankAccount acc : accounts) {
                System.out.printf("%-10d | %-20s | %-10s | $%-11.2f | %-10s%n",
                        acc.getAccountNumber(),
                        acc.getAccountHolder(),
                        acc.getAccountType(),
                        acc.getBalance(),
                        (acc.isFrozen() ? "FROZEN" : "ACTIVE"));
            }
        }
        System.out.println("=========================================================================\n");
    }

    public void printBankAudit() {
        BankAccount.printBankHealthReport();
    }

    public List<BankAccount> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }
}
