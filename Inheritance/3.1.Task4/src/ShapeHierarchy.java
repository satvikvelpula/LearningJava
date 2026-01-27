import java.lang.Math;
import java.util.ArrayList;

public abstract class ShapeHierarchy {

    public double calculateArea() {
        double area = 0;
        return area;
    }

    public abstract String color(String color);

}

class Circle extends ShapeHierarchy {

    double radius;
    String shape_color;
    public Circle() {
        this.radius = 5;
    }

    @Override
    public String color(String color) {
        return shape_color = color;
    }

    @Override
    public double calculateArea() {
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("The area of a circle with radius " + this.radius + " is: " + area + ", color is: " + shape_color);
        return area;
    }


}

class Rectangle extends ShapeHierarchy {
    double width;
    double height;
    String shape_color;

    public Rectangle() {
        this.width = 4;
        this.height = 6;
    }

    @Override
    public String color(String color) {
        return shape_color = color;
    }

    @Override
    public double calculateArea() {
        double area = width * height;
        System.out.println("The area of a rectangle with width " + this.width + " and height " + this.height + " is: " + area + ", color is: " + shape_color);
        return area;
    }
}

class Triangle extends ShapeHierarchy {
    double width;
    double height;
    String shape_color;

    public Triangle() {
        this.width = 3;
        this.height = 8;
    }

    @Override
    public String color(String color) {
        return shape_color = color;
    }

    @Override
    public double calculateArea() {
        double area = (width * height) / 2;
        System.out.println("The area of a rectangle with width " + this.width + " and height " + this.height + " is: " + area + ", color is: " + shape_color);
        return area;
    }

}

class ShapeCalculator {
    public static void main(String[] args) {
        ArrayList<ShapeHierarchy> shapes = new ArrayList<>();

        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();

        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(triangle);

        for (ShapeHierarchy shape : shapes) {
            shape.calculateArea();
        }

    }

}
