package Excercise_01.Creational_design_pattern.Factory_Pattern;

interface Button {
    void render();
    void onClick();
}

class WindowsButton implements Button {
    public void render() {
        System.out.println("Render a button in a Windows style");
    }

    public void onClick() {
        System.out.println("Handle click for Windows");
    }
}

class MacOSButton implements Button {
    public void render() {
        System.out.println("Render a button in a MacOS style");
    }

    public void onClick() {
        System.out.println("Handle click for MacOS");
    }
}

class ButtonFactory {
    public static Button getButton(String osType){
        if(osType.equalsIgnoreCase("Windows")){
            return new WindowsButton();
        } else if(osType.equalsIgnoreCase("MacOS")){
            return new MacOSButton();
        } else {
            throw new IllegalArgumentException("Unknown OS type");
        }
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        Button winButton = ButtonFactory.getButton("Windows");
        winButton.render();
        winButton.onClick();

        Button macButton = ButtonFactory.getButton("MacOS");
        macButton.render();
        macButton.onClick();
    }
}

