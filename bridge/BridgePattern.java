// Workshop interface (Implementor)
interface Workshop {
    void producePart(String partName);
}

// Concrete Workshop implementations
class ProduceEngine implements Workshop {
    public void producePart(String partName) {
        System.out.println("Producing " + partName);
    }
}

class ProduceChassis implements Workshop {
    public void producePart(String partName) {
        System.out.println("Assembling " + partName);
    }
}

// Abstraction
abstract class Vehicle {
    protected Workshop workshop1;
    protected Workshop workshop2;

    protected Vehicle(Workshop workshop1, Workshop workshop2) {
        this.workshop1 = workshop1;
        this.workshop2 = workshop2;
    }

    public abstract void manufacture();
}

// Refined Abstractions
class Car extends Vehicle {
    public Car(Workshop workshop1, Workshop workshop2) {
        super(workshop1, workshop2);
    }

    public void manufacture() {
        System.out.println("Manufacturing Car:");
        workshop1.producePart("Engine");
        workshop2.producePart("Chassis");
        System.out.println("Car manufacturing completed.\n");
    }
}

class Bike extends Vehicle {
    public Bike(Workshop workshop1, Workshop workshop2) {
        super(workshop1, workshop2);
    }

    public void manufacture() {
        System.out.println("Manufacturing Bike:");
        workshop1.producePart("Engine");
        workshop2.producePart("Chassis");
        System.out.println("Bike manufacturing completed.\n");
    }
}

// Demo class
public class BridgePattern {
    public static void main(String[] args) {
        // Workshops
        Workshop engineWorkshop = new ProduceEngine();
        Workshop chassisWorkshop = new ProduceChassis();

        // Create Car and Bike with different workshops
        Vehicle car = new Car(engineWorkshop, chassisWorkshop);
        Vehicle bike = new Bike(engineWorkshop, chassisWorkshop);

        // Manufacture vehicles
        car.manufacture();
        bike.manufacture();
    }
}
