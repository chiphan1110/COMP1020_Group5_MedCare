/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Patient;

import Dashboard.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.event.*;
import Register.Login;
/**
 *
 * 
 */
public class FeedbackAll extends javax.swing.JFrame {
    int rate;
    String doctorName, doctorID, comment, averageRate, date, department;
    
    public static int selectedAppointment=1;
    int userid = Login.userid;
    /**
     * Creates new form Ratings
     */
    public FeedbackAll() {
        initComponents();
        displayUserInfo();
        displayAppointment();
        displayDoctorInfo();
        
       
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
            stmt.setInt(3, selectedAppointment);
            int i = stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
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
//        rate = Integer.parseInt(txt_rate.getText());
        comment = comment_box.getText();
        
        if(rate < 1 || rate > 10){
            JOptionPane.showMessageDialog(this, "Rating must be from 1-10");
            return false;
        }
        
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
//            stmt.setInt(1, 1);
//            please try the code under to see if it cause error:
            stmt.setInt(1, userid);
            ResultSet rs1 = stmt.executeQuery();
            String userName = rs1.getString("Name");
            lbl_name.setText(userName);
            lbl_id.setText("" + userid);
        conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
//    private void displayUserInfo(){
//        try{
//            Class.forName("org.sqlite.JDBC");
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
//            String sql = "SELECT * FROM SignUp WHERE UserID=?";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setInt(1, userid);
//            ResultSet rs = stmt.executeQuery();
//            String username = rs.getString("Name");
//            lbl_name.setText(username);
//            lbl_id.setText("ID: " + userid);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
    
    private void displayDoctorInfo(){
        appointment_list.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                try{
                    selectedAppointment = Integer.parseInt(appointment_list.getSelectedItem().toString());
                    Class.forName("org.sqlite.JDBC");
                    Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
                    String sql = "SELECT * FROM Appointment WHERE AppointmentId=?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, selectedAppointment);
                    ResultSet rs = stmt.executeQuery();
        //            averageRate = rs.getString("Rating");
                    doctorName = rs.getString("DoctorName");
                    doctorID = rs.getString("DoctorID");
                    date = rs.getString("Date");
                    department = rs.getString("Department");
//                    averageRate = rs.getString("Rating");
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
        });
        
    }
    
    private void displayAppointment(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            String sql = "SELECT DISTINCT * FROM Appointment WHERE UserID = ? AND Status=? AND FirstFB=1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,userid);
            stmt.setString(2, "Past");
//            stmt.setString(3, "");
            ResultSet rs = stmt.executeQuery();
            appointment_list.removeAllItems();
            while(rs.next()){
                String appointmentID = rs.getString("AppointmentID");
                appointment_list.addItem(appointmentID);
            }
        }catch(Exception e){
            e.printStackTrace();
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
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        doctor_name = new javax.swing.JLabel();
        lbl_doctorid = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_department = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        appointment_list = new javax.swing.JComboBox<>();
        lbl_name = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
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
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicons/list_1.png"))); // NOI18N
        jLabel2.setText("Feedbacks");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 129, 201));
        jButton2.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Home");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 800, 160));

        jPanel5.setBackground(new java.awt.Color(174, 226, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicons/doctor.png"))); // NOI18N
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 120, -1));

        doctor_name.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        doctor_name.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(doctor_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 120, 20));

        lbl_doctorid.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        lbl_doctorid.setText("                       ");
        jPanel5.add(lbl_doctorid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 75, -1));

        jLabel13.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel13.setText("Department:");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        lbl_department.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        lbl_department.setText("                        ");
        jPanel5.add(lbl_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        jLabel12.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel12.setText("Doctor ID: ");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel3.setText("Doctor name: ");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 22));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 310, 380));

        jPanel2.setBackground(new java.awt.Color(174, 226, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel1.setText("Appointment ID:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, 22));

        appointment_list.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        appointment_list.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        jPanel2.add(appointment_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 220, -1));

        lbl_name.setBackground(new java.awt.Color(255, 255, 255));
        lbl_name.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        lbl_name.setText("User's name goes here");
        jPanel2.add(lbl_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 139, -1));

        lbl_id.setBackground(new java.awt.Color(255, 255, 255));
        lbl_id.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        lbl_id.setText("UserID goes here");
        jPanel2.add(lbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 139, -1));

        jLabel16.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel16.setText("User ID: ");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel4.setText("Name: ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 22));

        jLabel11.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel11.setText("Appointment Date:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        lbl_date.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jPanel2.add(lbl_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 70, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 154, 800, 70));

        jPanel6.setBackground(new java.awt.Color(174, 226, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(39, 123, 192));
        jButton1.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 130, 40));

        jLabel14.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel14.setText("Rate this appointment (1-10)");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 37));

        jLabel15.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel15.setText("Comments and suggestions:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        comment_box.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        comment_box.setText("");
        comment_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comment_boxActionPerformed(evt);
            }
        });
        jPanel6.add(comment_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 420, 130));

        txt_rate.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        txt_rate.setText("");
        txt_rate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rateActionPerformed(evt);
            }
        });
        jPanel6.add(txt_rate, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 170, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 224, 494, 380));

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
            displayAppointment();
     
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_rateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        PatientHome h = new PatientHome();
        h.show();
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
            java.util.logging.Logger.getLogger(FeedbackAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FeedbackAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FeedbackAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FeedbackAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FeedbackAll().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> appointment_list;
    private javax.swing.JTextField comment_box;
    private javax.swing.JLabel doctor_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_department;
    private javax.swing.JLabel lbl_doctorid;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JTextField txt_rate;
    // End of variables declaration//GEN-END:variables
}
