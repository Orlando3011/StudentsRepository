package src.menu;

import src.controller.GradeController;
import src.controller.StudentController;
import src.exception.IdExceptionHandler;
import src.model.Student;

import java.util.Scanner;

public class StudentsMenu {
    StudentController studentController;
    GradeController gradeController;

    public StudentsMenu(StudentController studentController, GradeController gradeController) {
        this.studentController = studentController;
        this.gradeController = gradeController;
    }

    public void init() {
        boolean exit = false;
        while(!exit) {
            System.out.println("Students");
            System.out.println("1: add");
            System.out.println("2: remove");
            System.out.println("3: edit");
            System.out.println("4: view");
            System.out.println("5: main menu");


            Scanner scanner = new Scanner(System.in);
            String nextLine = scanner.nextLine();

            switch (nextLine) {
                case "1":
                    System.out.println("Type student name:");
                    String studentName = scanner.nextLine();
                    studentController.addStudent(new Student(studentName));
                    break;
                case "2":
                    try {
                        System.out.println("Type student id to remove:");
                        int studentId = Integer.parseInt(scanner.nextLine());
                        studentController.removeStudent(studentId);
                        break;
                    }
                    catch (Exception e) {
                        IdExceptionHandler.handleIdException();
                        break;
                    }
                case "3":
                    try {
                        System.out.println("Type student name, press enter and type id of a student you want to edit:");
                        String studentNameToEdit = scanner.nextLine();
                        int studentIdToEdit = Integer.parseInt(scanner.nextLine());
                        studentController.updateStudent(studentIdToEdit, new Student(studentNameToEdit));
                        break;
                    }
                    catch (Exception e) {
                        IdExceptionHandler.handleIdException();
                        break;
                    }
                case "4":
                    studentController.viewStudents();
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    System.out.println("Please type valid menu option");
                    break;
            }
        }
    }
}
