/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academicguidancehub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author New HP
 */
public class Admin extends User implements FileLocationInterface{
    
    public Admin(String userId, String name, String password, String email, String contact, String role) {
        super(userId, name, password, email, contact, role);
    }
    
    public void removeIntake(String intakeCode) {
        File file = new File(intakeListPath);
        String delimiter = ";";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                // Split the line by the delimiter to check if it contains the specified 'intakeCode'
                String[] parts = line.split(delimiter);
                if (!parts[0].equals(intakeCode)) { // If the 'intakeCode' doesn't match, keep the line
                    content.append(line).append(System.lineSeparator());
                }
            }
            reader.close();

            // Write the updated content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content.toString());
            writer.close();

            JOptionPane.showMessageDialog(null, "Intake deleted successfully!", "INTAKE DELETE SUCCESS", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error deleting intake!", "INTAKE DELETE ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editSchoolWise(String schoolName, String newName) {
        File filePath = new File(schoolListPath);
        String delimiter = ";";
        try {
            // Read the existing data from the file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String rec;
            StringBuilder content = new StringBuilder();
            while ((rec = br.readLine()) != null) {
                // Split the line by the delimiter to check if it contains the specified 'schoolName'
                String[] parts = rec.split(delimiter);
                if (parts[0].equals(schoolName)) { // If the 'schoolName' matches, update the line with the new name
                    content.append(newName).append(System.lineSeparator());
                } else {
                    content.append(rec).append(System.lineSeparator());
                }
            }
            br.close();

            // Write the updated data back to the file
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(content.toString());
            bw.close();

            JOptionPane.showMessageDialog(null, "Edit school wise successfully!", "MODIFY SUCCESS", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error editing school wise!", "MODIFY ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Example method to demonstrate an administrative action
    public void resetPassword(User user, String newPassword) {
        user.setPassword(newPassword);
        JOptionPane.showMessageDialog(null, "Password reset successfully!");
    }

    // Example method for managing intakes table content
    public void intakesTableContent(DefaultTableModel tableModel) {
        File filePathClassType = new File(intakeListPath);
        String delimiter = ";";
        int[] classTypeColumnIndices = {0, 1, 2};
        try {
            // Read data from the file and populate the table model
            BufferedReader br = new BufferedReader(new FileReader(filePathClassType));
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(delimiter);
                tableModel.addRow(row);
            }
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Example method for managing school wise table content
    public void schoolWiseTableContent(DefaultTableModel tableModel) {
        File filePathClassType = new File(schoolListPath);
        String delimiter = ";";
        int[] classTypeColumnIndices = {0};
        try {
            // Read data from the file and populate the table model
            BufferedReader br = new BufferedReader(new FileReader(filePathClassType));
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(delimiter);
                tableModel.addRow(row);
            }
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
