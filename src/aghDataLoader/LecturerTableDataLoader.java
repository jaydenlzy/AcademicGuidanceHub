/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aghDataLoader;

/**
 *
 * @author Lzy
 */
import academicguidancehub.Project;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LecturerTableDataLoader extends DataLoader {

    private JTable table;

    public LecturerTableDataLoader(String filePath, JTable table) {
        super(filePath);
        this.table = table;
    }

    @Override
    public void loadData() {
        try {
            List<Project> projects = Project.loadProjectsFromFile(projectsFilePath);
            Map<String, Lecturer> lecturers = loadLecturers();

            // Update lecturer statistics with project data
            for (Project project : projects) {
                Lecturer supervisor = lecturers.get(project.getSupervisorID());
                if (supervisor != null) {
                    supervisor.incrementSupervisedProjects();
                    if ("done".equalsIgnoreCase(project.getStatus())) {
                        supervisor.incrementCompletedProjects();
                    } else {
                        supervisor.incrementOngoingProject();
                    }
                }
                Lecturer secondMarker = lecturers.get(project.getSecondMarkerID());
                if (secondMarker != null) {
                    secondMarker.incrementSecondMarkerProjects();
                }
            }

            // Prepare table data
            String[][] tableData = new String[lecturers.size()][6];
            int index = 0;
            for (Lecturer lecturer : lecturers.values()) {
                tableData[index][0] = lecturer.getLecturerID();
                tableData[index][1] = lecturer.getLecturerName();
                tableData[index][2] = lecturer.getSchool();
                tableData[index][3] = String.valueOf(lecturer.getSupervisedProjectsCount());
                tableData[index][4] = String.valueOf(lecturer.getSecondMarkerProjectsCount());
                tableData[index][5] = String.valueOf(lecturer.getCompletedProjectsCount());
                index++;
            }

            populateTable(tableData, new String[]{"LecturerID", "LecturerName", "School", "Supervisor of (Count)", "Second Marker of (Count)", "ProjectCompleted"});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Lecturer> loadLecturers() throws IOException {
        Map<String, Lecturer> lecturers = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(lecturerFilePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(";");
            if (data.length == 7) {
                String lecturerID = data[0];
                String lecturerName = data[1];
                String school = data[6];
                lecturers.put(lecturerID, new Lecturer(lecturerID, lecturerName, school));
            } else {}
        }
        reader.close();
        return lecturers;
    }

    private void populateTable(String[][] data, String[] headers) {
        DefaultTableModel model = new DefaultTableModel(data, headers);
        table.setModel(model);
    }

    private static class Lecturer {
        private final String lecturerID;
        private final String lecturerName;
        private final String school;
        private int supervisedProjectsCount = 0;
        private int secondMarkerProjectsCount = 0;
        private int completedProjectsCount = 0;
        private int ongoingProjectsCount = 0;

        public Lecturer(String lecturerID, String lecturerName, String school) {
            this.lecturerID = lecturerID;
            this.lecturerName = lecturerName;
            this.school = school;
        }

        public String getLecturerID() {
            return lecturerID;
        }

        public String getLecturerName() {
            return lecturerName;
        }

        public String getSchool() {
            return school;
        }

        public int getSupervisedProjectsCount() {
            return supervisedProjectsCount;
        }

        public int getSecondMarkerProjectsCount() {
            return secondMarkerProjectsCount;
        }

        public int getCompletedProjectsCount() {
            return completedProjectsCount;
        }

        public int getOngoingProjectsCount() {
            return ongoingProjectsCount;
        }

        public void incrementSupervisedProjects() {
            supervisedProjectsCount++;
        }

        public void incrementSecondMarkerProjects() {
            secondMarkerProjectsCount++;
        }

        public void incrementCompletedProjects() {
            completedProjectsCount++;
        }

        public void incrementOngoingProject() {
            ongoingProjectsCount++;
        }
    }
}
