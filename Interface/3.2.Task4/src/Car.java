import java.util.ArrayList;

abstract class AbstractVehicle implements Vehicle, ElectricalVehicle {

    protected String type;
    protected String fuelType;
    protected String color;
    protected boolean isElectric;
    protected double fuelEfficiency;

    public AbstractVehicle(String type, String fuelType, String color) {
        this.type = type;
        this.fuelType = fuelType;
        this.color = color;
    }

    @Override
    public boolean start() {
        System.out.println("Starting the vehicle...");
        return true;
    }

    @Override
    public boolean stop() {
        System.out.println("Stopping the vehicle...");
        return true;
    }

    @Override
    public boolean charge() {
        System.out.println("Can't charge. ");
         return isElectric = false;
    }
}

public class Car extends AbstractVehicle {

    public Car(String type, String fuelType, String color) {
        super(type, fuelType, color);
        isElectric = false;
    }

    @Override
    public boolean start() {
        System.out.println("Car is starting...");
        return true;
    }

    @Override
    public boolean stop() {
        System.out.println("Car is stopping...");
        return true;
    }

    @Override
    public boolean getInfo() {
        System.out.println("Car Information");
        System.out.println("Type: " + this.type);
        System.out.println("Fuel: " + this.fuelType);
        System.out.println("Color: " + this.color);
        return true;
    }

    @Override
    public void calculateFuelEfficiency(double distance, int litres_used) {
        fuelEfficiency = distance / litres_used;
    }
}

class Motorcycle extends AbstractVehicle {

    public Motorcycle(String type, String fuelType, String color) {
        super(type, fuelType, color);
        isElectric = false;
    }


    @Override
    public boolean start() {
        System.out.println("Motorcycle is starting...");
        return true;
    }

    @Override
    public boolean stop() {
        System.out.println("Motorcycle is stopping...");
        return true;
    }

    @Override
    public boolean getInfo() {
        System.out.println("Motorcycle Information");
        System.out.println("Type: " + this.type);
        System.out.println("Fuel: " + this.fuelType);
        System.out.println("Color: " + this.color);

        return true;
    }

    @Override
    public void calculateFuelEfficiency(double distance, int litres_used) {
        fuelEfficiency = distance / litres_used;
    }

}


class Bus extends AbstractVehicle {
    private int capacity;

    public Bus(String type, String fuelType, String color, int capacity) {
        super(type, fuelType, color);
        this.capacity = capacity;
        isElectric = false;
    }


    @Override
    public boolean start() {
        System.out.println("Bus is starting...");
        return true;
    }

    @Override
    public boolean stop() {
        System.out.println("Bus is stopping...");
        return true;
    }

    @Override
    public boolean getInfo() {
        System.out.println("Bus Information");
        System.out.println("Type: " + this.type);
        System.out.println("Fuel: " + this.fuelType);
        System.out.println("Capacity: " + this.capacity);

        return true;
    }

    @Override
    public void calculateFuelEfficiency(double distance, int litres_used) {
        fuelEfficiency = distance / litres_used;
    }

}

class ElectricCar extends AbstractVehicle {
    public ElectricCar(String type, String fuelType, String color) {
        super(type, fuelType, color);
        isElectric = true;
    }

    @Override
    public boolean start() {
        System.out.println("Electric car is starting...");
        return true;
    }

    @Override
    public boolean stop() {
        System.out.println("Electric car is stopping...");
        return true;
    }

    @Override
    public boolean charge() {
        System.out.println("Charging electrical car...");
        return true;
    }

    @Override
    public boolean getInfo() {
        System.out.println("Electric Car Information");
        System.out.println("Type: " + this.type);
        System.out.println("Fuel: " + this.fuelType);
        System.out.println("Color: " + this.color);

        return true;
    }

    @Override
    public void calculateFuelEfficiency(double distance, int kwh) {
        fuelEfficiency = distance / kwh;
    }

}

class ElectricMotorcycle extends AbstractVehicle {
    public ElectricMotorcycle(String type, String fuelType, String color) {
        super(type, fuelType, color);
        isElectric = true;
    }

    @Override
    public boolean start() {
        System.out.println("Electric motorcycle is starting...");
        return true;
    }

    @Override
    public boolean stop() {
        System.out.println("Electric motorcycle is stopping...");
        return true;
    }

    @Override
    public boolean charge() {
        System.out.println("Charging electrical motorcycle...");
        return true;
    }

    @Override
    public boolean getInfo() {
        System.out.println("Electric Motorcycle Information");
        System.out.println("Type: " + this.type);
        System.out.println("Fuel: " + this.fuelType);
        System.out.println("Color: " + this.color);
        return true;
    }

    @Override
    public void calculateFuelEfficiency(double distance, int kwh) {
        fuelEfficiency = distance / kwh;
    }

}


class VehicleDemo {
    public static void main(String[] args) {
        Car car = new Car("Car", "Petrol", "Red");
        Motorcycle motorcycle = new Motorcycle("Motorcycle", "Gasoline", "Black");
        Bus bus = new Bus("Bus", "Diesel", "Blue", 40);
        ElectricCar tesla = new ElectricCar("Car", "Electric", "Red");
        ElectricMotorcycle harley = new ElectricMotorcycle("Motorcycle", "Electric", "Black");
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(motorcycle);
        vehicles.add(bus);
        vehicles.add(tesla);
        vehicles.add(harley);

        for ( Vehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            vehicle.getInfo();
            vehicle.charge();
        }
    }
}
