public class ExperimentResult {

    private final String algorithmName;
    private final long[] times;
    private final long[] operations;

    public ExperimentResult(
            String algorithmName,
            long[] times,
            long[] operations) {

        this.algorithmName = algorithmName;
        this.times = times;
        this.operations = operations;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public long[] getTimes() {
        return times;
    }

    public long[] getOperations() {
        return operations;
    }
}