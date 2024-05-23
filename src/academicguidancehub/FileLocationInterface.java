/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package academicguidancehub;

/**
 *
 * @author Lzy
 */
public interface FileLocationInterface { 
    // this interface is to simplify different paths during reading and writing text files
    final String path = "src/textfiles/";
    public final String adminFilePath = path + "Admin.txt";
    public final String lecturerFilePath = path + "Lecturer.txt";
    public final String projectManagerPath = path + "ProjectManager.txt";
    public final String studentFilePath = path + "Students.txt";
    public final String schoolListPath = path + "SchoolWiseList.txt";
    public final String intakeListPath = path + "intakesType.txt";
    public final String projectTypePath = path + "ProjectType.txt";
    public final String projectsFilePath = path + "Projects.txt";
    public final String resultsFilePath = path + "Results.txt";
    
}   
 
