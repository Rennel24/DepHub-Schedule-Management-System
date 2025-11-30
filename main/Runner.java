package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.Program;
import model.Room;
import model.Schedule;
import model.Time;
import polymorphicclasses.CICSAdmin;
import polymorphicclasses.Professor;
import polymorphicclasses.Student;
import ui.MenuUI;
import exceptions.ScheduleConflictException;

public class Runner {
    private CICSAdmin admin;
    private Professor professor;
    private Student student;
    private MenuUI menuUi;
    private Scanner scanner; // Scanner as a class field

    public Runner() {
        this.admin = new CICSAdmin();                 // default ID: A001, password: admin123
        this.professor = new Professor();            // default ID: P001, password: prof123
        this.student = new Student();
        this.menuUi = new MenuUI();
        this.scanner = new Scanner(System.in);

        loadDefaultSchedules();
    }

    private void loadDefaultSchedules() {
        try {

            // Phy 101 - Calculus-Based Physics
            Program prog4 = new Program("Calculus-Based Physics (3 units)");
            Professor prof4 = new Professor("P104", "GOMEZ, RICARDO T.", "IT-2101 / ALANGILAN");
            Time time4a = new Time("07:00 AM", "10:00 AM");
            Room room4a = new Room("402", 40);
            Schedule sched4a = new Schedule("S104a", prog4, "IT-2101", prof4, "Monday", time4a, room4a);
            admin.addSchedule("1", prog4, "IT-2101", prof4, "Monday", time4a, room4a);
            prof4.addSchedule(sched4a);

            // CS 121 - Advanced Computer Programming
            Program prog5 = new Program("Advanced Computer Programming (3 units)");
            Professor prof5 = new Professor("P105", "RAMOS, JENNIFER K.", "IT-2101 / ALANGILAN");
            Time time5a = new Time("03:00 PM", "05:00 PM");
            Room room5a = new Room("104", 40);
            Schedule sched5a = new Schedule("S105a", prog5, "IT-2101", prof5, "Tuesday", time5a, room5a);
            admin.addSchedule("2", prog5, "IT-2101", prof5, "Tuesday", time5a, room5a);
            prof5.addSchedule(sched5a);

        } catch (Exception e) {
            System.out.println(" Error loading default schedules: " + e.getMessage());
        }
    }

