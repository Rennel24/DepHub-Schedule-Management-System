package model;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time {
    private LocalTime start;
    private LocalTime end;
    private static final DateTimeFormatter formatter12 = DateTimeFormatter.ofPattern("h:mm a");

    public Time(String start, String end) {
        this.start = LocalTime.parse(convertTo24Hour(start));
        this.end = LocalTime.parse(convertTo24Hour(end));
    }

    
    private String convertTo24Hour(String time12h) {
        DateTimeFormatter formatterInput = DateTimeFormatter.ofPattern("h:mm a");
        DateTimeFormatter formatter24 = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(time12h, formatterInput).format(formatter24);
    }

    // Checks if this time overlaps with another time
    public boolean overlapsWith(Time other) {
        return this.start.isBefore(other.end) && other.start.isBefore(this.end);
    }

    // Getters
    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    // Display time in standard 12-hour format
    public void displayTime() {
        System.out.println(start.format(formatter12) + " - " + end.format(formatter12));
    }

    // Optional: Return as string
    @Override
    public String toString() {
        return start.format(formatter12) + " - " + end.format(formatter12);
    }
}
