package src.controller;

import src.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private final List<Student> students;

    public StudentController() {
        students = new ArrayList<>();
    }

    public int getStudentId(Student student) {
        return students.indexOf(student);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int studentId) {
        students.remove(studentId);
    }

    public void updateStudent(int studentId, Student student) {
        students.remove(studentId);
        students.add(studentId, student);
    }

    public Student getStudentById(int id) {
        return students.get(id);
    }

    public void viewStudents() {
        System.out.println("List of students:");
        for (Student student:students) {
            System.out.println("Student id = " + students.indexOf(student));
            System.out.println("Student name = " + student.getName());
            System.out.println("------------");
        }
    }

    public List<Student> getStudents() {
        return students;
    }
}
