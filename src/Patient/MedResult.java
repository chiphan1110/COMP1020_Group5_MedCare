/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Patient;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public class MedResult extends javax.swing.JFrame {

    /**
     * Creates new form bookingManagement
     */
    
    String filename = null;
    byte[] prescription_image = null;
    int appointmentID = MedRecord.appointmentID;
    public MedResult() {
        initComponents();
        Connection con;
        ResultSet rsTable;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            PreparedStatement stmt = con.prepareStatement("SELECT * from Appointment WHERE AppointmentID = ?");
            stmt.setInt(1, appointmentID);        
            rsTable = stmt.executeQuery();
            
            if (rsTable.next()){
                AppointmentID.setText(String.valueOf(appointmentID));
                Date1.setText(rsTable.getString("Date"));
                Time.setText(rsTable.getString("Time")); 
                Department.setText(rsTable.getString("Department"));  
                Results.setText(rsTable.getString("Result")); 
                Results.setLineWrap(true);
                Results.setWrapStyleWord(true);
                Conclu.setText(rsTable.getString("Conclusion")); 
            }    
            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        displayPrescription();
    }
    
    private void displayPrescription(){
        try {
            // Connect to the SQLite database
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            // Prepare the SQL statement to retrieve the image
            String sql = "SELECT Prescription FROM Appointment WHERE AppointmentID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, appointmentID); // Assuming you want to retrieve the image with ID 1
            
            ResultSet rs = pstmt.executeQuery();
            
            // Retrieve the image bytes from the result set
            if (rs.next()) {
                byte[] imageData = rs.getBytes("Prescription");
                
                // Convert the bytes to an Image
                InputStream is = new ByteArrayInputStream(imageData);
                BufferedImage bufferedImage = ImageIO.read(is);
                Image image = bufferedImage.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
                
                // Set the Image to the JLabel
                jLabel2.setIcon(new ImageIcon(image));
            }
            
            // Close the resources
            rs.close();
            pstmt.close();
            conn.close();
            
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
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
        d = new javax.swing.JLabel();
        AppointmentID = new javax.swing.JTextField();
        time = new javax.swing.JLabel();
        Time = new javax.swing.JTextField();
        department = new javax.swing.JLabel();
        Department = new javax.swing.JTextField();
        Result = new javax.swing.JLabel();
        prescription = new javax.swing.JLabel();
        Conclusion = new javax.swing.JLabel();
        Conclu = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Results = new javax.swing.JTextArea();
        date1 = new javax.swing.JLabel();
        Date1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        topboard = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(174, 226, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        d.setText("Date:");
        jPanel1.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 40, 20));

        AppointmentID.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        AppointmentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppointmentIDActionPerformed(evt);
            }
        });
        jPanel1.add(AppointmentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 150, 25));

        time.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        time.setText("Time:");
        jPanel1.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 50, 20));

        Time.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jPanel1.add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 80, -1));

        department.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        department.setText("Department:");
        jPanel1.add(department, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, 20));

        Department.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jPanel1.add(Department, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 190, -1));

        Result.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Result.setText("Result:");
        jPanel1.add(Result, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 50, -1));

        prescription.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        prescription.setText("Prescription:");
        jPanel1.add(prescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        Conclusion.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Conclusion.setText("Conclusion:");
        jPanel1.add(Conclusion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        Conclu.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        Conclu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConcluActionPerformed(evt);
            }
        });
        jPanel1.add(Conclu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 279, -1));

        Results.setColumns(20);
        Results.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        Results.setRows(5);
        jScrollPane1.setViewportView(Results);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 279, 205));

        date1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        date1.setText("Appointment ID:");
        jPanel1.add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, -1));

        Date1.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jPanel1.add(Date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 80, -1));

        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 350, 340));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 800, 440));

        topboard.setBackground(new java.awt.Color(39, 123, 192));
        topboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicons/list.png"))); // NOI18N
        jLabel1.setText("Appointment Result");
        topboard.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 47, 414, -1));

        jButton2.setBackground(new java.awt.Color(39, 123, 192));
        jButton2.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        topboard.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        getContentPane().add(topboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 160));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ConcluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConcluActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConcluActionPerformed

    private void AppointmentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppointmentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AppointmentIDActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MedRecord med = new MedRecord();
        med.show();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    

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
            java.util.logging.Logger.getLogger(MedResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MedResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MedResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MedResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MedResult().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AppointmentID;
    private javax.swing.JTextField Conclu;
    private javax.swing.JLabel Conclusion;
    private javax.swing.JTextField Date1;
    private javax.swing.JTextField Department;
    private javax.swing.JLabel Result;
    private javax.swing.JTextArea Results;
    private javax.swing.JTextField Time;
    private javax.swing.JLabel d;
    private javax.swing.JLabel date1;
    private javax.swing.JLabel department;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel prescription;
    private javax.swing.JLabel time;
    private javax.swing.JPanel topboard;
    // End of variables declaration//GEN-END:variables
}
