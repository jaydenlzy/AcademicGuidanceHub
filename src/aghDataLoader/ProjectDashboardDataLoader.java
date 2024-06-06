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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProjectDashboardDataLoader extends DataLoader {

    private final JLabel lblCurrentProj;
    private final JLabel lblCommonProj;
    private final JLabel lblDoneProj;
    private final JLabel lblActiveSupervisors;

    public ProjectDashboardDataLoader(String filePath, JLabel lblCurrentProj, JLabel lblCommonProj, JLabel lblDoneProj, JLabel lblActiveSupervisors) {
        super(filePath);
        this.lblCurrentProj = lblCurrentProj;
        this.lblCommonProj = lblCommonProj;
        this.lblDoneProj = lblDoneProj;
        this.lblActiveSupervisors = lblActiveSupervisors;
    }

    @Override
    public void loadData() {
        try {
            List<Project> projects = Project.loadProjectsFromFile(projectsFilePath);

            int currentOngoingProjects = 0;
            int totalDoneProjects = 0;
            Map<String, Integer> projectCategoryCounts = new HashMap<>();
            Set<String> activeSupervisors = new HashSet<>();

            for (Project project : projects) {
                if ("pending".equalsIgnoreCase(project.getStatus())) {
                    currentOngoingProjects++;
                    projectCategoryCounts.put(project.getProjectCategory(), projectCategoryCounts.getOrDefault(project.getProjectCategory(), 0) + 1);
                    activeSupervisors.add(project.getSupervisorID());
                } else if ("done".equalsIgnoreCase(project.getStatus())) {
                    totalDoneProjects++;
                }
            }

            String mostCommonProjectCategory = null;
            int maxCount = 0;
            for (Map.Entry<String, Integer> entry : projectCategoryCounts.entrySet()) {
                if (entry.getValue() > maxCount) {
                    mostCommonProjectCategory = entry.getKey();
                    maxCount = entry.getValue();
                }
            }

            // Update the labels
            lblCurrentProj.setText(String.valueOf(currentOngoingProjects));
            lblCommonProj.setText(mostCommonProjectCategory + " (" + maxCount + ")");
            lblDoneProj.setText(String.valueOf(totalDoneProjects));
            lblActiveSupervisors.setText(String.valueOf(activeSupervisors.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
