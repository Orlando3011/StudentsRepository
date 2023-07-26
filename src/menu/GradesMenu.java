package src.menu;

import src.controller.GradeController;
import src.controller.StudentController;
import src.exception.IdExceptionHandler;
import src.model.Grade;

import java.util.Scanner;

public class GradesMenu {
    StudentController studentController;
    GradeController gradeController;

    public GradesMenu(StudentController studentController, GradeController gradeController) {
        this.studentController = studentController;
        this.gradeController = gradeController;
    }

    public void init() {
        boolean exit = false;
        while(!exit) {
            System.out.println("Grades");
            System.out.println("1: add");
            System.out.println("2: remove");
            System.out.println("3: edit");
            System.out.println("4: view");
            System.out.println("5: view grades of student");
            System.out.println("6: mean of grades");
            System.out.println("7: main menu");


            Scanner scanner = new Scanner(System.in);
            String nextLine = scanner.nextLine();

            switch (nextLine) {
                case "1":
                    try {
                        System.out.println("Type grade, press enter and type id of student for this grade:");
                        int gradeToAdd = Integer.parseInt(scanner.nextLine());
                        int studentId = Integer.parseInt(scanner.nextLine());
                        gradeController.addGrade(new Grade(gradeToAdd, studentId));
                        break;
                    }
                    catch (Exception e) {
                        IdExceptionHandler.handleIdException();
                        break;
                    }
                case "2":
                    try {
                        System.out.println("Type grade id to remove:");
                        int gradeId = Integer.parseInt(scanner.nextLine());
                        gradeController.removeGrade(gradeId);
                        break;
                    }
                    catch (Exception e) {
                        IdExceptionHandler.handleIdException();
                        break;
                    }
                case "3":
                    try {
                        System.out.println("Type new grade, enter, id of student you want to assign it, enter and id of grade you want to replace");
                        int editedGrade = Integer.parseInt(scanner.nextLine());
                        int editedGradeStudent = Integer.parseInt(scanner.nextLine());
                        int gradeToEdit = Integer.parseInt(scanner.nextLine());
                        gradeController.updateGrade(gradeToEdit, new Grade(editedGrade, editedGradeStudent));
                        break;
                    }
                    catch (Exception e) {
                        IdExceptionHandler.handleIdException();
                        break;
                    }
                case "4":
                    gradeController.viewGrades();
                    break;
                case "5":
                    try {
                        System.out.println("Type student id to view grades");
                        int studentIdForGrades = Integer.parseInt(scanner.nextLine());
                        gradeController.viewGradesOfStudent(studentIdForGrades);
                        break;
                    }
                    catch (Exception e) {
                        IdExceptionHandler.handleIdException();
                        break;
                    }
                case "6":
                    try {
                        System.out.println("Type student id to calculate mean:");
                        int studentIdForMean = Integer.parseInt(scanner.nextLine());
                        double mean = gradeController.getGradesForStudent(studentController.getStudents().get(studentIdForMean));
                        System.out.println("Mean of student " + studentController.getStudents().get(studentIdForMean).getName() + " is " + mean);
                        break;
                    }
                    catch (Exception e) {
                        IdExceptionHandler.handleIdException();
                        break;
                    }
                case "7":
                    exit = true;
                    break;
                default:
                    System.out.println("Please type valid menu option");
                    break;
            }
        }
    }
}
