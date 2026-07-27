package javakb.ch05_arrays;

/**
 * EnhancedForLoop demonstrates the 'for-each' loop in Java.
 * 
 * Syntax:
 * for (ElementType variable : arrayOrCollection) {
 *     // body
 * }
 * 
 * Advantages:
 * - Cleaner, simpler syntax (no manual index counter or length check required).
 * - Prevents off-by-one errors and ArrayIndexOutOfBoundsException.
 * 
 * Limitations:
 * - Read-only traversal: modifying the iteration variable does NOT change array elements.
 * - No access to element index.
 * - Cannot iterate backwards or skip elements.
 */
public class EnhancedForLoop {

    public static void main(String[] args) {
        String[] languages = {"Java", "Python", "C++", "JavaScript", "Go"};
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("--- 1. Simple For-Each Traversal over Strings ---");
        for (String lang : languages) {
            System.out.println("Language: " + lang);
        }

        System.out.println("\n--- 2. Summing Array Elements with For-Each ---");
        int totalSum = 0;
        for (int num : numbers) {
            totalSum += num;
        }
        System.out.println("Total Sum: " + totalSum);

        System.out.println("\n--- 3. Limitation Demonstration: Read-Only Nature ---");
        System.out.print("Before loop: ");
        printArray(numbers);

        // Attempting to modify element via for-each loop
        for (int num : numbers) {
            num = num * 2; // Changes local copy 'num', NOT the array!
        }

        System.out.print("After for-each modification attempt: ");
        printArray(numbers);
        System.out.println("Notice: Array elements remain unchanged because 'num' is a local copy!");
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
