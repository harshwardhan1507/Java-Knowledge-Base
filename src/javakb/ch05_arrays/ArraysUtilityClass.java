package javakb.ch05_arrays;

import java.util.Arrays;

/**
 * ArraysUtilityClass demonstrates useful helper methods provided by java.util.Arrays.
 * 
 * Featured Methods:
 * 1. Arrays.toString(arr)      - Formats array contents as readable string
 * 2. Arrays.sort(arr)          - Sorts primitive/object array in ascending order
 * 3. Arrays.equals(arr1, arr2) - Checks element-by-element equality
 * 4. Arrays.fill(arr, val)     - Fills array elements with specified value
 * 5. Arrays.copyOf(arr, len)   - Copies array up to specified length
 * 6. Arrays.binarySearch(arr, key) - Performs binary search on SORTED array
 */
public class ArraysUtilityClass {

    public static void main(String[] args) {
        int[] numbers = {42, 15, 8, 99, 23, 71};

        System.out.println("--- 1. Arrays.toString() ---");
        System.out.println("Original Array: " + Arrays.toString(numbers));

        System.out.println("\n--- 2. Arrays.sort() ---");
        Arrays.sort(numbers);
        System.out.println("Sorted Array:   " + Arrays.toString(numbers));

        System.out.println("\n--- 3. Arrays.binarySearch() [Array MUST be sorted!] ---");
        int target = 23;
        int index = Arrays.binarySearch(numbers, target);
        System.out.println("Binary Search for " + target + " -> Index: " + index);

        System.out.println("\n--- 4. Arrays.copyOf() ---");
        int[] shortCopy = Arrays.copyOf(numbers, 3);
        int[] longCopy = Arrays.copyOf(numbers, 8); // Padded with 0s
        System.out.println("Copied first 3 elements: " + Arrays.toString(shortCopy));
        System.out.println("Padded copy of length 8: " + Arrays.toString(longCopy));

        System.out.println("\n--- 5. Arrays.equals() ---");
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {3, 2, 1};
        System.out.println("arr1 equals arr2? " + Arrays.equals(arr1, arr2));
        System.out.println("arr1 equals arr3? " + Arrays.equals(arr1, arr3));

        System.out.println("\n--- 6. Arrays.fill() ---");
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 7);
        System.out.println("Filled Array with 7s: " + Arrays.toString(filledArray));
    }
}
