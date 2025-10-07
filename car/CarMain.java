
abstract class Car {
    protected String region; 

    public Car(String region) {
        this.region = region;
    }

    
    public abstract void assemble();

    public abstract void displayInfo();
}


interface Engine {
    
    void describe();
}


interface SafetyFeatures {
    
    void describe();
}

class NASedan extends Car {
    public NASedan() {
        super("North America");
    }

    @Override
    public void assemble() {
        System.out.println("Assembling North American Sedan: Spacious interior, comfortable ride.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Car Type: Sedan (North America)");
    }
}


class NASUV extends Car {
    public NASUV() {
        super("North America");
    }

    @Override
    public void assemble() {
        System.out.println("Assembling North American SUV: Robust chassis, large cargo space.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Car Type: SUV (North America)");
    }
}


class NAEngine implements Engine {
    @Override
    public void describe() {
        System.out.println("Engine: V6, high displacement, optimized for regular fuel (North America)");
    }
}


class NASafetyFeatures implements SafetyFeatures {
    @Override
    public void describe() {
        System.out.println("Safety Features: Standard airbags, basic ABS, rearview camera (North America)");
    }
}



class EUSedan extends Car {
    public EUSedan() {
        super("Europe");
    }

    @Override
    public void assemble() {
        System.out.println("Assembling European Sedan: Fuel-efficient, agile handling, compact design.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Car Type: Sedan (Europe)");
    }
}


class EUSUV extends Car {
    public EUSUV() {
        super("Europe");
    }

    @Override
    public void assemble() {
        System.out.println("Assembling European SUV: Efficient powertrain, advanced driver-assist systems.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Car Type: SUV (Europe)");
    }
}


class EUEngine implements Engine {
    @Override
    public void describe() {
        System.out.println("Engine: Turbocharged 4-cylinder, low emissions, optimized for premium fuel (Europe)");
    }
}


class EUSafetyFeatures implements SafetyFeatures {
    @Override
    public void describe() {
        System.out.println("Safety Features: Multiple airbags, advanced ABS, pedestrian detection, lane assist (Europe)");
    }
}





interface CarManufacturingFactory {
    Car createSedan();
    Car createSUV();
    Engine createEngine();
    SafetyFeatures createSafetyFeatures();
}



class NorthAmericaCarFactory implements CarManufacturingFactory {
    @Override
    public Car createSedan() {
        return new NASedan();
    }

    @Override
    public Car createSUV() {
        return new NASUV();
    }

    @Override
    public Engine createEngine() {
        return new NAEngine();
    }

    @Override
    public SafetyFeatures createSafetyFeatures() {
        return new NASafetyFeatures();
    }
}


class EuropeCarFactory implements CarManufacturingFactory {
    @Override
    public Car createSedan() {
        return new EUSedan();
    }

    @Override
    public Car createSUV() {
        return new EUSUV();
    }

    @Override
    public Engine createEngine() {
        return new EUEngine();
    }

    @Override
    public SafetyFeatures createSafetyFeatures() {
        return new EUSafetyFeatures();
    }
}



class CarDealership {
    private CarManufacturingFactory factory;

    
    public CarDealership(CarManufacturingFactory factory) {
        this.factory = factory;
    }

    
    public void orderSedan() {
        System.out.println("\n--- Ordering a Sedan ---");
        Car sedan = factory.createSedan();
        Engine engine = factory.createEngine();
        SafetyFeatures safetyFeatures = factory.createSafetyFeatures();

        sedan.displayInfo();
        sedan.assemble();
        engine.describe();
        safetyFeatures.describe();
        System.out.println("Sedan order complete.");
    }

    
    public void orderSUV() {
        System.out.println("\n--- Ordering an SUV ---");
        Car suv = factory.createSUV();
        Engine engine = factory.createEngine();
        SafetyFeatures safetyFeatures = factory.createSafetyFeatures();

        suv.displayInfo();
        suv.assemble();
        engine.describe();
        safetyFeatures.describe();
        System.out.println("SUV order complete.");
    }
}


public class CarMain {
    public static void main(String[] args) {
        System.out.println("Setting up North American Dealership...");
    
        CarManufacturingFactory naFactory = new NorthAmericaCarFactory();
        
        CarDealership naDealership = new CarDealership(naFactory);

        
        naDealership.orderSedan();
        naDealership.orderSUV();

        System.out.println("\n----------------------------------------");

        System.out.println("\nSetting up European Dealership...");
        
        CarManufacturingFactory euFactory = new EuropeCarFactory();
        CarDealership euDealership = new CarDealership(euFactory);

        
        euDealership.orderSedan();
        euDealership.orderSUV();
    }
}
