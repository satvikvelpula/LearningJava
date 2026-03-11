import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    HashMap<String, Double> cart;
    ArrayList<String> list_of_cart_keys;

    /*
        @Test
        public void checkIfItemHasBeenAdded() {
            ShoppingCart shoppingCart = new ShoppingCart();
            HashMap<String, Double> candidate = new HashMap<>();
            shoppingCart.addItem(candidate);
            HashMap<String, Double> getter = shoppingCart.retrieveItem(candidate);
            assertEquals(candidate, getter);
        }
     */

    public ShoppingCart() {
        this.cart = new HashMap<>();
        this.list_of_cart_keys = new ArrayList<>();
    }

    public HashMap<String, Double> getCart() {
        return cart;
    }

    public void addItem(String item_name, double item_cost) {
        String name = item_name;
        double cost = item_cost;
        if (name == null) {return;}
        if (cart.containsKey(name)) {return;}
        cart.put(name, cost);
        list_of_cart_keys.add(name);
    }

    public String retrieveItem(String item_name) {
        String lookingFor = item_name;
        String found = "";

        if (cart.containsKey(lookingFor)) {
            for (String i : list_of_cart_keys) {
                if (i.equals(item_name)) {
                    found = i;
                }
            }
        }
        System.out.println(found);
        return found;
    }

    public boolean removeItem(String item_name) {
        if (cart.containsKey(item_name)) {
            cart.remove(item_name);
            list_of_cart_keys.remove(item_name);
            return true;
        } else {
            return false;
        }
    }

    public double calculateTotalCost() {
        double price_total = 0;
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            double val = entry.getValue();
            price_total += val;
        }

        return price_total;
    }


    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem("Milk", 4.32);
        shoppingCart.addItem("Eggs", 3.45);
        shoppingCart.retrieveItem("eggs");
        System.out.println(shoppingCart.calculateTotalCost());
    }
}
