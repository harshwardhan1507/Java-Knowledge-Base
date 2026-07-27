package javakb.ch06_strings;

/**
 * StringFormatting demonstrates modern Java string formatting features:
 * 1. Printf format specifiers (%s, %d, %f, %b, %c, alignment, precision).
 * 2. String.format() vs System.out.printf().
 * 3. Modern .formatted(...) instance method (Java 15+).
 * 4. Escape sequences (\n, \t, \", \\).
 * 5. Java Text Blocks (""" ... """) multi-line literals for SQL, JSON, and HTML.
 */
public class StringFormatting {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" 1. FORMAT SPECIFIERS & STRING.FORMAT()");
        System.out.println("==================================================");

        String name = "Alice";
        int age = 25;
        double gpa = 3.8765;
        boolean isStudent = true;

        // String.format returns a formatted String
        String formattedInfo = String.format("Student: %s | Age: %d | GPA: %.2f | Active: %b", name, age, gpa, isStudent);
        System.out.println(formattedInfo);

        // Column Alignment Specifiers (%-15s for left-aligned, %10d for right-aligned)
        System.out.println("\n--- Aligned Table Output ---");
        System.out.printf("%-15s | %-10s | %-10s%n", "Name", "Role", "Salary ($)");
        System.out.println("----------------------------------------");
        System.out.printf("%-15s | %-10s | %-10.2f%n", "Alex Johnson", "Developer", 85000.50);
        System.out.printf("%-15s | %-10s | %-10.2f%n", "Maria Garcia", "Architect", 115000.00);
        System.out.printf("%-15s | %-10s | %-10.2f%n", "Sam Wilson", "Manager", 95500.75);

        System.out.println("\n==================================================");
        System.out.println(" 2. MODERN .formatted(...) METHOD (Java 15+)");
        System.out.println("==================================================");

        // Instance method .formatted() called directly on format string template
        String template = "Item: %s, Quantity: %d, Unit Price: $%.2f, Total: $%.2f";
        String invoiceRow = template.formatted("Laptop", 2, 999.99, 2 * 999.99);
        System.out.println(invoiceRow);

        System.out.println("\n==================================================");
        System.out.println(" 3. COMMON ESCAPE SEQUENCES");
        System.out.println("==================================================");

        System.out.println("Newline (\\n):\nLine One\nLine Two");
        System.out.println("Tab (\\t):\tCol1\tCol2\tCol3");
        System.out.println("Double Quote (\\\"): \"Java Knowledge Base\"");
        System.out.println("Backslash (\\\\): C:\\Users\\Harsh\\Documents");

        System.out.println("\n==================================================");
        System.out.println(" 4. JAVA TEXT BLOCKS (\"\"\" ... \"\"\")");
        System.out.println("==================================================");

        // Text Block: Multi-line string without tedious \n or + concatenation
        String jsonPayload = """
                {
                    "user": "harshwardhan",
                    "role": "admin",
                    "permissions": ["READ", "WRITE", "EXECUTE"],
                    "active": true
                }
                """;
        System.out.println("--- Multi-line JSON Text Block ---");
        System.out.println(jsonPayload);

        String sqlQuery = """
                SELECT id, username, email, created_at
                FROM users
                WHERE active = true AND role = '%s'
                ORDER BY created_at DESC;
                """.formatted("ADMIN");

        System.out.println("--- Multi-line Formatted SQL Text Block ---");
        System.out.println(sqlQuery);
    }
}
