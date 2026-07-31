package javakb.projects.intermediate.studentmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentManager {

    private final ArrayList<Student> students = new ArrayList<>();

    /**
     * Adds a new student to the list.
     *
     * @param student Student object to add.
     */
    public void addStudent(Student student) {
        if (searchStudentById(student.getId()) != null) {
            System.out.println("Student ID already exists.");
            return;
        }
        else {
            students.add(student);
        }

    }

    /**
     * Displays all students.
     */
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        else {
        for (Student student : students) {
            System.out.println(student);
        }}
    }

    /**
     * Searches for a student using their ID.
     *
     * @param id Student ID.
     * @return Student object if found, otherwise null.
     */
    public Student searchStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Updates an existing student's details.
     *
     * @param id ID of the student to update.
     */
    public void updateStudent(String id, String name, int age, double gpa){
        Student student = searchStudentById(id);
        if (student != null) {

        student.setAge(age);
            student.setName(name);
            student.setGpa(gpa);
        }
    }

    /**
     * Deletes a student from the list using their ID.
     *
     * @param id Student ID.
     */
    public void deleteStudent(String id) {
        Student student = searchStudentById(id);

        if(student != null){
            students.remove(student);
        }
    }

    /**
     * Sorts students alphabetically by name.
     */
    public void sortByName() {
        students.sort(Comparator.comparing(Student::getName));
    }

    /**
     * Sorts students by GPA.
     */
    public void sortByGpa() {
        students.sort(Comparator.comparingDouble(Student::getGpa));
    }

    /**
     * Reverses the current order of students.
     */
    public void reverseStudents() {
        Collections.reverse(students);
    }

    /**
     * Returns the total number of students.
     *
     * @return Number of students.
     */
    public int totalStudents() {

        return students.size();
    }

    /**
     * Returns the entire student list.
     */
    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }
}