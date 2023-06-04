/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Patient;
import Register.*;
import java.sql.*;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class ManageApppointment extends javax.swing.JFrame {
    /**
     * Creates new form UserInfo
     */
    int userid = Login.userid;
    public static int appointmentID;
    public ManageApppointment() {
        initComponents();
        getPatientInfo();
        updateIncomingAppointment();
        updatePastAppointment();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    String name, dateOfBirth, gender, address, phoneNum;
//    public int userID = Login.userid;
    
    public void getPatientInfo(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            PreparedStatement stmt = conn.prepareStatement("SELECT Name, DOB, Gender, PhoneNumber, Address FROM SignUp WHERE UserID = ?");
            stmt.setInt(1, userid);
            ResultSet resultSet = stmt.executeQuery();
       
            while (resultSet.next()) {
                name = resultSet.getString("Name");
                dateOfBirth = resultSet.getString("DOB");
                gender = resultSet.getString("Gender");
                phoneNum = resultSet.getString("PhoneNumber");
                address = resultSet.getString("Address");
                
                
                nameTextField.setText(name);
                UserID.setText(String.valueOf(userid));
                dobTextField.setText(dateOfBirth);
                genderTextField1.setText(gender);
                phoneNumTextField1.setText(phoneNum);
                addressText.setText(address);
            }
            resultSet.close();
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void updateIncomingAppointment(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            //            Statement stmt = conn.createStatement();
            PreparedStatement stmt = conn.prepareStatement("SELECT * from Appointment WHERE UserID = ?");
            stmt.setInt(1, userid);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int ID = rs.getInt("AppointmentID");
                String D = rs.getString("Date");

<<<<<<< HEAD
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
=======
                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd");
>>>>>>> main
                Date date = dateFormat.parse(D);
                Date currentDate = new Date();
                currentDate.setYear(0);
                date.setYear(0);
                int comparisonResult = date.compareTo(currentDate);
                //                    System.out.println(D);
                //                    System.out.println(currentDate);
                //                    System.out.println(comparisonResult);
                String status = (comparisonResult < 0) ? "Past" : "Incoming";
                PreparedStatement updateStmt = conn.prepareStatement("UPDATE Appointment SET Status = ? WHERE AppointmentID = ?");
                updateStmt.setString(1, status);
                //                   updateStmt.setInt(2, userid);
                updateStmt.setInt(2, ID);
                updateStmt.executeUpdate();
            }

           
            PreparedStatement stmt2 = conn.prepareStatement("SELECT * from Appointment WHERE UserID = ? AND Status = ?");
            stmt2.setInt(1, userid);
            stmt2.setString(2, "Incoming");
            ResultSet rs2 = stmt2.executeQuery();
            DefaultTableModel tb1Model = (DefaultTableModel)jTable1.getModel();
            tb1Model.setRowCount(0);
            while (rs2.next()){
                String id = String.valueOf(rs2.getInt("AppointmentID"));
                String D = rs2.getString("Date");
                String Time = rs2.getString("Time");
                String Doctor = rs2.getString("DoctorName");
                String doctorID = rs2.getString("DoctorID");
                String department = rs2.getString("Department");
                //                String Stat = rs.getString("Status");
                String tbData[] = {id, D, Time, department, Doctor, doctorID};
                //                tb1Model.setColumnCount(0);
                tb1Model.addRow(tbData);
            }
            rs2.close();
            stmt.close();
            conn.close();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void updatePastAppointment(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            //            Statement stmt = conn.createStatement();
            PreparedStatement stmt = conn.prepareStatement("SELECT * from Appointment WHERE UserID = ?");
            stmt.setInt(1, userid);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int ID = rs.getInt("AppointmentID");
                String D = rs.getString("Date");

<<<<<<< HEAD
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
=======
                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd");
>>>>>>> main
                Date date = dateFormat.parse(D);
                Date currentDate = new Date();
                currentDate.setYear(0);
                date.setYear(0);
                int comparisonResult = date.compareTo(currentDate);
                //                    System.out.println(D);
                //                    System.out.println(currentDate);
                //                    System.out.println(comparisonResult);
                String status = (comparisonResult < 0) ? "Past" : "Incoming";
                PreparedStatement updateStmt = conn.prepareStatement("UPDATE Appointment SET Status = ? WHERE AppointmentID = ?");
                updateStmt.setString(1, status);
                //                   updateStmt.setInt(2, userid);
                updateStmt.setInt(2, ID);
                updateStmt.executeUpdate();
            }

            DefaultTableModel tb2Model = (DefaultTableModel)jTable2.getModel();
            tb2Model.setRowCount(0);
            PreparedStatement stmt3 = conn.prepareStatement("SELECT * from Appointment WHERE UserID = ? AND Status = ?");
            stmt3.setInt(1, userid);
            stmt3.setString(2, "Past");
            ResultSet rs3 = stmt3.executeQuery();
            while (rs3.next()){
                String id = String.valueOf(rs3.getInt("AppointmentID"));
                String D = rs3.getString("Date");
                String Time = rs3.getString("Time");
                String Doctor = rs3.getString("DoctorName");
                String doctorID = rs3.getString("DoctorID");
                String department = rs3.getString("Department");
                //                String Stat = rs.getString("Status");
                String tb2Data[] = {id, D, Time, department, Doctor, doctorID};

                tb2Model.addRow(tb2Data);
                //                jTable1.getColumnModel().getColumn(5).setCellRenderer(new ManageButtonRenderer());
                //                jTable1.getColumnModel().getColumn(5).setCellEditor(new ManageButtonEditor());
            }
            rs3.close();
            stmt.close();
            conn.close();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainboard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ID1 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        dateOfBirthLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        dobTextField = new javax.swing.JTextField();
        genderLabel1 = new javax.swing.JLabel();
        genderTextField1 = new javax.swing.JTextField();
        phoneNumLabel1 = new javax.swing.JLabel();
        phoneNumTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        ApointmentBT = new javax.swing.JToggleButton();
        ApointmentBT1 = new javax.swing.JToggleButton();
        UserID = new javax.swing.JTextField();
        dateOfBirthLabel1 = new javax.swing.JLabel();
        addressText = new javax.swing.JTextField();
        topboard = new javax.swing.JPanel();
        Back = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainboard.setBackground(new java.awt.Color(174, 226, 255));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Appointment ID", "Date", "Time", "Department", "Doctor Name", "Doctor ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 100));

        ID1.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        ID1.setText("User ID:");

        nameLabel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        nameLabel.setText("Name:");

        dateOfBirthLabel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        dateOfBirthLabel.setText("Date of birth:");

        nameTextField.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N

        dobTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobTextFieldActionPerformed(evt);
            }
        });

        genderLabel1.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        genderLabel1.setText("Gender:");

        genderTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderTextField1ActionPerformed(evt);
            }
        });

        phoneNumLabel1.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        phoneNumLabel1.setText("Phone number:");

        phoneNumTextField1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel1.setText("Incoming Appointments:");

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel2.setText("Past Appointments:");

        jTable2.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Appointment ID", "Date", "Time", "Department", "Doctor Name", "Doctor ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        ApointmentBT.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        ApointmentBT.setText("Provide Feedback");
        ApointmentBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApointmentBTActionPerformed(evt);
            }
        });

        ApointmentBT1.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        ApointmentBT1.setText("Cancel Appointment");
        ApointmentBT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApointmentBT1ActionPerformed(evt);
            }
        });

        UserID.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N

        dateOfBirthLabel1.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        dateOfBirthLabel1.setText("Address:");

        addressText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainboardLayout = new javax.swing.GroupLayout(mainboard);
        mainboard.setLayout(mainboardLayout);
        mainboardLayout.setHorizontalGroup(
            mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainboardLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainboardLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ApointmentBT1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainboardLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ApointmentBT, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainboardLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateOfBirthLabel)
                            .addComponent(nameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dobTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(mainboardLayout.createSequentialGroup()
                                .addComponent(phoneNumLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(phoneNumTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainboardLayout.createSequentialGroup()
                                .addComponent(ID1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(UserID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainboardLayout.createSequentialGroup()
                                .addComponent(dateOfBirthLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainboardLayout.createSequentialGroup()
                                .addComponent(genderLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(genderTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        mainboardLayout.setVerticalGroup(
            mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainboardLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel)
                    .addComponent(ID1)
                    .addComponent(UserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genderTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genderLabel1))
                .addGap(18, 18, 18)
                .addGroup(mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateOfBirthLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addGroup(mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(phoneNumLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dobTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateOfBirthLabel)
                        .addComponent(phoneNumTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ApointmentBT1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ApointmentBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        getContentPane().add(mainboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 800, 440));

        topboard.setBackground(new java.awt.Color(39, 123, 192));

        Back.setFont(new java.awt.Font("Bodoni MT", 0, 36)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicons/admin.png"))); // NOI18N
        Back.setText("Manage Appointment");

        BackButton.setBackground(new java.awt.Color(0, 129, 201));
        BackButton.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        BackButton.setForeground(new java.awt.Color(255, 255, 255));
        BackButton.setText("Home");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topboardLayout = new javax.swing.GroupLayout(topboard);
        topboard.setLayout(topboardLayout);
        topboardLayout.setHorizontalGroup(
            topboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topboardLayout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
            .addGroup(topboardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topboardLayout.setVerticalGroup(
            topboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topboardLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Back)
                .addContainerGap())
        );

        getContentPane().add(topboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 160));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        Dashboard.PatientHome home = new Dashboard.PatientHome();
        home.show();
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void addressTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTextActionPerformed

    private void ApointmentBT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApointmentBT1ActionPerformed
        // TODO add your handling code here:
        int view = jTable1.getSelectedRow();

        if (view == -1){
            JOptionPane.showMessageDialog(this, "Please choose the appointment!");
        } else {
            int choice = JOptionPane.showOptionDialog(this, "Are you sure to cancel this appointment?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"OK", "Discard"}, "OK");
            if (choice == JOptionPane.OK_OPTION){
                int appID = Integer.parseInt(jTable1.getValueAt(view, 0).toString());
                String date = jTable1.getValueAt(view, 1).toString();
                String time = jTable1.getValueAt(view, 2).toString();
                String doctorID = jTable1.getValueAt(view, 5).toString();
                
                try{
                    Class.forName("org.sqlite.JDBC");
                    Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
                                                
//                  Delete from Appointment
                    PreparedStatement stmt1 = conn.prepareStatement("DELETE FROM Appointment WHERE AppointmentID = ?");
                    stmt1.setInt(1, appID);
                    int rowsAffected = stmt1.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Appointment deleted successfully.");
                    } else {
                        System.out.println("No appointment found with the given id.");
                    }
                    
                    
//                  Reset available timeslot 
                    PreparedStatement stmt = conn.prepareStatement("UPDATE Timeslot SET Available = 1 WHERE Date = ? AND Time = ? AND DoctorID = ?");
                    System.out.println(date);
                    System.out.println(time);
                    System.out.println(doctorID);

                    stmt.setString(1, date);
                    stmt.setString(2, time );
                    stmt.setString(3, doctorID);
                    int i = stmt.executeUpdate();
                    if (i > 0) {
                        System.out.println("Timeslot updated successfully.");
                    } else {
                        System.out.println("No timeslot found with the given id.");
                    }
                   
                    stmt.close();
                    conn.close();
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
                JOptionPane.showMessageDialog(this, "Appointment cancelled.");
            }
        }
        updateIncomingAppointment();
    }//GEN-LAST:event_ApointmentBT1ActionPerformed

    private void ApointmentBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApointmentBTActionPerformed
        // TODO add your handling code here:
        int view = jTable2.getSelectedRow();

        if (view == -1){
            JOptionPane.showMessageDialog(this, "Please choose the appointment!");
        } else {
            appointmentID = Integer.parseInt(jTable2.getValueAt(view, 0).toString());
            System.out.println(appointmentID);
            try{
                Class.forName("org.sqlite.JDBC");
                Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
                //            Statement stmt = conn.createStatement();
                PreparedStatement stmt = conn.prepareStatement("SELECT FirstFB from Appointment WHERE AppointmentID = ?");
                stmt.setInt(1, appointmentID);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    int FB = rs.getInt("FirstFB");
                    System.out.println(FB);
                    if (FB == 0){
                        JOptionPane.showMessageDialog(null, "This appointment has already been given feedback. Thank you!");
                    } else{
                        Feedback1 rate = new Feedback1();
                        rate.show();
                        this.dispose();
                    }   
                }   
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex);
                }
            }
            
    }//GEN-LAST:event_ApointmentBTActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void genderTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderTextField1ActionPerformed

    private void dobTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobTextFieldActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //        // TODO add your handling code here:
        //        int currentRow = jTable1.getSelectedRow();
        //        System.out.println(currentRow);
    }//GEN-LAST:event_jTable1MouseClicked
    
                           
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageApppointment().setVisible(true);
            }
        });
    }
//    public void loadData(){
//        connection = JavaSqlite.connectDB();
//        if(connection != null){
//            String sql = "Select id, date, time, doctor";
//            try{
//                pst = connection.prepareStatement(sql);
//                rs = pst.executeQuery();
//                
//                Object[] columnData = new Object[4];
//                
//                
//            } catch (Exception e){
//                JOptionPane.showMessageDialog(null, e);
//            }
//        }
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ApointmentBT;
    private javax.swing.JToggleButton ApointmentBT1;
    private javax.swing.JLabel Back;
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel ID1;
    private javax.swing.JTextField UserID;
    private javax.swing.JTextField addressText;
    private javax.swing.JLabel dateOfBirthLabel;
    private javax.swing.JLabel dateOfBirthLabel1;
    private javax.swing.JTextField dobTextField;
    private javax.swing.JLabel genderLabel1;
    private javax.swing.JTextField genderTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel mainboard;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel phoneNumLabel1;
    private javax.swing.JTextField phoneNumTextField1;
    private javax.swing.JPanel topboard;
    // End of variables declaration//GEN-END:variables
}
