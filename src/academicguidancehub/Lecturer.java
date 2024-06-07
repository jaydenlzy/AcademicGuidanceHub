package academicguidancehub;

import java.util.List; // Correct import for List
import java.util.ArrayList; // Correct import for ArrayList
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;

public class Lecturer extends User implements FileLocationInterface {

    private Map<String, String> lecturerMap; // Changed to proper instance variables
    private Map<String, String> studentMap;
    private Map<String, String> projectMap;
    private int completedReportCount;

    public Lecturer(String userId, String name, String password, String email, String contact, String role) {
        super(userId, name, password, email, contact, role);
        lecturerMap = new HashMap<>();
        studentMap = new HashMap<>();
        projectMap = new HashMap<>();
        loadLecturerData();
        loadStudentData();
        loadProjectData();
        updateCompletedReportCount();
    }

    // Constructor from an existing User object
    public Lecturer(User user) {
        super(user.getUserId(), user.getName(), user.getPassword(), user.getEmail(), user.getContact(), user.getRole());
        lecturerMap = new HashMap<>();
        studentMap = new HashMap<>();
        projectMap = new HashMap<>();
        loadLecturerData();
        loadStudentData();
        loadProjectData();
        updateCompletedReportCount();
    }

    public int getCompletedReportCount() {
        return completedReportCount;
    }

