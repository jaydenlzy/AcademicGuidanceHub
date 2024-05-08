/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academicguidancehub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadOperations {
    public ArrayList<User> readUserData(String filePath) {
        ArrayList<User> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String UserId = parts[0];
                String name = parts[1];
                String email = parts[3];
                String contact = parts[4];
                String createDate = parts[5];
                String role = parts[6];
                String UserPassword = parts[2]; 
                userList.add(new User(UserId,name,UserPassword,email,contact,createDate,role));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
