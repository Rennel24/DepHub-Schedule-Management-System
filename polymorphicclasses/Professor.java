package polymorphicclasses;
import java.util.ArrayList;

import model.Schedule;

import java.io.FileWriter;
import java.io.IOException;
import abstractclasses.*;

public class Professor extends Person {
    private ArrayList<Schedule> mySchedules; // Schedules assigned to this professor
    private String password; // For login authentication


       public Professor() {
        super("P001", "John Doe", "CICS"); // default ID, name, college
        this.password = "prof123";          // default password
        mySchedules = new ArrayList<>();
    }

    // Constructor
    public Professor(String id, String name, String college) {
        super(id, name, college);
        mySchedules = new ArrayList<>();
        this.password = "prof123"; // Default password for simplicity
    }

     public Professor(String name) {
        super(name);
        mySchedules = new ArrayList<>();
        this.password = "prof123"; // Default password for simplicity
     }



    public boolean authenticate(String id, String password) {
        return getId().equals(id) && this.password.equals(password);
    }


    // Add a schedule to this professor
    public void addSchedule(Schedule schedule) {
        mySchedules.add(schedule);
    }

    // Remove a schedule if needed
    public void removeSchedule(Schedule schedule) {
        mySchedules.remove(schedule);
    }

    // View professor's own schedules
    public void viewMySchedules() {
    System.out.println("\n" + getName() + "'s Schedules:");
    if (mySchedules.isEmpty()) {
        System.out.println("No schedules assigned yet.");
        return;
    }

    for (Schedule s : mySchedules) {
        s.displayScheduleInfo();
        System.out.println("------------------------");
    }
    }

    //  Print professor's schedules to a text file (like saving to Notepad)
    public void printMySchedulesToFile() {
        if (mySchedules.isEmpty()) {
            System.out.println("No schedules to print.");
            return;
        }

        String fileName = "Professor_" + getName().replaceAll(" ", "_") + "_Schedule.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("=== " + getName() + "'s Schedule List ===\n\n");

            for (Schedule s : mySchedules) {
                writer.write("Schedule ID: " + s.getSchedID() + "\n");
                writer.write("Program: " + s.getProgram().getProgramName() + "\n");
                writer.write("Section: " + s.getSection() + "\n");
                writer.write("Day: " + s.getDay() + "\n");
                writer.write("Time: " + s.getTime().getStart() + " - " + s.getTime().getEnd() + "\n");
                writer.write("Room: " + s.getRoom().getRoomName() + "\n");
                writer.write("---------------------------------\n");
            }

            writer.write("\nPrinted by: " + getName() + " (" + getId() + ")\n");
            System.out.println("✅ Schedule successfully saved to file: " + fileName);

        } catch (IOException e) {
            System.out.println("⚠️ Error while saving schedule: " + e.getMessage());
        }
    }

    // Check for schedule conflicts
    public boolean hasConflict(Schedule newSchedule) {
        for (Schedule s : mySchedules) {
            if (s.getDay().equalsIgnoreCase(newSchedule.getDay())
                    && s.getTime().overlapsWith(newSchedule.getTime())) {
                return true;
            }
        }
        return false;
    }

    // Getters and Setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Schedule> getMySchedules() {
        return mySchedules;
    }

    @Override
    public void roleDescription() {
        System.out.println(getName() + " is a professor teaching assigned courses in " + getCollege() + ".");
    }
}
