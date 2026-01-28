import java.util.HashMap;
import java.util.Map;

public class backUp {



    private HashMap<String, HashMap<String, Item>> categories = new HashMap<>();
    private HashMap<String, Item> groceryList = new HashMap<>();

    class Item {

        double item_cost;
        int item_quantity;
        public Item(double item_cost, int item_quantity) {
            this.item_cost = item_cost;
            this.item_quantity = item_quantity;
        }

        @Override
        public String toString() {
            return "Cost: " + item_cost + ", Quantity: " + item_quantity;
        }


    }

    // nested hashmap above, In Categories hashmap: Category (Key) : item, cost (Value)

    public void addItem(String groceryCategory, String item, double cost, int quantity) {

        if (!groceryList.containsKey(item)) {

            if (categories.containsKey(groceryCategory)) {
                HashMap<String, Item> innerHash = categories.get(groceryCategory);

                Item new_item = new Item(cost, quantity);
                innerHash.put(item, new_item);
                groceryList.put(item, new_item);
                System.out.println(categories.toString());
                Item getGroceryListValue = groceryList.get(item);
            } else {
                HashMap<String, Item> innerHash = new HashMap<>();
                Item new_item = new Item(cost, quantity);
                innerHash.put(item, new_item);
                categories.put(groceryCategory, innerHash);
                groceryList.put(item, new_item);
                System.out.println(categories.toString());
                Item getGroceryListValue = groceryList.get(item);
            }
        } else {
            System.out.println("Duplicate Item found. Please try again. ");
        }

    }


    public void removeItem(String groceryCategory, String item, double cost, int quantity) {

        if (!categories.containsKey(groceryCategory)) {
            System.out.println("Category doesn't exist. Please enter a valid field. ");
        }

        if (!groceryList.containsKey(item)) {
            System.out.println("Item doesn't exist. Please enter a valid field. ");
        }

        Item getGroceryListValue = groceryList.get(item);
        double getGroceryListValueCost = getGroceryListValue.item_cost;
        int getGroceryListValueQuantity = getGroceryListValue.item_quantity;

        if (categories.containsKey(groceryCategory)) {
            if (groceryList.containsKey(item) && getGroceryListValueCost == cost && getGroceryListValueQuantity == quantity) {
                groceryList.remove(item);
                HashMap<String, Item> innerHash = categories.get(groceryCategory);
                innerHash.remove(item);
                System.out.println(categories);
                int counter = 0;

                System.out.println("Updated List: ");

                for (String key : groceryList.keySet()) {
                    counter++;
                    Item keyValue = groceryList.get(key);
                    System.out.println(counter + ". " + key + ", " + keyValue);
                }

            } else {
                System.out.println("Error removing item. Please enter a valid field. ");
            }
        }
        else {
            System.out.println("Error removing item. Please enter a valid field. ");
        }
    }

    public void updateQuantity(String item, int quantity) {
        if (groceryList.containsKey(item)) {
            Item obj = groceryList.get(item);
            obj.item_quantity = quantity;
        } else {
            System.out.println("Item not found");
        }
    }

    public void displayList() {

        for (Map.Entry<String, Item> entry : groceryList.entrySet()) {
            String item = entry.getKey();
            Item values = entry.getValue();
            System.out.println(item + ", " + values);
        }

    }

    public void displayAvailableItems() {
        for (Map.Entry<String, Item> entry : groceryList.entrySet()) {
            String item = entry.getKey();
            Item values = entry.getValue();

            if (values.item_quantity < 0) {
                continue;
            }

            System.out.println(item + ", " + values);
        }
    }


    public void displayCategory() {
        for (Map.Entry<String, HashMap<String, Item>> entry : categories.entrySet()) {
            String categ = entry.getKey();
            HashMap<String, Item> items = entry.getValue();
            System.out.println("Category: " + categ + ", Items: " +  items);
        }
    }


    public void isInGroceryList(String item, double cost, int quantity) {

        if (!groceryList.containsKey(item)) {
            System.out.println("Item doesn't exist. Please enter a valid field. ");
        }

        Item getGroceryListValue = groceryList.get(item);

        if (getGroceryListValue != null) {

            double getGroceryListValueCost = getGroceryListValue.item_cost;
            int getGroceryListValueQuantity = getGroceryListValue.item_quantity;

            if (groceryList.containsKey(item) && groceryList.containsValue(getGroceryListValue) && getGroceryListValueCost == cost && getGroceryListValueQuantity == quantity) {
                boolean returning = true;
                System.out.println("Is " + "'" + item + ", " + cost + "'" + " in the grocery list? " + returning);
            } else {
                System.out.println("Invalid input. Please try again. ");
            }

        }

        else {
            System.out.println("Item's cost/quantity doesn't exist. ");
        }
    }

    public double calculateTotalCost() {
        double total = 0;
        for (String key : groceryList.keySet()) {
            Item itemObj = groceryList.get(key);
            total += itemObj.item_cost;
        }
        System.out.println(total);
        return total;
    }



    public static void main(String[] args) {
        backUp groceryListManager = new backUp();

        groceryListManager.addItem("Fruit", "Oranges",  4.99, 5);
        groceryListManager.addItem("Household Cleaning", "Dish Soap", 2.50, 3);
        groceryListManager.addItem("Vegetables", "Potatoes", 4.50, -2);
        groceryListManager.addItem("Vegetables", "Potatoes", 4.23, -1);
        groceryListManager.displayList();
        groceryListManager.displayCategory();
        groceryListManager.removeItem("Fruit", "Oranges",  4.99, 5);
        groceryListManager.isInGroceryList("Oranges", 4.99, 5);
        groceryListManager.calculateTotalCost();
        groceryListManager.displayAvailableItems();
    }
}
