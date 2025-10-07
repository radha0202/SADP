import java.util.Scanner;


interface Command {
    void execute();
    void undo();
}

class CeilingFan {
    private String location;
    private int speed;

    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }

    public void high() {
        speed = HIGH;
        System.out.println(location + " ceiling fan is on HIGH");
    }

    public void medium() {
        speed = MEDIUM;
        System.out.println(location + " ceiling fan is on MEDIUM");
    }

    public void low() {
        speed = LOW;
        System.out.println(location + " ceiling fan is on LOW");
    }

    public void off() {
        speed = OFF;
        System.out.println(location + " ceiling fan is OFF");
    }

    public int getSpeed() {
        return speed;
    }
}


class CeilingFanCommand implements Command {
    private CeilingFan ceilingFan;
    private int prevSpeed;
    private int newSpeed;

    public CeilingFanCommand(CeilingFan ceilingFan, int newSpeed) {
        this.ceilingFan = ceilingFan;
        this.newSpeed = newSpeed;
    }

    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        if (newSpeed == CeilingFan.HIGH) ceilingFan.high();
        else if (newSpeed == CeilingFan.MEDIUM) ceilingFan.medium();
        else if (newSpeed == CeilingFan.LOW) ceilingFan.low();
        else ceilingFan.off();
    }

    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) ceilingFan.high();
        else if (prevSpeed == CeilingFan.MEDIUM) ceilingFan.medium();
        else if (prevSpeed == CeilingFan.LOW) ceilingFan.low();
        else ceilingFan.off();
    }
}


class RemoteControl {
    private Command lastCommand;

    public void setCommand(Command command) {
        command.execute();
        lastCommand = command;
    }

    public void pressUndo() {
        if (lastCommand != null) {
            System.out.println("Undo last command:");
            lastCommand.undo();
        } else {
            System.out.println("No command to undo.");
        }
    }
}


public class CeilingFanTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RemoteControl remote = new RemoteControl();
        CeilingFan livingRoomFan = new CeilingFan("Living Room");

        while (true) {
            System.out.println("\n=== Ceiling Fan Control ===");
            System.out.println("1. Set HIGH");
            System.out.println("2. Set MEDIUM");
            System.out.println("3. Set LOW");
            System.out.println("4. Turn OFF");
            System.out.println("5. Undo Last Command");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            if (choice == 6) {
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {
                case 1:
                    remote.setCommand(new CeilingFanCommand(livingRoomFan, CeilingFan.HIGH));
                    break;
                case 2:
                    remote.setCommand(new CeilingFanCommand(livingRoomFan, CeilingFan.MEDIUM));
                    break;
                case 3:
                    remote.setCommand(new CeilingFanCommand(livingRoomFan, CeilingFan.LOW));
                    break;
                case 4:
                    remote.setCommand(new CeilingFanCommand(livingRoomFan, CeilingFan.OFF));
                    break;
                case 5:
                    remote.pressUndo();
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}

