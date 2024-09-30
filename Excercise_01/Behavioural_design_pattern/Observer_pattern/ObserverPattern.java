import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String event);
}

class EventManager {
    List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notify(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}

class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String event) {
        System.out.println("Hey " + name + ", there is a new event: " + event);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        eventManager.subscribe(user1);
        eventManager.subscribe(user2);

        eventManager.notify("Summer Sale starts tomorrow!");
    }
}
