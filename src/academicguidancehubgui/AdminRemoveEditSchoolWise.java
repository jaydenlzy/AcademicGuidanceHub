/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package academicguidancehubgui;

import academicguidancehub.FileLocationInterface;
import academicguidancehub.FileReaderUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author New HP
 */
public class AdminRemoveEditSchoolWise extends javax.swing.JFrame {

    /**
     * Creates new form AdminRemoveEditSchoolWise
     */
    public AdminRemoveEditSchoolWise() {
        initComponents();
        setSize(800,520);
        setResizable(false);
        
        schoolWiseTableContent();
        
        editBt.setVisible(false);
        saveBt.setVisible(false);
        removeBt.setVisible(false);
        
        changedName.setVisible(false);
        enameLabel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        swiseTb = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        enameLabel = new javax.swing.JLabel();
        changedName = new javax.swing.JTextField();
        cancelBt = new javax.swing.JButton();
        removeBt = new javax.swing.JButton();
        editBt = new javax.swing.JButton();
        saveBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 26)); // NOI18N
        jLabel3.setText("Edit/Remove School Wise Page");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 255));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 360, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/RemoveItakePage.png"))); // NOI18N
        jLabel1.setText("RemoveItakePage.png");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, -40, 300, 590));

        swiseTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        swiseTb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                swiseTbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(swiseTb);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 160));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("School Wises Table:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        enameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        enameLabel.setText("Edit Name:");
        getContentPane().add(enameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        changedName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(changedName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 450, 30));

        cancelBt.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        cancelBt.setText("Back");
        cancelBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelBtMouseClicked(evt);
            }
        });
        getContentPane().add(cancelBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 80, 30));

        removeBt.setBackground(new java.awt.Color(255, 0, 51));
        removeBt.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        removeBt.setForeground(new java.awt.Color(255, 255, 255));
        removeBt.setText("Remove");
        removeBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeBtMouseClicked(evt);
            }
        });
        getContentPane().add(removeBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 80, 30));

        editBt.setBackground(new java.awt.Color(204, 204, 0));
        editBt.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        editBt.setText("Edit");
        editBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtMouseClicked(evt);
            }
        });
        getContentPane().add(editBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 80, 30));

        saveBt.setBackground(new java.awt.Color(0, 51, 255));
        saveBt.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        saveBt.setForeground(new java.awt.Color(255, 255, 255));
        saveBt.setText("Save Changes");
        saveBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBtMouseClicked(evt);
            }
        });
        getContentPane().add(saveBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 120, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void swiseTbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_swiseTbMouseClicked
        DefaultTableModel stList = (DefaultTableModel)swiseTb.getModel();
        int selectedRow = swiseTb.getSelectedRow();
        
        if(selectedRow != -1){
            editBt.setVisible(true);
            removeBt.setVisible(true);
            String name = stList.getValueAt(swiseTb.getSelectedRow(),0).toString();
            changedName.setText(name);
        }
    }//GEN-LAST:event_swiseTbMouseClicked

    private void editBtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtMouseClicked
        swiseTb.setEnabled(false);
        changedName.setVisible(true);
        removeBt.setVisible(false);
        enameLabel.setVisible(true);
        editBt.setVisible(false);
        saveBt.setVisible(true);
        removeBt.setVisible(false);
    }//GEN-LAST:event_editBtMouseClicked

    private void saveBtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtMouseClicked
        String name = changedName.getText();
        DefaultTableModel stList = (DefaultTableModel)swiseTb.getModel();
        int selectedRow = swiseTb.getSelectedRow();
        
        if(selectedRow != -1){
            try {
                // Read the existing data from the file
                ArrayList<String> wiseList = new ArrayList<>();
                BufferedReader br = new BufferedReader(new FileReader(FileLocationInterface.schoolListPath));
                String rec;
                while ((rec = br.readLine()) != null) {
                    wiseList.add(rec);
                }
                br.close();

                // Update the data in the ArrayList
                String updatedRow = name; // Assuming you only need to update the first column
                wiseList.set(selectedRow, updatedRow);

                // Write the updated data back to the file
                BufferedWriter bw = new BufferedWriter(new FileWriter(FileLocationInterface.schoolListPath));
                for (String line : wiseList) {
                    bw.write(line);
                    bw.newLine();
                }
                bw.close();

                // Inform the user about the successful edit
                JOptionPane.showMessageDialog(null, "Edit school wise successfully!", "MODIFY SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                
                schoolWiseTableContent();
                saveBt.setVisible(false);
                changedName.setVisible(false);
                enameLabel.setVisible(false);
                swiseTb.setEnabled(true);
                removeBt.setVisible(false);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error editing school wise!", "MODIFY ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveBtMouseClicked

    private void removeBtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeBtMouseClicked
        DefaultTableModel model = (DefaultTableModel) swiseTb.getModel();
        int selectedRow = swiseTb.getSelectedRow();
        
        if (selectedRow != -1) {
            String name = model.getValueAt(swiseTb.getSelectedRow(),0).toString();

            model.removeRow(selectedRow);
            
            String delimiter = ";";
            UpdateTextFile(FileLocationInterface.schoolListPath, name, delimiter);
            JOptionPane.showMessageDialog(null, "Intake deleted successfully!", "INTAKE DELETE SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            editBt.setVisible(false);
            removeBt.setVisible(false);
        }
    }//GEN-LAST:event_removeBtMouseClicked

    private void cancelBtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtMouseClicked
        this.dispose();
        AdminDashboard obj = new AdminDashboard();
        obj.setVisible(true);
    }//GEN-LAST:event_cancelBtMouseClicked

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
            java.util.logging.Logger.getLogger(AdminRemoveEditSchoolWise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminRemoveEditSchoolWise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminRemoveEditSchoolWise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminRemoveEditSchoolWise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminRemoveEditSchoolWise().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBt;
    private javax.swing.JTextField changedName;
    private javax.swing.JButton editBt;
    private javax.swing.JLabel enameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton removeBt;
    private javax.swing.JButton saveBt;
    private javax.swing.JTable swiseTb;
    // End of variables declaration//GEN-END:variables

    private void schoolWiseTableContent() {
        String delimiter = ";";
        int[] classTypeColumnIndices = {0};
        String[][] classTypeData = FileReaderUtils.readData(FileLocationInterface.schoolListPath, delimiter, classTypeColumnIndices);

        if (classTypeData != null) {
            DefaultTableModel classTypeTableModel = new DefaultTableModel();
            classTypeTableModel.addColumn("School Wise Name");

            for (String[] row : classTypeData) {
                classTypeTableModel.addRow(row);
            }

            swiseTb.setModel(classTypeTableModel);
        }
    }

    private void UpdateTextFile(String intakesfilePath, String name, String delimiter) {
        try {
        // Read the content of the file and store it in a list
            File file = new File(intakesfilePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                // Split the line by the delimiter to check if it contains the specified 'tp'
                String[] parts = line.split(delimiter);
                if (!parts[0].equals(name)) { // If the 'tp' doesn't match, keep the line
                    content.append(line).append(System.lineSeparator());
                }
            }
            reader.close();

            // Write the updated content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content.toString());
            writer.close();

            System.out.println("Entry with intake code '" + name + "' removed from the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
