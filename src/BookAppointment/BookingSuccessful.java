/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package BookAppointment;

import Dashboard.*;
import ManageAppointment.*;
import MedInfo.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import java.awt.Image;
/**
 *
 * @author truonghuy
 */
public class BookingSuccessful extends javax.swing.JFrame {

    /**
     * Creates new form BookingSuccessful
     */
    public BookingSuccessful() {
        initComponents();
        getAppointmentInfo();
        getDoctorRatingInfo();
    }
    
    @SuppressWarnings("unchecked")
                
    String department, date, time, doctorName, doctorRating;
    int userID, appointmentID;
    
    public void getAppointmentInfo(){
        userID = Booking.userID;
        System.out.println(userID);
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            PreparedStatement stmt = conn.prepareStatement("SELECT AppointmentID, Department, Date, Time, DoctorName FROM Appointment WHERE UserID = ? AND Status = 'Incoming'");
            stmt.setInt(1, userID);
            ResultSet resultSet = stmt.executeQuery();
            
            while (resultSet.next()) {
                appointmentID = resultSet.getInt("AppointmentID");
                department = resultSet.getString("Department");
                date = resultSet.getString("Date");
                time = resultSet.getString("Time");
                doctorName = resultSet.getString("DoctorName");
                appointmentIDInfoLabel.setText(String.valueOf(appointmentID));
                departmentInfoLabel.setText(department);
                dateInfoLabel.setText(date);
                timeInfoLabel.setText(time);
                doctorNameInfoLabel.setText(doctorName);
            }
            resultSet.close();
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void getDoctorRatingInfo(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            PreparedStatement stmt = conn.prepareStatement("SELECT Rating FROM Doctor WHERE DoctorName = ?");
            stmt.setString(1, doctorName);
            ResultSet resultSet = stmt.executeQuery();
            
            while (resultSet.next()) {
                doctorRating = String.valueOf(resultSet.getDouble("Rating"));
                doctorRatingInfoLabel.setText(String.valueOf(doctorRating));
            }
            resultSet.close();
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        messageLabel = new javax.swing.JLabel();
        appointmentIDLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        departmentLabel = new javax.swing.JLabel();
        appointmentIDInfoLabel = new javax.swing.JLabel();
        departmentInfoLabel = new javax.swing.JLabel();
        dateInfoLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        timeInfoLabel = new javax.swing.JLabel();
        completedIcon = new javax.swing.JLabel();
        doctorNameLabel = new javax.swing.JLabel();
        doctorNameInfoLabel = new javax.swing.JLabel();
        doctorRatingInfoLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        viewStatusButton = new javax.swing.JButton();
        medicalRecordsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(174, 226, 255));

        messageLabel.setFont(new java.awt.Font("Bodoni MT", 1, 36)); // NOI18N
        messageLabel.setText("Booking Successful!");

        appointmentIDLabel.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        appointmentIDLabel.setText("Appointment ID:");

        dateLabel.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        dateLabel.setText("Date:");

        departmentLabel.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        departmentLabel.setText("Department:");

        appointmentIDInfoLabel.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        appointmentIDInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        appointmentIDInfoLabel.setText("id");

        departmentInfoLabel.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        departmentInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        departmentInfoLabel.setText("department");

        dateInfoLabel.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        dateInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dateInfoLabel.setText("date");

        timeLabel.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        timeLabel.setText("Time:");

        timeInfoLabel.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        timeInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        timeInfoLabel.setText("time");

        ImageIcon imageIcon = new ImageIcon(new ImageIcon("clipart3179395.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
        completedIcon.setIcon(imageIcon);
        completedIcon.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        completedIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicons/tick2.png"))); // NOI18N

        doctorNameLabel.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        doctorNameLabel.setText("Doctor:");

        doctorNameInfoLabel.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        doctorNameInfoLabel.setText("name");

        doctorRatingInfoLabel.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        doctorRatingInfoLabel.setText("rating");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(completedIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(messageLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(appointmentIDLabel)
                            .addComponent(departmentLabel)
                            .addComponent(dateLabel)
                            .addComponent(timeLabel)
                            .addComponent(doctorNameLabel))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(appointmentIDInfoLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(doctorNameInfoLabel)
                                        .addGap(84, 84, 84)
                                        .addComponent(doctorRatingInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(timeInfoLabel)
                                    .addComponent(dateInfoLabel)
                                    .addComponent(departmentInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(196, 196, 196))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(completedIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageLabel)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(appointmentIDInfoLabel)
                        .addGap(10, 10, 10)
                        .addComponent(departmentInfoLabel)
                        .addGap(10, 10, 10)
                        .addComponent(dateInfoLabel)
                        .addGap(10, 10, 10)
                        .addComponent(timeInfoLabel)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doctorNameInfoLabel)
                            .addComponent(doctorRatingInfoLabel)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(appointmentIDLabel)
                        .addGap(10, 10, 10)
                        .addComponent(departmentLabel)
                        .addGap(10, 10, 10)
                        .addComponent(dateLabel)
                        .addGap(10, 10, 10)
                        .addComponent(timeLabel)
                        .addGap(10, 10, 10)
                        .addComponent(doctorNameLabel)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 410));

        jPanel2.setBackground(new java.awt.Color(39, 123, 192));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeButton.setBackground(new java.awt.Color(0, 129, 201));
        homeButton.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        homeButton.setForeground(new java.awt.Color(255, 255, 255));
        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        jPanel2.add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 160, 70));

        viewStatusButton.setBackground(new java.awt.Color(0, 129, 201));
        viewStatusButton.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        viewStatusButton.setForeground(new java.awt.Color(255, 255, 255));
        viewStatusButton.setText("Manage");
        viewStatusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStatusButtonActionPerformed(evt);
            }
        });
        jPanel2.add(viewStatusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 160, 70));

        medicalRecordsButton.setBackground(new java.awt.Color(0, 129, 201));
        medicalRecordsButton.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        medicalRecordsButton.setForeground(new java.awt.Color(255, 255, 255));
        medicalRecordsButton.setText("Medical Records");
        medicalRecordsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicalRecordsButtonActionPerformed(evt);
            }
        });
        jPanel2.add(medicalRecordsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 160, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 800, 190));
        jPanel2.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        Home home = new Home();
        home.show();
        this.dispose();
    }//GEN-LAST:event_homeButtonActionPerformed

    private void viewStatusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStatusButtonActionPerformed
        // TODO add your handling code here:
        Manage mana = new Manage();
        mana.show();
        this.dispose();
    }//GEN-LAST:event_viewStatusButtonActionPerformed

    private void medicalRecordsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicalRecordsButtonActionPerformed
        // TODO add your handling code here:
        MedReports med = new MedReports();
        med.show();
        this.dispose();
    }//GEN-LAST:event_medicalRecordsButtonActionPerformed


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
            java.util.logging.Logger.getLogger(BookingSuccessful.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingSuccessful.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingSuccessful.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingSuccessful.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookingSuccessful().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appointmentIDInfoLabel;
    private javax.swing.JLabel appointmentIDLabel;
    private javax.swing.JLabel completedIcon;
    private javax.swing.JLabel dateInfoLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel departmentInfoLabel;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JLabel doctorNameInfoLabel;
    private javax.swing.JLabel doctorNameLabel;
    private javax.swing.JLabel doctorRatingInfoLabel;
    private javax.swing.JButton homeButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton medicalRecordsButton;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel timeInfoLabel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JButton viewStatusButton;
    // End of variables declaration//GEN-END:variables
}
