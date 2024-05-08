/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package academicguidancehubgui;

import academicguidancehub.User;
import academicguidancehub.ReadOperations;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GeneralLoginPage extends javax.swing.JFrame {

    private ArrayList<User> userList;
    
    public GeneralLoginPage() {
        initComponents();
        setSize(700,625);
        setResizable(false);
        forgetPw.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        loginB = new javax.swing.JButton();
        cancelB = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        userID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        forgetPw = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel3.setText("Login Page");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 153), 3));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loginB.setText("Login");
        loginB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBActionPerformed(evt);
            }
        });
        jPanel6.add(loginB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 80, 30));

        cancelB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelB.setText("Cancel");
        cancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBActionPerformed(evt);
            }
        });
        jPanel6.add(cancelB, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 80, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("User ID");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        userID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIDActionPerformed(evt);
            }
        });
        jPanel6.add(userID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 200, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Password");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        forgetPw.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        forgetPw.setForeground(new java.awt.Color(255, 51, 51));
        forgetPw.setText("Forget Password");
        forgetPw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgetPwMouseClicked(evt);
            }
        });
        jPanel6.add(forgetPw, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));
        jPanel6.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 190, 30));
        jPanel6.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 200, 30));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 450, 230));

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 700, 120));

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("jLabel1");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 130));

        getContentPane().add(jPanel7, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBActionPerformed
        String enteredID = userID.getText();
        String enteredPassword = new String(password.getPassword());

        if(enteredPassword.length()==0){
            forgetPw.setVisible(true);
        }
        
        User user = findUserByID(enteredID);

        if (user != null) {
            if (enteredPassword.equals(user.getPassword())) {
                switch (user.getRole()) {
                    case "Student":
                        JOptionPane.showMessageDialog(null, "Welcome to Student Page.", "Student Page", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "Lecturer":
                        JOptionPane.showMessageDialog(null, "Welcome to Lecturer Page.", "Lecturer Page", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "Project Manager":
                        JOptionPane.showMessageDialog(null, "Welcome to Project manager Page.", "PM Page", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "Admin":
                        AdminDashboard adD = new AdminDashboard();
                        adD.setVisible(true);
                        this.dispose();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Error in programming code! Please check.", "Login Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect password", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "User not found", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginBActionPerformed

    private void userIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userIDActionPerformed

    private void cancelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBActionPerformed

    private void forgetPwMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgetPwMouseClicked
        dispose();
        GeneralForgetPassword obj = new GeneralForgetPassword();
        obj.setVisible(true);
    }//GEN-LAST:event_forgetPwMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GeneralLoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneralLoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneralLoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneralLoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneralLoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelB;
    private javax.swing.JLabel forgetPw;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton loginB;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField userID;
    // End of variables declaration//GEN-END:variables

    private User findUserByID(String enteredID) {
        ReadOperations reader = new ReadOperations();
        if (enteredID.startsWith("ST")) {
            userList = reader.readUserData("src/textfiles/Students.txt");
            System.out.println("User List Size: " + userList.size()); // Debugging
            for (User user : userList) {
                System.out.println("User ID: " + user.getUserId()); // Debugging
                if (user.getUserId().equals(enteredID)) {
                    System.out.println("User Found!"); // Debugging
                    return user;
                }
            }
        } else if (enteredID.startsWith("LC")) {
            userList = reader.readUserData("src/textfiles/Staff.txt");
            System.out.println("User List Size: " + userList.size()); // Debugging
            for (User user : userList) {
                System.out.println("User ID: " + user.getUserId()); // Debugging
                if (user.getUserId().equals(enteredID)) {
                    System.out.println("User Found!"); // Debugging
                    return user;
                }
            }
        } else if (enteredID.startsWith("AD")) {
            userList = reader.readUserData("src/textfiles/Admin.txt");
            System.out.println("User List Size: " + userList.size()); // Debugging
            for (User user : userList) {
                System.out.println("User ID: " + user.getUserId()); // Debugging
                if (user.getUserId().equals(enteredID)) {
                    System.out.println("User Found!"); // Debugging
                    return user;
                }
            }
        }
        System.out.println("User Not Found!"); // Debugging
        return null;
    }
}
