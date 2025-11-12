package exceptions;
public class ScheduleConflictException extends Exception {
    public ScheduleConflictException() {
        super("Schedule conflict detected!");
    }

    public ScheduleConflictException(String message) {
        super(message);
    }
}
