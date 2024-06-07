package academicguidancehub;

public class CompletedReport {

    private String studentName;
    private String projectName;
    private int firstMarkerMark;
    private String secondMarkerMark;
    private int finalMark;

    public CompletedReport(String studentName, String projectName, int firstMarkerMark, String secondMarkerMark, int finalMark) {
        this.studentName = studentName;
        this.projectName = projectName;
        this.firstMarkerMark = firstMarkerMark;
        this.secondMarkerMark = secondMarkerMark;
        this.finalMark = finalMark;
    }

    // Getters
    public String getStudentName() {
        return studentName;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getFirstMarkerMark() {
        return firstMarkerMark;
    }

    public String getSecondMarkerMark() {
        return secondMarkerMark;
    }

    public int getFinalMark() {
        return finalMark;
    }

    // Setters (if needed)
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setFirstMarkerMark(int firstMarkerMark) {
        this.firstMarkerMark = firstMarkerMark;
    }

    public void setSecondMarkerMark(String secondMarkerMark) {
        this.secondMarkerMark = secondMarkerMark;
    }

    public void setFinalMark(int finalMark) {
        this.finalMark = finalMark;
    }
}
