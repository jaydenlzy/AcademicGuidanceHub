package academicguidancehub;

import java.util.List; // Correct import for List
import java.util.ArrayList; // Correct import for ArrayList
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lecturer extends User implements FileLocationInterface {

    public Lecturer(String userId, String name, String password, String email, String contact, String role) {
        super(userId, name, password, email, contact, role);
    }

    // Constructor from an existing User object
    public Lecturer(User user) {
        super(user.getUserId(), user.getName(), user.getPassword(), user.getEmail(), user.getContact(), user.getRole());
    }

    public List<String> getPendingTasks() {
        List<String> tasks = new ArrayList<>();
        String filePath = projectsFilePath; // replace with actual path to your task file

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                String taskLecturerId = fields[7]; // assuming 8th field is LC ID (index 7)
                String secondMarkerId = fields[8]; // assuming 9th field is second marker ID (index 8)
                String status = fields[9]; // assuming 10th field is status (index 9)

                // Check if the task is pending and assigned to the current lecturer or second marker
                if ((this.getUserId().equals(taskLecturerId) || this.getUserId().equals(secondMarkerId))
                        && "Pending".equalsIgnoreCase(status)) {
                    tasks.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tasks;
    }

}
