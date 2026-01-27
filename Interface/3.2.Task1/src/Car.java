import java.util.ArrayList;

abstract class AbstractVehicle implements Vehicle {

    protected String type;
    protected String fuelType;
    protected String color;

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


}

public class Car extends AbstractVehicle {

    public Car(String type, String fuelType, String color) {
        super(type, fuelType, color);
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
}

class Motorcycle extends AbstractVehicle {

    public Motorcycle(String type, String fuelType, String color) {
        super(type, fuelType, color);
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
        System.out.println("Car Information");
        System.out.println("Type: " + this.type);
        System.out.println("Fuel: " + this.fuelType);
        System.out.println("Color: " + this.color);

        return true;
    }

}


class Bus extends AbstractVehicle {
    private int capacity;

    public Bus(String type, String fuelType, String color, int capacity) {
        super(type, fuelType, color);
        this.capacity = capacity;
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

}


class VehicleDemo {
    public static void main(String[] args) {
        Car car = new Car("Car", "Petrol", "Red");
        Motorcycle motorcycle = new Motorcycle("Motorcycle", "Gasoline", "Black");
        Bus bus = new Bus("Bus", "Diesel", "Blue", 40);
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(motorcycle);
        vehicles.add(bus);

        for ( Vehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            vehicle.getInfo();
        }
    }
}
