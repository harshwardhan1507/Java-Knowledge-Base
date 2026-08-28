package javakb.projects.intermediate.bankingsystem;

import java.util.Scanner;

/**
 * Entry point and interactive console interface for the Apex Reserve Banking System.
 */
public class Main {

    public static void runAutomatedDemo(BankManager manager) {
        System.out.println("\n========================================================");
        System.out.println("      AUTOMATED APEX RESERVE OOP DEMONSTRATION");
        System.out.println("========================================================");

        // 1. Creating accounts using overloaded constructors & chaining
        System.out.println("\n[Step 1: Creating Accounts using Overloaded Constructors]");
        BankAccount acc1 = manager.createAccount("Harsh Wardhan", "SAVINGS", 1500.0, 5.0);
        BankAccount acc2 = manager.createAccount("Sophia Loren", "CHECKING", 800.0);
        BankAccount acc3 = manager.createAccount("Liam Smith"); // Default constructor chaining

        // 2. Fluent Method Chaining (Returning 'this')
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
        Scanner scanner = new Scanner(System.in);
        BankManager manager = new BankManager();

        // Seed initial sample accounts
        manager.createAccount("Alice Johnson", "SAVINGS", 2500.0, 4.75);
        manager.createAccount("Bob Smith", "CHECKING", 1200.0);

        boolean running = true;
        System.out.println("==========================================================");
        System.out.println("    WELCOME TO APEX NATIONAL RESERVE BANKING SYSTEM       ");
        System.out.println("==========================================================");

        while (running) {
            System.out.println("\n----------------- MAIN BANKING MENU -----------------");
            System.out.println("1. Open New Bank Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Transfer Funds Between Accounts");
            System.out.println("5. Apply Monthly Interest to Savings Accounts");
            System.out.println("6. View Account Details & Statement");
            System.out.println("7. List All Accounts");
            System.out.println("8. Bank Financial Audit Report");
            System.out.println("9. Run Automated OOP Showcase Demo");
            System.out.println("10. Exit");
            System.out.print("Select an option (1-10): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1 and 10.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Account Holder Name: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Enter Account Type (SAVINGS / CHECKING): ");
                    String type = scanner.nextLine().trim().toUpperCase();
                    if (!type.equals("SAVINGS") && !type.equals("CHECKING")) {
                        type = "CHECKING";
                    }
                    System.out.print("Enter Initial Deposit (Min $25.00): $");
                    double deposit = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    BankAccount newAcc = manager.createAccount(name, type, deposit);
                    System.out.println("\n🎉 Account successfully opened!");
                    newAcc.printAccountSummary();
                }
                case 2 -> {
                    System.out.print("Enter Account Number: ");
                    int accNum = scanner.nextInt();
                    System.out.print("Enter Deposit Amount: $");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    manager.deposit(accNum, amount);
                }
                case 3 -> {
                    System.out.print("Enter Account Number: ");
                    int accNum = scanner.nextInt();
                    System.out.print("Enter Withdrawal Amount: $");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    manager.withdraw(accNum, amount);
                }
                case 4 -> {
                    System.out.print("Enter Source (Sender) Account Number: ");
                    int fromAcc = scanner.nextInt();
                    System.out.print("Enter Destination (Receiver) Account Number: ");
                    int toAcc = scanner.nextInt();
                    System.out.print("Enter Transfer Amount: $");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    manager.transfer(fromAcc, toAcc, amount);
                }
                case 5 -> manager.applyInterestToAll();
                case 6 -> {
                    System.out.print("Enter Account Number: ");
                    int accNum = scanner.nextInt();
                    scanner.nextLine();
                    BankAccount acc = manager.findAccount(accNum);
                    if (acc != null) {
                        acc.printStatement();
                    } else {
                        System.out.println("   [ERROR] Account #" + accNum + " not found.");
                    }
                }
                case 7 -> manager.listAllAccounts();
                case 8 -> manager.printBankAudit();
                case 9 -> runAutomatedDemo(manager);
                case 10 -> {
                    System.out.println("\nThank you for banking with Apex National Reserve. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid selection! Please enter a choice from 1 to 10.");
            }
        }

        scanner.close();
    }
}
