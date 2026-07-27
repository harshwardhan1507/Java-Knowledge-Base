package javakb.ch05_arrays;

/**
 * MultiDimensionalArrays demonstrates 2D arrays (matrices) and Jagged/Ragged arrays in Java.
 * 
 * Key Concepts:
 * 1. A 2D array in Java is an "array of arrays".
 * 2. Syntax: DataType[][] matrix = new DataType[rows][cols];
 * 3. Element access: matrix[rowIndex][columnIndex]
 * 4. Jagged / Ragged Array: A 2D array where sub-arrays have different column lengths.
 */
public class MultiDimensionalArrays {

    public static void main(String[] args) {
        System.out.println("--- 1. Literal 2D Matrix Initialization & Traversal ---");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Traversal using nested for loops
        for (int i = 0; i < matrix.length; i++) {           // Outer loop over rows
            for (int j = 0; j < matrix[i].length; j++) {    // Inner loop over columns
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\n--- 2. Matrix Row and Column Calculations ---");
        int totalSum = 0;
        for (int r = 0; r < matrix.length; r++) {
            int rowSum = 0;
            for (int c = 0; c < matrix[r].length; c++) {
                rowSum += matrix[r][c];
                totalSum += matrix[r][c];
            }
            System.out.println("Sum of Row " + r + " = " + rowSum);
        }
        System.out.println("Total Matrix Sum = " + totalSum);

        System.out.println("\n--- 3. Jagged / Ragged Array (Variable Column Sizes) ---");
        // Create a 2D array with 3 rows, but columns not yet specified
        int[][] jagged = new int[3][];
        jagged[0] = new int[]{1, 2};          // Row 0 has 2 elements
        jagged[1] = new int[]{3, 4, 5, 6};    // Row 1 has 4 elements
        jagged[2] = new int[]{7};             // Row 2 has 1 element

        for (int r = 0; r < jagged.length; r++) {
            System.out.print("Row [" + r + "] (size " + jagged[r].length + "): ");
            for (int val : jagged[r]) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
