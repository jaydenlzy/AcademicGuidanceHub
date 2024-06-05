package academicguidancehub;

import java.util.List; // Correct import for List
import java.util.ArrayList; // Correct import for ArrayList
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Lecturer extends User implements FileLocationInterface {

    private Map<String, String> lecturerMap; // Changed to proper instance variables
    private Map<String, String> studentMap;

    public Lecturer(String userId, String name, String password, String email, String contact, String role) {
        super(userId, name, password, email, contact, role);
        lecturerMap = new HashMap<>();
        studentMap = new HashMap<>();
        loadLecturerData();
        loadStudentData();
    }

    // Constructor from an existing User object
    public Lecturer(User user) {
        super(user.getUserId(), user.getName(), user.getPassword(), user.getEmail(), user.getContact(), user.getRole());
        lecturerMap = new HashMap<>();
        studentMap = new HashMap<>();
        loadLecturerData();
        loadStudentData();
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
}
