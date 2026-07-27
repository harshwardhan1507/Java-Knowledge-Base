package javakb.ch04_methods;

/**
 * VarargsDemo demonstrates Variable-Length Arguments (Varargs) in Java.
 * 
 * Concept: Varargs allow a method to accept zero or multiple arguments of a specified type.
 * 
 * Syntax:
 * public static returnType methodName(DataType... parameterName)
 * 
 * Rules for Varargs:
 * 1. A method can have only ONE varargs parameter.
 * 2. The varargs parameter MUST be the LAST parameter in the method parameter list.
 * 3. Inside the method body, varargs is treated as an array of the specified type.
 */
public class VarargsDemo {

    /**
     * Calculates the sum of variable number of integers.
     * 
     * @param numbers Varargs parameter (treated as int[] inside method)
     * @return Sum of all provided numbers
     */
    public static int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    /**
     * Demonstrates combining standard parameters with a varargs parameter.
     * The standard parameter MUST come first; varargs MUST come last.
     * 
     * @param studentName Name of student
     * @param marks Variable number of subject marks
     */
    public static void printReportCard(String studentName, double... marks) {
        System.out.println("Student: " + studentName);
        if (marks.length == 0) {
            System.out.println("  No marks recorded.");
            return;
        }

        double total = 0;
        for (double m : marks) {
            total += m;
        }
        double average = total / marks.length;
        System.out.println("  Total Marks: " + total + " | Average: " + String.format("%.2f", average));
    }

    public static void main(String[] args) {
        System.out.println("--- 1. Calling Varargs with Variable Number of Arguments ---");
        System.out.println("sum() [0 args]: " + sum());
        System.out.println("sum(5) [1 arg]: " + sum(5));
        System.out.println("sum(10, 20, 30) [3 args]: " + sum(10, 20, 30));
        System.out.println("sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) [10 args]: " + sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        System.out.println("\n--- 2. Passing an Array to Varargs Method ---");
        int[] numberArray = {100, 200, 300};
        System.out.println("sum(numberArray): " + sum(numberArray));

        System.out.println("\n--- 3. Varargs Combined with Regular Parameters ---");
        printReportCard("Harsh", 88.5, 92.0, 95.5, 91.0);
        printReportCard("Alex"); // Zero vararg elements passed
    }
}
