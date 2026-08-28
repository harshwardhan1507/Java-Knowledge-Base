package javakb.projects.intermediate;

import java.util.Scanner;

/**
 * InventoryManagement — Intermediate Mini-Project
 *
 * Features:
 * - Manages parallel arrays for Product IDs, Product Names, and Stock Quantities.
 * - Menu-driven interface using Scanner and switch.
 * - Options: View Inventory, Search Item by ID, Update Stock, Check Low Stock Warning, Exit.
 */
public class InventoryManagement {

    private static final int[] productIds = {101, 102, 103, 104, 105};
    private static final String[] productNames = {"Laptop", "Mouse", "Keyboard", "Monitor", "Headphones"};
    private static final int[] stockQuantities = {15, 50, 8, 22, 5}; // Stock counts

    public static void displayInventory() {
        System.out.println("\n------------------------------------------------");
        System.out.printf("%-10s %-20s %-10s%n", "ID", "Product Name", "Quantity");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < productIds.length; i++) {
            System.out.printf("%-10d %-20s %-10d%n", productIds[i], productNames[i], stockQuantities[i]);
        }
        System.out.println("------------------------------------------------");
    }

    public static int searchProductIndex(int id) {
        for (int i = 0; i < productIds.length; i++) {
            if (productIds[i] == id) {
                return i; // Found index
            }
        }
        return -1; // Not found
    }

    public static boolean updateStock(int id, int newQuantity) {
        int index = searchProductIndex(id);
        if (index != -1) {
            stockQuantities[index] = newQuantity;
            return true;
        }
        return false;
    }

    public static void displayLowStock(int threshold) {
        System.out.println("\n--- LOW STOCK ALERTS (Quantity < " + threshold + ") ---");
        boolean foundLow = false;
        for (int i = 0; i < productIds.length; i++) {
            if (stockQuantities[i] < threshold) {
                System.out.println("  ⚠️ " + productNames[i] + " (ID: " + productIds[i] + ") - Only " + stockQuantities[i] + " left!");
                foundLow = true;
            }
        }
        if (!foundLow) {
            System.out.println("  All products have sufficient stock.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("==============================================");
        System.out.println("        INVENTORY MANAGEMENT SYSTEM           ");
        System.out.println("==============================================");

        while (running) {
            System.out.println("\n1. View All Inventory");
            System.out.println("2. Search Product by ID");
            System.out.println("3. Update Stock Quantity");
            System.out.println("4. Check Low Stock Warnings (< 10)");
            System.out.println("5. Exit");
            System.out.print("Select an option (1-5): ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice!");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> displayInventory();
                case 2 -> {
                    System.out.print("Enter Product ID to search: ");
                    int id = sc.nextInt();
                    int idx = searchProductIndex(id);
                    if (idx != -1) {
                        System.out.println("FOUND: " + productNames[idx] + " (ID: " + productIds[idx] + ") | Stock: " + stockQuantities[idx]);
                    } else {
                        System.out.println("Product ID " + id + " NOT found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter Product ID to update: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new stock quantity: ");
                    int newQty = sc.nextInt();
                    if (newQty < 0) {
                        System.out.println("Quantity cannot be negative!");
                        break;
                    }
                    if (updateStock(id, newQty)) {
                        System.out.println("Stock updated successfully!");
                    } else {
                        System.out.println("Product ID " + id + " NOT found.");
                    }
                }
                case 4 -> displayLowStock(10);
                case 5 -> {
                    System.out.println("Exiting Inventory Management System. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option! Please enter 1 to 5.");
            }
        }

        sc.close();
    }
}
