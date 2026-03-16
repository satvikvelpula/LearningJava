import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Task1 {

    public static int calculateMeanOfArray(List<Integer> provided_arr) throws NullPointerException {
        Optional<Integer> max = provided_arr.stream().reduce(Integer::sum);
        int maximum = 0;
        if (max.isPresent()) {
            maximum = max.get();
        }
        maximum /= provided_arr.size();
        return maximum;
    }

    public static void main(String[] args) {
        List<Integer> array2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(calculateMeanOfArray(array2));
    }

}
