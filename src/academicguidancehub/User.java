/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academicguidancehub;

/**
 *
 * @author New HP
 */
public class User {
    private String UserId;
    private String name;
    private String email;
    private String role;
    private String UserPassword;

    public User(String userId, String name, String email, String role, String password) {
        this.UserId = userId;
        this.name = name;
        this.email = email;
        this.role = role;
        this.UserPassword = password;
    }

    public String getUserId() {
        return UserId;
    }

    public String getUserPassword() {
        return UserPassword;
    }
    
    public String getRole(){
        return role;
    }
}
