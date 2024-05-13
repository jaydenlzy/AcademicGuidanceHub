/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package academicguidancehubgui;

import academicguidancehub.ReadOperations;
import academicguidancehub.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author New HP
 */
public class AdminEditStudent extends javax.swing.JFrame {

    private ArrayList<User> studentList;
    /**
     * Creates new form EditStudentLecturer
     */
    public AdminEditStudent(String id, String name, String password, String email, String contact, String intake) {
        initComponents();
        setSize(900,640);
        setResizable(false);
        
        loadIntakeData();
        
        studentID.setText(id);
        studentName.setText(name);
        studentPassword.setText(password);
        studentEmail.setText(email);
        studentContact.setText(contact);
        studentIntake.setSelectedItem(intake);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        studentName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        studentPassword = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        studentEmail = new javax.swing.JTextField();
        editBt = new javax.swing.JButton();
        cancelBt = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        studentContact = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        studentIntake = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        studentID = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 26)); // NOI18N
        jLabel1.setText("Edit Student Page");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(jLabel1)
                .addContainerGap(353, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(28, 28, 28))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/EditStudentPage.png"))); // NOI18N
        jLabel2.setText("EditStudentPage.png");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 160, 540));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        jLabel3.setText("Student Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, -1, -1));

        studentName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 280, 40));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        jLabel4.setText("Student Password:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, -1));

        studentPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(studentPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 280, 40));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        jLabel5.setText("Student Intake:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, -1, -1));

        studentEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(studentEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 280, 40));

        editBt.setBackground(new java.awt.Color(255, 51, 51));
        editBt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        editBt.setForeground(new java.awt.Color(255, 255, 255));
        editBt.setText("Edit");
        editBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtMouseClicked(evt);
            }
        });
        getContentPane().add(editBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 540, 110, 40));

        cancelBt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancelBt.setText("Cancel");
        cancelBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelBtMouseClicked(evt);
            }
        });
        getContentPane().add(cancelBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 540, 100, 40));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        jLabel6.setText("Student Contact:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, -1, -1));

        studentContact.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(studentContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 280, 40));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        jLabel7.setText("Student Email:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, -1, -1));

        studentIntake.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(studentIntake, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 280, 40));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        jLabel8.setText("Student ID:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        studentID.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        studentID.setEnabled(false);
        getContentPane().add(studentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 280, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtMouseClicked
        this.dispose();
        AdminAmendStudentLecturerDetails obj = new AdminAmendStudentLecturerDetails();
        obj.setVisible(true);
    }//GEN-LAST:event_cancelBtMouseClicked

    private void editBtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtMouseClicked
        String enteredID = studentID.getText();
        User student = findStudentByID(enteredID);
        String newPassword = studentPassword.getText();
        String newEmail = studentEmail.getText();
        String newName = studentName.getText();
        String newContact = studentContact.getText();
        String newIntake = (String)studentIntake.getSelectedItem();
        
        if (student != null) {
            ArrayList<String> studentIDs = new ArrayList();
            String rec;
            BufferedReader br;
            try {
                br = new BufferedReader(new FileReader("src/textfiles/Students.txt"));
                while ((rec = br.readLine()) != null) {
                    String[] record = rec.strip().split(";");
                    System.out.println("" + record[0]);
                    studentIDs.add(record[0]);
                }

            } catch (Exception ex) {
                Logger.getLogger(GeneralForgetPassword.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(int i = 0; i< studentIDs.size(); i++){
                if(enteredID.equals(studentIDs.get(i))){
                    UpdateStudent(enteredID, newName, newPassword, newEmail, newContact, newIntake);
                    break;
                }
            } 
            
            JOptionPane.showMessageDialog(null, "Edit student successfully!", "MODIFY SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            AdminAmendStudentLecturerDetails obj = new AdminAmendStudentLecturerDetails();
            obj.setVisible(true);
        }
    }//GEN-LAST:event_editBtMouseClicked

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
            java.util.logging.Logger.getLogger(AdminEditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminEditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminEditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminEditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBt;
    private javax.swing.JButton editBt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField studentContact;
    private javax.swing.JTextField studentEmail;
    private javax.swing.JTextField studentID;
    private javax.swing.JComboBox<String> studentIntake;
    private javax.swing.JTextField studentName;
    private javax.swing.JTextField studentPassword;
    // End of variables declaration//GEN-END:variables

    private void loadIntakeData() {
        ArrayList<String[]> intakesdataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/textfiles/intakesType.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                studentIntake.addItem(values[0]);
                intakesdataList.add(values);
            }

            // Convert ArrayList to a 2D String array
            String[][] data = new String[intakesdataList.size()][];
            for (int i = 0; i < intakesdataList.size(); i++) {
                data[i] = intakesdataList.get(i);
            }
            //return data;
        } catch (IOException e) {
            //return null;
        }
    }

    private User findStudentByID(String enteredID) {
        ReadOperations reader = new ReadOperations();
        if (enteredID.startsWith("ST")) {
            studentList = reader.readUserData("src/textfiles/Students.txt");
            System.out.println("User List Size: " + studentList.size()); // Debugging
            for (User user : studentList) {
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

    private void UpdateStudent(String enteredID, String newName, String newPassword, String newEmail, String newContact, String newIntake) {
        String filePath = "src/textfiles/Students.txt";
        try (BufferedReader buffer = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            ArrayList<String> updatedLines = new ArrayList<>();

            // Read and update lines
            while ((currentLine = buffer.readLine()) != null) {
                String[] data = currentLine.split(";");
                if (data.length >= 2 && enteredID.equals(data[0].trim())) {
                    data[1] = newName.toUpperCase();
                    data[2] = newPassword;
                    data[3] = newEmail;
                    data[4] = newContact;
                    data[6] = newIntake;
                }
                updatedLines.add(String.join(";", data));
            }

            // Write the updated data back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String updatedLine : updatedLines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
