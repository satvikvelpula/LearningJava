import java.util.List;

@FunctionalInterface
public interface Summable<T> {
    int apply(List<Integer> list);
}
