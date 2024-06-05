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

public class Lecturer extends User implements FileLocationInterface {

    private Map<String, String> lecturerMap; // Changed to proper instance variables
    private Map<String, String> studentMap;
    private Map<String, String> projectMap;

    public Lecturer(String userId, String name, String password, String email, String contact, String role) {
        super(userId, name, password, email, contact, role);
        lecturerMap = new HashMap<>();
        studentMap = new HashMap<>();
        projectMap = new HashMap<>();
        loadLecturerData();
        loadStudentData();
        loadProjectData();
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

    public void acceptPresentation(String projectId, String studentId) {
        // Implement logic to accept presentation
        updateResultFile(projectId, studentId, "accept");
    }

    public void rejectPresentation(String projectId, String studentId) {
        // Implement logic to reject presentation
        updateResultFile(projectId, studentId, "reject");
    }

    private void updateResultFile(String projectId, String studentId, String status) {
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
    }
}
