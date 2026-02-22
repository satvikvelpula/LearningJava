interface Vehicle {

    default boolean start() {
        return true;
    }

    default boolean stop() {
        return true;
    }

    default boolean getInfo() {
        return true;
    }

    default boolean charge() {
        System.out.println("Can't charge. ");
        return true;
    }

    default void calculateFuelEfficiency(double distance, int fuel_used) {
    }

}

interface ElectricalVehicle {

    default boolean charge() {
        return true;
    }

}