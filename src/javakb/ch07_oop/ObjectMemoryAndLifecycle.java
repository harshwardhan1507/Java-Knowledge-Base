package javakb.ch07_oop;

/**
 * Demonstrates the Java Memory Model for Objects, Reference Variables,
 * Object Aliasing, Null References, and the Object Lifecycle.
 *
 * Key Concepts:
 * 1. Stack Memory: Stores primitive variables and reference variables (pointers).
 * 2. Heap Memory: Stores the actual object instances (data and fields).
 * 3. Reference Assignment (Aliasing): Assigning one reference to another copies the
 *    memory address, NOT the object itself. Both point to the exact same heap memory.
 * 4. Null References: A reference pointing to no memory location (null).
 * 5. Garbage Collection Eligibility: Objects with zero active references become
 *    eligible for heap memory reclamation by the Java Virtual Machine (JVM).
 */

class Device {
    String deviceName;
    int batteryLevel;

    Device(String deviceName, int batteryLevel) {
        this.deviceName = deviceName;
        this.batteryLevel = batteryLevel;
    }

    void useDevice(int consumption) {
        this.batteryLevel = Math.max(0, this.batteryLevel - consumption);
        System.out.printf("-> Used %s. Battery remaining: %d%%%n", deviceName, batteryLevel);
    }
}

public class ObjectMemoryAndLifecycle {

    public static void main(String[] args) {
        System.out.println("=== Chapter 7: Object Memory Model & Lifecycle Demo ===\n");

        // -------------------------------------------------------------
        // 1. Stack vs Heap & Reference Variables
        // -------------------------------------------------------------
        System.out.println("--- 1. Stack Reference vs Heap Object ---");

        // 'phone1' is stored on the STACK and holds the memory address (reference)
        // to the Device object created in the HEAP.
        Device phone1 = new Device("iPhone 15 Pro", 100);

        System.out.println("phone1 reference created.");
        System.out.println("Object HashCode / Memory Identity: " + System.identityHashCode(phone1));
        System.out.println("Device: " + phone1.deviceName + " | Battery: " + phone1.batteryLevel + "%");

        // -------------------------------------------------------------
        // 2. Object Aliasing (Multiple References to the Same Heap Object)
        // -------------------------------------------------------------
        System.out.println("\n--- 2. Object Aliasing (phone2 = phone1) ---");

        // Assigning phone1 to phone2 copies the REFERENCE (address), NOT the object!
        Device phone2 = phone1;

        System.out.println("phone2 is now assigned to phone1.");
        System.out.println("phone1 Identity HashCode: " + System.identityHashCode(phone1));
        System.out.println("phone2 Identity HashCode: " + System.identityHashCode(phone2));
        System.out.println("Do phone1 and phone2 point to the same object? " + (phone1 == phone2));

        // Mutating through phone2:
        System.out.println("\nAction: Draining battery using phone2...");
        phone2.useDevice(35);

        // Checking state through phone1:
        System.out.println("Checking battery via phone1: " + phone1.batteryLevel + "% (Changed because both share the same heap object!)");

        // -------------------------------------------------------------
        // 3. Creating a Distinct Object vs Aliasing
        // -------------------------------------------------------------
        System.out.println("\n--- 3. Distinct Objects with Identical Values ---");

        Device phone3 = new Device("iPhone 15 Pro", 65);

        System.out.println("phone3 created with 'new' keyword.");
        System.out.println("phone1 Identity HashCode: " + System.identityHashCode(phone1));
        System.out.println("phone3 Identity HashCode: " + System.identityHashCode(phone3));
        System.out.println("phone1 == phone3? " + (phone1 == phone3) + " (Different heap addresses!)");

        // -------------------------------------------------------------
        // 4. Null References & NullPointerException Prevention
        // -------------------------------------------------------------
        System.out.println("\n--- 4. Working with null References ---");

        Device unassignedPhone = null;
        System.out.println("unassignedPhone value: " + unassignedPhone);

        // Safe access using null check
        if (unassignedPhone != null) {
            unassignedPhone.useDevice(10);
        } else {
            System.out.println("-> Prevented NullPointerException: unassignedPhone is currently null.");
        }

        // -------------------------------------------------------------
        // 5. Object Lifecycle & Garbage Collection Eligibility
        // -------------------------------------------------------------
        System.out.println("\n--- 5. Object Lifecycle & Unreachable Objects ---");

        Device tempDevice = new Device("Temporary Tablet", 50);
        System.out.println("Created tempDevice on Heap: " + tempDevice.deviceName + " (HashCode: " + System.identityHashCode(tempDevice) + ")");

        // Reassigning reference: The previous "Temporary Tablet" object on the heap
        // now has 0 references pointing to it. It becomes UNREACHABLE.
        System.out.println("Reassigning tempDevice reference to null...");
        tempDevice = null;

        System.out.println("-> The 'Temporary Tablet' object is now orphan/unreachable.");
        System.out.println("-> The Java Virtual Machine's Garbage Collector (GC) will automatically reclaim its memory in the background.");
    }
}
