package javakb.projects.intermediate.studentmanagement;

import java.util.Scanner;

public class Main {

    public static void display() {
        System.out.println("\n========== Student Management System ==========");
        System.out.println("1. Add Student");
        System.out.println("2. Display Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Sort by Name");
        System.out.println("7. Sort by GPA");
        System.out.println("8. Reverse Students");
        System.out.println("9. Total Students");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
    }

    public static Student userInput(Scanner scanner) {
        System.out.print("Enter Student ID : ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Age : ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Student GPA : ");
        double gpa = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Student Name : ");
        String name = scanner.nextLine();

        return new Student(id, age, gpa, name);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;
        String id;
        double gpa;
        String name;
        int age;

        do {

            display();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {

                case 1:
                    // Read student details
                    // Create Student object
                    // manager.addStudent(...)

                    Student student = userInput(scanner);
                    manager.addStudent(student);
                    System.out.println("Student Added Successfully");
                    break;

                case 2:
                    manager.displayStudents();

                    break;

                case 3:
                    // Read ID
                    // manager.searchStudentById(...)
                    // Print result
                    System.out.print("Enter Student ID : ");
                    id = scanner.nextLine();
                    student = manager.searchStudentById(id);

                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }

                case 4:
                    // Read ID
                    // Read updated details
                    // manager.updateStudent(...)
                    System.out.print("Enter Student Id : ");
                    id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter Student GPA : ");
                    gpa = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Student Age : ");
                    age = scanner.nextInt();
                    scanner.nextLine();
                    manager.updateStudent(id, name, age, gpa);
                    System.out.println("Student Updated Successfully");
                    break;

                case 5:
                    // Read ID
                    // manager.deleteStudent(...)
                    System.out.print("Enter Student Id : ");
                    id = scanner.nextLine();
                    manager.deleteStudent(id);
                    System.out.println("Student Deleted Successfully");
                    break;

                case 6:
                    manager.sortByName();
                    System.out.println("Students sorted by name successfully.");
                    break;

                case 7:
                    manager.sortByGpa();
                    System.out.println("Students sorted by gpa successfully.");
                    break;

                case 8:
                    manager.reverseStudents();
                    System.out.println("Students reversed successfully.");
                    break;

                case 9:
                    // Print total students
                    int size = manager.totalStudents();
                    System.out.print("Size of Student List : " + size);
                    break;

                case 10:
                    System.out.println("Exiting Student Management System...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 10);

        scanner.close();
    }
}