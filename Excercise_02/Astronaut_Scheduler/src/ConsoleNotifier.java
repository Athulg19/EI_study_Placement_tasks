package Excercise_02.Astronaut_Scheduler.src;

// ConsoleNotifier.java
/**
 * Concrete observer that notifies users via console.
 */
public class ConsoleNotifier implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Notification: " + message);
    }
}
