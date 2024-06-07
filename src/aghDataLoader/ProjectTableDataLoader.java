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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ProjectTableDataLoader extends DataLoader {

    private JTable table;
    private String tableType;

    public ProjectTableDataLoader(String filePath, JTable table, String tableType) {
        super(filePath);
        this.table = table;
        this.tableType = tableType;
    }

    @Override
    public void loadData() {
        try {
            List<Project> projects = Project.loadProjectsFromFile(projectsFilePath);

            if (tableType.equals("projectType")) {
                loadProjectTypeTable(projects);
            } else if (tableType.equals("projectStatusIntakeTable")) {
                loadProjectStatusTable(projects, true);
            } else if (tableType.equals("projectStatusIndividualTable")) {
                loadProjectStatusTable(projects, false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadProjectTypeTable(List<Project> projects) throws IOException {
        Map<String, ProjectStatistics> statisticsMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(projectTypePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 4) {
                    String category = data[0];
                    String preferredSchool = data[1];
                    String requireSecondMarker = data[2];
                    String requirePresentation = data[3];
                    statisticsMap.put(category, new ProjectStatistics(category, preferredSchool, requireSecondMarker, requirePresentation));
                }
            }
        }

        for (Project project : projects) {
            ProjectStatistics stats = statisticsMap.get(project.getProjectCategory());
            if (stats != null) {
                stats.incrementTotalCount();
                if ("done".equalsIgnoreCase(project.getStatus())) {
                    stats.incrementDoneProject();
                } else {
                    stats.incrementOngoingProject();
                }
            }
        }

        // Prepare table data
        String[][] tableData = new String[statisticsMap.size()][6];
        int index = 0;
        for (ProjectStatistics stats : statisticsMap.values()) {
            tableData[index][0] = stats.category;
            tableData[index][1] = stats.preferredSchool;
            tableData[index][2] = String.valueOf(stats.ongoingProject);
            tableData[index][3] = String.valueOf(stats.doneProject);
            tableData[index][4] = stats.requireSecondMarker;
            tableData[index][5] = stats.requirePresentation;
            index++;
        }

        populateTable(tableData, new String[]{"Project Category", "Preferred School", "Ongoing Project", "Done Project", "Require Second Marker", "Require Presentation"});
    }

    private void loadProjectStatusTable(List<Project> projects, boolean isIntake) {
        List<String[]> tableDataList = new ArrayList<>();
        Map<String, List<Project>> projectGroups = new HashMap<>();

        for (Project project : projects) {
            projectGroups.computeIfAbsent(project.getProjectID(), k -> new ArrayList<>()).add(project);
        }

        for (Map.Entry<String, List<Project>> entry : projectGroups.entrySet()) {
            String projectID = entry.getKey();
            List<Project> projectList = entry.getValue();

            if ((isIntake && projectList.size() > 1) || (!isIntake && projectList.size() == 1)) {
                for (Project project : projectList) {
                    tableDataList.add(new String[]{
                        project.getProjectCategory(),
                        project.getProjectTitle(),
                        project.getProjectDueDate(),
                        project.getStudentIntake(),
                        project.getStudentID(),
                        project.getSupervisorID(),
                        project.getSecondMarkerID(),
                        project.getStatus() != null ? project.getStatus() : "NA" // Handle cases where status might be missing
                    });
                }
            }
        }

        String[][] tableData = tableDataList.toArray(new String[0][]);
        populateTable(tableData, new String[]{"Project Category", "Project Title", "Project Due Date", "Student Intake", "Student ID", "Supervisor Name", "Second Marker Name", "Status"});
    }

    private void populateTable(String[][] data, String[] headers) {
        DefaultTableModel model = new DefaultTableModel(data, headers);
        table.setModel(model);
    }

    private static class ProjectStatistics {

        String category;
        String preferredSchool;
        String requireSecondMarker;
        String requirePresentation;
        int ongoingProject = 0;
        int doneProject = 0;

        ProjectStatistics(String category, String preferredSchool, String requireSecondMarker, String requirePresentation) {
            this.category = category;
            this.preferredSchool = preferredSchool;
            this.requireSecondMarker = requireSecondMarker;
            this.requirePresentation = requirePresentation;
        }

        void incrementTotalCount() {
            ongoingProject++;
        }

        void incrementOngoingProject() {
            ongoingProject++;
        }

        void incrementDoneProject() {
            doneProject++;
        }
    }
}
