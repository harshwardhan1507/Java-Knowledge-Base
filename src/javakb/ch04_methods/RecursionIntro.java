package javakb.ch04_methods;

/**
 * RecursionIntro demonstrates the fundamentals of recursion in Java.
 * 
 * Concept: Recursion is a programming technique where a method calls itself to solve a smaller
 * instance of the same problem.
 * 
 * Every recursive method MUST have two components:
 * 1. Base Case: The condition under which the method stops calling itself (prevents infinite recursion).
 * 2. Recursive Step: The part where the method calls itself with a modified (usually reduced) argument.
 * 
 * Pitfall: Missing or incorrect base cases lead to StackOverflowError due to exhausted memory in the call stack.
 */
public class RecursionIntro {

    /**
     * Calculates factorial of n (n! = n * (n-1) * ... * 1).
     * 
     * Base Case: if n <= 1, return 1
     * Recursive Step: return n * factorial(n - 1)
     * 
     * @param n Non-negative integer
     * @return Factorial of n
     */
    public static int factorial(int n) {
        if (n <= 1) {
            return 1; // Base case
        }
        return n * factorial(n - 1); // Recursive call
    }

    /**
     * Prints a countdown from n to 1 recursively.
     * Visualizes method call stack unwinding.
     * 
     * @param n Starting integer
     */
    public static void countDown(int n) {
        if (n <= 0) {
            System.out.println("Blastoff!"); // Base case
            return;
        }
        System.out.print(n + " -> ");
        countDown(n - 1); // Recursive call
    }

    /**
     * Calculates the nth Fibonacci number recursively.
     * Fib sequence: 0, 1, 1, 2, 3, 5, 8, 13...
     * 
     * @param n Position in Fibonacci sequence
     * @return nth Fibonacci value
     */
    public static int fibonacci(int n) {
        if (n <= 0) return 0; // Base case 1
        if (n == 1) return 1; // Base case 2
        return fibonacci(n - 1) + fibonacci(n - 2); // Tree recursive call
    }

    public static void main(String[] args) {
        System.out.println("--- 1. Recursive Countdown ---");
        countDown(5);

        System.out.println("\n--- 2. Factorial Calculation ---");
        int num = 5;
        System.out.println("Factorial of " + num + " (" + num + "!) = " + factorial(num));

        System.out.println("\n--- 3. Fibonacci Sequence ---");
        System.out.print("First 7 Fibonacci numbers: ");
        for (int i = 0; i < 7; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }
}