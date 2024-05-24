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

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectTableDataLoader extends TableDataLoader implements FileLocationInterface {

    public ProjectTableDataLoader(JTable table) {
        super(projectsFilePath, table);
    }

    @Override
    protected String[] getTableHeaders() {
        return new String[]{"Project Category", "Preferred School", "Total Count", "Ongoing Project", "Done Project", "Require Presentation", "Delete"};
    }

    @Override
    protected int[] getColumnIndices() {
        return new int[]{0, 1}; 
    }

    @Override
    public void loadData() {
        try {
            // Load project types
            Map<String, String> projectTypes = Project.loadProjectTypesFromFile(projectTypePath);

            // Load projects
            List<Project> projects = Project.loadProjectsFromFile(projectsFilePath);

            // Statistics maps
            Map<String, ProjectStatistics> statisticsMap = new HashMap<>();

            for (Project project : projects) {
                String category = project.getProjectCategory();
                boolean requirePresentation = project.isRequirePresentation();
                String status = project.getStatus();

                String preferredSchool = projectTypes.getOrDefault(category, "Unknown");
                statisticsMap.putIfAbsent(category, new ProjectStatistics(category, preferredSchool));

                ProjectStatistics stats = statisticsMap.get(category);
                stats.incrementTotalCount();
                if (requirePresentation) {
                    stats.setRequirePresentation(true);
                }
                if ("done".equalsIgnoreCase(status)) {
                    stats.incrementDoneProject();
                } else {
                    stats.incrementOngoingProject();
                }
            }

            // Prepare data for the table
            String[][] tableData = new String[statisticsMap.size()][7];
            int index = 0;
            for (Map.Entry<String, ProjectStatistics> entry : statisticsMap.entrySet()) {
                ProjectStatistics stats = entry.getValue();
                tableData[index][0] = stats.category;
                tableData[index][1] = stats.preferredSchool;
                tableData[index][2] = String.valueOf(stats.totalCount);
                tableData[index][3] = String.valueOf(stats.ongoingProject);
                tableData[index][4] = String.valueOf(stats.doneProject);
                tableData[index][5] = String.valueOf(stats.requirePresentation);
                tableData[index][6] = "Delete"; // Placeholder for the Edit button
                index++;
            }

            populateTable(tableData);
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace for any exceptions
        }
    }

    private static class ProjectStatistics {
        String category;
        String preferredSchool;
        int totalCount = 0;
        int ongoingProject = 0;
        int doneProject = 0;
        boolean requirePresentation = false;

        ProjectStatistics(String category, String preferredSchool) {
            this.category = category;
            this.preferredSchool = preferredSchool;
        }

        void incrementTotalCount() {
            totalCount++;
        }

        void incrementOngoingProject() {
            ongoingProject++;
        }

        void incrementDoneProject() {
            doneProject++;
        }

        void setRequirePresentation(boolean requirePresentation) {
            this.requirePresentation = requirePresentation;
        }
    }
}