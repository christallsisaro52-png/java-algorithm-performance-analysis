import java.util.ArrayList;
import java.util.LinkedList;

public class ExperimentRunner {

    private static final int NUMBER_OF_RUNS = 30;

    public static ExperimentResult runArrayListInsertion(
            ArrayList<University> original) {

        long[] times = new long[NUMBER_OF_RUNS];
        long[] operations = new long[NUMBER_OF_RUNS];

        for (int run = 0; run < NUMBER_OF_RUNS; run++) {

            ArrayList<University> data =
                    DataUtils.copyAndShuffle(original);

            OperationCounter counter =
                    new OperationCounter();

            long start = System.nanoTime();

            InsertionSort.sort(data, counter);

            long end = System.nanoTime();

            times[run] = end - start;
            operations[run] = counter.getTotalOperations();
        }

        return new ExperimentResult(
                "Insertion Sort - ArrayList",
                times,
                operations
        );
    }

    public static ExperimentResult runLinkedListInsertion(
            LinkedList<University> original) {

        long[] times = new long[NUMBER_OF_RUNS];
        long[] operations = new long[NUMBER_OF_RUNS];

        for (int run = 0; run < NUMBER_OF_RUNS; run++) {

            LinkedList<University> data =
                    DataUtils.copyAndShuffleLinked(original);

            OperationCounter counter =
                    new OperationCounter();

            long start = System.nanoTime();

            InsertionSort.sort(data, counter);

            long end = System.nanoTime();

            times[run] = end - start;
            operations[run] = counter.getTotalOperations();
        }

        return new ExperimentResult(
                "Insertion Sort - LinkedList",
                times,
                operations
        );
    }

    public static ExperimentResult runArrayListBubble(
            ArrayList<University> original) {

        long[] times = new long[NUMBER_OF_RUNS];
        long[] operations = new long[NUMBER_OF_RUNS];

        for (int run = 0; run < NUMBER_OF_RUNS; run++) {

            ArrayList<University> data =
                    DataUtils.copyAndShuffle(original);

            OperationCounter counter =
                    new OperationCounter();

            long start = System.nanoTime();

            BubbleSort.sort(data, counter);

            long end = System.nanoTime();

            times[run] = end - start;
            operations[run] = counter.getTotalOperations();
        }

        return new ExperimentResult(
                "Bubble Sort - ArrayList",
                times,
                operations
        );
    }

    public static ExperimentResult runLinkedListBubble(
            LinkedList<University> original) {

        long[] times = new long[NUMBER_OF_RUNS];
        long[] operations = new long[NUMBER_OF_RUNS];

        for (int run = 0; run < NUMBER_OF_RUNS; run++) {

            LinkedList<University> data =
                    DataUtils.copyAndShuffleLinked(original);

            OperationCounter counter =
                    new OperationCounter();

            long start = System.nanoTime();

            BubbleSort.sort(data, counter);

            long end = System.nanoTime();

            times[run] = end - start;
            operations[run] = counter.getTotalOperations();
        }

        return new ExperimentResult(
                "Bubble Sort - LinkedList",
                times,
                operations
        );
    }

    public static ExperimentResult runArrayListMerge(
            ArrayList<University> original) {

        long[] times = new long[NUMBER_OF_RUNS];
        long[] operations = new long[NUMBER_OF_RUNS];

        for (int run = 0; run < NUMBER_OF_RUNS; run++) {

            ArrayList<University> data =
                    DataUtils.copyAndShuffle(original);

            OperationCounter counter =
                    new OperationCounter();

            long start = System.nanoTime();

            MergeSort.sort(data, counter);

            long end = System.nanoTime();

            times[run] = end - start;
            operations[run] = counter.getTotalOperations();
        }

        return new ExperimentResult(
                "Merge Sort - ArrayList",
                times,
                operations
        );
    }

    public static ExperimentResult runLinkedListMerge(
            LinkedList<University> original) {

        long[] times = new long[NUMBER_OF_RUNS];
        long[] operations = new long[NUMBER_OF_RUNS];

        for (int run = 0; run < NUMBER_OF_RUNS; run++) {

            LinkedList<University> data =
                    DataUtils.copyAndShuffleLinked(original);

            OperationCounter counter =
                    new OperationCounter();

            long start = System.nanoTime();

            MergeSort.sort(data, counter);

            long end = System.nanoTime();

            times[run] = end - start;
            operations[run] = counter.getTotalOperations();
        }

        return new ExperimentResult(
                "Merge Sort - LinkedList",
                times,
                operations
        );
    }

    public static ExperimentResult runBuiltIn(
            ArrayList<University> original) {

        long[] times = new long[NUMBER_OF_RUNS];
        long[] operations = new long[NUMBER_OF_RUNS];

        for (int run = 0; run < NUMBER_OF_RUNS; run++) {

            ArrayList<University> data =
                    DataUtils.copyAndShuffle(original);

            OperationCounter counter =
                    new OperationCounter();

            long start = System.nanoTime();

            BuiltInSort.sort(data, counter);

            long end = System.nanoTime();

            times[run] = end - start;
            operations[run] = counter.getTotalOperations();
        }

        return new ExperimentResult(
                "Built-in Sort - ArrayList",
                times,
                operations
        );
    }
}