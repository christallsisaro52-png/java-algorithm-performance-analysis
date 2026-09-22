import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CSVReader {

    private static final String FILE_PATH =
            "data/World University Rankings 2023-Cleaned.csv";

    public static ArrayList<University> readArrayList() {
        ArrayList<University> universities = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line = br.readLine(); // Skip the header row

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                if (data.length < 13) {
                    continue;
                }

                int universityRank = Integer.parseInt(data[0].trim());

                String universityName = data[1].trim();

                String location = data[2].trim();

                int numberOfStudents =
                        Integer.parseInt(data[3].replace("\"", "").replace(",", "").trim());

                double studentsPerStaff =
                        Double.parseDouble(data[4].trim());

                String internationalStudents = data[5].trim();

                String femaleMaleRatio = data[6].trim();

                double overallScore = parseScore(data[7]);

                double teachingScore = parseScore(data[8]);

                double researchScore = parseScore(data[9]);

                double citationScore = parseScore(data[10]);

                double industryIncomeScore = parseScore(data[11]);

                double internationalOutlookScore = parseScore(data[12]);

                University university = new University(
                        universityRank,
                        universityName,
                        location,
                        numberOfStudents,
                        studentsPerStaff,
                        internationalStudents,
                        femaleMaleRatio,
                        overallScore,
                        teachingScore,
                        researchScore,
                        citationScore,
                        industryIncomeScore,
                        internationalOutlookScore
                );

                universities.add(university);
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        return universities;
    }

    public static LinkedList<University> readLinkedList() {
        LinkedList<University> universities = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line = br.readLine(); // Skip the header row

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                if (data.length < 13) {
                    continue;
                }

                int universityRank = Integer.parseInt(data[0].trim());

                String universityName = data[1].trim();

                String location = data[2].trim();

                int numberOfStudents =
                        Integer.parseInt(data[3].replace("\"", "").replace(",", "").trim());

                double studentsPerStaff =
                        Double.parseDouble(data[4].trim());

                String internationalStudents = data[5].trim();

                String femaleMaleRatio = data[6].trim();

                double overallScore = parseScore(data[7]);

                double teachingScore = parseScore(data[8]);

                double researchScore = parseScore(data[9]);

                double citationScore = parseScore(data[10]);

                double industryIncomeScore = parseScore(data[11]);

                double internationalOutlookScore = parseScore(data[12]);

                University university = new University(
                        universityRank,
                        universityName,
                        location,
                        numberOfStudents,
                        studentsPerStaff,
                        internationalStudents,
                        femaleMaleRatio,
                        overallScore,
                        teachingScore,
                        researchScore,
                        citationScore,
                        industryIncomeScore,
                        internationalOutlookScore
                );

                universities.add(university);
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        return universities;
    }

    private static double parseScore(String value) {

        value = value.trim();

        if (value.isEmpty()) {
            return 0.0;
        }

        // If the value is a range, use the midpoint
        if (value.contains("–")) {
            String[] range = value.split("–");

            double lower = Double.parseDouble(range[0].trim());
            double upper = Double.parseDouble(range[1].trim());

            return (lower + upper) / 2.0;
        }

        return Double.parseDouble(value);
    }
}