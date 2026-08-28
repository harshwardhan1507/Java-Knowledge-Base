package javakb.ch07_oop;

/**
 * Demonstrates the mechanics of Constructors in Java.
 *
 * Key Concepts:
 * 1. Constructor: A special method with the same name as the class and NO return type,
 *    invoked automatically when an object is created with 'new'.
 * 2. Default Constructor: The no-argument constructor automatically provided by the Java
 *    compiler ONLY IF no other constructors are defined in the class.
 * 3. Parameterized Constructor: Initializes object fields with custom values upon creation.
 * 4. Constructor Overloading: Multiple constructors with different parameter lists.
 * 5. Constructor Chaining (this(...)): Invoking another constructor in the same class to
 *    reuse initialization logic and prevent code duplication. (Must be the FIRST statement!).
 * 6. Copy Constructor: Initializes a new object using data copied from an existing instance.
 */

class AccountProfile {
    String username;
    String email;
    String membershipTier;
    int loyaltyPoints;

    // 1. Explicit No-Argument Constructor (Calls 4-parameter constructor via chaining)
    AccountProfile() {
        this("Guest_User", "guest@example.com", "BRONZE", 0);
        System.out.println("   [Constructor] Explicit No-Arg constructor invoked.");
    }

    // 2. Parameterized Constructor (2 Parameters - Chains to 4-parameter constructor)
    AccountProfile(String username, String email) {
        this(username, email, "STANDARD", 100);
        System.out.println("   [Constructor] 2-Param constructor invoked.");
    }

    // 3. Fully-Parameterized Constructor (Master Constructor)
    AccountProfile(String username, String email, String membershipTier, int loyaltyPoints) {
        this.username = username;
        this.email = email;
        this.membershipTier = membershipTier;
        this.loyaltyPoints = loyaltyPoints;
        System.out.println("   [Constructor] Full 4-Param master constructor executed.");
    }

    // 4. Copy Constructor (Creates a new independent instance by copying another)
    AccountProfile(AccountProfile other) {
        this(other.username, other.email, other.membershipTier, other.loyaltyPoints);
        System.out.println("   [Constructor] Copy constructor created clone of: " + other.username);
    }

    void display() {
        System.out.printf("   User: %-12s | Email: %-20s | Tier: %-8s | Points: %d%n",
                username, email, membershipTier, loyaltyPoints);
    }
}

// Demonstrating compiler-generated default constructor
class SimpleBox {
    int length;
    int width;
    int height;

    // No constructor defined here!
    // The Java compiler automatically generates:
    // public SimpleBox() { super(); }
}

public class ConstructorsDemo {

    public static void main(String[] args) {
        System.out.println("=== Chapter 7: Constructors & Constructor Chaining Demo ===\n");

        // -------------------------------------------------------------
        // 1. Compiler-Provided Default Constructor
        // -------------------------------------------------------------
        System.out.println("--- 1. Compiler Default Constructor ---");
        SimpleBox box = new SimpleBox();
        System.out.println("Default values assigned by JVM: length=" + box.length + ", width=" + box.width + ", height=" + box.height);

        // -------------------------------------------------------------
        // 2. Constructor Overloading & Constructor Chaining (this(...))
        // -------------------------------------------------------------
        System.out.println("\n--- 2. No-Arg Constructor (with Chaining) ---");
        AccountProfile guest = new AccountProfile();
        guest.display();

        System.out.println("\n--- 3. 2-Parameter Constructor (with Chaining) ---");
        AccountProfile standardUser = new AccountProfile("harsh_w", "harsh@example.com");
        standardUser.display();

        System.out.println("\n--- 4. Master 4-Parameter Constructor ---");
        AccountProfile vipUser = new AccountProfile("sarah_connor", "sarah@resistance.org", "PLATINUM", 5000);
        vipUser.display();

        // -------------------------------------------------------------
        // 5. Copy Constructor
        // -------------------------------------------------------------
        System.out.println("\n--- 5. Copy Constructor Pattern ---");
        AccountProfile clonedUser = new AccountProfile(vipUser);
        clonedUser.username = "sarah_backup"; // Modifying clone
        clonedUser.display();

        System.out.println("\nVerifying original user remains intact:");
        vipUser.display();
    }
}
