package src.controller;

import src.model.Grade;
import src.model.Student;
import src.service.GradeService;

import java.util.ArrayList;
import java.util.List;

public class GradeController {
    private final List<Grade> grades;
    private StudentController studentController;
    private final GradeService gradeService;

    public GradeController(StudentController studentController) {
        this.studentController = studentController;
        grades = new ArrayList<>();
        gradeService = new GradeService(studentController, this);
    }

    public void addGrade(Grade grade) {
        if(gradeService.checkStudentIdForGrade(grade)) grades.add(grade);
    }

    public void removeGrade(int gradeId) {
        grades.remove(gradeId);
    }

    public void updateGrade(int gradeId, Grade grade) {
        if(gradeService.checkStudentIdForGrade(grade)) {
            grades.remove(gradeId);
            grades.add(gradeId, grade);
        }
    }

    public void viewGrades() {
        System.out.println("List of grades:");
        for (Grade grade: grades) {
            System.out.println("Grade id = " + grades.indexOf(grade));
            System.out.println("Grade for student id = " + grade.getStudentId());
            System.out.println("Grade = " + grade.getGrade());
            System.out.println("------------");
        }
    }

    public void viewGradesOfStudent(int studentId) {
        System.out.println("Grades for student " + studentController.getStudentById(studentId).getName());
        System.out.println(gradeService.getGradesOfStudent(studentId).toString());
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public double getGradesForStudent(Student student) {
        return gradeService.calculateMeanForStudent(student);
    }
}
