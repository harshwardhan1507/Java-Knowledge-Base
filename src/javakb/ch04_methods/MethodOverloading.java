package javakb.ch04_methods;

/**
 * MethodOverloading demonstrates static (compile-time) polymorphism in Java.
 * 
 * Rules for Method Overloading:
 * 1. Methods MUST have the SAME name.
 * 2. Methods MUST have DIFFERENT parameter lists (number of params, data types, or parameter order).
 * 3. Return type alone CANNOT be used to distinguish overloaded methods.
 * 4. Access modifiers can vary, but parameter lists must differ.
 */
public class MethodOverloading {

    // Overload 1: Two integer parameters
    public static int add(int a, int b) {
        System.out.print("add(int, int) -> ");
        return a + b;
    }

    // Overload 2: Three integer parameters (differ by parameter count)
    public static int add(int a, int b, int c) {
        System.out.print("add(int, int, int) -> ");
        return a + b + c;
    }

    // Overload 3: Two double parameters (differ by parameter type)
    public static double add(double a, double b) {
        System.out.print("add(double, double) -> ");
        return a + b;
    }

    // Overload 4: Mixed parameter types (order: String, int)
    public static void display(String tag, int value) {
        System.out.println("display(String, int): " + tag + " = " + value);
    }

    // Overload 5: Mixed parameter types (order: int, String - differ by parameter order)
    public static void display(int value, String tag) {
        System.out.println("display(int, String): " + value + " (" + tag + ")");
    }

    /* 
     * INVALID OVERLOAD EXAMPLE (Will not compile if uncommented):
     * The compiler resolves methods based on parameter list, not return type!
     * 
     * public static double add(int a, int b) {
     *     return (double)(a + b);
     * }
     */

    public static void main(String[] args) {
        System.out.println("--- 1. Overloading by Parameter Count ---");
        System.out.println(add(10, 20));
        System.out.println(add(10, 20, 30));

        System.out.println("\n--- 2. Overloading by Parameter Data Type ---");
        System.out.println(add(2.5, 4.5));

        System.out.println("\n--- 3. Overloading by Parameter Order ---");
        display("Score", 95);
        display(95, "Score");

        System.out.println("\n--- 4. Automatic Type Promotion ---");
        // add(int, double) doesn't exist, but add(double, double) accepts int -> double promotion!
        System.out.print("add(5, 4.2) resolves to ");
        System.out.println(add(5, 4.2));
    }
}