

public class Calculator {

    private int value;

    // Constructor initializes calculator to zero
    public Calculator() {
        value = 0;
    }

    // Resets calculator to zero
    public void reset() {
        value = 0;
    }

    // Adds a positive integer
    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed.");
        }
        value += number;
    }

    // Returns current value
    public int getValue() {
        return value;
    }

    // Temporary main method for testing
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.add(5);
        calculator.add(10);
        calculator.add(3);

        System.out.println("Current value: " + calculator.getValue());

        calculator.reset();
        System.out.println("After reset: " + calculator.getValue());
    }
}
