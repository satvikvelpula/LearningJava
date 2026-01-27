import java.util.ArrayList;

class Car {

    protected double speed;
    private String typeName;
    protected double gasolineLevel;
    private double targetSpeed;
    private boolean isCruiseOn;
    private boolean canCruiseControl; // only if targetSpeed param is accepted


    public Car(String typeName, double gasolineLevel) {
        this.speed = 0;
        this.typeName = typeName;
        this.gasolineLevel = gasolineLevel;
    }

    public void accelerate() {
        if (gasolineLevel > 0) {
            speed += 4;
            gasolineLevel -= 1.5;
        }
        else
            speed = 0;
    }

    void decelerate() {
        if (gasolineLevel > 0) {
            speed = Math.max(0, speed - 4);
            gasolineLevel -= 1.5;
        } else
            speed = 0;
    }


    double getSpeed() {
        return speed;
    }


    String getTypeName() {
        return typeName;
    }


    public double fillTank() {
        gasolineLevel = 1000;
        return gasolineLevel;
    }


    double getGasolineLevel() {
        return gasolineLevel;
    }


    double getTargetSpeed() {
        return targetSpeed;
    }

    public double setTargetSpeed(double param) {
        if (param > 120 || param < 50) {
            canCruiseControl = false;
            isCruiseOn = false;
            System.out.println("Target speed not reachable. Cruise control not possible. ");
        } else {
            targetSpeed = param;
            canCruiseControl = true;
        }
        return targetSpeed;
    }

    public boolean isCruiseOn() {
        return isCruiseOn;
    }

    public void cruiseOnOff() {
        isCruiseOn = !isCruiseOn;
    }


    public void startCruiseControl() {

        if (isCruiseOn) {

            if (canCruiseControl) {

                if (speed < targetSpeed) {
                    accelerate();
                }

                if (speed > targetSpeed) {
                    decelerate();
                }
            }

        }

    }
}

class SportsCar extends Car {
    public SportsCar(String typeName, double gasolineLevel) {
        super(typeName, gasolineLevel);
    }

    @Override
    public void accelerate() {
        if (gasolineLevel > 0) {
            speed += 10;
            gasolineLevel -= 3;
        }
        else
            speed = 0;
    }

    @Override
    public void decelerate() {
        if (gasolineLevel > 0) {
            speed = Math.max(0, speed - 7.5);
            gasolineLevel -= 3;
        } else
            speed = 0;
    }
}

class Bus extends Car {
    String busName;
    ArrayList<Integer> passengers;
    public Bus (String busName, double gasolineLevel) {
        super(busName, gasolineLevel);
        this.busName = busName;
        passengers = new ArrayList<>();
    }

    public boolean passengerEnter(int amount) {
        if (amount <= 0) {
            return false;
        }

        for (int i = 1; i <= amount; i++) {
            passengers.add(i);
        }
        return true;
    }

    public boolean passengerExit(int amount) {
        if (amount > passengers.get(passengers.size() - 1)) {
            System.out.println("Amount doesn't fit passenger count on bus. ");
            return false;
        } else {
            int remaining_num = passengers.size() - amount; // e.g. passengers are 23, 10 is amount, remaining num is 13
            for (int j = passengers.size() - 1; j >= remaining_num; j--) {
                passengers.remove(j);
            }
            return true;
        }
    }

    public void displayPassengers() {
        System.out.println(passengers.size() + " passengers on the bus. ");
    }

}

class CarDriver {
    public static void main(String[] args) {
        Car myCar;
        SportsCar mySportsCar;
        Bus bus;

        myCar = new Car("Toyota Corolla", 200);
        mySportsCar = new SportsCar("Bughatti", 400);
        bus = new Bus("Travel Bus", 800);

        bus.passengerEnter(32);
        bus.passengerExit(34);

        bus.displayPassengers();


        for (int i = 0; i < 20; i++) {
            // myCar.accelerate();
            // System.out.println(myCar.getTypeName() + ": Speed is " + myCar.getSpeed() + " km/h" + " Gas Level: " + myCar.gasolineLevel);
            mySportsCar.accelerate();
            System.out.println(mySportsCar.getTypeName() + ": Speed is " + mySportsCar.getSpeed() + " km/h" + " Gas Level: " + mySportsCar.gasolineLevel);
        }


        mySportsCar.setTargetSpeed(50);
        mySportsCar.cruiseOnOff();

        for (int j = 0; j < 20; j++) {
            mySportsCar.startCruiseControl();
            System.out.println(mySportsCar.getTypeName() + ": Cruise Control ON, speed is " + mySportsCar.getSpeed() + " km/h" + " Gas Level: " + mySportsCar.gasolineLevel);
        }
    }
}