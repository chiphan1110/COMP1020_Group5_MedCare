/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;
import Dashboard.*;
import ManageAppointment.*;
import MedInfo.*;
import javax.swing.JFrame;
import Register.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.util.ArrayList;

/**
 *
 * @author truonghuy
 */
public class AddInfo extends javax.swing.JFrame {

    /**
     * Creates new form AddInfo
     */
    public AddInfo() {
        initComponents();
        getAdminInfo();
    }
    
    int adminID, doctorID, retrievedDoctorID, timeslotID;
    String name, dateOfBirth, gender, phoneNum, address, selectedDate, selectedTime, selectedDepartment, selectedDoctor, doctorName;
    
    private boolean shouldPerformAction = true;
    
    public void getAdminInfo(){
        adminID = Login.userid;
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            PreparedStatement stmt = conn.prepareStatement("SELECT Name, DOB, Gender, PhoneNumber, Address FROM SignUp WHERE UserID = ?");
            stmt.setInt(1, adminID);
            ResultSet resultSet = stmt.executeQuery();
       
            while (resultSet.next()) {
                name = resultSet.getString("Name");
                dateOfBirth = resultSet.getString("DOB");
                gender = resultSet.getString("Gender");
                phoneNum = resultSet.getString("PhoneNumber");
                address = resultSet.getString("Address");
                
                nameTextField.setText(name);
                dobTextField.setText(dateOfBirth);
                genderTextField.setText(gender);
                phoneNumTextField.setText(phoneNum);
                addressTextField.setText(address);
            }
            
            
            resultSet.close();
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void getTimeslotID(){
        ResultSet resultSet = null;
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            String sql = "SELECT max(AppointmentID) FROM Appointment";
            Statement stmt = conn.createStatement();
            resultSet = stmt.executeQuery(sql);
            
            while(resultSet.next()){
                timeslotID = resultSet.getInt(1);
                timeslotID++;
            }
            resultSet.close();
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void getDoctorName(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            PreparedStatement stmt = conn.prepareStatement("SELECT DoctorName FROM Doctor WHERE Department = ?");
            stmt.setString(1, selectedDepartment);
            ResultSet resultSet = stmt.executeQuery();
            
            shouldPerformAction = false;
            while (resultSet.next()) {
                doctorName = resultSet.getString("DoctorName");
                doctorComboBox.addItem(doctorName);
            }
            shouldPerformAction = true; //commit
            
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void getDoctorID(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            PreparedStatement stmt = conn.prepareStatement("SELECT DoctorID FROM Doctor WHERE DoctorName = ?");
            stmt.setString(1, selectedDoctor);
            ResultSet resultSet = stmt.executeQuery();
          
            while (resultSet.next()) {
                doctorID = resultSet.getInt("DoctorID");
            }
            
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean checkConflictTimeslot(){
        ArrayList<Integer> retrievedDoctorIDs = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            PreparedStatement stmt = conn.prepareStatement("SELECT DISTINCT DoctorID FROM Timeslot WHERE Date = ? AND Time = ? AND Department = ? AND Available = 1");
            stmt.setString(1, selectedDate);
            stmt.setString(2, selectedTime);
            stmt.setString(3, selectedDepartment);
            ResultSet resultSet = stmt.executeQuery();
         
            while (resultSet.next()) {
                retrievedDoctorID = resultSet.getInt("DoctorID");
                retrievedDoctorIDs.add(doctorID);
            }
            
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i : retrievedDoctorIDs){
            if (doctorID == retrievedDoctorID){
                JOptionPane.showMessageDialog(this, "The chosen Doctor is already assigned to this timeslot.");
            }
        }
        return true;
    }
    
    public void insertTimeslot(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            String sql = "INSERT INTO Timeslot (TimeslotID, DoctorID, Date, Time, Available, Department) VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, timeslotID);
            stmt.setInt(2, doctorID);
            stmt.setString(3, selectedDate);
            stmt.setString(4, selectedTime);
            stmt.setInt(5, 1);
            stmt.setString(6, selectedDepartment);
            stmt.setString(7, selectedDepartment);
            stmt.executeUpdate();

            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    boolean validation(){
        
        if(selectedDate.equals("")){
            JOptionPane.showMessageDialog(this, "please fill all field");
            return false;
        }
        
        if(selectedTime.equals("")){
            JOptionPane.showMessageDialog(this, "please fill all field");
            return false;
        }
        
        if(selectedDepartment.equals("")){
            JOptionPane.showMessageDialog(this, "please fill all field");
            return false;
        }
        return true;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideBar = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        viewStatusButton = new javax.swing.JButton();
        medicalRecordsButton = new javax.swing.JButton();
        panelParent = new javax.swing.JPanel();
        timeLabel = new javax.swing.JLabel();
        dateOfBirthLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        phoneNumLabel = new javax.swing.JLabel();
        patienInformationLabel = new javax.swing.JLabel();
        appointmentInformationLabel = new javax.swing.JLabel();
        departmentLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        phoneNumTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        departmentComboBox = new javax.swing.JComboBox<>();
        timeComboBox = new javax.swing.JComboBox<>();
        submitButton = new javax.swing.JButton();
        dobTextField = new javax.swing.JTextField();
        genderTextField = new javax.swing.JTextField();
        doctorLabel = new javax.swing.JLabel();
        doctorComboBox = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sideBar.setBackground(new java.awt.Color(39, 123, 192));
        sideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeButton.setBackground(new java.awt.Color(0, 129, 201));
        homeButton.setFont(new java.awt.Font("Cambria", 1, 17)); // NOI18N
        homeButton.setForeground(new java.awt.Color(255, 255, 255));
        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        sideBar.add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 70));

        viewStatusButton.setBackground(new java.awt.Color(0, 129, 201));
        viewStatusButton.setFont(new java.awt.Font("Cambria", 1, 17)); // NOI18N
        viewStatusButton.setForeground(new java.awt.Color(255, 255, 255));
        viewStatusButton.setText("Manage ");
        viewStatusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStatusButtonActionPerformed(evt);
            }
        });
        sideBar.add(viewStatusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 160, 70));

        medicalRecordsButton.setBackground(new java.awt.Color(0, 129, 201));
        medicalRecordsButton.setFont(new java.awt.Font("Cambria", 1, 17)); // NOI18N
        medicalRecordsButton.setForeground(new java.awt.Color(255, 255, 255));
        medicalRecordsButton.setText("Medical Record");
        medicalRecordsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicalRecordsButtonActionPerformed(evt);
            }
        });
        sideBar.add(medicalRecordsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 160, 70));

        panelParent.setBackground(new java.awt.Color(174, 226, 255));
        panelParent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timeLabel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        timeLabel.setText("Time:");
        panelParent.add(timeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        dateOfBirthLabel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        dateOfBirthLabel.setText("Date of birth:");
        panelParent.add(dateOfBirthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        nameLabel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        nameLabel.setText("Name:");
        panelParent.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        addressLabel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        addressLabel.setText("Address:");
        panelParent.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        genderLabel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        genderLabel.setText("Gender:");
        panelParent.add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        phoneNumLabel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        phoneNumLabel.setText("Phone number:");
        panelParent.add(phoneNumLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        patienInformationLabel.setFont(new java.awt.Font("Cambria", 1, 17)); // NOI18N
        patienInformationLabel.setText("Admin Information");
        panelParent.add(patienInformationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        appointmentInformationLabel.setFont(new java.awt.Font("Cambria", 1, 17)); // NOI18N
        appointmentInformationLabel.setText("Add Timeslot");
        panelParent.add(appointmentInformationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        departmentLabel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        departmentLabel.setText("Department:");
        panelParent.add(departmentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        dateLabel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        dateLabel.setText("Date:");
        panelParent.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        nameTextField.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        panelParent.add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 190, -1));

        phoneNumTextField.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        panelParent.add(phoneNumTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 160, -1));

        addressTextField.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        panelParent.add(addressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 340, -1));

        departmentComboBox.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Internal Medicine", "Pediatrics", "Cardiology", "Dermatology", "Orthopedics", "Emergency Medicine", "Psychiatry" }));
        getAvailableDepartment();
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboBoxActionPerformed(evt);
            }
        });
        panelParent.add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 300, -1));

        timeComboBox.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        timeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeComboBoxActionPerformed(evt);
            }
        });
        panelParent.add(timeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 150, -1));

        submitButton.setBackground(new java.awt.Color(39, 123, 192));
        submitButton.setFont(new java.awt.Font("Cambria", 0, 17)); // NOI18N
        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        panelParent.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 140, 40));

        dobTextField.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        panelParent.add(dobTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 140, -1));

        genderTextField.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        panelParent.add(genderTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 90, -1));

        doctorLabel.setText("Doctor:");
        panelParent.add(doctorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        doctorComboBox.setToolTipText("");
        doctorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorComboBoxActionPerformed(evt);
            }
        });
        panelParent.add(doctorComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));
        panelParent.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(panelParent, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panelParent, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
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

    private void departmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboBoxActionPerformed
        // TODO add your handling code here:
        JComboBox<String> comboBox = (JComboBox<String>) evt.getSource();
        selectedDepartment = comboBox.getSelectedItem().toString();
    }//GEN-LAST:event_departmentComboBoxActionPerformed

    private void timeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeComboBoxActionPerformed
        // TODO add your handling code here:
        JComboBox<String> comboBox = (JComboBox<String>) evt.getSource();
        selectedTime = comboBox.getSelectedItem().toString();
    }//GEN-LAST:event_timeComboBoxActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        if(validation()){
            getDoctorID();
            if (checkConflictTimeslot()){
                insertTimeslot();
            }
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void doctorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doctorComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(AddInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JLabel appointmentInformationLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel dateOfBirthLabel;
    private javax.swing.JComboBox<String> departmentComboBox;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JTextField dobTextField;
    private javax.swing.JComboBox<String> doctorComboBox;
    private javax.swing.JLabel doctorLabel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JTextField genderTextField;
    private javax.swing.JButton homeButton;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JButton medicalRecordsButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPanel panelParent;
    private javax.swing.JLabel patienInformationLabel;
    private javax.swing.JLabel phoneNumLabel;
    private javax.swing.JTextField phoneNumTextField;
    private javax.swing.JPanel sideBar;
    private javax.swing.JButton submitButton;
    private javax.swing.JComboBox<String> timeComboBox;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JButton viewStatusButton;
    // End of variables declaration//GEN-END:variables
}
