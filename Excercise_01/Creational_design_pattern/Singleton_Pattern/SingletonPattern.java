package Excercise_01.Creational_design_pattern.Singleton_Pattern;

class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        Singleton singleInstance = Singleton.getInstance();
        singleInstance.showMessage();
    }
}

