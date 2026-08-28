package javakb.ch07_oop;

/**
 * Demonstrates Java's parameter passing mechanism: Java is strictly PASS-BY-VALUE.
 *
 * Key Concepts:
 * 1. Pass-by-Value (Primitives): When passing primitive types (int, double, boolean),
 *    an independent copy of the raw value is passed to the method. Changes inside the
 *    method NEVER affect the caller's variable.
 * 2. Pass-by-Value (Object References): When passing an object reference, a copy of the
 *    MEMORY ADDRESS (the reference) is passed by value.
 *    - Mutating object state (e.g., obj.field = newValue): Affects the object on the Heap
 *      because both the caller and the method parameter hold references pointing to the same memory.
 *    - Reassigning the parameter reference (e.g., obj = new Object()): Only reassigns the local
 *      parameter copy on the Stack. The caller's original reference variable remains completely unaffected!
 */

class Wallet {
    String owner;
    double balance;

    Wallet(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    void display() {
        System.out.printf("   [Wallet] Owner: %-12s | Balance: $%.2f%n", owner, balance);
    }
}

public class PassByValueDemo {

    // 1. Primitive Pass-by-Value
    public static void tryToModifyPrimitive(int num) {
        System.out.println("   [Inside Method] Initial parameter 'num': " + num);
        num = num + 50; // Modifies only local stack copy
        System.out.println("   [Inside Method] Modified parameter 'num': " + num);
    }

    // 2. Object Reference Pass-by-Value: Mutating State
    public static void addCash(Wallet wallet, double amount) {
        System.out.println("   [Inside Method] Adding $" + amount + " to wallet...");
        wallet.balance += amount; // Modifies the actual Heap object via copied reference
        System.out.printf("   [Inside Method] Updated wallet balance to: $%.2f%n", wallet.balance);
    }

    // 3. Object Reference Pass-by-Value: Attempting Reference Reassignment
    public static void tryToSwapWallets(Wallet w1, Wallet w2) {
        System.out.println("   [Inside Method] Attempting to swap references w1 and w2...");
        Wallet temp = w1;
        w1 = w2; // Reassigns only the local stack parameter w1
        w2 = temp; // Reassigns only the local stack parameter w2
        System.out.println("   [Inside Method] Swapped locally inside method!");
        System.out.print("   [Inside Method] w1 is now: ");
        w1.display();
        System.out.print("   [Inside Method] w2 is now: ");
        w2.display();
    }

    // 4. Object Reference Pass-by-Value: Attempting to replace caller's object
    public static void tryToReplaceWallet(Wallet wallet) {
        System.out.println("   [Inside Method] Creating a brand new Wallet instance...");
        wallet = new Wallet("Brand New Owner", 9999.0); // Reassigns local parameter copy
        System.out.print("   [Inside Method] Local parameter now points to: ");
        wallet.display();
    }

    public static void main(String[] args) {
        System.out.println("=== Chapter 7: Pass-by-Value Proof in Java ===\n");

        // -------------------------------------------------------------
        // Case 1: Primitive Parameter Passing
        // -------------------------------------------------------------
        System.out.println("--- Case 1: Passing Primitive Types (int) ---");
        int originalNumber = 100;
        System.out.println("Original number in main BEFORE call: " + originalNumber);

        tryToModifyPrimitive(originalNumber);

        System.out.println("Original number in main AFTER call : " + originalNumber + " (UNCHANGED!)\n");

        // -------------------------------------------------------------
        // Case 2: Object Reference Passing - Mutating Internal State
        // -------------------------------------------------------------
        System.out.println("--- Case 2: Passing Object Reference & Mutating State ---");
        Wallet myWallet = new Wallet("Harsh", 150.0);
        System.out.print("Wallet in main BEFORE call: ");
        myWallet.display();

        addCash(myWallet, 75.0);

        System.out.print("Wallet in main AFTER call : ");
        myWallet.display();
        System.out.println("-> Result: State CHANGED because the copied reference pointed to the same Heap object.\n");

        // -------------------------------------------------------------
        // Case 3: Object Reference Passing - Attempting Reference Reassignment
        // -------------------------------------------------------------
        System.out.println("--- Case 3: Attempting to Swap Object References in Method ---");
        Wallet walletA = new Wallet("Alice", 200.0);
        Wallet walletB = new Wallet("Bob", 500.0);

        System.out.println("BEFORE swap call:");
        System.out.print("walletA: ");
        walletA.display();
        System.out.print("walletB: ");
        walletB.display();

        tryToSwapWallets(walletA, walletB);

        System.out.println("\nAFTER swap call in main:");
        System.out.print("walletA: ");
        walletA.display();
        System.out.print("walletB: ");
        walletB.display();
        System.out.println("-> Result: References were NOT swapped in caller! Java passed the references by value.\n");

        // -------------------------------------------------------------
        // Case 4: Attempting to Reassign Object Reference
        // -------------------------------------------------------------
        System.out.println("--- Case 4: Attempting to Reassign Reference to New Object ---");
        Wallet targetWallet = new Wallet("David", 50.0);
        System.out.print("targetWallet BEFORE call: ");
        targetWallet.display();

        tryToReplaceWallet(targetWallet);

        System.out.print("targetWallet AFTER call : ");
        targetWallet.display();
        System.out.println("-> Result: targetWallet still points to David ($50.0). Reassignment inside method only affected the local parameter copy.");
    }
}
