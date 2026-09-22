import java.util.List;

public class SortTask<T extends Comparable<T>> implements Runnable {

    private final List<T> list;
    private final String algorithm;

    public SortTask(List<T> list, String algorithm) {
        this.list = list;
        this.algorithm = algorithm;
    }

    @Override
    public void run() {

        long startTime = System.nanoTime();

        if (algorithm.startsWith("Insertion Sort")) {

            InsertionSort.sort(list);

        } else if (algorithm.startsWith("Bubble Sort")) {

            BubbleSort.sort(list);

        } else if (algorithm.startsWith("Merge Sort")) {

            MergeSort.sort(list);

        } else if (algorithm.startsWith("Built-in Sort")) {

            BuiltInSort.sort(list);

        } else {

            System.out.println("Unknown algorithm: " + algorithm);
            return;
        }

        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        System.out.println(
                algorithm
                        + " finished in "
                        + duration
                        + " ns"
        );
    }
}