package javakb.ch05_arrays;

import java.util.Arrays;

/**
 * ArrayDeclaration demonstrates array creation, allocation, default values,
 * and element access mechanics in Java.
 * 
 * Key Concepts:
 * 1. An array is a fixed-size collection of elements of the same data type stored in contiguous memory.
 * 2. Array indices are 0-based: index ranges from 0 to (length - 1).
 * 3. Default Values when uninitialized:
 *    - Numeric primitives (int, double, etc.): 0 or 0.0
 *    - boolean: false
 *    - char: '\u0000' (null character)
 *    - Reference types (Objects, String): null
 */
public class ArrayDeclaration {

    public static void main(String[] args) {
        System.out.println("--- 1. Declaration and Allocation with 'new' ---");
        // Declare and allocate memory for an integer array of size 5
        int[] numbers = new int[5];
        
        // Initializing elements manually by index
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        System.out.println("First element (index 0): " + numbers[0]);
        System.out.println("Third element (index 2): " + numbers[2]);
        System.out.println("Last element (index 4): " + numbers[4]);
        System.out.println("Array length: " + numbers.length);

        System.out.println("\n--- 2. Direct Literal Initialization ---");
        // Shorthand literal array initialization
        int[] marks = {90, 85, 78, 92, 88};
        String[] fruits = {"Apple", "Banana", "Cherry"};

        System.out.println("Marks array: " + Arrays.toString(marks));
        System.out.println("Fruits array: " + Arrays.toString(fruits));

        System.out.println("\n--- 3. Default Primitive & Reference Values ---");
        int[] defaultInts = new int[3];       // Default: 0
        double[] defaultDoubles = new double[3]; // Default: 0.0
        boolean[] defaultBools = new boolean[3]; // Default: false
        String[] defaultStrings = new String[3]; // Default: null

        System.out.println("Default int[0]: " + defaultInts[0]);
        System.out.println("Default double[0]: " + defaultDoubles[0]);
        System.out.println("Default boolean[0]: " + defaultBools[0]);
        System.out.println("Default String[0]: " + defaultStrings[0]);

        System.out.println("\n--- 4. Updating Elements ---");
        System.out.println("Before update: marks[2] = " + marks[2]);
        marks[2] = 100; // Update element at index 2
        System.out.println("After update: marks[2] = " + marks[2]);

        System.out.println("\n--- 5. Out of Bounds Exception Trap ---");
        try {
            // Trying to access index equal to array length causes ArrayIndexOutOfBoundsException
            @SuppressWarnings("unused")
            int invalidAccess = marks[marks.length]; 
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught Expected Error: " + e.getMessage());
            System.out.println("Rule: Valid index range for length " + marks.length + " is 0 to " + (marks.length - 1));
        }
    }
}
