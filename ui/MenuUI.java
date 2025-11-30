package ui;
public class MenuUI {

    public void showLoginMenu() {
        System.out.println("\n========= LOGIN MENU =========");
        System.out.println("1. Admin Login");
        System.out.println("2. Professor Login");
        System.out.println("3. Student Login");
        System.out.println("4. Exit");
    }

    public void showAdminMenu() {
        System.out.println("\n======== CICS ADMIN MENU =========");
        System.out.println("1. Show Role Description");
        System.out.println("2. Add Schedule");
        System.out.println("3. View Schedules (Generate Report)");
        System.out.println("4. Update Schedule");
        System.out.println("5. Delete Schedule");
        System.out.println("6. Assign Schedule");
        System.out.println("7. Print All Schedules to File");
        System.out.println("8. Logout");
        System.out.print("Enter your choice: ");
    }

    public void showProfessorMenu() {
        System.out.println("\n========= PROFESSOR MENU =======");
        System.out.println("1. Show Role Description");
        System.out.println("2. View Assigned Schedules");
        System.out.println("3. Print My Schedules to File");
        System.out.println("4. Logout");
        System.out.print("Enter your choice: ");
    }

    public void showStudentMenu() {
        System.out.println("\n========= STUDENT MENU =========");
        System.out.println("1. Show Role Description");
        System.out.println("2. View All Available Schedules");
        System.out.println("3. View Enrolled Schedules");
        System.out.println("4. Enroll in a Schedule");
        System.out.println("5. Logout");
        System.out.print("Enter your choice: ");
    }

}
