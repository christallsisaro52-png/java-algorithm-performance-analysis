import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        // Load the original dataset
        ArrayList<University> arrayList =
                CSVReader.readArrayList();

        LinkedList<University> linkedList =
                CSVReader.readLinkedList();

        System.out.println("========================================");
        System.out.println("       CS214 ASSIGNMENT 1");
        System.out.println("       30-RUN EXPERIMENT");
        System.out.println("========================================");

        System.out.println();

        System.out.println(
                "Total universities: "
                        + arrayList.size()
        );

        System.out.println(
                "Number of runs per algorithm: 30"
        );

        System.out.println();

        // Run all seven algorithms
        ExperimentResult insertionArray =
                ExperimentRunner.runArrayListInsertion(arrayList);

        ExperimentResult insertionLinked =
                ExperimentRunner.runLinkedListInsertion(linkedList);

        ExperimentResult bubbleArray =
                ExperimentRunner.runArrayListBubble(arrayList);

        ExperimentResult bubbleLinked =
                ExperimentRunner.runLinkedListBubble(linkedList);

        ExperimentResult mergeArray =
                ExperimentRunner.runArrayListMerge(arrayList);

        ExperimentResult mergeLinked =
                ExperimentRunner.runLinkedListMerge(linkedList);

        ExperimentResult builtIn =
                ExperimentRunner.runBuiltIn(arrayList);

        System.out.println();
        System.out.println("========================================");
        System.out.println("       ALL 210 RUNS COMPLETED");
        System.out.println("========================================");

        System.out.println();

        printResults(insertionArray);
        printResults(insertionLinked);
        printResults(bubbleArray);
        printResults(bubbleLinked);
        printResults(mergeArray);
        printResults(mergeLinked);
        printResults(builtIn);

        System.out.println();
        System.out.println("========================================");
        System.out.println("       GENERATING MATLAB GRAPHS");
        System.out.println("========================================");

        MatlabGraph.createGraphs();
    }

    private static void printResults(
            ExperimentResult result) {

        long[] times = result.getTimes();
        long[] operations = result.getOperations();

        System.out.println("----------------------------------------");
        System.out.println(result.getAlgorithmName());
        System.out.println("----------------------------------------");

        System.out.println(
                "Best Time: "
                        + getBest(times)
                        + " ns"
        );

        System.out.println(
                "Mean Time: "
                        + getMean(times)
                        + " ns"
        );

        System.out.println(
                "Median Time: "
                        + getMedian(times)
                        + " ns"
        );

        System.out.println(
                "Worst Time: "
                        + getWorst(times)
                        + " ns"
        );

        System.out.println();

        System.out.println(
                "Best Operations: "
                        + getBest(operations)
        );

        System.out.println(
                "Mean Operations: "
                        + getMean(operations)
        );

        System.out.println(
                "Median Operations: "
                        + getMedian(operations)
        );

        System.out.println(
                "Worst Operations: "
                        + getWorst(operations)
        );

        System.out.println();
    }

    private static long getBest(long[] values) {

        long best = values[0];

        for (long value : values) {

            if (value < best) {
                best = value;
            }
        }

        return best;
    }

    private static long getWorst(long[] values) {

        long worst = values[0];

        for (long value : values) {

            if (value > worst) {
                worst = value;
            }
        }

        return worst;
    }

    private static double getMean(long[] values) {

        long total = 0;

        for (long value : values) {
            total += value;
        }

        return (double) total / values.length;
    }

    private static double getMedian(long[] values) {

        long[] sorted =
                values.clone();

        java.util.Arrays.sort(sorted);

        int middle =
                sorted.length / 2;

        if (sorted.length % 2 == 0) {

            return (
                    sorted[middle - 1]
                            + sorted[middle]
            ) / 2.0;

        } else {

            return sorted[middle];
        }
    }
}