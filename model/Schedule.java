package model;
import polymorphicclasses.*;

public class Schedule {

    private String schedID;
    private Program program;
    private String section;
    private Professor professor;
    private String day;
    private Time time;
    private Room room;
    

  public Schedule(String schedID, Program program, String section, Professor prof, String day,
    Time time, Room room){

        this.schedID = schedID;
        this.program = program;
        this.section = section;
        this.professor = prof;
        this.day = day;
        this.time = time;
        this.room = room;
  }

  // Checks if this schedule conflicts with another schedule
            public boolean conflictsWith(Schedule other) {
                // Same room?
                boolean sameRoom = this.room.getRoomName().equalsIgnoreCase(other.getRoom().getRoomName());

                // Same professor?
                boolean sameProf = this.professor.getId().equalsIgnoreCase(other.getProfessor().getId());

                // Overlapping time?
                boolean overlap = this.time.overlapsWith(other.getTime());

                boolean sameDay = this.day.equalsIgnoreCase(other.getDay());

                // Conflict exists if either same room or same professor AND times overlap
                return sameDay && (sameRoom || sameProf) && overlap;
        }


      public String getSchedID() {
        return schedID;
    }

    public Program getProgram() {
        return program;
    }

    public String getSection() {
        return section;
    }

    public Professor getProfessor() {
        return professor;
    }

    public String getDay() {
        return day;
    }

    public Time getTime() {
        return time;
    }

    public Room getRoom() {
        return room;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setDay(String day) {
    this.day = day;
}


    public void displayScheduleInfo() {
        System.out.println("Schedule ID: " + schedID);
        System.out.println("Program: " +  (program != null ? program.getProgramName() : "N/A"));
        System.out.println("Section: " + section);
        System.out.println("Professor: " + professor.getName());
        System.out.println("Day: " + day);
        System.out.println("Time: " + time.toString());
        System.out.println("Room: " + room.getRoomName() + " (Capacity: " + room.getCapacity() + ")");
        System.out.println("--------------------------------------------------------------------");
    }





}
