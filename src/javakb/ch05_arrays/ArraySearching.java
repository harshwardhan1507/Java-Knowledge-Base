package javakb.ch05_arrays;

/**
 * ArraySearching demonstrates the Linear Search algorithm on arrays.
 * 
 * Algorithm:
 * Sequential search that checks each element in the array one by one from index 0
 * to (length - 1) until the target element is found or array ends.
 * 
 * Time Complexity Analysis:
 * - Best Case: O(1) (target is at index 0)
 * - Worst Case: O(n) (target is at the last index or not in array)
 * - Average Case: O(n)
 * - Space Complexity: O(1) (Auxiliary space)
 */
public class ArraySearching {

    /**
     * Performs a Linear Search on an integer array.
     * 
     * @param arr Target array to search
     * @param target Element value to search for
     * @return 0-based index of target if found; -1 otherwise
     */
    public static int linearSearch(int[] arr, int target) {
        if (arr == null) return -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Target found at index i
            }
        }
        return -1; // Target not present in array
    }

    public static void main(String[] args) {
        int[] numbers = {24, 7, 89, 45, 12, 56, 33};
        int target1 = 45;
        int target2 = 99;

        System.out.println("--- Linear Search Demonstration ---");
        System.out.print("Array elements: ");
        for (int n : numbers) System.out.print(n + " ");
        System.out.println();

        // Search 1: Present target
        int index1 = linearSearch(numbers, target1);
        if (index1 != -1) {
            System.out.println("Target " + target1 + " FOUND at index: " + index1);
        } else {
            System.out.println("Target " + target1 + " NOT found.");
        }

        // Search 2: Absent target
        int index2 = linearSearch(numbers, target2);
        if (index2 != -1) {
            System.out.println("Target " + target2 + " FOUND at index: " + index2);
        } else {
            System.out.println("Target " + target2 + " NOT found (Returned: " + index2 + ")");
        }
    }
}
