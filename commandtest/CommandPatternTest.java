// Command Interface
interface Command {
    void execute();
    void undo();
}

// Receiver - Light
class Light {
    public void on() {
        System.out.println("Light is ON");
    }
    public void off() {
        System.out.println("Light is OFF");
    }
}

// Concrete Command - LightOnCommand
class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.on();
    }
    public void undo() {
        light.off();
    }
}

// Concrete Command - LightOffCommand
class LightOffCommand implements Command {
    private Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.off();
    }
    public void undo() {
        light.on();
    }
}

// Invoker - RemoteControl
class RemoteControl {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressButton() {
        command.execute();
    }
    public void pressUndo() {
        command.undo();
    }
}

// Client - Test
public class CommandPatternTest {
    public static void main(String[] args) {
        // Receiver
        Light livingRoomLight = new Light();

        // Commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Invoker
        RemoteControl remote = new RemoteControl();

        // Turn ON Light
        remote.setCommand(lightOn);
        remote.pressButton();   // Light is ON
        remote.pressUndo();     // Light is OFF

        // Turn OFF Light
        remote.setCommand(lightOff);
        remote.pressButton();   // Light is OFF
        remote.pressUndo();     // Light is ON
    }
}