    public void run() {
        int choice = -1;
        do {
            menuUi.showLoginMenu();
            try {
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline

                switch (choice) {
                    case 1:
                        System.out.println();
                        adminLogin();
                        break;
                    case 2:
                        System.out.println();
                        professorLogin();
                        break;
                    case 3:
                        System.out.println();
                        studentLogin();
                        break;
                    case 4:
                        System.out.println("Exiting system...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 3.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // clear the invalid input
            }
        } while (choice != 4);

        scanner.close();
    }

    // --- Authentication ---
    private void adminLogin() {
        try {
            System.out.print("Enter Admin ID: "); //A001
            String id = scanner.nextLine();
            System.out.print("Enter Password: ");  //admin123
            String password = scanner.nextLine();

            if (admin.authenticateAdmin(id, password)) {
                System.out.println("Admin login successful!");
                runAdminMenu();
            } else {
                System.out.println("Invalid Admin credentials!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during login: " + e.getMessage());
        }
    }

    private void professorLogin() {
        System.out.print("Enter Professor ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (professor.authenticate(id, password)) {
            System.out.println("Professor login successful!");
            runProfessorMenu();
        } else {
            System.out.println("Invalid Professor credentials!");
        }
    }

    private void studentLogin() {
        System.out.print("Enter SR-CODE: ");
        String id = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (student.authenticate(id, password)) {
            System.out.println("Student login successful!");
            runStudentMenu();

        } else {
            System.out.println("Invalid Student credentials!");
        }
    }

    // --- Menus ---
    private void runAdminMenu() {
        int option;
        do {
            menuUi.showAdminMenu();

            try {
                option = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (option) {
                    case 1:
                        System.out.println();
                        admin.roleDescription();
                        break;
                    case 2:
                        System.out.println();
                        addSchedule();
                        break;
                    case 3:
                        System.out.println();
                        admin.generateReport();
                        break;
                    case 4:
                        System.out.println();
                        updateSchedule();
                        break;
                    case 5:
                        System.out.println();
                        deleteSchedule();
                        break;
                    case 6:
                        System.out.println();
                        assignScheduleToProfessor();
                        break;
                    case 7:
                        System.out.println();
                        admin.printAllSchedulesToFile();
                        break;
                    case 8:
                        System.out.println("\nLogging out...");
                        break;
                    default:
                        System.out.println("\nInvalid choice! Please select 1–8.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 8.");
                scanner.nextLine(); // clear invalid input
                option = -1; // reset loop
            }

        } while (option != 8);
    }

    private void runProfessorMenu() {
        int option;
        do {
            menuUi.showProfessorMenu();

            try {
                option = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (option) {
                    case 1:
                        System.out.println();
                        professor.roleDescription();
                        break;
                    case 2:
                        System.out.println();
                        professor.viewMySchedules();
                        break;
                    case 3:
                        System.out.println();
                        professor.printMySchedulesToFile();
                        break;
                    case 4:
                        System.out.println("\nLogging out...");
                        break;
                    default:
                        System.out.println("\nInvalid choice! Please select 1–4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input! Please enter a number between 1 and 4.");
                scanner.nextLine(); // clear invalid input
                option = -1; // reset loop
            }
        } while (option != 4);
    }

    private void runStudentMenu() {
        int option;
        do {
            menuUi.showStudentMenu();

            try {
                option = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (option) {
                    case 1:
                        student.roleDescription();
                        break;
                    case 2:
                        student.viewAllSchedules(admin);
                        break;
                    case 3:
                        student.viewEnrolledSchedules();
                        break;
                    case 4:
                        enrollScheduleForStudent();
                        break;
                    case 5:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please select 1–5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                scanner.nextLine();
                option = -1;
            }
        } while (option != 5);
    }

    // --- Input Handlers ---
    private void addSchedule() {
        try {
            System.out.print("Enter Schedule ID: ");
            String schedID = scanner.nextLine();

            System.out.print("Enter Program Name: ");
            String progName = scanner.nextLine();
            Program program = new Program(progName);

            System.out.print("Enter Section: ");
            String section = scanner.nextLine();

            System.out.print("Enter Professor Name: ");
            String profName = scanner.nextLine();
            Professor prof = new Professor(profName);

            System.out.print("Enter Day: ");
            String day = scanner.nextLine();

            System.out.print("Enter Start Time: ");
            String start = scanner.nextLine();

            System.out.print("Enter End Time: ");
            String end = scanner.nextLine();
            Time time = new Time(start, end);

            System.out.print("Enter Room Name: ");
            String roomName = scanner.nextLine();
            System.out.print("Enter Room Capacity: ");
            int capacity = scanner.nextInt();
            scanner.nextLine(); // consume newline
            Room room = new Room(roomName, capacity);

            admin.addSchedule(schedID, program, section, prof, day, time, room);
            System.out.println("\nSchedule added successfully: " + schedID);

        } catch (java.util.InputMismatchException ime) {
            System.out.println("Invalid input! Please enter a valid number for room capacity.");
            scanner.nextLine(); // clear invalid input
        } catch (ScheduleConflictException sce) {
            System.out.println("" + sce.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private void updateSchedule() {
        try {
            System.out.print("Enter Schedule ID to update: ");
            String schedID = scanner.nextLine();

            System.out.print("Enter new day: ");
            String newDay = scanner.nextLine();

            System.out.print("Enter new start time (e.g. 8:00 AM): ");
            String newStart = scanner.nextLine();

            System.out.print("Enter new end time (e.g. 10:00 AM): ");
            String newEnd = scanner.nextLine();
            Time newTime = new Time(newStart, newEnd);

            System.out.print("Enter new room name: ");
            String roomName = scanner.nextLine();

            System.out.print("Enter new room capacity: ");
            int capacity = scanner.nextInt();
            scanner.nextLine(); // consume newline
            Room newRoom = new Room(roomName, capacity);

            admin.updateSchedule(schedID, newDay, newTime, newRoom);

        } catch (java.util.InputMismatchException ime) {
            System.out.println("Invalid input! Please enter a valid number for room capacity.");
            scanner.nextLine(); // clear invalid input
        } catch (ScheduleConflictException sce) {
            System.out.println(sce.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private void deleteSchedule() {
        try {
            System.out.print("Enter Schedule ID to delete: ");
            String id = scanner.nextLine();

            Schedule scheduleToDelete = admin.findScheduleById(id);
            if (scheduleToDelete == null) {
                System.out.println("Schedule not found: " + id);
                return;
            }

            System.out.println("\nSchedule details to be deleted:");
            scheduleToDelete.displayScheduleInfo();

            System.out.print("Are you sure you want to delete this schedule? (Y/N): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                admin.deleteSchedule(id);
            } else {
                System.out.println("Deletion cancelled.");
            }

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private void assignScheduleToProfessor() {
        System.out.print("Enter Schedule ID to assign: ");
        String schedId = scanner.nextLine();

        Schedule scheduleToAssign = admin.findScheduleById(schedId);
        if (scheduleToAssign == null) {
            System.out.println("Schedule not found!");
            return;
        }

        professor.addSchedule(scheduleToAssign);
        System.out.println("Schedule " + schedId + " successfully assigned to Professor " + professor.getName());
    }

    private void enrollScheduleForStudent() {
        try {
            System.out.print("Enter Schedule ID to enroll: ");
            String schedId = scanner.nextLine();

            Schedule sched = admin.findScheduleById(schedId);
            if (sched != null) {
                student.enrollSchedule(sched);
            } else {
                System.out.println("⚠️ Schedule not found!");
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred while enrolling: " + e.getMessage());
        }
    }
}
