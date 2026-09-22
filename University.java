public class University implements Comparable<University> {

    private final int universityRank;
    private final String universityName;
    private final String location;
    private final int numberOfStudents;
    private final double studentsPerStaff;
    private final String internationalStudents;
    private final String femaleMaleRatio;
    private final double overallScore;
    private final double teachingScore;
    private final double researchScore;
    private final double citationScore;
    private final double industryIncomeScore;
    private final double internationalOutlookScore;

    public University(int universityRank, String universityName, String location,
                      int numberOfStudents, double studentsPerStaff,
                      String internationalStudents, String femaleMaleRatio,
                      double overallScore, double teachingScore,
                      double researchScore, double citationScore,
                      double industryIncomeScore, double internationalOutlookScore) {

        this.universityRank = universityRank;
        this.universityName = universityName;
        this.location = location;
        this.numberOfStudents = numberOfStudents;
        this.studentsPerStaff = studentsPerStaff;
        this.internationalStudents = internationalStudents;
        this.femaleMaleRatio = femaleMaleRatio;
        this.overallScore = overallScore;
        this.teachingScore = teachingScore;
        this.researchScore = researchScore;
        this.citationScore = citationScore;
        this.industryIncomeScore = industryIncomeScore;
        this.internationalOutlookScore = internationalOutlookScore;
    }

    public int getUniversityRank() {
        return universityRank;
    }

    public String getUniversityName() {
        return universityName;
    }

    public String getLocation() {
        return location;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public double getStudentsPerStaff() {
        return studentsPerStaff;
    }

    public String getInternationalStudents() {
        return internationalStudents;
    }

    public String getFemaleMaleRatio() {
        return femaleMaleRatio;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public double getTeachingScore() {
        return teachingScore;
    }

    public double getResearchScore() {
        return researchScore;
    }

    public double getCitationScore() {
        return citationScore;
    }

    public double getIndustryIncomeScore() {
        return industryIncomeScore;
    }

    public double getInternationalOutlookScore() {
        return internationalOutlookScore;
    }

    @Override
    public int compareTo(University other) {
        return Integer.compare(this.universityRank, other.universityRank);
    }
}