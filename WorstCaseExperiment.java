import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WorstCaseExperiment {



    private static final int RUNS = 30;

    // Different input sizes
    private static final int[] INPUT_SIZES = {
            100, 200, 400, 600, 800,
            1000, 1200, 1400, 1600, 1697
    };

    public static void main(String[] args) {

        // Load all universities from CSV
        ArrayList<University> allUniversities =
                CSVReader.readArrayList();

        System.out.println("========================================");
        System.out.println("       PART 4 - BIG O EXPERIMENT");
        System.out.println("========================================");
        System.out.println();

        System.out.println(
                "Total universities: " + allUniversities.size()
        );

        System.out.println(
                "Runs per input size: " + RUNS
        );

        System.out.println();

        // Create results CSV
        try (PrintWriter writer = new PrintWriter(
                new FileWriter("part4_worstcase_results.csv"))) {

            writer.println(
                    "InputSize,Algorithm,DataStructure,AverageTimeNs"
            );

            // Test every input size
            for (int size : INPUT_SIZES) {

                System.out.println("----------------------------------------");
                System.out.println("Input size: " + size);
                System.out.println("----------------------------------------");

                // ================================================
                // 1. INSERTION SORT - ARRAYLIST
                // ================================================

                double insertionArray =
                        testInsertionArrayList(
                                allUniversities, size);

                writer.println(
                        size + ",Insertion Sort,ArrayList,"
                                + insertionArray
                );

                System.out.println(
                        "Insertion Sort - ArrayList: "
                                + insertionArray + " ns"
                );


                // ================================================
                // 2. INSERTION SORT - LINKEDLIST
                // ================================================

                double insertionLinked =
                        testInsertionLinkedList(
                                allUniversities, size);

                writer.println(
                        size + ",Insertion Sort,LinkedList,"
                                + insertionLinked
                );

                System.out.println(
                        "Insertion Sort - LinkedList: "
                                + insertionLinked + " ns"
                );


                // ================================================
                // 3. BUBBLE SORT - ARRAYLIST
                // ================================================

                double bubbleArray =
                        testBubbleArrayList(
                                allUniversities, size);

                writer.println(
                        size + ",Bubble Sort,ArrayList,"
                                + bubbleArray
                );

                System.out.println(
                        "Bubble Sort - ArrayList: "
                                + bubbleArray + " ns"
                );


                // ================================================
                // 4. BUBBLE SORT - LINKEDLIST
                // ================================================

                double bubbleLinked =
                        testBubbleLinkedList(
                                allUniversities, size);

                writer.println(
                        size + ",Bubble Sort,LinkedList,"
                                + bubbleLinked
                );

                System.out.println(
                        "Bubble Sort - LinkedList: "
                                + bubbleLinked + " ns"
                );


                // ================================================
                // 5. MERGE SORT - ARRAYLIST
                // ================================================

                double mergeArray =
                        testMergeArrayList(
                                allUniversities, size);

                writer.println(
                        size + ",Merge Sort,ArrayList,"
                                + mergeArray
                );

                System.out.println(
                        "Merge Sort - ArrayList: "
                                + mergeArray + " ns"
                );


                // ================================================
                // 6. MERGE SORT - LINKEDLIST
                // ================================================

                double mergeLinked =
                        testMergeLinkedList(
                                allUniversities, size);

                writer.println(
                        size + ",Merge Sort,LinkedList,"
                                + mergeLinked
                );

                System.out.println(
                        "Merge Sort - LinkedList: "
                                + mergeLinked + " ns"
                );


                // ================================================
                // 7. BUILT-IN SORT - ARRAYLIST
                // ================================================

                double builtIn =
                        testBuiltInSort(
                                allUniversities, size);

                writer.println(
                        size + ",Built-in Sort,ArrayList,"
                                + builtIn
                );

                System.out.println(
                        "Built-in Sort - ArrayList: "
                                + builtIn + " ns"
                );

                System.out.println();
            }

            System.out.println("========================================");
            System.out.println("       EXPERIMENT COMPLETED");
            System.out.println("========================================");

            System.out.println();
            System.out.println(
                    "Results saved to: part4_worstcase_results.csv"
            );

        } catch (IOException e) {

            System.out.println(
                    "Error creating results file: "
                            + e.getMessage()
            );
        }
    }


    // ============================================================
    // INSERTION SORT - ARRAYLIST
    // ============================================================

    private static double testInsertionArrayList(
            ArrayList<University> allUniversities,
            int size) {

        long totalTime = 0;

        for (int run = 0; run < RUNS; run++) {

            ArrayList<University> data =
                    createRandomArrayList(
                            allUniversities, size);

            long start = System.nanoTime();

            InsertionSort.sort(data);

            long end = System.nanoTime();

            totalTime += (end - start);
        }

        return (double) totalTime / RUNS;
    }


    // ============================================================
    // INSERTION SORT - LINKEDLIST
    // ============================================================

    private static double testInsertionLinkedList(
            ArrayList<University> allUniversities,
            int size) {

        long totalTime = 0;

        for (int run = 0; run < RUNS; run++) {

            LinkedList<University> data =
                    createRandomLinkedList(
                            allUniversities, size);

            long start = System.nanoTime();

            InsertionSort.sort(data);

            long end = System.nanoTime();

            totalTime += (end - start);
        }

        return (double) totalTime / RUNS;
    }


    // ============================================================
    // BUBBLE SORT - ARRAYLIST
    // ============================================================

    private static double testBubbleArrayList(
            ArrayList<University> allUniversities,
            int size) {

        long totalTime = 0;

        for (int run = 0; run < RUNS; run++) {

            ArrayList<University> data =
                    createRandomArrayList(
                            allUniversities, size);

            long start = System.nanoTime();

            BubbleSort.sort(data);

            long end = System.nanoTime();

            totalTime += (end - start);
        }

        return (double) totalTime / RUNS;
    }


    // ============================================================
    // BUBBLE SORT - LINKEDLIST
    // ============================================================

    private static double testBubbleLinkedList(
            ArrayList<University> allUniversities,
            int size) {

        long totalTime = 0;

        for (int run = 0; run < RUNS; run++) {

            LinkedList<University> data =
                    createRandomLinkedList(
                            allUniversities, size);

            long start = System.nanoTime();

            BubbleSort.sort(data);

            long end = System.nanoTime();

            totalTime += (end - start);
        }

        return (double) totalTime / RUNS;
    }


    // ============================================================
    // MERGE SORT - ARRAYLIST
    // ============================================================

    private static double testMergeArrayList(
            ArrayList<University> allUniversities,
            int size) {

        long totalTime = 0;

        for (int run = 0; run < RUNS; run++) {

            ArrayList<University> data =
                    createRandomArrayList(
                            allUniversities, size);

            long start = System.nanoTime();

            MergeSort.sort(data);

            long end = System.nanoTime();

            totalTime += (end - start);
        }

        return (double) totalTime / RUNS;
    }


    // ============================================================
    // MERGE SORT - LINKEDLIST
    // ============================================================

    private static double testMergeLinkedList(
            ArrayList<University> allUniversities,
            int size) {

        long totalTime = 0;

        for (int run = 0; run < RUNS; run++) {

            LinkedList<University> data =
                    createRandomLinkedList(
                            allUniversities, size);

            long start = System.nanoTime();

            MergeSort.sort(data);

            long end = System.nanoTime();

            totalTime += (end - start);
        }

        return (double) totalTime / RUNS;
    }


    // ============================================================
    // BUILT-IN SORT - ARRAYLIST
    // ============================================================

    private static double testBuiltInSort(
            ArrayList<University> allUniversities,
            int size) {

        long totalTime = 0;

        for (int run = 0; run < RUNS; run++) {

            ArrayList<University> data =
                    createRandomArrayList(
                            allUniversities, size);

            long start = System.nanoTime();

            Collections.sort(data);

            long end = System.nanoTime();

            totalTime += (end - start);
        }

        return (double) totalTime / RUNS;
    }


    // ============================================================
    // CREATE RANDOM ARRAYLIST
    // ============================================================

    private static ArrayList<University> createRandomArrayList(
            ArrayList<University> allUniversities,
            int size) {

        ArrayList<University> data =
                new ArrayList<>(
                        allUniversities.subList(0, size)
                );

        // Sort into ascending order first
        Collections.sort(data);

        // Reverse into descending order
        Collections.reverse(data);

        return data;
    }


    // ============================================================
    // CREATE RANDOM LINKEDLIST
    // ============================================================

    private static LinkedList<University> createRandomLinkedList(
            ArrayList<University> allUniversities,
            int size) {

        LinkedList<University> data =
                new LinkedList<>(
                        allUniversities.subList(0, size)
                );

        // Sort into ascending order first
        Collections.sort(data);

        // Reverse into descending order
        Collections.reverse(data);

        return data;
    }
}