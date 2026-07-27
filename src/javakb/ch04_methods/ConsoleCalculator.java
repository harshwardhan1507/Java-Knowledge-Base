package javakb.ch04_methods;

import java.util.Scanner;

/**
 * ConsoleCalculator — Chapter 4 Mini Project
 * 
 * Requirements:
 * - Separate static methods for add, subtract, multiply, and divide operations.
 * - Division by zero check with user-friendly error output.
 * - Varargs addition method for calculating sum of multiple numbers.
 * - Interactive, menu-driven loop controlled via Scanner and switch statement.
 */
public class ConsoleCalculator {

    /**
     * Performs addition of two numbers.
     */
    public static double add(double a, double b) {
        return a + b;
    }

    /**
     * Performs subtraction of two numbers.
     */
    public static double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Performs multiplication of two numbers.
     */
    public static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Performs division of two numbers with zero check.
     */
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is undefined!");
            return Double.NaN;
        }
        return a / b;
    }

    /**
     * Sums multiple numbers using Varargs.
     */
    public static double sumVarargs(double... numbers) {
        double total = 0;
        for (double num : numbers) {
            total += num;
        }
        return total;
    }

    /**
     * Displays menu options to the user.
     */
    public static void displayMenu() {
        System.out.println("\n========= CONSOLE CALCULATOR =========");
        System.out.println("1. Add (+) two numbers");
        System.out.println("2. Subtract (-) two numbers");
        System.out.println("3. Multiply (*) two numbers");
        System.out.println("4. Divide (/) two numbers");
        System.out.println("5. Add multiple numbers (Varargs)");
        System.out.println("6. Exit");
        System.out.print("Select an option (1-6): ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Chapter 04 Method-Driven Console Calculator!");

        while (running) {
            displayMenu();

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1 and 6.");
                scanner.next(); // Clear invalid input
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter first number: ");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    double num2 = scanner.nextDouble();
                    System.out.printf("Result: %.4f + %.4f = %.4f%n", num1, num2, add(num1, num2));
                }
                case 2 -> {
                    System.out.print("Enter first number: ");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    double num2 = scanner.nextDouble();
                    System.out.printf("Result: %.4f - %.4f = %.4f%n", num1, num2, subtract(num1, num2));
                }
                case 3 -> {
                    System.out.print("Enter first number: ");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    double num2 = scanner.nextDouble();
                    System.out.printf("Result: %.4f * %.4f = %.4f%n", num1, num2, multiply(num1, num2));
                }
                case 4 -> {
                    System.out.print("Enter numerator: ");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter denominator: ");
                    double num2 = scanner.nextDouble();
                    double result = divide(num1, num2);
                    if (!Double.isNaN(result)) {
                        System.out.printf("Result: %.4f / %.4f = %.4f%n", num1, num2, result);
                    }
                }
                case 5 -> {
                    System.out.print("How many numbers do you want to add? ");
                    int count = scanner.nextInt();
                    if (count <= 0) {
                        System.out.println("Count must be greater than 0.");
                        break;
                    }
                    double[] nums = new double[count];
                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter number " + (i + 1) + ": ");
                        nums[i] = scanner.nextDouble();
                    }
                    System.out.printf("Sum of %d numbers = %.4f%n", count, sumVarargs(nums));
                }
                case 6 -> {
                    System.out.println("Exiting Console Calculator. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option! Please select between 1 and 6.");
            }
        }

        scanner.close();
    }
}
