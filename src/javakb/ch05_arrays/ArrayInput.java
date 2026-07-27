package javakb.ch05_arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ArrayInput demonstrates reading dynamic array dimensions and populating elements
 * directly from user input using Scanner.
 */
public class ArrayInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Reading User Input into an Array ---");
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();

        if (size <= 0) {
            System.out.println("Invalid size! Array size must be positive.");
            scanner.close();
            return;
        }

        int[] userNumbers = new int[size];

        System.out.println("Enter " + size + " integer values:");
        for (int i = 0; i < userNumbers.length; i++) {
            System.out.print("Element [" + i + "]: ");
            userNumbers[i] = scanner.nextInt();
        }

        System.out.println("\nArray successfully populated!");
        System.out.println("User Array: " + Arrays.toString(userNumbers));

        // Quick sum calculation
        int sum = 0;
        for (int num : userNumbers) {
            sum += num;
        }
        System.out.println("Sum of entered elements: " + sum);
        System.out.printf("Average of entered elements: %.2f%n", (double) sum / size);

        scanner.close();
    }
}
