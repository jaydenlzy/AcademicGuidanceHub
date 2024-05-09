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
public class RegisterNewLecturer {
    
    private static final String lecturerRecordfile = "src/textfiles/Staff.txt";
    
    public static void registerLecturer(String name, String contact) {
        String lecturerID = generateLecturerID();
        String password = generatePassword(lecturerID, name);
        String email = generateEmail(name);
        String createDate = getCurrentDate();
        String role = "Lecturer";
        
        String lecturerRecord = lecturerID + ";" + name + ";" + password + ";" + email + ";" + contact + ";" + createDate + ";" + role;
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(lecturerRecordfile, true))) {
            writer.write(lecturerRecord);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedWriter writer2 = new BufferedWriter(new FileWriter("src/textfiles/Lecturer.txt", true))) {
            writer2.write(lecturerRecord);
            writer2.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateLecturerID() {
        return "LC" + String.format("%06d", getNextLecturerID());
    }

    private static String generatePassword(String lecturerID, String name) {
        String[] parts = name.split(" "); 
        String firstName = parts[0]; 
        return lecturerID + "#" + firstName;
    }

    private static String generateEmail(String name) {
        return name.toLowerCase().replace(" ", "") + "@gmail.com";
    }

    private static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }

    private static int getNextLecturerID() {
        int nextID = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(lecturerRecordfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String lecturerID = parts[0].trim(); 
                String number = lecturerID.substring(2); 
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
