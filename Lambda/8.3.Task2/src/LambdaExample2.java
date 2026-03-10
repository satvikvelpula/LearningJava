
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaExample2 {

    List<Integer> integers;

    public LambdaExample2 () {
        integers = new ArrayList<>(Arrays.asList(10, 5, 8, 20, 15, 3, 12));
    }

    public void filterEvenNumbers() {
        Filterable<Integer> filterable = list -> {
            for (int i = list.size() - 1; i >= 0; i--) {
                int val = list.get(i);
                if (val % 2 == 0 && list.get(i) == val) {
                    list.remove(i);
                }
            }
        };

        filterable.filter(integers);
        System.out.println(integers);
    }

    public void doubleOdd() {
        Filterable<Integer> filterable = list -> {
            for (int i = list.size() - 1; i >= 0; i--) {
                int val = list.get(i);
                if (!(val % 2 == 0)) {
                    int formula = val * val;
                    list.set(i, formula);
                }
            }
        };

        filterable.filter(integers);
        System.out.println(integers);
    }

    public int sum() {
        final int[] total = {0};
        Summable<Integer> summable = list -> {
            for (int i = list.size() - 1; i >= 0; i--) {
                int val = list.get(i);
                total[0] += val;
            }
            return total[0];
        };

        summable.apply(integers);
        System.out.println(total[0]);
        return total[0];
    }

}

class Main {
    public static void main(String[] args) {
        LambdaExample2 list = new LambdaExample2();
        list.filterEvenNumbers();
        list.doubleOdd();
        list.sum();
    }
}
