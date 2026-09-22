public class OperationCounter {

    private long comparisons;
    private long swaps;
    private long assignments;

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementSwaps() {
        swaps++;
    }

    public void incrementAssignments() {
        assignments++;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getAssignments() {
        return assignments;
    }

    public long getTotalOperations() {
        return comparisons + swaps + assignments;
    }
}