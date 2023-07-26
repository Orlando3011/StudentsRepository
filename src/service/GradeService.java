package src.service;

import src.controller.GradeController;
import src.controller.StudentController;
import src.model.Grade;
import src.model.Student;

import java.util.ArrayList;
import java.util.List;

public class GradeService {
    StudentController studentController;
    GradeController gradeController;

    public GradeService(StudentController studentController, GradeController gradeController) {
        this.studentController = studentController;
        this.gradeController = gradeController;
    }

    public boolean checkStudentIdForGrade(Grade grade) {
        if(studentController.getStudents().size() <= grade.getStudentId()) {
            System.out.println("There is no student with id = " + grade.getStudentId());
            System.out.println("Try to add grade for the correct student id");
            return false;
        }
        else return true;
    }

    public double calculateMeanForStudent(Student student) {
        double mean = 0;
        int gradeCount = 0;
        for (Grade grade: gradeController.getGrades()) {
            if(grade.getStudentId() == studentController.getStudentId(student)) {
                mean += grade.getGrade();
                gradeCount++;
            }
        }
        mean = mean / gradeCount;
        return mean;
    }

    public List<Grade> getGradesOfStudent(int studentId) {
        List<Grade> grades = new ArrayList<>();
        for (Grade grade:gradeController.getGrades()) {
            if(grade.getStudentId() == studentId) grades.add(grade);
        }
        return grades;
    }
}
