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
        return new String[]{"Project Category", "Preferred School", "Total Count", "Ongoing Project", "Done Project", "Require Presentation"};
    }

    @Override
    protected int[] getColumnIndices() {
        return new int[]{0, 1};
    }

    @Override
    public void loadData() {
        try {
            Map<String, String> projectTypes = Project.loadProjectTypesFromFile(projectTypePath);

            List<Project> projects = Project.loadProjectsFromFile(projectsFilePath);

            Map<String, ProjectStatistics> statisticsMap = new HashMap<>();

            // Populate statistics map with project types even if they don't have corresponding projects
            for (Map.Entry<String, String> entry : projectTypes.entrySet()) {
                String category = entry.getKey();
                String preferredSchool = entry.getValue();
                statisticsMap.put(category, new ProjectStatistics(category, preferredSchool));
            }

            // Update statistics for existing projects
            for (Project project : projects) {
                String category = project.getProjectCategory();
                boolean requirePresentation = project.isRequirePresentation();
                String status = project.getStatus();

                ProjectStatistics stats = statisticsMap.get(category);
                if (stats == null) { // In case the project type is not in the projectTypes file
                    stats = new ProjectStatistics(category, "Unknown");
                    statisticsMap.put(category, stats);
                }

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
                index++;
            }

            populateTable(tableData);
        } catch (IOException e) {
            e.printStackTrace();
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
