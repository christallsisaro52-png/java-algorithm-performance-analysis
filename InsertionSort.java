import java.util.List;

public class InsertionSort {

    public static <T extends Comparable<T>> void sort(List<T> list) {

        sort(list, null);
    }

    public static <T extends Comparable<T>> void sort(
            List<T> list, OperationCounter counter) {

        for (int i = 1; i < list.size(); i++) {

            T key = list.get(i);

            if (counter != null) {
                counter.incrementAssignments();
            }

            int j = i - 1;

            while (j >= 0) {

                if (counter != null) {
                    counter.incrementComparisons();
                }

                if (list.get(j).compareTo(key) <= 0) {
                    break;
                }

                list.set(j + 1, list.get(j));

                if (counter != null) {
                    counter.incrementAssignments();
                }

                j--;
            }

            list.set(j + 1, key);

            if (counter != null) {
                counter.incrementAssignments();
            }
        }
    }
}