import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Task2 {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4);
        List<Integer> filtered_out_even = arr.stream().filter(Predicate.not(a -> a % 2 == 0)).toList();
        System.out.println(filtered_out_even);

        List<Integer> doubled = filtered_out_even.stream().map(a -> a*a).toList();
        System.out.println(doubled);

        Optional<Integer> sum = doubled.stream().reduce(Integer::sum);
        System.out.println(sum.get());

    }
}