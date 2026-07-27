package javakb.ch05_arrays;

/**
 * ArrayTraversal demonstrates iterating over array elements using traditional index-based loops.
 * 
 * Key Concepts:
 * 1. Traditional 'for' loop uses an explicit index variable (e.g. i = 0 to i < arr.length).
 * 2. Allows accessing current index, modifying elements during iteration, and traversing backwards.
 * 3. Array bounds: Always use 'i < arr.length' (NOT 'i <= arr.length').
 */
public class ArrayTraversal {

    public static void main(String[] args) {
        int[] scores = {45, 67, 89, 92, 74, 81};

        System.out.println("--- 1. Forward Traversal (0 to length - 1) ---");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Score at index [" + i + "] = " + scores[i]);
        }

        System.out.println("\n--- 2. Backward / Reverse Traversal (length - 1 down to 0) ---");
        for (int i = scores.length - 1; i >= 0; i--) {
            System.out.println("Score at index [" + i + "] = " + scores[i]);
        }

        System.out.println("\n--- 3. Modifying Elements During Traversal ---");
        System.out.print("Original Scores: ");
        printArrayInline(scores);

        // Add 5 bonus points to every score below 80
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 80) {
                scores[i] += 5;
            }
        }

        System.out.print("Updated Scores (with +5 bonus to < 80): ");
        printArrayInline(scores);

        System.out.println("\n--- 4. Traversing Every Second Element (Step-based) ---");
        for (int i = 0; i < scores.length; i += 2) {
            System.out.println("Even Index [" + i + "] -> " + scores[i]);
        }
    }

    private static void printArrayInline(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
