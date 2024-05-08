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
    private String password;
    private String email;
    private String contact;
    private String createDate;
    private String role;

    public User(String userId, String name, String password, String email, String contact, String createDate, String role) {
        this.UserId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.contact = contact;
        this.createDate = createDate;
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return UserId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getRole() {
        return role;
    }
}