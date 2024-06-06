/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package academicguidancehubgui;

import academicguidancehub.FileLocationInterface;
import static academicguidancehub.FileLocationInterface.presentationtimeFilePath;
import academicguidancehub.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author isaac
 */
public class StudentRequestPresentation extends javax.swing.JFrame {

    /**
     * Creates new form StudentRequestPresentation
     */
    Student st = null;

    public StudentRequestPresentation(Student st) {
        this.st = st;
        initComponents();
        jlStudentName1.setText(st.getName());
        jlStudentId.setText(st.getUserId());
        
        checkSubmissions();
        
    }

    
    public void checkSubmissions() {
    ArrayList<String[]> selectAssignmentList = new ArrayList<>();

    // Load submissions into a set for quick lookup
    Set<String> submissionsSet = new HashSet<>();
    try (BufferedReader submissionReader = new BufferedReader(new FileReader(presentationtimeFilePath))) {
        String submissionLine;
        while ((submissionLine = submissionReader.readLine()) != null) {
            String[] submissionValues = submissionLine.split(";");
            if (submissionValues.length > 2) { // Check if the array has at least 3 elements
                submissionsSet.add(submissionValues[0] + ";" + submissionValues[2]);
            } else {
                System.out.println("Skipping invalid line in Submission.txt with insufficient values: " + submissionLine);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error reading Submission.txt file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(FileLocationInterface.submissionFilePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(";");
            if (values.length > 1) { // Check if the array has at least 2 elements
                String projectKey = values[0] + ";" + values[1];
                if (st.getUserId().equals(values[0]) && !submissionsSet.contains(projectKey)) {
                    cbSelectAssignment.addItem(values[1]);
                    selectAssignmentList.add(values);
                }
            } else {
                System.out.println("Skipping invalid line with insufficient values: " + line);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (ArrayIndexOutOfBoundsException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error processing line: Array index out of bounds", "Error", JOptionPane.ERROR_MESSAGE);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jbBack = new javax.swing.JButton();
        jbSubmit = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbSelectAssignment = new javax.swing.JComboBox<>();
        jlReqDate = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlReqTime = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtDate = new javax.swing.JTextField();
        jtTime = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jlStudentId = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlStudentName1 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 80));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jbBack.setText("Back");
        jbBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbBackMouseClicked(evt);
            }
        });

        jbSubmit.setText("Submit");
        jbSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSubmitMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("PT Serif", 1, 24)); // NOI18N
        jLabel2.setText("Request for Presentation");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(282, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(264, 264, 264))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("Select Assignment:");

        cbSelectAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSelectAssignmentActionPerformed(evt);
            }
        });

        jlReqDate.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlReqDate.setText("Request Presentation Date:");

        jLabel6.setText("(Example: 25 May 2024)");

        jlReqTime.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jlReqTime.setText("Request Presentation Time:");

        jLabel7.setText("(Example: 14:00)");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbSelectAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(164, 164, 164))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(97, 97, 97)
                                    .addComponent(jbSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(55, 55, 55)
                                    .addComponent(jbBack, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(247, 247, 247)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jlReqDate)
                                    .addComponent(jlReqTime)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(jtTime))
                                .addGap(228, 228, 228))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSelectAssignment, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlReqDate, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jtDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlReqTime, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setPreferredSize(new java.awt.Dimension(1000, 80));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlStudentId.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlStudentId.setForeground(new java.awt.Color(255, 255, 255));
        jlStudentId.setText("ST XXX");
        jPanel6.add(jlStudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Academic Guidance Hub (AGH)");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jlStudentName1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlStudentName1.setForeground(new java.awt.Color(255, 255, 255));
        jlStudentName1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/user.png"))); // NOI18N
        jlStudentName1.setText("Student XXX");
        jPanel6.add(jlStudentName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbBackMouseClicked
        this.dispose();
        StudentDashboard obj = new StudentDashboard(st);
        obj.setVisible(true);
    }//GEN-LAST:event_jbBackMouseClicked

    private void jbSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSubmitMouseClicked
// Get the text from jtDate and jtTime fields
        String date = jtDate.getText();
        String time = jtTime.getText();
        String selectedAssignment = (String) cbSelectAssignment.getSelectedItem();

        // Check if jtDate or jtTime is blank
        if (date.isEmpty() || time.isEmpty()) {
            // Show error message
            JOptionPane.showMessageDialog(null, "Date and time fields cannot be blank.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Both fields are not empty, so store them in the file
            try {
                // Create a FileWriter object with append mode
                FileWriter fileWriter = new FileWriter(presentationtimeFilePath, true);

                // Create a BufferedWriter object to write to the file
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                // Write student ID, name, date, and time to the file
                bufferedWriter.write(st.getUserId() + ";" + st.getName() + ";" + selectedAssignment + ";" + date + ";" + time);
                bufferedWriter.newLine(); // Add a new line

                // Close the bufferedWriter
                bufferedWriter.close();

                // Show success message
                JOptionPane.showMessageDialog(null, "Presentation Time Request Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                StudentDashboard obj = new StudentDashboard(st);
                obj.setVisible(true);
            } catch (IOException e) {
                // Show error message if an exception occurs while writing to the file
                JOptionPane.showMessageDialog(null, "Error occurred while writing to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbSubmitMouseClicked

    private void cbSelectAssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSelectAssignmentActionPerformed

    }//GEN-LAST:event_cbSelectAssignmentActionPerformed

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
            java.util.logging.Logger.getLogger(StudentRequestPresentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentRequestPresentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentRequestPresentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentRequestPresentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbSelectAssignment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton jbBack;
    private javax.swing.JButton jbSubmit;
    private javax.swing.JLabel jlReqDate;
    private javax.swing.JLabel jlReqTime;
    private javax.swing.JLabel jlStudentId;
    private javax.swing.JLabel jlStudentName1;
    private javax.swing.JTextField jtDate;
    private javax.swing.JTextField jtTime;
    // End of variables declaration//GEN-END:variables
}
