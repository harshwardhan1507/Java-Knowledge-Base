package javakb.ch04_methods;

/**
 * BasicMethod demonstrates method declaration, definition, and invocation in Java.
 * 
 * Concept: A method is a reusable block of code that performs a specific task.
 * Methods help keep code clean, modular, and DRY (Don't Repeat Yourself).
 * 
 * Syntax:
 * <access_modifier> static <return_type> <method_name>(<parameters>) {
 *     // method body
 * }
 */
public class BasicMethod {

    /**
     * A basic user-defined method that prints a greeting message.
     * The 'static' keyword allows calling this method directly from the static main() method
     * without instantiating an object of BasicMethod.
     */
    public static void greet() {
        System.out.println("Hello! You are inside the greet() method.");
    }

    /**
     * A customized greeting method taking a parameter.
     * 
     * @param name The name of the person to greet
     */
    public static void greetUser(String name) {
        System.out.println("Welcome to Java Methods, " + name + "!");
    }

    public static void main(String[] args) {
        System.out.println("--- 1. Simple Method Call ---");
        // Methods are declared outside main() and called inside main() (or other methods).
        greet();

        System.out.println("\n--- 2. Reusability of Methods ---");
        // Reusability: We can invoke the method multiple times without duplicating logic.
        greet();
        greet();

        System.out.println("\n--- 3. Method with Arguments ---");
        greetUser("Harsh");
        greetUser("Developer");
    }
}