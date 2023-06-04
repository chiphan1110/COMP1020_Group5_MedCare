/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;
import Patient.MedRecord;
import Patient.ManageApppointment;
import Dashboard.*;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author truonghuy
 */
public class AdManageTimeslot extends javax.swing.JFrame {

    /**
     * Creates new form AddInfo
     */
    public AdManageTimeslot() {
        initComponents();
        updateTimeslotTable();
    }
    

    int doctorID, timeslotID;
    String selectedTime, selectedDepartment, selectedDoctor, doctorName, selectedDate, existingTime;
    
    String retrievedTimeslotID, retrievedDoctorID, retrievedDate, retrievedTime, retrievedAvailable, retrievedDepartment;
    
    private boolean shouldPerformAction = true;
    
    public void updateTimeslotTable(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            PreparedStatement stmt = conn.prepareStatement("SELECT TimeslotID, DoctorID, Date, Time, Available, Department FROM Timeslot");
            ResultSet resultSet = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel)timeslotTable.getModel();
            model.setRowCount(0);
       
            while (resultSet.next()) {
                
                retrievedTimeslotID = String.valueOf(resultSet.getInt("TimeslotID"));
                retrievedDoctorID = String.valueOf(resultSet.getInt("DoctorID"));
                retrievedDate = resultSet.getString("Date");
                retrievedTime = resultSet.getString("Time");
                retrievedAvailable = String.valueOf(resultSet.getInt("Available"));
                retrievedDepartment = resultSet.getString("Department");
                  
                String tbData[] = {retrievedTimeslotID, retrievedDoctorID, retrievedDate, retrievedTime, retrievedAvailable, retrievedDepartment};  
                model.addRow(tbData); 
            }
            resultSet.close();
            stmt.close();
            conn.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void createTimeslotID(){
        ResultSet resultSet = null;
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            String sql = "SELECT max(TimeslotID) FROM Timeslot";
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
            shouldPerformAction = true;
            
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
    
    public void getAvailableTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        selectedDate = format.format(jDateChooser.getDate());
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            PreparedStatement stmt = conn.prepareStatement("SELECT DISTINCT Time FROM Timeslot WHERE Department = ? AND DoctorID = ? AND Date = ?");
            stmt.setString(1, selectedDepartment);
            stmt.setInt(2, doctorID);
            stmt.setString(3, selectedDate);
            ResultSet resultSet = stmt.executeQuery();
         
            while (resultSet.next()) {
                existingTime = resultSet.getString("Time");
                timeComboBox.removeItem(existingTime);
            }
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            stmt.executeUpdate();

            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    boolean validationOfAdding(){
        
        if(selectedDate.equals("")){
            JOptionPane.showMessageDialog(this, "please fill all field");
            return false;
        }
        
        if (selectedDoctor.equals("")){
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
        panelParent = new javax.swing.JPanel();
        timeLabel = new javax.swing.JLabel();
        appointmentInformationLabel = new javax.swing.JLabel();
        departmentLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox<>();
        timeComboBox = new javax.swing.JComboBox<>();
        AddButton = new javax.swing.JButton();
        doctorLabel = new javax.swing.JLabel();
        doctorComboBox = new javax.swing.JComboBox<>();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        timeslotTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        DeleteButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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
        viewStatusButton.setText("<html><center> Manage <br> Appointment </center></html>");
        viewStatusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStatusButtonActionPerformed(evt);
            }
        });
        sideBar.add(viewStatusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 160, 70));

        panelParent.setBackground(new java.awt.Color(174, 226, 255));
        panelParent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timeLabel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        timeLabel.setText("Time:");
        panelParent.add(timeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        appointmentInformationLabel.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        appointmentInformationLabel.setText("Add Timeslot");
        panelParent.add(appointmentInformationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        departmentLabel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        departmentLabel.setText("Department:");
        panelParent.add(departmentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        dateLabel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        dateLabel.setText("Date:");
        panelParent.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        departmentComboBox.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Internal Medicine", "Pediatrics", "Cardiology", "Dermatology", "Orthopedics", "Emergency Medicine", "Psychiatry" }));
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboBoxActionPerformed(evt);
            }
        });
        panelParent.add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 220, -1));

        timeComboBox.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        timeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "9.00-9.30", "9.30-10.00", "10.00-10.30", "10.30-11.00", "14.00-14.30", "14.30-15.00", "15.00-15.30", "15.30-16.00", "16.00-16.30", "16.30-17.00", "19.00-19.30", "19.30-20.00", "20.00-20.30", "20.30-21.00" }));
        timeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeComboBoxActionPerformed(evt);
            }
        });
        panelParent.add(timeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 160, -1));

        AddButton.setBackground(new java.awt.Color(39, 123, 192));
        AddButton.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        AddButton.setForeground(new java.awt.Color(255, 255, 255));
        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        panelParent.add(AddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 140, 40));

        doctorLabel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        doctorLabel.setText("Doctor:");
        panelParent.add(doctorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        doctorComboBox.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        doctorComboBox.setToolTipText("");
        doctorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorComboBoxActionPerformed(evt);
            }
        });
        panelParent.add(doctorComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 200, -1));

        jDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserPropertyChange(evt);
            }
        });
        panelParent.add(jDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 190, -1));
        jDateChooser.setMinSelectableDate(new Date());

        timeslotTable.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        timeslotTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Timeslot ID", "Doctor ID", "Date", "Time", "Available", "Department"
            }
        ));
        jScrollPane1.setViewportView(timeslotTable);

        panelParent.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 580, 180));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setText("Delete Timeslot");
        panelParent.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        DeleteButton.setBackground(new java.awt.Color(39, 123, 192));
        DeleteButton.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        DeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        panelParent.add(DeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, 140, 40));

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel2.setText("* Select timeslot in the table above");
        panelParent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 464, -1, -1));

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        jLabel3.setText("Timeslot Table");
        panelParent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

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
<<<<<<< HEAD
        AdminHome home = new AdminHome();
