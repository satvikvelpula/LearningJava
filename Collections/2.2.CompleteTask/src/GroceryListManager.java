import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {


    private HashMap<String, Double> groceryList = new HashMap<>();
    private HashMap<String, HashMap<String, Double>> categories = new HashMap<>();

    // nested hashmap above, In Categories hashmap: Category (Key) : item, cost (Value)

    public void addItem(String groceryCategory, String item, double cost) {

        if (categories.containsKey(groceryCategory)) {
            HashMap<String, Double> innerHash = categories.get(groceryCategory);
            innerHash.put(item, cost);
            groceryList.put(item, cost);

        } else {
            HashMap<String, Double> innerHash = new HashMap<>();
            innerHash.put(item, cost);
            categories.put(groceryCategory, innerHash);
            System.out.println(categories);
            groceryList.put(item, cost);

        }
    }


    public void removeItem(String groceryCategory, String item, double cost) {
        if (groceryList.containsKey(item) && groceryList.containsValue(cost) && categories.containsKey(groceryCategory)) {
            groceryList.remove(item, cost);
            HashMap<String, Double> innerHash = categories.get(groceryCategory);
            innerHash.remove(item, cost);
            System.out.println(categories);
            int counter = 0;


            System.out.println("Updated List: ");

            for (String key : groceryList.keySet()) {
                counter++;
                double keyValue = groceryList.get(key);
                System.out.println(counter + ". " + key + ", " + keyValue);
            }

        } else {
            System.out.println("Error removing item. Please enter a valid field. ");
        }
    }

    public void displayList() {

        for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
            String item = entry.getKey();
            double cost = entry.getValue();
            System.out.println(item + ", " + cost);
        }

    }

    public void displayCategory() {
        for (Map.Entry<String, HashMap<String, Double>> entry : categories.entrySet()) {
            String categ = entry.getKey();
            HashMap<String, Double> items = entry.getValue();
            System.out.println("Category: " + categ + ", Items: " +  items);
        }
    }


    public void isInGroceryList(String item, double cost) {
        if (groceryList.containsKey(item) && groceryList.containsValue(cost)) {
            boolean returning = true;
            System.out.println("Is " + "'" + item + ", " + cost + "'" + " in the grocery list? "  + returning);
        } else {
            System.out.println("Invalid input. Please try again. ");
        }
    }

    public double calculateTotalCost() {
        double total = 0;
        for (String key : groceryList.keySet()) {
            total += groceryList.get(key);
        }
        System.out.println(total);
        return total;
    }

    public static void main(String[] args) {
        GroceryListManager groceryListManager = new GroceryListManager();

        groceryListManager.addItem("Dairy", "Milk", 2.50);
        // groceryListManager.addItem("Fruit", "Oranges",  4.99);
        // groceryListManager.addItem("Household Cleaning", "Dish Soap", 2.50);
        groceryListManager.addItem("Vegetables", "Potatoes", 4.50);

        groceryListManager.removeItem("Vegetables", "Potatoes", 4.5);

        groceryListManager.displayCategory();
    }
}
