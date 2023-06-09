/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Patient;
import Dashboard.PatientHome;
import Patient.ManageApppointment;
import Register.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * 
 */
public class Feedback1 extends javax.swing.JFrame {
    int rate;
    String doctorName, doctorID, comment, averageRate, date, department;
    int appointmentID = ManageApppointment.appointmentID;
    int userid = Login.userid;
    /**
     * Creates new form Ratings
     */

    public Feedback1() {
        initComponents();
        displayDoctorInfo();
        displayUserInfo();
//        appointment_list2.setText(String.valueOf(appointmentID));
    }
    
    void updateRatings(){
        rate = Integer.parseInt(txt_rate.getText());
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            String sql2 = "UPDATE Doctor SET Rating = CAST(((CAST(Rating AS REAL) * RateCounter) + ?) / (RateCounter + 1) AS TEXT), RateCounter = RateCounter + 1 WHERE DoctorId = ?";
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1, rate);
            stmt2.setInt(2, Integer.parseInt(doctorID));
            int i = stmt2.executeUpdate();
        conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    void updateFeedback(){
        comment = comment_box.getText();
        rate = Integer.parseInt(txt_rate.getText());
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            String sql = "UPDATE Appointment SET Feedback=?, Rate=?, FirstFB=0 WHERE AppointmentID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, comment);
            stmt.setInt(2, rate);
            stmt.setInt(3, appointmentID);
            int i = stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    boolean validation(){
        String rate2 = txt_rate.getText();
        if(rate2.equals("")){
            JOptionPane.showMessageDialog(this, "Please provide ratings");
            return false;
        }
        
        try{
            rate = Integer.parseInt(txt_rate.getText());
            if(rate < 1 || rate > 10){
            JOptionPane.showMessageDialog(this, "Rating must be from 1-10");
            return false;
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Rating must be a number from 1-10");
            return false;
        }
        comment = comment_box.getText();
        
        if(comment.equals("")){
            JOptionPane.showMessageDialog(this, "Please give some comment");
            return false;
        }
        return true;
    }
    
    private void displayUserInfo(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\\\sqlite\\\\db\\\\test.sqlite");
            String sql1 = "SELECT * FROM SignUp WHERE UserID=?";
            PreparedStatement stmt = conn.prepareStatement(sql1);
            stmt.setInt(1, userid);
//            please try the code under to see if it cause error:
//            stmt.setInt(1, userid);
            ResultSet rs1 = stmt.executeQuery();
            String userName = rs1.getString("Name");
            lbl_name2.setText(userName);
            lbl_id.setText(" " + userid);
        conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    private void displayDoctorInfo(){
        try{
                    Class.forName("org.sqlite.JDBC");
                    Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
                    String sql = "SELECT * FROM Appointment WHERE AppointmentId=?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, appointmentID);
                    ResultSet rs = stmt.executeQuery();
           
        //            averageRate = rs.getString("Rating");
                    doctorName = rs.getString("DoctorName");
                    doctorID = rs.getString("DoctorID");
                    date = rs.getString("Date");
                    department = rs.getString("Department");
//                    averageRate = rs.getString("Rating");
                    AppointID.setText(String.valueOf(appointmentID));
                    doctor_name.setText("Dr." + doctorName);
                    lbl_doctorid.setText(doctorID);
//                    average_rating.setText(averageRate);
                    lbl_date.setText(date);
                    lbl_department.setText(department);
            stmt.close();
            rs.close();
            conn.close();
                }catch(Exception a){
                    a.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        AppointID = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        lbl_name2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lbl_doctorid = new javax.swing.JLabel();
        lbl_department = new javax.swing.JLabel();
        doctor_name = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        comment_box = new javax.swing.JTextField();
        txt_rate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(39, 123, 192));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Bodoni MT", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicons/about.png"))); // NOI18N
        jLabel2.setText("Feedbacks");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 300, 80));

        jButton2.setBackground(new java.awt.Color(0, 129, 201));
        jButton2.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 800, 160));

        jPanel2.setBackground(new java.awt.Color(174, 226, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel5.setText("Appointment ID:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, 22));

        AppointID.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        AppointID.setText("IdHere");
        jPanel2.add(AppointID, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 50, -1));

        lbl_id.setBackground(new java.awt.Color(255, 255, 255));
        lbl_id.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        lbl_id.setText("User's ID goes here");
        jPanel2.add(lbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 139, -1));

        lbl_name2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_name2.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        lbl_name2.setText("User's name goes here");
        jPanel2.add(lbl_name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 139, -1));

        jLabel12.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel12.setText("Full Name: ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel16.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel16.setText("User ID:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 60, 20));

        jLabel17.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel17.setText("Appointment Date:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        lbl_date.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        lbl_date.setText("DateGoesHere");
        jPanel2.add(lbl_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 154, 800, 70));

        jPanel5.setBackground(new java.awt.Color(174, 226, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicons/doctor.png"))); // NOI18N
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 120, 120));

        lbl_doctorid.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        lbl_doctorid.setText("DoctorIDHere");
        jPanel5.add(lbl_doctorid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 100, -1));

        lbl_department.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        lbl_department.setText("DepartmentHere");
        jPanel5.add(lbl_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        doctor_name.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        doctor_name.setText("DoctorNameGoesHere");
        doctor_name.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(doctor_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        jLabel11.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel11.setText("Doctor ID:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel18.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel18.setText("Doctor Name:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel13.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel13.setText("Department:");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 310, 380));

        jPanel6.setBackground(new java.awt.Color(174, 226, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(39, 123, 192));
        jButton1.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 303, 130, 40));

        jLabel14.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel14.setText("Rate this appointment (1-10)");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 47, -1, 37));

        jLabel15.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel15.setText("Comments and suggestions:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 120, -1, -1));

        comment_box.setText("");
        comment_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comment_boxActionPerformed(evt);
            }
        });
        jPanel6.add(comment_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 156, 420, 129));

        txt_rate.setText("");
        txt_rate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rateActionPerformed(evt);
            }
        });
        jPanel6.add(txt_rate, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 54, 169, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 490, 380));

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comment_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comment_boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comment_boxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (validation()){
            JOptionPane.showMessageDialog(this, "Thank you for rating!");
            updateRatings();
            updateFeedback();
            ManageApppointment mana = new ManageApppointment();
            mana.show();
            this.dispose();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_rateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ManageApppointment mana = new ManageApppointment();
        mana.show();
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
            java.util.logging.Logger.getLogger(Feedback1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Feedback1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Feedback1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Feedback1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Feedback1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AppointID;
    private javax.swing.JTextField comment_box;
    private javax.swing.JLabel doctor_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_department;
    private javax.swing.JLabel lbl_doctorid;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_name2;
    private javax.swing.JTextField txt_rate;
    // End of variables declaration//GEN-END:variables
}
