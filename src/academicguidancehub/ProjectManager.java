/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academicguidancehub;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Lzy
 */
public class ProjectManager extends User implements FileLocationInterface {

    public ProjectManager(String userId, String name, String password, String email, String contact, String role) {
        super(userId, name, password, email, contact, role);
    }

    public ProjectManager(User user) {
        super(user.getUserId(), user.getName(), user.getPassword(), user.getEmail(), user.getContact(), user.getRole());
    }

    public void createProjectTypeFile() {
        File file = new File(projectTypePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("An error occurred while creating the file: " + e.getMessage());
        }
    }

    public void createProjectsFile() {
        File file = new File(projectsFilePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("An error occurred while creating the file: " + e.getMessage());
        }
    }

    public void createResultFile() {
        File file = new File(resultsFilePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("An error occurred while creating the file: " + e.getMessage());
        }
    }

}
