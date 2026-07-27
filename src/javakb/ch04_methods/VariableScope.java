package javakb.ch04_methods;

/**
 * VariableScope demonstrates variable visibility, lifetime, and scope rules in Java.
 * 
 * Variable Scopes in Java:
 * 1. Class / Static Scope: Declared inside a class with 'static'. Accessible throughout the class.
 * 2. Method / Local Scope: Declared inside a method. Accessible only within that method after declaration.
 * 3. Block Scope: Declared inside a block ({ ... }). Accessible only within that block.
 * 4. Variable Shadowing: A local/block variable with the same name as a class variable masks/shadows the class variable.
 */
public class VariableScope {

    // Class level static variable (Class Scope)
    // Accessible by all static methods in this class
    static int globalValue = 100;

    public static void displayGlobal() {
        System.out.println("Inside displayGlobal(): globalValue = " + globalValue);
    }

    public static void demonstrateLocalScope() {
        // Local variable (Method Scope)
        int localVal = 50;
        System.out.println("Inside demonstrateLocalScope(): localVal = " + localVal);
        System.out.println("Inside demonstrateLocalScope(): globalValue = " + globalValue);
        
        // Note: localVal is destroyed when demonstrateLocalScope() finishes execution.
    }

    public static void main(String[] args) {
        System.out.println("--- 1. Class / Static Scope ---");
        System.out.println("In main(): globalValue = " + globalValue);
        displayGlobal();

        System.out.println("\n--- 2. Local Scope ---");
        demonstrateLocalScope();
        // System.out.println(localVal); // COMPILE ERROR: localVal cannot be resolved outside its method

        System.out.println("\n--- 3. Block Scope ---");
        int outerVar = 10;
        {
            // Block scope starts
            int blockVar = 20;
            System.out.println("Inside block: outerVar = " + outerVar);
            System.out.println("Inside block: blockVar = " + blockVar);
            // Block scope ends
        }
        // System.out.println(blockVar); // COMPILE ERROR: blockVar is out of scope here!
        System.out.println("Outside block: outerVar = " + outerVar);

        System.out.println("\n--- 4. Variable Shadowing ---");
        int globalValue = 999; // Shadowing class-level 'globalValue' within main() method
        System.out.println("Local shadowed globalValue in main(): " + globalValue);
        System.out.println("Accessing Class globalValue explicitly: " + VariableScope.globalValue);
    }
}