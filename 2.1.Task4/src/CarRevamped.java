class CarRevamped {

    private double speed;
    private String typeName;
    private double gasolineLevel;
    private double targetSpeed;
    private boolean isCruiseOn;
    private boolean canCruiseControl; // only if targetSpeed param is accepted


    public CarRevamped(String typeName, double gasolineLevel) {
        this.speed = 0;
        this.typeName = typeName;
        this.gasolineLevel = gasolineLevel;
    }

    public void accelerate() {
        if (gasolineLevel > 0)
            speed += 4;
        else
            speed = 0;
    }

    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
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
        gasolineLevel = 100;
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
                    decelerate(4);
                }
            }

        }

    }
}

class CarDriver {
    public static void main(String[] args) {
        CarRevamped myCar;

        myCar = new CarRevamped("Toyota Corolla", 10);


        for (int i = 0; i < 10; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": Speed is " + myCar.getSpeed() + " km/h");
        }

        myCar.setTargetSpeed(50);
        myCar.cruiseOnOff();

        for (int j = 0; j < 100; j++) {
            myCar.startCruiseControl();
            System.out.println(myCar.getTypeName() + ": Cruise Control ON, speed is " + myCar.getSpeed() + " km/h");
        }

    }
}