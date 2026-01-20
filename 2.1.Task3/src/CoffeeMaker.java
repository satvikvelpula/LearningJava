/*
A coffee maker has a selector for coffee type (normal/espresso) and a selector for coffee amount (10–80 ml).
It also has an on/off switch that behaves in the same way as TV on/off switch.
Coffee type and amount selectors behave like TV channel switch,
i.e., they can only be changed when the device is on,
and the device remembers the selections even when it is switched off.

CoffeeMaker class should not have any console input/output operations.
Create another class, CoffeeMakerDriver, that creates an instance of CoffeeMaker
 and tests it by switching the device on, setting the coffee type and amount, and switching the device off.
  The output should be similar to the following:

  Coffee maker is on
  Coffee type is espresso
  Coffee amount is 50 ml
  Coffee maker is off
 */


public class CoffeeMaker {

    String coffeeType;
    int coffeeAmount;
    private boolean isOn;
    int max = 80;
    int min = 10;


    public CoffeeMaker() {
        this.coffeeType = coffeeType;
        this.coffeeAmount = coffeeAmount;
        this.isOn = false;
    }

    public boolean turnOn() {
        return isOn = true;
    }

    public boolean pressOnOff() {
        isOn = !isOn;
        return isOn;
    }

    public boolean getMachineStatus() {
        return isOn;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }

    public boolean selectType(String param) {

        if (!isOn) {
            return false;
        }

        if (param.equals("espresso") || param.equals("normal")) {
            coffeeType = param;
            return true;
        } else {
            return false;
        }

    }

    public boolean isCoffeeTypeValid() {
        if (selectType(coffeeType)) {
            return true;
        }
        return false;
    }

    public boolean selectCoffeeAmount(int param) {

        if (!isOn) {
            return false;
        }

        if (param > max || param < min) {
            return false;
        } else {
            coffeeAmount = param;
            return true;
        }
    }

    public boolean isCoffeeAmountInRange(int param) {
        if (param < max && param >= min) {
            return true;
        }
            return false;
    }

}

class CoffeeMakerDriver {

    public static void main(String[] args) {
        CoffeeMaker myCoffeeMaker = new CoffeeMaker();

        myCoffeeMaker.turnOn();

        if (myCoffeeMaker.getMachineStatus()) {
            System.out.println("Coffee maker is on ");
        }

        myCoffeeMaker.selectType("espresso");

        if (myCoffeeMaker.isCoffeeTypeValid()) {
            System.out.println("Coffee type is " + myCoffeeMaker.coffeeType);
        } else {
            System.out.println("Coffee type is invalid ");
        }

        myCoffeeMaker.selectCoffeeAmount(50);

        if (myCoffeeMaker.isCoffeeAmountInRange(myCoffeeMaker.coffeeAmount)) {
            System.out.println("Coffee amount is " + myCoffeeMaker.coffeeAmount + "ml");
        } else {
            System.out.println("Coffee amount is invalid");
        }

        myCoffeeMaker.pressOnOff();

        if (!myCoffeeMaker.getMachineStatus()) {
            System.out.println("Coffee maker is off");
        }

    }


}




