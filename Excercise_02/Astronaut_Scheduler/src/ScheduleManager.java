package Excercise_02.Astronaut_Scheduler.src;

// ScheduleManager.java
import java.util.*;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.time.LocalTime;

/**
 * Singleton class that manages the schedule of tasks.
 */
public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private List<Observer> observers;
    private static final Logger logger = Logger.getLogger(ScheduleManager.class.getName());

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
        try {
            FileHandler fh = new FileHandler("application.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (Exception e) {
            System.err.println("Failed to initialize logger handler.");
        }
    }

    /**
     * Returns the single instance of ScheduleManager.
     */
    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    /**
     * Adds an observer to the list.
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Adds a task to the schedule after checking for conflicts.
     */
    public void addTask(Task task) throws TaskConflictException {
        for (Task existingTask : tasks) {
            if (taskOverlap(task, existingTask)) {
                String message = "Task conflicts with existing task \"" + existingTask.getDescription() + "\".";
                notifyObservers(message);
                logger.warning("Attempted to add conflicting task: " + task.getDescription());
                throw new TaskConflictException(message);
            }
        }
        tasks.add(task);
        tasks.sort(Comparator.comparing(Task::getStartTime));
        logger.info("Task added: " + task.getDescription());
    }

    /**
     * Removes a task based on its description.
     */
    public void removeTask(String description) throws TaskNotFoundException {
        Task taskToRemove = null;
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                taskToRemove = task;
                break;
            }
        }
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            logger.info("Task removed: " + description);
        } else {
            String message = "Task not found: " + description;
            logger.warning(message);
            throw new TaskNotFoundException("Task not found.");
        }
    }

    /**
     * Edits an existing task.
     */
    public void editTask(String oldDescription, Task newTask) throws TaskNotFoundException, TaskConflictException {
        removeTask(oldDescription);
        try {
            addTask(newTask);
            logger.info("Task edited: " + oldDescription + " to " + newTask.getDescription());
        } catch (TaskConflictException e) {
            // Revert to old task if new task conflicts
            Task oldTask = new Task(oldDescription, newTask.getStartTime(), newTask.getEndTime(), newTask.getPriority());
            tasks.add(oldTask);
            tasks.sort(Comparator.comparing(Task::getStartTime));
            throw e;
        }
    }

    /**
     * Marks a task as completed.
     */
    public void markTaskCompleted(String description) throws TaskNotFoundException {
        Task taskToMark = null;
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                taskToMark = task;
                break;
            }
        }
        if (taskToMark != null) {
            taskToMark.setCompleted(true);
            logger.info("Task marked as completed: " + description);
        } else {
            String message = "Task not found: " + description;
            logger.warning(message);
            throw new TaskNotFoundException("Task not found.");
        }
    }

    /**
     * Returns all tasks.
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Returns tasks filtered by priority.
     */
    public List<Task> getTasksByPriority(PriorityLevel priority) {
        List<Task> priorityTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority() == priority) {
                priorityTasks.add(task);
            }
        }
        return priorityTasks;
    }

    /**
     * Checks if two tasks overlap.
     */
    private boolean taskOverlap(Task task1, Task task2) {
        return task1.getStartTime().isBefore(task2.getEndTime()) && task2.getStartTime().isBefore(task1.getEndTime());
    }

    /**
     * Notifies all observers with a message.
     */
    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
