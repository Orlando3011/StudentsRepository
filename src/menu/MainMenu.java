package src.menu;

import src.controller.GradeController;
import src.controller.StudentController;

import java.util.Scanner;

public class MainMenu {
    StudentController studentController;
    GradeController gradeController;

    public void Menu() {
        studentController = new StudentController();
        gradeController = new GradeController(studentController);
    }

    public MainMenu() {
        studentController = new StudentController();
        gradeController = new GradeController(studentController);
    }

    public void init() {
        boolean exit = false;
        while(!exit) {
            System.out.println("Student repository");
            System.out.println("1: students");
            System.out.println("2: grades");
            System.out.println("3: exit");

            Scanner scanner = new Scanner(System.in);
            String nextLine = scanner.nextLine();

            switch (nextLine) {
                case "1":
                    StudentsMenu studentsMenu = new StudentsMenu(studentController, gradeController);
                    studentsMenu.init();
                    break;
                case "2":
                    GradesMenu gradesMenu = new GradesMenu(studentController, gradeController);
                    gradesMenu.init();
                    break;
                case "3":
                    exit = true;
                    break;
                default:
                    System.out.println("Please type valid menu option");
                    break;
            }

        }
    }
}
