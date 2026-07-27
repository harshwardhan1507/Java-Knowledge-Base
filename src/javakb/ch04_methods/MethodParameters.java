package javakb.ch04_methods;

import java.util.Arrays;

/**
 * MethodParameters demonstrates:
 * 1. Parameters vs Arguments.
 * 2. Java's Pass-by-Value mechanism for primitive types.
 * 3. Java's Pass-by-Value mechanism for reference types (objects and arrays).
 * 
 * IMPORTANT JAVA CONCEPT:
 * Java is STRICTLY Pass-by-Value.
 * - For primitives, a copy of the primitive value is passed.
 * - For objects/arrays, a copy of the reference (memory address) is passed.
 */
public class MethodParameters {

    /**
     * Adds two integers and displays parameters and sum.
     * 
     * @param a formal parameter a
     * @param b formal parameter b
     */
    public static void add(int a, int b) {
        System.out.println("Inside add(): formal parameters a = " + a + ", b = " + b);
        System.out.println("Sum is: " + (a + b));
    }

    /**
     * Demonstrates primitive pass-by-value.
     * Modifying 'number' inside this method will NOT alter the original variable in main().
     */
    public static void modifyPrimitive(int number) {
        System.out.println("Inside modifyPrimitive() BEFORE modification: number = " + number);
        number = 999;
        System.out.println("Inside modifyPrimitive() AFTER modification: number = " + number);
    }

    /**
     * Demonstrates object/array pass-by-value.
     * Mutating array elements via copied reference DOES modify the caller's array.
     */
    public static void modifyArrayElements(int[] arr) {
        if (arr.length > 0) {
            arr[0] = 777; // Mutates original array element
        }
    }

    /**
     * Demonstrates reassigning reference inside method.
     * Reassigning 'arr' to a new array object DOES NOT affect caller's original array.
     */
    public static void reassignReference(int[] arr) {
        arr = new int[]{100, 200, 300}; // Reassigns local copy of reference
        System.out.println("Inside reassignReference(): arr = " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        System.out.println("--- 1. Basic Parameters & Arguments ---");
        int num1 = 10;
        int num2 = 20;
        // num1 and num2 are actual arguments passed to add()
        add(num1, num2);

        System.out.println("\n--- 2. Pass-by-Value (Primitives) ---");
        int original = 50;
        System.out.println("In main() BEFORE calling modifyPrimitive(): original = " + original);
        modifyPrimitive(original);
        System.out.println("In main() AFTER calling modifyPrimitive(): original = " + original + " (Unchanged!)");

        System.out.println("\n--- 3. Pass-by-Value (Reference Types: Element Mutation) ---");
        int[] numbers = {1, 2, 3};
        System.out.println("In main() BEFORE modifyArrayElements(): " + Arrays.toString(numbers));
        modifyArrayElements(numbers);
        System.out.println("In main() AFTER modifyArrayElements(): " + Arrays.toString(numbers) + " (Element [0] changed!)");

        System.out.println("\n--- 4. Pass-by-Value (Reference Types: Reference Reassignment) ---");
        System.out.println("In main() BEFORE reassignReference(): " + Arrays.toString(numbers));
        reassignReference(numbers);
        System.out.println("In main() AFTER reassignReference(): " + Arrays.toString(numbers) + " (Reference unchanged!)");
    }
}