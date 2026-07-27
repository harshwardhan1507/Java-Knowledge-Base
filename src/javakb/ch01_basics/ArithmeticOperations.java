package javakb.ch01_basics;

import java.util.Scanner;

public class ArithmeticOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number one: ");
        int a = sc.nextInt();
        System.out.print("Enter number two: ");
        int b = sc.nextInt();

        int sum = a + b;
        System.out.println("Sum (a + b): " + sum);

        int difference = a - b;
        System.out.println("Difference (a - b): " + difference);

        int multiplication = a * b;
        System.out.println("Multiplication (a * b): " + multiplication);

        // Guard against division by zero for both division and modulus
        if (b != 0) {
            int division = a / b;
            int remainder = a % b;
            System.out.println("Division (a / b): " + division);
            System.out.println("Remainder (a % b): " + remainder);
        } else {
            System.out.println("Division and Remainder: Cannot divide or calculate modulus by zero!");
        }

        System.out.println("\n--- Increment and Decrement Operators ---");
        System.out.println("Before increment a: " + a);
        a++;
        System.out.println("After increment a++: " + a);

        System.out.println("Before decrement b: " + b);
        b--;
        System.out.println("After decrement b--: " + b);

        sc.close();
    }
}