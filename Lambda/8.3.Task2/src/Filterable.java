import java.util.List;

@FunctionalInterface
public interface Filterable<T> {
    void filter(List<T> list);
}

