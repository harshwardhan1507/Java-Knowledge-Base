package javakb.ch05_arrays;

import java.util.Arrays;

/**
 * ArrayOperations demonstrates modular utility methods operating on arrays:
 * 1. Sum calculation
 * 2. Average calculation
 * 3. Finding Maximum element
 * 4. Finding Minimum element
 * 5. In-place Reversal
 * 6. Counting Even and Odd numbers
 */
public class ArrayOperations {

    /**
     * Calculates the sum of all elements in an integer array.
     */
    public static int sum(int[] arr) {
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        return total;
    }

    /**
     * Calculates the average value of elements in an integer array.
     */
    public static double average(int[] arr) {
        if (arr == null || arr.length == 0) return 0.0;
        return (double) sum(arr) / arr.length;
    }

    /**
     * Finds the maximum value in an integer array.
     */
    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Finds the minimum value in an integer array.
     */
    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * Reverses an array in-place using two pointers (start and end).
     */
    public static void reverseInPlace(int[] arr) {
        if (arr == null) return;
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            // Swap elements
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Counts and returns even and odd counts as a two-element array [evenCount, oddCount].
     */
    public static int[] countEvenOdd(int[] arr) {
        int evenCount = 0;
        int oddCount = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return new int[]{evenCount, oddCount};
    }

    public static void main(String[] args) {
        int[] data = {12, 45, 7, 23, 56, 89, 34, 18};

        System.out.println("Input Array: " + Arrays.toString(data));
        System.out.println("Sum: " + sum(data));
        System.out.printf("Average: %.2f%n", average(data));
        System.out.println("Maximum Element: " + findMax(data));
        System.out.println("Minimum Element: " + findMin(data));

        int[] counts = countEvenOdd(data);
        System.out.println("Even Count: " + counts[0] + " | Odd Count: " + counts[1]);

        System.out.println("\n--- In-Place Reversal ---");
        System.out.println("Before Reversal: " + Arrays.toString(data));
        reverseInPlace(data);
        System.out.println("After Reversal:  " + Arrays.toString(data));
    }
}
