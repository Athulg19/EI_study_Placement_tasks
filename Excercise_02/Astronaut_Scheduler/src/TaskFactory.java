package Excercise_02.Astronaut_Scheduler.src;

// TaskFactory.java
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Factory class to create Task objects.
 */
public class TaskFactory {
    public static Task createTask(String description, String startTimeStr, String endTimeStr, String priorityStr)
            throws InvalidTimeException, InvalidPriorityException {
        LocalTime startTime = parseTime(startTimeStr);
        LocalTime endTime = parseTime(endTimeStr);
        if (endTime.isBefore(startTime)) {
            throw new InvalidTimeException("End time cannot be before start time.");
        }
        PriorityLevel priority = parsePriority(priorityStr);
        return new Task(description, startTime, endTime, priority);
    }

    private static LocalTime parseTime(String timeStr) throws InvalidTimeException {
        try {
            return LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (DateTimeParseException e) {
            throw new InvalidTimeException("Invalid time format. Please use HH:mm.");
        }
    }

    private static PriorityLevel parsePriority(String priorityStr) throws InvalidPriorityException {
        try {
            return PriorityLevel.valueOf(priorityStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidPriorityException("Invalid priority level. Please use High, Medium, or Low.");
        }
    }
}
