import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        int result = numbers.stream()
                .filter(n -> n % 2 != 0)   // keep odd numbers
                .map(n -> n * 2)           // double them
                .reduce(0, Integer::sum);  // sum all values

        System.out.println("Result: " + result);
    }
}
