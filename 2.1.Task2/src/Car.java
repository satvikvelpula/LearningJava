
public class Car {

    private double speed;
    private double gasolineLevel;
    private String typeName;
    private double gasolineCapacity;


    public Car(String typeName) {
        gasolineLevel = 0;
        this.typeName = typeName;

    }

    public Car(String typeName, double gasolineCapacity, double speed) {
        this(typeName);
        this.gasolineCapacity = gasolineCapacity;
        this.speed = speed;
    }

    public void accelerate() {
        if (gasolineLevel > 0)
            speed += 10;
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
    void fillTank() {
        gasolineLevel = 100;
    }
    double getGasolineLevel() {
        return gasolineLevel;
    }

    public double getGasolineCapacity() {
        return gasolineCapacity;
    }
}