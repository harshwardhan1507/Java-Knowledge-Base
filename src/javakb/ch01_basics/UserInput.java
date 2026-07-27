package javakb.ch01_basics;

import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("User, please input the following:");

        System.out.print("Enter an integer: ");
        int x = sc.nextInt();

        System.out.print("Enter a decimal number: ");
        double y = sc.nextDouble();

        System.out.print("Enter a boolean (true/false): ");
        boolean bool = sc.nextBoolean();

        System.out.print("Enter a single character: ");
        char ch = sc.next().charAt(0);

        sc.nextLine(); // Flushing leftover newline buffer before reading string line!
        System.out.print("Enter a full string: ");
        String str = sc.nextLine();

        System.out.println("\n--- Entered Details ---");
        System.out.println("Integer: " + x);
        System.out.println("Decimal: " + y);
        System.out.println("Boolean: " + bool);
        System.out.println("Character: " + ch);
        System.out.println("String: " + str);

        sc.close(); // Good practice to close Scanner resource
    }
}