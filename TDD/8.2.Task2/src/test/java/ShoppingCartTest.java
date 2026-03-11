import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    @BeforeAll
    public static void message() {
        System.out.println("Starting tests for Shopping Cart");
    }

    @Test
    public void checkIfItemHasBeenAdded() {
        ShoppingCart shoppingCart = new ShoppingCart(); // makes the shopping cart
        String candidate_item = "Apple"; // makes the key value
        double candidate_cost = 6.70; // makes the value of the key
        shoppingCart.addItem(candidate_item, candidate_cost); // adds the item to the hashmap inside shopping cart and takes the two parameters
        String getter = shoppingCart.retrieveItem(candidate_item); // gets the specific item
        assertEquals(candidate_item, getter);
    }

    @Test
    public void checkIfItemHasBeenDeleted() {
        ShoppingCart shoppingCart = new ShoppingCart();
        String candidate_item = "Apple";
        double candidate_cost = 6.70;
        shoppingCart.addItem(candidate_item, candidate_cost);
        boolean removable = shoppingCart.removeItem(candidate_item);
        assertTrue(removable, "Item should be removed if returned true. ");
    }

    @Test
    public void checkIfTotalCostMatches() {
        ShoppingCart shoppingCart = new ShoppingCart();

        String candidate_item = "Apple";
        double candidate_cost = 6.70;
        shoppingCart.addItem(candidate_item, candidate_cost);

        String candidate_item2 = "Eggs";
        double candidate_cost2 = 4.90;
        shoppingCart.addItem(candidate_item2, candidate_cost2);

        String candidate_item3 = "Milk";
        double candidate_cost3 = 6.90;

        double sum = candidate_cost + candidate_cost2 + candidate_cost3;
        shoppingCart.addItem(candidate_item3, candidate_cost3);

        shoppingCart.calculateTotalCost();

        assertEquals(sum, shoppingCart.calculateTotalCost(), "The calculated total cost should match each cost of item added in the cart. ");
    }



}