    public List<String[]> getAssignedSupervisees() {
        List<String[]> supervisees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(projectsFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 11) {
                    String studentId = fields[6];
                    String firstMarkerId = fields[7];
                    String secondMarkerId = fields[8];
                    if (firstMarkerId.equals(this.getUserId()) || secondMarkerId.equals(this.getUserId())) {
                        String studentName = studentMap.getOrDefault(studentId, "Unknown Student");
                        String firstMarker = lecturerMap.getOrDefault(firstMarkerId, "Unknown Marker");
                        String secondMarker = lecturerMap.getOrDefault(secondMarkerId, "Unknown Marker");
                        supervisees.add(new String[]{studentName, fields[1], firstMarker, secondMarker});
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return supervisees;
    }

    public List<String[]> getDetailedSupervisees() {
        List<String[]> supervisees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(resultsFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 9) {
                    String studentId = fields[1];
                    String firstMarkerId = fields[2];
                    String secondMarkerId = fields[3];
                    if (firstMarkerId.equals(this.getUserId()) || secondMarkerId.equals(this.getUserId())) {
                        String studentName = getStudentNameById(studentId);
                        String projectName = getProjectNameById(fields[0]);
                        String firstMarker = getLecturerNameById(firstMarkerId);
                        String secondMarker = getLecturerNameById(secondMarkerId);
                        String firstMarkerMarks = fields[4];
                        String secondMarkerMarks = fields[5];
                        supervisees.add(new String[]{studentName, projectName, firstMarker, secondMarker, firstMarkerMarks, secondMarkerMarks});
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return supervisees;
    }

    private void loadLecturerData() {
        try (BufferedReader br = new BufferedReader(new FileReader(lecturerFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length == 7) {
                    String id = fields[0];
                    String name = fields[1];
                    lecturerMap.put(id, name);
                } else {
                    System.out.println("Unexpected data format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updatePresentationResultFile(String projectId, String studentId, String status) {
        try {
            List<String[]> lines = getAllResultsData();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(resultsFilePath))) {
                for (String[] fields : lines) {
                    if (fields.length >= 9 && fields[0].equals(projectId) && fields[1].equals(studentId)) {
                        fields[6] = status; // Update the status in column 7
                    }
                    bw.write(String.join(";", fields));
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadStudentData() {
        try (BufferedReader br = new BufferedReader(new FileReader(studentFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 2) {
                    studentMap.put(fields[0], fields[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLecturerNameById(String lecturerId) {
        return lecturerMap.getOrDefault(lecturerId, "Unknown Lecturer");
    }

    public String getStudentNameById(String studentId) {
        return studentMap.getOrDefault(studentId, "Unknown Student");
    }

    private String getProjectNameById(String projectId) {
        return projectMap.getOrDefault(projectId, "Unknown Project");
    }

    public static List<String[]> getAllLecturersData() {
        List<String[]> lecturersData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(lecturerFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 7) {
                    String[] lecturer = {fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]};
                    lecturersData.add(lecturer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lecturersData;
    }

    public String[] getLecturerDataById(String lecturerId) {
        for (String[] lecturer : getAllLecturersData()) {
            if (lecturer[0].equals(lecturerId)) {
                return lecturer;
            }
        }
        return null;
    }

    private void loadProjectData() {
        try (BufferedReader br = new BufferedReader(new FileReader(projectsFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 2) {
                    projectMap.put(fields[0], fields[1]); // Assuming project ID is in fields[0] and module name in fields[1]
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> getResults() {
        List<String[]> results = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(resultsFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 9 && (fields[2].equals(this.getUserId()) || fields[3].equals(this.getUserId()))) {
                    String studentName = studentMap.getOrDefault(fields[1], "Unknown Student");
                    String moduleName = projectMap.getOrDefault(fields[0], "Unknown Module");
                    results.add(new String[]{fields[0], studentName, moduleName, fields[7], fields[8], fields[6]});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    public List<String[]> getPresentationData() {
        List<String[]> presentationData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(resultsFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 9) {
                    String studentName = studentMap.getOrDefault(fields[1], "Unknown Student");
                    String projectName = projectMap.getOrDefault(fields[0], "Unknown Project");
                    String lecturerName = getLecturerNameById(fields[2]);
                    String presentationDate = fields[8];
                    presentationData.add(new String[]{studentName, projectName, lecturerName, presentationDate});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return presentationData;
    }

    public void updateResultFile(String projectId, String studentId, String status) {
        // Update the result file with the specified status for the given project and student
        try (BufferedReader br = new BufferedReader(new FileReader(resultsFilePath))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 9 && fields[0].equals(projectId) && fields[1].equals(studentId)) {
                    fields[6] = status; // Update the status in column 7
                    line = String.join(";", fields); // Reconstruct the line with updated status
                }
                lines.add(line);
            }
            // Write the updated lines back to the result file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(resultsFilePath))) {
                for (String updatedLine : lines) {
                    bw.write(updatedLine);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Call updateResultFileByStudentId
    }

    private List<String[]> getAllResultsData() {
        List<String[]> resultsData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(resultsFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                resultsData.add(fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultsData;
    }

    public String getPresentationDateTime(String projectId, String studentName) {
        System.out.println("Searching for Project ID: " + projectId + " and Student Name: " + studentName);
        try (BufferedReader br = new BufferedReader(new FileReader(resultsFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                System.out.println("Checking line: " + line);
                if (fields.length >= 9) {
                    String fileProjectId = fields[0].trim();
                    String fileStudentName = fields[1].trim(); // Student name is in the second column
                    System.out.println("File Project ID: " + fileProjectId + ", File Student Name: " + fileStudentName);
                    if (fileProjectId.equals(projectId.trim()) && fileStudentName.equals(studentName.trim())) {
                        String presentationDateTime = fields[8].trim(); // Field 9 (index 8) contains the Presentation Date and Time
                        System.out.println("Found Presentation Date/Time: " + presentationDateTime);
                        return presentationDateTime;
                    }
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("No Presentation Date/Time Found");
        return null;
    }

    public String getPresentationDateTimeByStudentId(String studentId) {
        System.out.println("Searching for Presentation Date and Time for Student ID: " + studentId);
        try (BufferedReader br = new BufferedReader(new FileReader(resultsFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                System.out.println("Checking line: " + line);
                if (fields.length >= 9) {
                    String fileStudentId = fields[1].trim();
                    System.out.println("File Student ID: " + fileStudentId);
                    if (fileStudentId.equals(studentId.trim())) {
                        String presentationDateTime = fields[8].trim(); // Field 9 (index 8) contains the Presentation Date and Time
                        System.out.println("Found Presentation Date/Time: " + presentationDateTime);
                        return presentationDateTime;
                    }
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("No Presentation Date/Time Found for Student ID: " + studentId);
        return null;
    }

    public void displayPresentationDetails(String projectId, String studentId, JLabel lblPresentationDateAndTime) {
        String presentationDateTime = getPresentationDateTime(projectId, studentId);
        if (presentationDateTime != null) {
            lblPresentationDateAndTime.setText(presentationDateTime);
        } else {
            lblPresentationDateAndTime.setText("No Presentation Date/Time Found");
        }
    }

    public int getPresentationRequestCount() {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(resultsFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 9 && (fields[2].equals(this.getUserId()) || fields[3].equals(this.getUserId()))) {
                    if (fields[6].equalsIgnoreCase("pending")) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getPendingReportCount() {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(resultsFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 9 && (fields[2].equals(this.getUserId()) || fields[3].equals(this.getUserId()))) {
                    if (fields[4].equalsIgnoreCase("pending")) { // Assuming field 6 contains the report status
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    private void updateCompletedReportCount() {
        completedReportCount = 0; // Reset count to 0
        try (BufferedReader br = new BufferedReader(new FileReader(resultsFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length > 0 && fields[fields.length - 2].equalsIgnoreCase("completed")) {
                    completedReportCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<CompletedReport> getCompletedReports() {
        List<CompletedReport> completedReports = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(resultsFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 10 && fields[fields.length - 2].equalsIgnoreCase("completed")) {
                    String studentName = getStudentNameById(fields[1]);
                    String projectName = getProjectNameById(fields[0]);

                    // Parse the first marker mark (column 5)
                    int firstMarkerMark = parseValidInt(fields[4]);

                    // Handle second marker mark (column 6), allowing "N/A"
                    String secondMarkerMarkStr = fields[5];
                    String secondMarkerMark;
                    if (secondMarkerMarkStr.equalsIgnoreCase("N/A")) {
                        secondMarkerMark = "N/A";
                    } else {
                        secondMarkerMark = String.valueOf(parseValidInt(secondMarkerMarkStr));
                    }

                    // Parse the final mark, allowing "N/A"
                    String finalMarkStr = fields[fields.length - 1];
                    int finalMark;
                    if (finalMarkStr.equalsIgnoreCase("N/A")) {
                        finalMark = 0; // or some other default value or handling
                    } else {
                        finalMark = parseValidInt(finalMarkStr);
                    }

                    completedReports.add(new CompletedReport(studentName, projectName, firstMarkerMark, secondMarkerMark, finalMark));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return completedReports;
    }

    private int parseValidInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            // Handle the case where the value is not a valid integer
            System.err.println("Invalid integer value: " + value);
            return 0; // or some other default value or error handling
        }
    }

    public void assignMarkToStudent(String studentName, String mark) {
        System.out.println("Assigning mark " + mark + " to student " + studentName);

        String studentId = null;
        for (Map.Entry<String, String> entry : studentMap.entrySet()) {
            if (entry.getValue().equals(studentName)) {
                studentId = entry.getKey();
                break;
            }
        }

        if (studentId != null) {
            String lecturerId = getUserId();
            boolean isColumn5 = false;
            boolean isColumn6 = false;
            if (lecturerId.equals(getSecondMarkerId(studentId))) {
                isColumn6 = true;
            } else if (lecturerId.equals(getFirstMarkerId(studentId))) {
                isColumn5 = true;
            }

            if (isColumn5 || isColumn6) {
                updateMarkInResultFile(studentId, mark, isColumn5, isColumn6);
                System.out.println("Mark assigned successfully.");
            } else {
                System.out.println("You are not the marker for this student.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    private String getFirstMarkerId(String studentId) {

        return "LC000001"; // Placeholder
    }

    private String getSecondMarkerId(String studentId) {

        return "LC000002"; // Placeholder
    }

    private void updateMarkInResultFile(String studentId, String mark, boolean isColumn5, boolean isColumn6) {
        try {
            List<String[]> lines = getAllResultsData();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(resultsFilePath))) {
                for (String[] fields : lines) {
                    if (fields.length >= 9 && fields[1].equals(studentId)) {
                        if (isColumn5) {
                            fields[4] = mark; // Update the mark in column 5
                        } else if (isColumn6) {
                            fields[5] = mark; // Update the mark in column 6
                        }
                    }
                    bw.write(String.join(";", fields));
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> getPendingStudents() {
        List<String[]> pendingStudents = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(resultsFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 9 && (fields[2].equals(this.getUserId()) || fields[3].equals(this.getUserId()))) {
                    // Check if the report status is pending (assuming it's in column 7)
                    if (fields[6].equalsIgnoreCase("pending")) {
                        String studentName = getStudentNameById(fields[1]); // Get student name by ID
                        String projectName = getProjectNameById(fields[0]); // Get project name by ID
                        pendingStudents.add(new String[]{studentName, projectName});
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pendingStudents;
    }

    public void updateResultFileByStudentId(String studentId, String status) {
        try {
            List<String[]> lines = getAllResultsData();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(resultsFilePath))) {
                for (String[] fields : lines) {
                    if (fields.length >= 9 && fields[1].equals(studentId)) {
                        fields[6] = status; // Update the status in column 7
                    }
                    bw.write(String.join(";", fields));
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getStudentIdByStudentName(String studentName) {
        String studentId = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(studentFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] studentInfo = line.split(";");
                if (studentName.equals(studentInfo[1])) { // Assuming student name is at index 1
                    studentId = studentInfo[0]; // Student ID is at index 0
                    break; // Exit loop once the matching student is found
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception properly in your application
        }
        return studentId;
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        boolean passwordChanged = false;
        try (BufferedReader br = new BufferedReader(new FileReader(lecturerFilePath))) {
            String line;
            List<String> updatedLines = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 3 && fields[0].equals(this.getUserId())) {
                    if (fields[2].equals(oldPassword)) {
                        fields[2] = newPassword;
                        passwordChanged = true;
                    }
                }
                updatedLines.add(String.join(";", fields));
            }

            if (passwordChanged) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(lecturerFilePath))) {
                    for (String updatedLine : updatedLines) {
                        bw.write(updatedLine);
                        bw.newLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passwordChanged;
    }
}
