package javakb.ch05_arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * StudentMarksAnalyzer — Chapter 5 Beginner Mini-Project
 * 
 * Features:
 * - Reads number of subjects and individual marks into an array.
 * - Computes Total Marks, Average, Highest Mark, Lowest Mark.
 * - Counts number of Passed subjects (>= 40) and Failed subjects (< 40).
 * - Displays a formatted summary report.
 */
public class StudentMarksAnalyzer {

    public static int calculateTotal(int[] marks) {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum;
    }

    public static double calculateAverage(int[] marks) {
        if (marks.length == 0) return 0.0;
        return (double) calculateTotal(marks) / marks.length;
    }

    public static int findHighest(int[] marks) {
        int highest = marks[0];
        for (int m : marks) {
            if (m > highest) highest = m;
        }
        return highest;
    }

    public static int findLowest(int[] marks) {
        int lowest = marks[0];
        for (int m : marks) {
            if (m < lowest) lowest = m;
        }
        return lowest;
    }

    public static int[] analyzePassFail(int[] marks, int passThreshold) {
        int pass = 0, fail = 0;
        for (int m : marks) {
            if (m >= passThreshold) pass++;
            else fail++;
        }
        return new int[]{pass, fail};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("     STUDENT MARKS ANALYZER SYSTEM       ");
        System.out.println("=========================================");

        System.out.print("Enter total number of subjects: ");
        int count = sc.nextInt();

        if (count <= 0) {
            System.out.println("Invalid count! Exiting program.");
            sc.close();
            return;
        }

        int[] marks = new int[count];

        System.out.println("\nEnter marks for " + count + " subjects (0 - 100):");
        for (int i = 0; i < count; i++) {
            while (true) {
                System.out.print("Subject " + (i + 1) + ": ");
                int val = sc.nextInt();
                if (val >= 0 && val <= 100) {
                    marks[i] = val;
                    break;
                }
                System.out.println("  Invalid mark! Please enter a value between 0 and 100.");
            }
        }

        // Calculations
        int total = calculateTotal(marks);
        double avg = calculateAverage(marks);
        int highest = findHighest(marks);
        int lowest = findLowest(marks);
        int[] passFail = analyzePassFail(marks, 40);

        // Display Summary
        System.out.println("\n-----------------------------------------");
        System.out.println("           PERFORMANCE SUMMARY           ");
        System.out.println("-----------------------------------------");
        System.out.println("Marks Recorded: " + Arrays.toString(marks));
        System.out.println("Total Marks:    " + total + " / " + (count * 100));
        System.out.printf("Average Mark:   %.2f%%%n", avg);
        System.out.println("Highest Mark:   " + highest);
        System.out.println("Lowest Mark:    " + lowest);
        System.out.println("Passed Subjects (>= 40): " + passFail[0]);
        System.out.println("Failed Subjects (< 40):  " + passFail[1]);
        System.out.println("Overall Result: " + (passFail[1] == 0 ? "PASSED 🎉" : "NEEDS IMPROVEMENT ⚠️"));
        System.out.println("-----------------------------------------");

        sc.close();
    }
}