=======
        PatientHome home = new PatientHome();
>>>>>>> main
        home.show();
        this.dispose();

    }//GEN-LAST:event_homeButtonActionPerformed

    private void viewStatusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStatusButtonActionPerformed
        // TODO add your handling code here:
<<<<<<< HEAD
        AdManageAppointment mana = new AdManageAppointment();
=======
        ManageApppointment mana = new ManageApppointment();
>>>>>>> main
        mana.show();
        this.dispose();
    }//GEN-LAST:event_viewStatusButtonActionPerformed

<<<<<<< HEAD
=======
    private void medicalRecordsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicalRecordsButtonActionPerformed
        // TODO add your handling code here:
        MedRecord med = new MedRecord();
        med.show();
        this.dispose();
    }//GEN-LAST:event_medicalRecordsButtonActionPerformed

>>>>>>> main
    private void departmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboBoxActionPerformed
        // TODO add your handling code here:
        if (shouldPerformAction){
            JComboBox<String> comboBox = (JComboBox<String>) evt.getSource();
            selectedDepartment = comboBox.getSelectedItem().toString();
            getDoctorName();
        }
    }//GEN-LAST:event_departmentComboBoxActionPerformed

    private void timeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeComboBoxActionPerformed
        // TODO add your handling code here:
        JComboBox<String> comboBox = (JComboBox<String>) evt.getSource();
        selectedTime = comboBox.getSelectedItem().toString();
    }//GEN-LAST:event_timeComboBoxActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        // TODO add your handling code here:
        if(validationOfAdding()){
            createTimeslotID();
            insertTimeslot();
            JOptionPane.showMessageDialog(this, "Added new timeslot successfully");
            updateTimeslotTable();
        }
    }//GEN-LAST:event_AddButtonActionPerformed

    private void doctorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorComboBoxActionPerformed
        // TODO add your handling code here:
        JComboBox<String> comboBox = (JComboBox<String>) evt.getSource();
        selectedDoctor = comboBox.getSelectedItem().toString();
        getDoctorID();
    }//GEN-LAST:event_doctorComboBoxActionPerformed

    private void jDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserPropertyChange
        // TODO add your handling code here:
        if ("date".equals(evt.getPropertyName())) {
            getAvailableTime();
        }
    }//GEN-LAST:event_jDateChooserPropertyChange

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        int row = timeslotTable.getSelectedRow();

        if (row == -1){
            JOptionPane.showMessageDialog(this, "Please choose the timeslot!");
        } else {
            timeslotID = Integer.parseInt(timeslotTable.getValueAt(row, 0).toString());
            
            
            try{
                Class.forName("org.sqlite.JDBC");
                Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM Timeslot WHERE TimeslotID = ?");
                stmt.setInt(1, timeslotID);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Timeslot deleted successfully.");
                } else {
                    System.out.println("No timeslot found with the given id.");
                }
                conn.close();
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
            JOptionPane.showMessageDialog(this, "Timeslot deleted.");
        }
        updateTimeslotTable();
    }//GEN-LAST:event_DeleteButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AdManageTimeslot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdManageTimeslot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdManageTimeslot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdManageTimeslot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AdManageTimeslot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JLabel appointmentInformationLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JComboBox<String> departmentComboBox;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JComboBox<String> doctorComboBox;
    private javax.swing.JLabel doctorLabel;
    private javax.swing.JButton homeButton;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelParent;
    private javax.swing.JPanel sideBar;
    private javax.swing.JComboBox<String> timeComboBox;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTable timeslotTable;
    private javax.swing.JButton viewStatusButton;
    // End of variables declaration//GEN-END:variables
}
