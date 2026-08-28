package javakb.ch07_oop;

/**
 * Demonstrates the differences between Static and Instance members in Java,
 * including Static vs Instance variables, methods, initializer blocks,
 * and the exact order of initialization.
 *
 * Key Concepts:
 * 1. Instance Variables: Belong to a specific object. Stored on the Heap.
 *    Each object gets its own independent copy.
 * 2. Static Variables: Belong to the Class itself. Stored in Metaspace (Class Area).
 *    Single shared copy across all instances.
 * 3. Instance Methods: Require an object to be invoked. Have access to 'this'
 *    and can access both instance and static members.
 * 4. Static Methods: Invoked directly on the Class name (e.g., Math.sqrt).
 *    Do NOT have access to 'this' or instance fields directly.
 * 5. Static Blocks (static { }): Execute ONCE when the class is loaded by the JVM.
 * 6. Instance Blocks ({ }): Execute every time an object is instantiated, BEFORE the constructor.
 * 7. Initialization Order: Static Block -> Instance Block -> Constructor.
 */

class Employee {
    // 1. Static Constant (Shared across all instances, cannot be changed)
    public static final String COMPANY_NAME = "NovaTech Solutions";
    public static final double MIN_WAGE = 15.00;

    // 2. Static Variable (Shared counter tracking total employees hired)
    private static int totalEmployeesHired = 0;

    // 3. Instance Variables (Unique to each individual Employee object)
    private int employeeId;
    private String name;
    private double hourlyRate;

    // 4. Static Initialization Block (Runs ONCE when class is loaded)
    static {
        System.out.println("   [1. Static Block] Employee class loaded into JVM Metaspace.");
        System.out.println("   [1. Static Block] Company: " + COMPANY_NAME);
    }

    // 5. Instance Initialization Block (Runs every time an object is created, BEFORE constructor)
    {
        totalEmployeesHired++;
        this.employeeId = 1000 + totalEmployeesHired;
        System.out.println("   [2. Instance Block] Auto-generated Employee ID: " + this.employeeId);
    }

    // 6. Constructor (Runs after Instance Initializer Block)
    public Employee(String name, double hourlyRate) {
        this.name = name;
        this.hourlyRate = Math.max(hourlyRate, MIN_WAGE);
        System.out.println("   [3. Constructor] Employee '" + this.name + "' initialized.");
    }

    // 7. Instance Method: Accesses both instance fields and static fields
    public void printEmployeeDetails() {
        System.out.printf("   [Employee #%d] %-15s | Rate: $%.2f/hr | Company: %s%n",
                this.employeeId, this.name, this.hourlyRate, COMPANY_NAME);
    }

    // 8. Static Method: Operates on class-level data without requiring an object instance
    public static int getTotalEmployeesHired() {
        // NOTE: 'this.name' is illegal here because static methods have no instance context!
        return totalEmployeesHired;
    }

    // Static Utility Method
    public static double calculateAnnualSalary(double hourlyRate, int hoursPerWeek) {
        return hourlyRate * hoursPerWeek * 52;
    }
}

public class StaticVsInstanceDemo {

    public static void main(String[] args) {
        System.out.println("=== Chapter 7: Static vs Instance Members Demo ===\n");

        // -------------------------------------------------------------
        // 1. Accessing Static Members Without Any Object Creation
        // -------------------------------------------------------------
        System.out.println("--- 1. Accessing Static Constant & Static Method (No object instantiated yet) ---");
        System.out.println("Company: " + Employee.COMPANY_NAME);
        System.out.println("Initial Total Employees: " + Employee.getTotalEmployeesHired());

        double estSalary = Employee.calculateAnnualSalary(35.50, 40);
        System.out.printf("Estimated Annual Salary for $35.50/hr (40 hrs/wk): $%,.2f%n", estSalary);

        // -------------------------------------------------------------
        // 2. Observing Initialization Order During Object Creation
        // -------------------------------------------------------------
        System.out.println("\n--- 2. Instantiating Employee 1 (Watch execution order) ---");
        Employee emp1 = new Employee("Alice Zhang", 45.00);

        System.out.println("\n--- 3. Instantiating Employee 2 ---");
        Employee emp2 = new Employee("Bob Martinez", 32.50);

        System.out.println("\n--- 4. Instantiating Employee 3 ---");
        Employee emp3 = new Employee("Charlie Kim", 12.00); // Below min wage, adjusted to MIN_WAGE

        // -------------------------------------------------------------
        // 3. Independent Instance State vs Shared Static State
        // -------------------------------------------------------------
        System.out.println("\n--- 5. Verifying Instance Details (Independent State) ---");
        emp1.printEmployeeDetails();
        emp2.printEmployeeDetails();
        emp3.printEmployeeDetails();

        System.out.println("\n--- 6. Verifying Shared Static Counter ---");
        System.out.println("Total Employees Hired (accessed via Employee.getTotalEmployeesHired()): "
                + Employee.getTotalEmployeesHired());
    }
}
