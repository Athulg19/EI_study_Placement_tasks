package Excercise_02.Astronaut_Scheduler.src;

// AstronautScheduleApp.java
import java.util.List;
import java.util.Scanner;

/**
 * Main application class for the Astronaut Daily Schedule Organizer.
 */
public class AstronautScheduleApp {
    private static Scanner scanner = new Scanner(System.in);
    private static ScheduleManager scheduleManager = ScheduleManager.getInstance();

    public static void main(String[] args) {
        scheduleManager.addObserver(new ConsoleNotifier());
        boolean exit = false;
        while (!exit) {
            printMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    removeTask();
                    break;
                case "3":
                    viewTasks();
                    break;
                case "4":
                    markTaskCompleted();
                    break;
                case "5":
                    viewTasksByPriority();
                    break;
                case "6":
                    editTask();
                    break;
                case "7":
                    exit = true;
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    /**
     * Prints the main menu options.
     */
    private static void printMenu() {
        System.out.println("\nAstronaut Daily Schedule Organizer");
        System.out.println("1. Add a new task");
        System.out.println("2. Remove an existing task");
        System.out.println("3. View all tasks");
        System.out.println("4. Mark task as completed");
        System.out.println("5. View tasks by priority");
        System.out.println("6. Edit an existing task");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Handles adding a new task.
     */
    private static void addTask() {
        try {
            System.out.print("Enter task description: ");
            String description = scanner.nextLine();
            System.out.print("Enter start time (HH:mm): ");
            String startTime = scanner.nextLine();
            System.out.print("Enter end time (HH:mm): ");
            String endTime = scanner.nextLine();
            System.out.print("Enter priority level (High, Medium, Low): ");
            String priority = scanner.nextLine();
            Task task = TaskFactory.createTask(description, startTime, endTime, priority);
            scheduleManager.addTask(task);
            System.out.println("Task added successfully. No conflicts.");
        } catch (InvalidTimeException | InvalidPriorityException | TaskConflictException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Handles removing an existing task.
     */
    private static void removeTask() {
        try {
            System.out.print("Enter task description to remove: ");
            String description = scanner.nextLine();
            scheduleManager.removeTask(description);
            System.out.println("Task removed successfully.");
        } catch (TaskNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Displays all scheduled tasks.
     */
    private static void viewTasks() {
        List<Task> tasks = scheduleManager.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            System.out.println("Scheduled Tasks:");
            for (Task task : tasks) {
                System.out.println(task.toString());
            }
        }
    }

    /**
     * Handles marking a task as completed.
     */
    private static void markTaskCompleted() {
        try {
            System.out.print("Enter task description to mark as completed: ");
            String description = scanner.nextLine();
            scheduleManager.markTaskCompleted(description);
            System.out.println("Task marked as completed.");
        } catch (TaskNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Displays tasks filtered by a specific priority level.
     */
    private static void viewTasksByPriority() {
        System.out.print("Enter priority level to view (High, Medium, Low): ");
        String priorityStr = scanner.nextLine();
        try {
            PriorityLevel priority = PriorityLevel.valueOf(priorityStr.toUpperCase());
            List<Task> tasks = scheduleManager.getTasksByPriority(priority);
            if (tasks.isEmpty()) {
                System.out.println("No tasks with priority " + priorityStr + ".");
            } else {
                System.out.println("Tasks with priority " + priorityStr + ":");
                for (Task task : tasks) {
                    System.out.println(task.toString());
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid priority level.");
        }
    }

    /**
     * Handles editing an existing task.
     */
    private static void editTask() {
        try {
            System.out.print("Enter description of task to edit: ");
            String oldDescription = scanner.nextLine();
            System.out.print("Enter new task description: ");
            String description = scanner.nextLine();
            System.out.print("Enter new start time (HH:mm): ");
            String startTime = scanner.nextLine();
            System.out.print("Enter new end time (HH:mm): ");
            String endTime = scanner.nextLine();
            System.out.print("Enter new priority level (High, Medium, Low): ");
            String priority = scanner.nextLine();
            Task newTask = TaskFactory.createTask(description, startTime, endTime, priority);
            scheduleManager.editTask(oldDescription, newTask);
            System.out.println("Task edited successfully.");
        } catch (InvalidTimeException | InvalidPriorityException | TaskNotFoundException | TaskConflictException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
