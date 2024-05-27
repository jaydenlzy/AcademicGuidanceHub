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
import java.util.List;

public class ProjectTableDataLoader extends TableDataLoader implements FileLocationInterface {

    public ProjectTableDataLoader(JTable table) {
        super(projectsFilePath, table);
    }

    @Override
    protected String[] getTableHeaders() {
        return new String[]{
            "Project ID", "Project Category", "Project Title", "Project Due Date","Require Presentation", "Student Intake", "Student ID", "Supervisor ID","Second Marker ID", "Status"};
    }

    @Override
    protected int[] getColumnIndices() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    @Override
    public void loadData() {
        try {
            List<Project> projects = Project.loadProjectsFromFile(projectsFilePath);

            String[][] tableData = new String[projects.size()][10];
            int index = 0;
            for (Project project : projects) {
                tableData[index][0] = project.getProjectID();
                tableData[index][1] = project.getProjectCategory();
                tableData[index][2] = project.getProjectTitle();
                tableData[index][3] = project.getProjectDueDate();
                tableData[index][4] = String.valueOf(project.isRequirePresentation());
                tableData[index][5] = project.getStudentIntake();
                tableData[index][6] = project.getStudentID();
                tableData[index][7] = project.getSupervisorID();
                tableData[index][8] = project.getSecondMarkerID();
                tableData[index][9] = project.getStatus();
                index++;
            }

            populateTable(tableData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

