/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package academicguidancehubgui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AdminRegisterLecturer extends javax.swing.JFrame {

    /**
     * Creates new form Register_Lecturer
     */
    public AdminRegisterLecturer() {
        initComponents();
        setSize(900,620);
        setResizable(false);
        
        ArrayList<String[]> schoolwisedataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/textfiles/SchoolWiseList.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length >= 1) {
                    FunctionalCb.addItem(values[0]); // Assuming FunctionalCb is your combo box
                    schoolwisedataList.add(values);
                } else {
                    // Log or display a warning message if the line is improperly formatted
                    System.err.println("Ignoring improperly formatted line: " + line);
                }
            }
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
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cancelBt = new javax.swing.JButton();
        registerBt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lecturerContact = new javax.swing.JTextField();
        lecturerName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        FunctionalCb = new javax.swing.JComboBox<>();
        groupRegister = new javax.swing.JButton();
        attachFileLink = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel6.setText("register_background.png");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 600));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 32)); // NOI18N
        jLabel2.setText("Register Lecturer Page");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        cancelBt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cancelBt.setText("Cancel");
        cancelBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelBtMouseClicked(evt);
            }
        });
        getContentPane().add(cancelBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, 90, 40));

        registerBt.setBackground(new java.awt.Color(0, 102, 102));
        registerBt.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        registerBt.setForeground(new java.awt.Color(255, 255, 255));
        registerBt.setText("Register");
        registerBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerBtMouseClicked(evt);
            }
        });
        getContentPane().add(registerBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 110, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Functional Area");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Full Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));

        lecturerContact.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        getContentPane().add(lecturerContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 440, 40));

        lecturerName.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        getContentPane().add(lecturerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 440, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Contact");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, -1));

        FunctionalCb.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        getContentPane().add(FunctionalCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 440, 40));

        groupRegister.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        groupRegister.setForeground(new java.awt.Color(0, 0, 153));
        groupRegister.setText("Register from a school wise list");
        groupRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                groupRegisterMouseClicked(evt);
            }
        });
        getContentPane().add(groupRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, 210, 30));

        attachFileLink.setText("Attach File.");
        getContentPane().add(attachFileLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtMouseClicked
        this.dispose();
        AdminDashboard obj = new AdminDashboard();
        obj.setVisible(true);
    }//GEN-LAST:event_cancelBtMouseClicked

    private void registerBtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtMouseClicked
        String name = capitalizeInitials(lecturerName.getText());
        String contact = lecturerContact.getText();
        String schooloffield = (String)FunctionalCb.getSelectedItem();
        String filePath = attachFileLink.getText();
        
        if (name.isEmpty() && contact.isEmpty() && filePath.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields or select a file", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if ((name.isEmpty() || contact.isEmpty()) && filePath.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields or select a file", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (filePath.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a text file", "Error", JOptionPane.ERROR_MESSAGE);
            registerLecturer(name,contact,schooloffield);
            return;
        }  
        
        registerLecturerFromFile(filePath,schooloffield);
        
        JOptionPane.showMessageDialog(this, "Lecturer registered successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    
        lecturerName.setText("");
        lecturerContact.setText("");
        
        this.dispose();
        AdminDashboard obj = new AdminDashboard();
        obj.setVisible(true);
    }//GEN-LAST:event_registerBtMouseClicked

    private void groupRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groupRegisterMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            java.io.File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            attachFileLink.setText(filePath);
        }
    }//GEN-LAST:event_groupRegisterMouseClicked

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
            java.util.logging.Logger.getLogger(AdminRegisterLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminRegisterLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminRegisterLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminRegisterLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminRegisterLecturer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> FunctionalCb;
    private javax.swing.JLabel attachFileLink;
    private javax.swing.JButton cancelBt;
    private javax.swing.JButton groupRegister;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lecturerContact;
    private javax.swing.JTextField lecturerName;
    private javax.swing.JButton registerBt;
    // End of variables declaration//GEN-END:variables

    private String capitalizeInitials(String name) {
        StringBuilder capitalized = new StringBuilder();
        String[] parts = name.split(" ");
        for (String part : parts) {
            if (!part.isEmpty()) {
                capitalized.append(Character.toUpperCase(part.charAt(0))); // Capitalize the first character
                capitalized.append(part.substring(1).toLowerCase()); // Convert the rest of the string to lowercase
                capitalized.append(" "); // Add a space between parts
            }
        }
        return capitalized.toString().trim();
    }

    private void registerLecturer(String Name, String contact, String schooloffield) {
        String lecturerRecordfile = "src/textfiles/Lecturer.txt";
        
        var lecturerID = generateLecturerID();
        var password = generatePassword(lecturerID, Name);
        var email = generateEmail(Name);
        String role = "Lecturer";
        
        String lecturerRecord = lecturerID + ";" + Name + ";" + password + ";" + email + ";" + contact + ";" + role + ";" + schooloffield;
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(lecturerRecordfile, true))) {
            writer.write(lecturerRecord);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    private String generateLecturerID() {
        return "LC" + String.format("%06d", getNextLecturerID());
    }

    private String generatePassword(String lecturerID, String Name) {
        String[] parts = Name.split(" "); 
        String firstName = parts[0]; 
        return lecturerID + "#" + firstName;
    }

    private String generateEmail(String Name) {
        return Name.toLowerCase().replace(" ", "") + "@gmail.com";
    }

    private int getNextLecturerID() {
        int nextID = 0;
        String lecturerRecordfile = "src/textfiles/Lecturer.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(lecturerRecordfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String lecturerID = parts[0].trim(); 
                String number = lecturerID.substring(2); 
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

    private void registerLecturerFromFile(String filePath, String schooloffield) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming each line contains student name and contact separated by a delimiter, like ","
                String[] parts = line.split(",");
                String name = capitalizeInitials(parts[0]);
                String contact = parts[1];

                // Register the student under the selected intake
                registerLecturer(name, contact, schooloffield);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
