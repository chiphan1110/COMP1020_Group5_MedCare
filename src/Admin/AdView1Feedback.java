/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;

import Admin.AdManageAppointment;
import Register.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * 
 */
public class AdView1Feedback extends javax.swing.JFrame {
    int appRate;
    String doctorName, doctorID, comment, averageRate, date, time, department, feedback;
    int appointmentID = Admin.AdManageAppointment.appointmentID;
    int patientID = Admin.AdManageAppointment.patientID;
    /**
     * Creates new form Ratings
     */

    public AdView1Feedback() {
        initComponents();
        displayDoctorInfo();
        displayPatientInfo();
        displayAppointmentInfo();
    }
    
        
    private void displayPatientInfo(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\\\sqlite\\\\db\\\\test.sqlite");
            String sql1 = "SELECT * FROM SignUp WHERE UserID=?";
            PreparedStatement stmt = conn.prepareStatement(sql1);
            stmt.setInt(1, patientID);
            ResultSet rs1 = stmt.executeQuery();
            String userName = rs1.getString("Name");
            patient_name.setText(userName);
            patient_id.setText(""+patientID);
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


            doctorName = rs.getString("DoctorName");
            doctorID = rs.getString("DoctorID");
            department = rs.getString("Department");

            doctor_name.setText("Dr." + doctorName);
            doctor_id.setText(doctorID);
            doctor_depart.setText(department);

            stmt.close();
            rs.close();
            conn.close();
                }catch(Exception a){
                    a.printStackTrace();
        }
    }
    private void displayAppointmentInfo(){
    try{
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
        String sql = "SELECT * FROM Appointment WHERE AppointmentId=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, appointmentID);
        ResultSet rs = stmt.executeQuery();
        
        date = rs.getString("Date");
        time = rs.getString("Time");
        appRate = rs.getInt("Rate");
        feedback = rs.getString("Feedback");
        
        AppointID.setText(""+appointmentID);
        appoint_date.setText(date);
        appoint_time.setText(time);
        appoint_rate.setText("" + appRate);
        appoint_fb.setText("<html><body style='word-wrap: break-word;'>" + feedback + "</body></html>");
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
        jLabel17 = new javax.swing.JLabel();
        appoint_date = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        appoint_time = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        doctor_id = new javax.swing.JLabel();
        doctor_depart = new javax.swing.JLabel();
        doctor_name = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        appoint_rate = new javax.swing.JLabel();
        appoint_fb = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        patient_name = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        patient_id = new javax.swing.JLabel();

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
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 22));

        AppointID.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        AppointID.setText("                            ");
        jPanel2.add(AppointID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 50, -1));

        jLabel17.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel17.setText("Date:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        appoint_date.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        appoint_date.setText("                            ");
        jPanel2.add(appoint_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        jLabel19.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel19.setText("Time:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        appoint_time.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        appoint_time.setText("                            ");
        jPanel2.add(appoint_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 154, 800, 70));

        jPanel5.setBackground(new java.awt.Color(174, 226, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicons/doctor.png"))); // NOI18N
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 130, 130));

        doctor_id.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        doctor_id.setText("                            ");
        jPanel5.add(doctor_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 100, -1));

        doctor_depart.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        doctor_depart.setText("                            ");
        jPanel5.add(doctor_depart, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        doctor_name.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        doctor_name.setText("                            ");
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

        jLabel14.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel14.setText("Appointment Rating:");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 30));

        jLabel15.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel15.setText("Comments and suggestions:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 20));

        appoint_rate.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        appoint_rate.setText("                            ");
        jPanel6.add(appoint_rate, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, 30));

        appoint_fb.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        appoint_fb.setText("                            ");
        appoint_fb.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel6.add(appoint_fb, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 400, 120));

        jLabel12.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel12.setText("Patient Name: ");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        patient_name.setBackground(new java.awt.Color(255, 255, 255));
        patient_name.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jPanel6.add(patient_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 170, 20));

        jLabel16.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel16.setText("Patient ID:");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 80, 20));

        patient_id.setBackground(new java.awt.Color(255, 255, 255));
        patient_id.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        patient_id.setText("                       ");
        jPanel6.add(patient_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 139, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 490, 380));

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AdManageAppointment mana = new AdManageAppointment();
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
            java.util.logging.Logger.getLogger(AdView1Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdView1Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdView1Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdView1Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AdView1Feedback().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AppointID;
    private javax.swing.JLabel appoint_date;
    private javax.swing.JLabel appoint_fb;
    private javax.swing.JLabel appoint_rate;
    private javax.swing.JLabel appoint_time;
    private javax.swing.JLabel doctor_depart;
    private javax.swing.JLabel doctor_id;
    private javax.swing.JLabel doctor_name;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel patient_id;
    private javax.swing.JLabel patient_name;
    // End of variables declaration//GEN-END:variables
}
