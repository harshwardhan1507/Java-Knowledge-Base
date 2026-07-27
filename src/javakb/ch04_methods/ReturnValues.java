package javakb.ch04_methods;

/**
 * ReturnValues demonstrates returning values from methods in Java.
 * 
 * Key Concepts:
 * 1. Method return type specifies what data type the method gives back to the caller.
 * 2. Use 'void' if the method does not return any value.
 * 3. The 'return' statement exits the method immediately and optionally yields a value.
 */
public class ReturnValues {

    /**
     * Calculates the sum of two integers.
     * 
     * @param a First integer
     * @param b Second integer
     * @return Sum of a and b
     */
    public static int add(int a, int b) {
        return a + b; // Must return an int
    }

    /**
     * Calculates the average of three numbers.
     * Fixes operator precedence: (a + b + c) / 3.0 instead of a + b + c / 3.
     * 
     * @param a First number
     * @param b Second number
     * @param c Third number
     * @return Average of a, b, and c as double
     */
    public static double average(double a, double b, double c) {
        return (a + b + c) / 3.0;
    }

    /**
     * Checks if a given number is even.
     * 
     * @param number Integer to check
     * @return true if even, false otherwise
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Demonstrates early return to guard against invalid inputs.
     * 
     * @param age Age of user
     */
    public static void printEligibility(int age) {
        if (age < 0) {
            System.out.println("Invalid age provided: " + age);
            return; // Early return to exit method early
        }

        if (age >= 18) {
            System.out.println("Age " + age + ": Eligible to vote.");
        } else {
            System.out.println("Age " + age + ": Not eligible to vote yet.");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- 1. Returning Primitive Values ---");
        int sum = add(15, 25);
        System.out.println("Sum is: " + sum);

        double avg = average(3.0, 4.0, 5.0);
        System.out.println("Average of 3, 4, 5 is: " + avg);

        System.out.println("\n--- 2. Boolean Return Values ---");
        int testNum = 8;
        System.out.println("Is " + testNum + " even? " + isEven(testNum));

        System.out.println("\n--- 3. Early Return Guard Clause ---");
        printEligibility(-5);
        printEligibility(16);
        printEligibility(21);
    }
}