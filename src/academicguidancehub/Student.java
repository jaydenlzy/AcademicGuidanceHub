/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academicguidancehub;


/**
 *
 * @author isaac
 */
public class Student extends User implements FileLocationInterface {
    
    public Student(String userId, String name, String password, String email, String contact, String role) {
        super(userId, name, password, email, contact, role);
    }

    public Student(User user) {
        super(user.getUserId(), user.getName(), user.getPassword(), user.getEmail(), user.getContact(), user.getRole());
    }
    
}
