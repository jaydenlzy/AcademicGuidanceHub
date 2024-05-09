/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academicguidancehub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author New HP
 */
public class RegisterNewStudent {
    
    private static final String studentRecordfile = "src/textfiles/Students.txt";
    
    public static void registerStudent(String name, String contact, String intake) {
        String studentID = generateStudentID();
        String password = generatePassword(studentID, name);
        String email = generateEmail(name);
        String createDate = getCurrentDate();
        String role = "Student";
        
        String studentRecord = studentID + ";" + name + ";" + password + ";" + email + ";" + contact + ";" + createDate + ";" + role + ";" + intake;
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(studentRecordfile, true))) {
            writer.write(studentRecord);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedWriter writer2 = new BufferedWriter(new FileWriter("src/textfiles/Student"+intake+".txt", true))) {
            writer2.write(studentRecord);
            writer2.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateStudentID() {
        return "ST" + String.format("%06d", getNextStudentID());
    }

    private static String generatePassword(String studentID, String name) {
        return studentID + "@" + getInitials(name);
    }

    private static String generateEmail(String name) {
        return name.toLowerCase().replace(" ", "") + "@gmail.com";
    }

    private static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }

    private static int getNextStudentID() {
        int nextID = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(studentRecordfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String studentID = parts[0].trim(); // Extract student ID from each line
                String number = studentID.substring(2); // Remove the "ST" prefix
                int id = Integer.parseInt(number);
                if (id > nextID) {
                    nextID = id;
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return nextID + 1;
    }

    private static String getInitials(String name) {
        StringBuilder initials = new StringBuilder();
        String[] parts = name.split(" ");
        for (String part : parts) {
            initials.append(part.charAt(0));
        }
        return initials.toString().toUpperCase();
    }
}
