/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package academicguidancehubgui;

import javax.swing.JOptionPane;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author New HP
 */
public class AdminRegisterStudents extends javax.swing.JFrame {

    /**
     * Creates new form Register_Students
     */
    public AdminRegisterStudents() {
        initComponents();
        setSize(900,620);
        setResizable(false);
        
        ArrayList<String[]> intakesdataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/textfiles/intakesType.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                intakeCB.addItem(values[0]);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        registerBt = new javax.swing.JButton();
        cancelBt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        studentName = new javax.swing.JTextField();
        studentContact = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        intakeCB = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 32)); // NOI18N
        jLabel2.setText("Register Student Page");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, -1, -1));

        registerBt.setBackground(new java.awt.Color(102, 102, 0));
        registerBt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        registerBt.setForeground(new java.awt.Color(255, 255, 255));
        registerBt.setText("Register");
        registerBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerBtMouseClicked(evt);
            }
        });
        registerBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtActionPerformed(evt);
            }
        });
        getContentPane().add(registerBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 440, 110, 40));

        cancelBt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cancelBt.setText("Cancel");
        cancelBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelBtMouseClicked(evt);
            }
        });
        getContentPane().add(cancelBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 440, 90, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/register_student_Background.png"))); // NOI18N
        jLabel3.setText("register_student_Background.png");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 600));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel1.setText("Intake:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel4.setText("Student Name:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, -1, -1));

        studentName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, 170, 40));

        studentContact.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(studentContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, 170, 40));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel5.setText("Contact Number:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, -1, -1));

        intakeCB.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        getContentPane().add(intakeCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, 170, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtMouseClicked
        this.dispose();
        AdminDashboard obj = new AdminDashboard();
        obj.setVisible(true);
    }//GEN-LAST:event_cancelBtMouseClicked

    private void registerBtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtMouseClicked
        String name = studentName.getText().toUpperCase();
        String contact = studentContact.getText();
        String intake = (String)intakeCB.getSelectedItem();
        
        if (name.isEmpty() || contact.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        registerStudent(name,contact,intake);
        
        JOptionPane.showMessageDialog(this, "Student registered successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    
        studentName.setText("");
        studentContact.setText("");
        
        this.dispose();
        AdminDashboard obj = new AdminDashboard();
        obj.setVisible(true);
    }//GEN-LAST:event_registerBtMouseClicked

    private void registerBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerBtActionPerformed

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
            java.util.logging.Logger.getLogger(AdminRegisterStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminRegisterStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminRegisterStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminRegisterStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminRegisterStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBt;
    private javax.swing.JComboBox<String> intakeCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton registerBt;
    private javax.swing.JTextField studentContact;
    private javax.swing.JTextField studentName;
    // End of variables declaration//GEN-END:variables

    private void registerStudent(String name, String contact, String intake) {
        String studentRecordfile = "src/textfiles/Students.txt";
        
        String studentID = generateStudentID();
        String password = generatePassword(studentID, name);
        String email = generateEmail(name);
        String role = "Student";
        
        String studentRecord = studentID + ";" + name + ";" + password + ";" + email + ";" + contact + ";" + role + ";" + intake;
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(studentRecordfile, true))) {
            writer.write(studentRecord);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    private String generateStudentID() {
        return "ST" + String.format("%06d", getNextStudentID());
    }

    private String generatePassword(String studentID, String name) {
        return studentID + "@" + getInitials(name);
    }

    private String generateEmail(String name) {
        return name.toLowerCase().replace(" ", "") + "@gmail.com";
    }

    private int getNextStudentID() {
        int nextID = 0;
        String studentRecordfile = "src/textfiles/Students.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(studentRecordfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String studentID = parts[0].trim(); // Extract student ID from each line
                String number = studentID.substring(2); // Remove the "ST" prefix
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

    private String getInitials(String name) {
        StringBuilder initials = new StringBuilder();
        String[] parts = name.split(" ");
        for (String part : parts) {
            initials.append(part.charAt(0));
        }
        return initials.toString().toUpperCase();
    }
}
