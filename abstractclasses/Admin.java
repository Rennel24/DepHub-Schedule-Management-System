package abstractclasses;
import java.util.ArrayList;
import model.Program;
import model.Room;
import model.Schedule;
import exceptions.ScheduleConflictException;
import model.Time;
import polymorphicclasses.Professor;


public abstract class Admin extends Person {
    protected ArrayList<Schedule> schedules;

    public Admin(String id, String name, String college) {
        super(id, name, college);
        this.schedules = new ArrayList<>();
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    // Abstract method to define admin responsibilities
    public abstract void manageSchedules();

    //  Add a new schedule
           public void addSchedule(String schedID, Program program, String section, Professor prof,
                        String day, Time time, Room room) throws ScheduleConflictException {

    // Create a new schedule object
    Schedule newSchedule = new Schedule(schedID, program, section, prof, day, time, room);

    // Check for existing schedule ID and conflicts
    for (Schedule s : schedules) {
        if (s.getSchedID().equalsIgnoreCase(schedID)) {
            throw new ScheduleConflictException("Schedule ID already exists: " + schedID);
        }

        boolean timeOverlap = s.getDay().equalsIgnoreCase(day) && s.getTime().overlapsWith(time);
        boolean professorConflict = s.getProfessor().equals(prof) && timeOverlap;
        boolean roomConflict = s.getRoom().equals(room) && timeOverlap;

        if (professorConflict) {
            throw new ScheduleConflictException(
                "Professor " + prof.getName() + " already has a schedule at this time (conflict with Schedule" + s.getSchedID() + ")"
            );
        }

        if (roomConflict) {
            throw new ScheduleConflictException(
                "Room " + room.getRoomName() + " is already booked at this time (conflict with " + s.getSchedID() + ")"
            );
        }
    }

    // Add the schedule if no conflicts
    schedules.add(newSchedule);
    prof.addSchedule(newSchedule); // Link schedule to professor
}



    //  View all schedules
    public void viewSchedules() {
        System.out.println("\nALL SCHEDULES managed by " + getName() + ":\n");
        if (schedules.isEmpty()) {
            System.out.println("No schedules available.");
        } else {
            for (Schedule s : schedules) {
                s.displayScheduleInfo();
            }
        }
    }

    //  Delete a schedule
    public void deleteSchedule(String schedID) {
        boolean found = false;
        for (int i = 0; i < schedules.size(); i++) {
            if (schedules.get(i).getSchedID().equalsIgnoreCase(schedID)) {
                Schedule s = schedules.remove(i);
                s.getProfessor().removeSchedule(s); // Remove from professor's schedule
                found = true;
                System.out.println("Schedule " + schedID + " deleted successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Schedule not found: " + schedID);
        }
    }

    // Update a schedule’s time or room
    public void updateSchedule(String schedID, String newDay, Time newTime, Room newRoom) throws ScheduleConflictException {
        for (Schedule s : schedules) {
            if (s.getSchedID().equalsIgnoreCase(schedID)) {

                boolean sameDetails =
                        s.getDay().equalsIgnoreCase(newDay) &&
                        s.getTime().getStart().equals(newTime.getStart()) &&
                        s.getTime().getEnd().equals(newTime.getEnd()) &&
                        s.getRoom().getRoomName().equalsIgnoreCase(newRoom.getRoomName()) &&
                        s.getRoom().getCapacity() == newRoom.getCapacity();

                if (sameDetails) {
                    throw new ScheduleConflictException("No update needed — schedule already has these details.");
                }

                // Check for conflicts
                for (Schedule other : schedules) {
                    if (!other.equals(s) && other.getDay().equalsIgnoreCase(newDay)) {
                        if (other.getRoom().getRoomName().equalsIgnoreCase(newRoom.getRoomName())
                                && other.getTime().overlapsWith(newTime)) {
                            throw new ScheduleConflictException(
                                    "Room " + newRoom.getRoomName() + " is already booked at this time (conflict with " + other.getSchedID() + ")");
                        }

                        if (other.getProfessor().equals(s.getProfessor())
                                && other.getTime().overlapsWith(newTime)) {
                            throw new ScheduleConflictException(
                                    "Professor " + s.getProfessor().getName() + " already has a schedule at this time (conflict with " + other.getSchedID() + ")");
                        }
                    }
                }

                // No conflicts → update
                s.setDay(newDay);
                s.setTime(newTime);
                s.setRoom(newRoom);
                System.out.println("Schedule " + schedID + " updated successfully.");
                return;
            }
        }
        throw new ScheduleConflictException("Schedule not found: " + schedID);
    }
}
