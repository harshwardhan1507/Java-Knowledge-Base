package javakb.ch01_basics;

public class VariablesAndDataTypes {
    public static void main(String[] args) {
        // Primitive Data types
        int num = 3;
        float numerical = 3.3f;
        double numerical2 = 3.1456937363;
        long numerical3 = 1234567890L; // L suffix for long literal
        boolean bool = true;          // true or false only
        char c = 'A';
        String str = "Hello World";

        System.out.println("int: " + num);
        System.out.println("float: " + numerical);
        System.out.println("double: " + numerical2);
        System.out.println("long: " + numerical3);
        System.out.println("char: " + c);
        System.out.println("boolean: " + bool);
        System.out.println("String: " + str);

        // Variables mutation
        int x = 3;
        System.out.println("x is " + x);
        x = 5;
        System.out.println("x updated is " + x); // value changed

        // Constants using final
        final double PI = 3.14159; // use final to make it constant
        System.out.println("Constant PI: " + PI);
        // PI = 4.12; // Will throw compile-time error as final variables cannot be re-assigned
    }
}