package polymorphicclasses;

import java.util.ArrayList;
import java.util.List;

import model.Schedule;
import abstractclasses.*;
public class Student extends Person {

    private String password;
    private List<Schedule> enrolledSchedules;

    // --- Constructors ---
    public Student(String id, String name, String college) {
        super(id, name, college);
        this.password = "stud123";
        this.enrolledSchedules = new ArrayList<>();
    }

    public Student() {
        super("24-00424","Juan Dela Cruz", "CICS");
        this.password = "stud123";
        this.enrolledSchedules = new ArrayList<>();
    }

    // --- Authentication ---
    public boolean authenticate(String id, String password) {
        return getId().equals(id) && this.password.equals(password);
    }

    // --- Role Description (Polymorphism) ---
    @Override
    public void roleDescription() {
        System.out.println("Student " + getName() + 
            " can view all available schedules, enroll in them, and view enrolled schedules.");
    }

    // --- View all schedules (from Admin list) ---

    public void viewAllSchedules(CICSAdmin admin) {
        ArrayList<Schedule> allSchedules = admin.getSchedules();

        if (allSchedules == null || allSchedules.isEmpty()) {
            System.out.println("No schedules are currently available.");
        } else {
            System.out.println("\nAll Available Schedules:");
            for (Schedule s : allSchedules) {
                s.displayScheduleInfo();
                System.out.println("------------------------------------");
            }
        }
    }


    // --- View student's enrolled schedules ---
    public void viewEnrolledSchedules() {
        if (enrolledSchedules.isEmpty()) {
            System.out.println(" You have not enrolled in any schedules yet.");
        } else {
            System.out.println("\n Enrolled Schedules:");
            for (Schedule s : enrolledSchedules) {
                s.displayScheduleInfo();
                System.out.println("------------------------------------");
            }
        }
    }

    // --- Enroll in a schedule ---
    public void enrollSchedule(Schedule schedule) {
            for (Schedule s : enrolledSchedules) {
                if (s.getDay().equalsIgnoreCase(schedule.getDay()) && s.getTime().overlapsWith(schedule.getTime())) {
                    System.out.println("Time conflict! You already have a class on " + schedule.getDay() + " at " + s.getTime());
                    return;
                }
            }

            if (enrolledSchedules.contains(schedule)) {
                System.out.println("You are already enrolled in this schedule.");
            } else {
                enrolledSchedules.add(schedule);
                System.out.println("Successfully enrolled in schedule: " + schedule.getSchedID());
            }
        }


            public String getPassword() {
                return this.password;
            }

            public void setPassword(String password) {
                this.password = password;
            }


}
