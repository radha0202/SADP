
interface Command {
    void execute();
    void undo();
}


class Light {
    public void on() {
        System.out.println("Light is ON");
    }
    public void off() {
        System.out.println("Light is OFF");
    }
}


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

public class CommandPatternTest {
    public static void main(String[] args) {
        
        Light livingRoomLight = new Light();

        
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        
        RemoteControl remote = new RemoteControl();

        
        remote.setCommand(lightOn);
        remote.pressButton();   
        remote.pressUndo();    

        
        remote.setCommand(lightOff);
        remote.pressButton();   
        remote.pressUndo();     
    }
}

