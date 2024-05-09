/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academicguidancehub;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author New HP
 */
public class CreateNewIntake {
    
    private static final String intakeRecordfile = "src/textfiles/intakesType.txt";
    
    public static void createNewIntake(String intakeCode, String intakeName, String intakeDate) {
        String createDate = getCurrentDate();
        
        String intakeRecord = intakeCode + ";" + intakeName + ";" + intakeDate + ";" + createDate;
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(intakeRecordfile, true))) {
            writer.write(intakeRecord);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            File file = new File("src/textfiles/Student"+intakeCode+".txt");
            if (file.createNewFile()) {
                System.out.println("Empty text file created successfully.");
            } else {
                System.out.println("Empty text file already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }
}
