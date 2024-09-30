package Excercise_02.Astronaut_Scheduler.src;

// Task.java
import java.time.LocalTime;

/**
 * Represents a task in the astronaut's schedule.
 */
public class Task {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private PriorityLevel priority;
    private boolean completed;

    public Task(String description, LocalTime startTime, LocalTime endTime, PriorityLevel priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.completed = false;
    }

    // Getters and Setters
    public String getDescription() { return description; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public PriorityLevel getPriority() { return priority; }
    public boolean isCompleted() { return completed; }

    public void setDescription(String description) { this.description = description; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
    public void setPriority(PriorityLevel priority) { this.priority = priority; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    @Override
    public String toString() {
        return String.format("%s - %s: %s [%s]%s",
                startTime.toString(), endTime.toString(), description, priority,
                completed ? " (Completed)" : "");
    }
}

