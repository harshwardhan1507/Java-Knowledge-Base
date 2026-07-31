package javakb.projects.intermediate.studentmanagement;

import java.util.ArrayList;

/*
*
### Student.java

Represents a student.

Fields:

- ID
- Name
- Age
- CGPA

Responsibilities:

- Store student data
- Constructors
- Getters & Setters
- `toString()`
*/
public class Student {
    private String name;
    private final String id;
    private int age;
    private double gpa;

    public Student(String id, int age, double gpa, String name) {
        this.id = id;
        this.age = age;
        this.gpa = gpa;
        this.name = name;
    }

    public String getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0)
            this.age = age;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0 && gpa <= 10)
            this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }




    @Override
    public String toString() {
        return String.format("""
            +---------------------------+
            |      Student Details      |
            +---------------------------+
            | ID   : %-17s |
            | Name : %-17s |
            | Age  : %-17d |
            | GPA  : %-17.2f |
            +---------------------------+
            """, id, name, age, gpa);
    }
}