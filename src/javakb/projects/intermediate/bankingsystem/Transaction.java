package javakb.projects.intermediate.bankingsystem;

/**
 * Represents an individual financial transaction on a BankAccount.
 */
public class Transaction {
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

    public String getTransactionId() {
        return transactionId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getPostBalance() {
        return postBalance;
    }

    public String getDescription() {
        return description;
    }

    public void printRecord() {
        System.out.printf("   [%s] %-10s | Amount: %10s | Balance: %10s | Note: %s%n",
                this.transactionId,
                this.type,
                String.format("$%.2f", this.amount),
                String.format("$%.2f", this.postBalance),
                this.description);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: $%.2f (Post-Balance: $%.2f) - %s",
                transactionId, type, amount, postBalance, description);
    }
}
