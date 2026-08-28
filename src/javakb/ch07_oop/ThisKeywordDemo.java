package javakb.ch07_oop;

/**
 * Demonstrates the 4 primary use cases of the 'this' keyword in Java.
 *
 * Key Concepts:
 * 1. Resolving Variable Shadowing: Disambiguating instance fields from method/constructor parameters.
 * 2. Calling Current Object Methods: Explicitly or implicitly invoking instance methods within the class.
 * 3. Passing 'this' as an Argument: Passing the current object instance to external methods or helpers.
 * 4. Returning 'this' for Method Chaining: Returning the current object reference to enable a fluent interface.
 */

// Helper utility class to demonstrate passing 'this' as an argument
class OrderAuditLogger {
    static void logOrderCreation(Order order) {
        System.out.println("   [AUDIT LOG] Order #" + order.orderId + " created for customer '" + order.customerName + "'. Total items: " + order.itemCount);
    }
}

class Order {
    // Instance variables
    int orderId;
    String customerName;
    String itemSummary;
    int itemCount;
    double totalAmount;
    String status;

    // Use Case 1: Resolving Variable Shadowing in Constructor
    Order(int orderId, String customerName) {
        // 'orderId' on left is instance field; 'orderId' on right is local parameter
        this.orderId = orderId;
        this.customerName = customerName;
        this.itemSummary = "";
        this.itemCount = 0;
        this.totalAmount = 0.0;
        this.status = "CREATED";

        // Use Case 2: Invoking current object method
        this.initializeDefaults();

        // Use Case 3: Passing 'this' as an argument to an external logger
        OrderAuditLogger.logOrderCreation(this);
    }

    void initializeDefaults() {
        System.out.println("   [Init] Initializing default order configuration...");
    }

    // Use Case 4: Returning 'this' for Fluent Method Chaining (Builder-style setters)
    Order addItem(String itemName, double price) {
        if (!itemSummary.isEmpty()) {
            itemSummary += ", ";
        }
        itemSummary += itemName;
        itemCount++;
        totalAmount += price;
        System.out.printf("   -> Added item: %s ($%.2f) to Order #%d%n", itemName, price, this.orderId);
        return this; // Returns current Order instance
    }

    Order applyDiscount(double discountPercentage) {
        if (discountPercentage > 0 && discountPercentage <= 100) {
            double discountAmount = totalAmount * (discountPercentage / 100.0);
            totalAmount -= discountAmount;
            System.out.printf("   -> Applied %.0f%% discount (-$%.2f). New total: $%.2f%n",
                    discountPercentage, discountAmount, this.totalAmount);
        }
        return this; // Returns current Order instance
    }

    Order setStatus(String status) {
        this.status = status;
        System.out.println("   -> Status updated to: " + this.status);
        return this; // Returns current Order instance
    }

    void printInvoice() {
        System.out.println("\n   ================ INVOICE ================");
        System.out.println("   Order ID  : #" + this.orderId);
        System.out.println("   Customer  : " + this.customerName);
        System.out.println("   Items     : " + this.itemSummary + " (" + this.itemCount + " items)");
        System.out.printf("   Total Due : $%.2f%n", this.totalAmount);
        System.out.println("   Status    : " + this.status);
        System.out.println("   =========================================\n");
    }
}

public class ThisKeywordDemo {

    public static void main(String[] args) {
        System.out.println("=== Chapter 7: The 'this' Keyword in Java ===\n");

        // -------------------------------------------------------------
        // 1, 2 & 3: Shadowing Resolution, Internal Calling, Passing 'this'
        // -------------------------------------------------------------
        System.out.println("--- 1, 2 & 3: Creating Order (Shadowing, Method Call, Passing 'this') ---");
        Order myOrder = new Order(1001, "Harsh Wardhan");

        // -------------------------------------------------------------
        // 4. Fluent Method Chaining (Returning 'this')
        // -------------------------------------------------------------
        System.out.println("\n--- 4. Fluent Method Chaining using 'return this' ---");

        // Chaining operations smoothly across multiple lines
        myOrder.addItem("Mechanical Keyboard", 120.00)
               .addItem("Wireless Mouse", 55.00)
               .addItem("Desk Mat", 25.00)
               .applyDiscount(10.0)
               .setStatus("CONFIRMED & READY FOR SHIPPING");

        // Print final result
        myOrder.printInvoice();
    }
}
