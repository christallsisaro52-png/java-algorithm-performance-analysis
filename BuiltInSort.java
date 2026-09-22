import java.util.List;

public class BuiltInSort {

    public static <T extends Comparable<T>> void sort(List<T> list) {

        list.sort(null);
    }

    public static <T extends Comparable<T>> void sort(
            List<T> list, OperationCounter counter) {

        list.sort(null);

        if (counter != null) {
            counter.incrementAssignments();
        }
    }
}