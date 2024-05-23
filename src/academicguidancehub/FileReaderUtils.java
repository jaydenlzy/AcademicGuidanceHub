/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academicguidancehub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author New HP
 */

public class FileReaderUtils {
    public static String[][] readData(String filePath, String delimiter, int[] columnIndices) {
        ArrayList<String[]> dataList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(delimiter);
                if (values.length >= columnIndices.length) {
                    String[] selectedValues = new String[columnIndices.length];
                    for (int i = 0; i < columnIndices.length; i++) {
                        int columnIndex = columnIndices[i];
                        selectedValues[i] = values[columnIndex];
                    }
                    dataList.add(selectedValues);
                }
            }

            // Convert ArrayList to a 2D String array
            String[][] data = new String[dataList.size()][];
            for (int i = 0; i < dataList.size(); i++) {
                data[i] = dataList.get(i);
            }

            return data;
        } catch (IOException e) {
            return null;
        }
    }

    public static boolean writeData(String filePathSchoolWiseList, DefaultTableModel stList, String delimiter, int[] schoolWiseListColumnIndices) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
