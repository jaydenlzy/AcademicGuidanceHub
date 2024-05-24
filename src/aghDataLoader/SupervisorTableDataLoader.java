/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aghDataLoader;

/**
 *
 * @author Lzy
 */

import academicguidancehub.FileLocationInterface;
import academicguidancehub.Project;
import javax.swing.JTable;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupervisorTableDataLoader extends TableDataLoader {

    public SupervisorTableDataLoader(JTable table) {
        super(FileLocationInterface.lecturerFilePath, table);
    }

    @Override
    protected String[] getTableHeaders() {
        return new String[]{"Lecturer ID", "Name", "School", "Supervisor Of", "Second Marker Of", "Projects Completed"};
    }

    @Override
    protected int[] getColumnIndices() {
        return new int[]{0, 1, 6}; //lecturer ID, name, and school are at indices 0, 1, and 6
    }

    @Override
    public void loadData() {
        try {
            // Read lecturers data
            String[][] lecturersData = fileReaderUtils.readData(lecturerFilePath, ";", getColumnIndices());

            // Map to hold supervisor statistics
            Map<String, SupervisorStatistics> statisticsMap = new HashMap<>();

            for (String[] lecturer : lecturersData) {
                String lecturerID = lecturer[0];
                String name = lecturer[1];
                String school = lecturer[2];

                // Initialize statistics for each lecturer
                statisticsMap.put(lecturerID, new SupervisorStatistics(name, school));
            }

            // Load project data using Project class
            List<Project> projects = Project.loadProjectsFromFile(projectsFilePath);

            for (Project project : projects) {
                String supervisorID = project.getSupervisorID();
                String secondMarkerID = project.getSecondMarkerID();
                String status = project.getStatus();

                // Update supervisor statistics based on project data
                if (statisticsMap.containsKey(supervisorID)) {
                    statisticsMap.get(supervisorID).incrementSupervisorOf();
                }
                if (statisticsMap.containsKey(secondMarkerID)) {
                    statisticsMap.get(secondMarkerID).incrementSecondMarkerOf();
                }
                // Increment projects completed for supervisor and second marker
                if ("Completed".equalsIgnoreCase(status)) {
                    if (statisticsMap.containsKey(supervisorID)) {
                        statisticsMap.get(supervisorID).incrementProjectsCompleted();
                    }
                }
            }

            // Prepare data for the table
            String[][] tableData = new String[statisticsMap.size()][6];
            int index = 0;
            for (Map.Entry<String, SupervisorStatistics> entry : statisticsMap.entrySet()) {
                SupervisorStatistics stats = entry.getValue();
                tableData[index][0] = entry.getKey();
                tableData[index][1] = stats.name;
                tableData[index][2] = stats.school;
                tableData[index][3] = String.valueOf(stats.supervisorOf);
                tableData[index][4] = String.valueOf(stats.secondMarkerOf);
                tableData[index][5] = String.valueOf(stats.projectsCompleted);
                index++;
            }

            populateTable(tableData);
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace for any exceptions
        }
    }

    private static class SupervisorStatistics {
        String name;
        String school;
        int supervisorOf = 0;
        int secondMarkerOf = 0;
        int projectsCompleted = 0;

        SupervisorStatistics(String name, String school) {
            this.name = name;
            this.school = school;
        }

        void incrementSupervisorOf() {
            supervisorOf++;
        }

        void incrementSecondMarkerOf() {
            secondMarkerOf++;
        }

        void incrementProjectsCompleted() {
            projectsCompleted++;
        }
    }
}
