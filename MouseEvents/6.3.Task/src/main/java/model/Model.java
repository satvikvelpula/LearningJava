package model;

import static java.lang.Math.min;

public class Model {

    private double x;
    private double y;
    private double targetX;
    private double targetY;
    private final double smoothingFactor;
    private double maxSpeed;

    public Model(double startX, double startY) {
        this.x = startX;
        this.y = startY;
        this.targetX = startX;
        this.targetY = startY;
        this.smoothingFactor = 0.1;
        this.maxSpeed = 10;
    }

    public void setTarget(double provided_targetX, double provided_targetY) {
        targetX = provided_targetX;
        targetY = provided_targetY;
    }

    public void update() {
        double distance_x = targetX - x;
        double distance_y = targetY - y;
        double distance = Math.sqrt((distance_x*distance_x) + (distance_y*distance_y));

        if (distance > 0) {
            double step = distance * smoothingFactor; // intended movement length
            step = min(step, maxSpeed);
            x += (distance_x / distance) * step;
            y += (distance_y / distance) * step;
        }

    }

    public double getTargetX() {return targetX;}
    public double getTargetY() {return targetY;}
    public double getX() {return x;}
    public double getY() {return y;}

}
