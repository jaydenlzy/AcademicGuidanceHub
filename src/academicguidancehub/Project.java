/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academicguidancehub;

/**
 *
 * @author Lzy
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Project {
    private String projectID;
    private String projectCategory;
    private String projectTitle;
    private String projectDueDate;
    private boolean requirePresentation;
    private String studentIntake;
    private String studentID;
    private String supervisorID;
    private String secondMarkerID;
    private String status;

    // Constructor
    public Project(String projectID, String projectCategory, String projectTitle, String projectDueDate, boolean requirePresentation, String studentIntake, String studentID, String supervisorID, String secondMarkerID, String status) {
        this.projectID = projectID;
        this.projectCategory = projectCategory;
        this.projectTitle = projectTitle;
        this.projectDueDate = projectDueDate;
        this.requirePresentation = requirePresentation;
        this.studentIntake = studentIntake;
        this.studentID = studentID;
        this.supervisorID = supervisorID;
        this.secondMarkerID = secondMarkerID;
        this.status = status;
    }

    // Getters
    public String getProjectID() {
        return projectID;
    }

    public String getProjectCategory() {
        return projectCategory;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public String getProjectDueDate() {
        return projectDueDate;
    }

    public boolean isRequirePresentation() {
        return requirePresentation;
    }

    public String getStudentIntake() {
        return studentIntake;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getSupervisorID() {
        return supervisorID;
    }

    public String getSecondMarkerID() {
        return secondMarkerID;
    }

    public String getStatus() {
        return status;
    }

    // Method to load projects from file
    public static List<Project> loadProjectsFromFile(String filePath) throws IOException {
        List<Project> projects = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 10) {
                boolean requirePresentation = "Yes".equalsIgnoreCase(data[4]);
                projects.add(new Project(data[0], data[1], data[2], data[3], requirePresentation, data[5], data[6], data[7], data[8], data[9]));
            } else {
                System.err.println("Skipping line due to incorrect number of fields: " + line);
            }
        }
        reader.close();
        return projects;
    }
}
