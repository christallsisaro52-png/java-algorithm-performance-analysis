import java.util.List;

public class MergeSort {

    public static <T extends Comparable<T>> void sort(List<T> list) {
        sort(list, null);
    }

    public static <T extends Comparable<T>> void sort(
            List<T> list, OperationCounter counter) {

        if (list.size() <= 1) {
            return;
        }

        mergeSort(list, 0, list.size() - 1, counter);
    }

    private static <T extends Comparable<T>> void mergeSort(
            List<T> list,
            int left,
            int right,
            OperationCounter counter) {

        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;

        mergeSort(list, left, middle, counter);
        mergeSort(list, middle + 1, right, counter);

        merge(list, left, middle, right, counter);
    }

    private static <T extends Comparable<T>> void merge(
            List<T> list,
            int left,
            int middle,
            int right,
            OperationCounter counter) {

        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        Object[] leftArray = new Object[leftSize];
        Object[] rightArray = new Object[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = list.get(left + i);

            if (counter != null) {
                counter.incrementAssignments();
            }
        }

        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = list.get(middle + 1 + j);

            if (counter != null) {
                counter.incrementAssignments();
            }
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftSize && j < rightSize) {

            @SuppressWarnings("unchecked")
            T leftValue = (T) leftArray[i];

            @SuppressWarnings("unchecked")
            T rightValue = (T) rightArray[j];

            if (counter != null) {
                counter.incrementComparisons();
            }

            if (leftValue.compareTo(rightValue) <= 0) {

                list.set(k, leftValue);
                i++;

            } else {

                list.set(k, rightValue);
                j++;
            }

            if (counter != null) {
                counter.incrementAssignments();
            }

            k++;
        }

        while (i < leftSize) {

            @SuppressWarnings("unchecked")
            T value = (T) leftArray[i];

            list.set(k, value);

            if (counter != null) {
                counter.incrementAssignments();
            }

            i++;
            k++;
        }

        while (j < rightSize) {

            @SuppressWarnings("unchecked")
            T value = (T) rightArray[j];

            list.set(k, value);

            if (counter != null) {
                counter.incrementAssignments();
            }

            j++;
            k++;
        }
    }
}