/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academicguidancehub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author New HP
 */
public class FileHandler {
    public static int countRecords(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int count = 0;
        while (reader.readLine() != null) {
            count++;
        }
        reader.close();
        return count;
    }
}
