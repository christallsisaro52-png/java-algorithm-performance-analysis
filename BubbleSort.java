import java.util.List;

public class BubbleSort {

    public static <T extends Comparable<T>> void sort(List<T> list) {

        sort(list, null);
    }

    public static <T extends Comparable<T>> void sort(
            List<T> list, OperationCounter counter) {

        for (int i = 0; i < list.size() - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < list.size() - 1 - i; j++) {

                if (counter != null) {
                    counter.incrementComparisons();
                }

                if (list.get(j).compareTo(list.get(j + 1)) > 0) {

                    T temp = list.get(j);

                    if (counter != null) {
                        counter.incrementAssignments();
                    }

                    list.set(j, list.get(j + 1));

                    if (counter != null) {
                        counter.incrementAssignments();
                    }

                    list.set(j + 1, temp);

                    if (counter != null) {
                        counter.incrementAssignments();
                        counter.incrementSwaps();
                    }

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}