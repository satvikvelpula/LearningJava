# Calculator Model (MVC Pattern)

## Program Description

This program implements a simple Calculator class that can sum positive integers.  
The calculator follows the Model role in the MVC (Model-View-Controller) design pattern.  
It stores and manages the current numerical value internally and provides methods to modify and access it.

The calculator does not allow negative integers. If a negative number is passed to the add method, an exception is thrown.

---

## Calculator Class

```java
package model;

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

```

## Copilot-Generated Explanation

The `Calculator` class is responsible for storing and managing a single integer value.  
It acts as the **Model** in the MVC pattern, meaning it handles the data and business logic of the program.

### How the Class Works

- The class contains a private variable called `value` that stores the current total.
- When a new `Calculator` object is created, the value is automatically set to zero.
- The `add(int number)` method increases the stored value by the given number.
- If a negative number is passed to the `add` method, the program throws an `IllegalArgumentException`. This prevents invalid input and ensures the calculator only works with positive integers.
- The `reset()` method sets the value back to zero.
- The `getValue()` method returns the current total.

### About the Main Method

The `main` method is included temporarily to test the functionality of the class.  
It creates a `Calculator` object, adds several numbers, prints the result, resets the calculator, and prints the value again.
