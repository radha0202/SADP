// Abstract Products

/**
 * Abstract class representing a generic Car.
 * Concrete car types (Sedan, SUV) will extend this class.
 */
abstract class Car {
    protected String region; // To indicate the region for which the car is built

    public Car(String region) {
        this.region = region;
    }

    /**
     * Abstract method to define how a car is assembled.
     * To be implemented by concrete car types.
     */
    public abstract void assemble();

    /**
     * Abstract method to display information about the car.
     * To be implemented by concrete car types.
     */
    public abstract void displayInfo();
}

/**
 * Abstract class representing a generic Engine specification.
 * Concrete engine types will implement this interface.
 */
interface Engine {
    /**
     * Describes the characteristics of the engine.
     */
    void describe();
}

/**
 * Abstract class representing generic Safety Features specification.
 * Concrete safety feature sets will implement this interface.
 */
interface SafetyFeatures {
    /**
     * Describes the safety features included.
     */
    void describe();
}


// Concrete Products for North America

/**
 * Concrete implementation of Car for a North American Sedan.
 */
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

/**
 * Concrete implementation of Car for a North American SUV.
 */
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

/**
 * Concrete implementation of Engine for North American specifications.
 */
class NAEngine implements Engine {
    @Override
    public void describe() {
        System.out.println("Engine: V6, high displacement, optimized for regular fuel (North America)");
    }
}

/**
 * Concrete implementation of SafetyFeatures for North American specifications.
 */
class NASafetyFeatures implements SafetyFeatures {
    @Override
    public void describe() {
        System.out.println("Safety Features: Standard airbags, basic ABS, rearview camera (North America)");
    }
}


// Concrete Products for Europe

/**
 * Concrete implementation of Car for a European Sedan.
 */
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

/**
 * Concrete implementation of Car for a European SUV.
 */
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

/**
 * Concrete implementation of Engine for European specifications.
 */
class EUEngine implements Engine {
    @Override
    public void describe() {
        System.out.println("Engine: Turbocharged 4-cylinder, low emissions, optimized for premium fuel (Europe)");
    }
}

/**
 * Concrete implementation of SafetyFeatures for European specifications.
 */
class EUSafetyFeatures implements SafetyFeatures {
    @Override
    public void describe() {
        System.out.println("Safety Features: Multiple airbags, advanced ABS, pedestrian detection, lane assist (Europe)");
    }
}


// Abstract Factory

/**
 * Abstract Factory interface for creating a family of related car products
 * (Car, Engine, SafetyFeatures).
 * Concrete factories will implement this interface for specific regions.
 */
interface CarManufacturingFactory {
    Car createSedan();
    Car createSUV();
    Engine createEngine();
    SafetyFeatures createSafetyFeatures();
}


// Concrete Factories

/**
 * Concrete Factory for manufacturing cars and specifications for North America.
 * Implements the CarManufacturingFactory to produce NA-specific products.
 */
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

/**
 * Concrete Factory for manufacturing cars and specifications for Europe.
 * Implements the CarManufacturingFactory to produce EU-specific products.
 */
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


// Client Code

/**
 * The client class (CarDealership) that uses the Abstract Factory.
 * It works with abstract types (Car, Engine, SafetyFeatures, CarManufacturingFactory)
 * and is unaware of the concrete implementations.
 */
class CarDealership {
    private CarManufacturingFactory factory;

    /**
     * Constructor that takes a CarManufacturingFactory.
     * This allows the dealership to be configured for a specific region's manufacturing.
     * @param factory The concrete factory to use for creating cars and specifications.
     */
    public CarDealership(CarManufacturingFactory factory) {
        this.factory = factory;
    }

    /**
     * Orders a Sedan and its associated specifications from the configured factory.
     */
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

    /**
     * Orders an SUV and its associated specifications from the configured factory.
     */
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

// Main class to run the demonstration
public class CarMain {
    public static void main(String[] args) {
        System.out.println("Setting up North American Dealership...");
        // Create a North American factory
        CarManufacturingFactory naFactory = new NorthAmericaCarFactory();
        // Create a dealership configured for North America
        CarDealership naDealership = new CarDealership(naFactory);

        // Order cars from the North American dealership
        naDealership.orderSedan();
        naDealership.orderSUV();

        System.out.println("\n----------------------------------------");

        System.out.println("\nSetting up European Dealership...");
        // Create a European factory
        CarManufacturingFactory euFactory = new EuropeCarFactory();
        // Create a dealership configured for Europe
        CarDealership euDealership = new CarDealership(euFactory);

        // Order cars from the European dealership
        euDealership.orderSedan();
        euDealership.orderSUV();
    }
}
