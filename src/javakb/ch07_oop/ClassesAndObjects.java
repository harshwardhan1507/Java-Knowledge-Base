package javakb.ch07_oop;

/**
 * Demonstrates the core concepts of Classes and Objects in Java.
 *
 * Key Concepts:
 * 1. Class: A blueprint or template defining state (fields) and behavior (methods).
 * 2. Object: A concrete instance of a class occupying memory on the heap.
 * 3. State: Instance variables holding data unique to each object.
 * 4. Behavior: Methods performing actions or modifying the object's state.
 * 5. Multiple Instances: Each object maintains its own independent state.
 */

// Class Definition: Car (Blueprint)
class Car {
    // State / Instance Variables (Fields)
    String brand;
    String model;
    int year;
    double speed;
    boolean isEngineRunning;

    // Constructor to initialize an object's state
    Car(String carBrand, String carModel, int carYear, double initialSpeed) {
        brand = carBrand;
        model = carModel;
        year = carYear;
        speed = initialSpeed;
        isEngineRunning = false;
    }

    // Behavior / Instance Methods
    void startEngine() {
        if (!isEngineRunning) {
            isEngineRunning = true;
            System.out.println("-> " + brand + " " + model + ": Engine started with a roar!");
        } else {
            System.out.println("-> " + brand + " " + model + ": Engine is already running.");
        }
    }

    void stopEngine() {
        if (isEngineRunning) {
            if (speed > 0) {
                System.out.println("-> Cannot stop engine while moving! Apply brakes first.");
            } else {
                isEngineRunning = false;
                System.out.println("-> " + brand + " " + model + ": Engine shut down.");
            }
        } else {
            System.out.println("-> " + brand + " " + model + ": Engine is already off.");
        }
    }

    void accelerate(double amount) {
        if (!isEngineRunning) {
            System.out.println("-> Cannot accelerate! Start the engine first.");
            return;
        }
        speed += amount;
        System.out.printf("-> %s %s accelerated by %.1f km/h. Current speed: %.1f km/h%n",
                brand, model, amount, speed);
    }

    void applyBrake(double amount) {
        speed = Math.max(0, speed - amount);
        System.out.printf("-> %s %s slowed down by %.1f km/h. Current speed: %.1f km/h%n",
                brand, model, amount, speed);
    }

    void displayStatus() {
        System.out.println("====================================");
        System.out.println("  Car: " + year + " " + brand + " " + model);
        System.out.println("  Engine Running : " + (isEngineRunning ? "YES" : "NO"));
        System.out.printf("  Current Speed  : %.1f km/h%n", speed);
        System.out.println("====================================");
    }
}

// Class Definition: Student (Demonstrating state manipulation and calculations)
class Student {
    String name;
    int rollNumber;
    double gpa;

    Student(String studentName, int studentRoll, double studentGpa) {
        name = studentName;
        rollNumber = studentRoll;
        gpa = studentGpa;
    }

    void updateGpa(double newGpa) {
        if (newGpa >= 0.0 && newGpa <= 4.0) {
            double oldGpa = gpa;
            gpa = newGpa;
            System.out.printf("-> %s's GPA updated from %.2f to %.2f%n", name, oldGpa, gpa);
        } else {
            System.out.println("-> Invalid GPA value: " + newGpa + " (must be between 0.0 and 4.0)");
        }
    }

    String getAcademicStanding() {
        if (gpa >= 3.8) return "Summa Cum Laude / Dean's List";
        if (gpa >= 3.5) return "Magna Cum Laude";
        if (gpa >= 3.0) return "Good Standing";
        if (gpa >= 2.0) return "Satisfactory";
        return "Academic Probation";
    }

    void printProfile() {
        System.out.printf("[%d] %-15s | GPA: %.2f | Standing: %s%n",
                rollNumber, name, gpa, getAcademicStanding());
    }
}

public class ClassesAndObjects {

    public static void main(String[] args) {
        System.out.println("=== Chapter 7: Classes and Objects Demo ===\n");

        // -------------------------------------------------------------
        // 1. Instantiating Objects from the 'Car' Class
        // -------------------------------------------------------------
        System.out.println("--- 1. Creating and Interacting with Car Objects ---");

        // 'car1' and 'car2' are reference variables on the stack.
        // The 'new' keyword allocates distinct memory on the heap.
        Car car1 = new Car("Ford", "Mustang GT", 2024, 0.0);
        Car car2 = new Car("BMW", "M4 Competition", 2025, 0.0);

        System.out.println("Initial State of car1:");
        car1.displayStatus();

        System.out.println("\nOperating car1:");
        car1.accelerate(30); // Fails because engine is off
        car1.startEngine();
        car1.accelerate(60.0);
        car1.accelerate(45.5);
        car1.applyBrake(20.0);
        car1.displayStatus();

        System.out.println("\nOperating car2 independently:");
        car2.startEngine();
        car2.accelerate(120.0);
        car2.displayStatus();

        // Notice that modifying car2 had NO effect on car1 (independent state)
        System.out.println("Notice: car1 speed remains " + car1.speed + " km/h while car2 speed is " + car2.speed + " km/h.\n");

        // -------------------------------------------------------------
        // 2. Instantiating and Managing Student Objects
        // -------------------------------------------------------------
        System.out.println("--- 2. Creating and Managing Student Objects ---");

        Student s1 = new Student("Alice Johnson", 101, 3.92);
        Student s2 = new Student("Bob Smith", 102, 3.15);
        Student s3 = new Student("Charlie Brown", 103, 1.85);

        System.out.println("Student Profiles:");
        s1.printProfile();
        s2.printProfile();
        s3.printProfile();

        System.out.println("\nUpdating Student GPAs:");
        s3.updateGpa(2.65);
        s3.printProfile();

        s2.updateGpa(5.0); // Invalid test
    }
}
