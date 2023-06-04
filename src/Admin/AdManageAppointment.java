/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;
<<<<<<< HEAD
import Dashboard.*;
=======
>>>>>>> main
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class AdManageAppointment extends javax.swing.JFrame {
    /**
     * Creates new form UserInfo
     */
    public static int patientID;
    public static int appointmentID;
    public AdManageAppointment() {
        initComponents();
        updateStatus();
        UpdateIncomingAppointment();
        UpdatePastAppointment();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    String appointID, userID, name, doctorID, doctorname, date, time, department, symptom;
    
    public void updateStatus(){
            try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            PreparedStatement stmt = conn.prepareStatement("SELECT AppointmentID, Date from Appointment");
//            stmt.setInt(1, userid);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int ID = rs.getInt("AppointmentID");
                String D = rs.getString("Date");

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
            conn.close();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void UpdateIncomingAppointment(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
<<<<<<< HEAD
            PreparedStatement stmt = conn.prepareStatement("SELECT Appointment.AppointmentID, Appointment.UserID, SignUp.Name, Appointment.DoctorID, Appointment.DoctorName, Appointment.Date, Appointment.Time,Appointment.Department,Appointment.Symptom FROM Appointment INNER JOIN SignUp ON Appointment.UserID = SignUp.UserID WHERE Status = ?");
=======
            PreparedStatement stmt = conn.prepareStatement("SELECT Appointment.*, SignUp.* FROM Appointment INNER JOIN SignUp ON Appointment.UserID = SignUp.UserID WHERE Status = ?");
>>>>>>> main
            stmt.setString(1, "Incoming");
            ResultSet rsTable = stmt.executeQuery();
            DefaultTableModel tb1Model = (DefaultTableModel)IncomingTable.getModel();
            tb1Model.setRowCount(0);
       
            while (rsTable.next()) {
                appointID = rsTable.getString("AppointmentID");
                userID = rsTable.getString("UserID");
                name = rsTable.getString("Name");
                doctorID = rsTable.getString("DoctorID");
                doctorname = rsTable.getString("DoctorName");
                date = rsTable.getString("Date");
                time = rsTable.getString("Time");
                department = rsTable.getString("Department");
                symptom = rsTable.getString("Symptom");
                  
                String tbData[] = {appointID, userID, name, date, time, department,doctorID, doctorname, symptom};  
                tb1Model.addRow(tbData); 
            }
            rsTable.close();
            stmt.close();
            conn.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void UpdatePastAppointment(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            PreparedStatement stmt = conn.prepareStatement("SELECT Appointment.AppointmentID, Appointment.UserID, SignUp.Name, Appointment.DoctorName, Appointment.Date, Appointment.Time, Appointment.Department, Appointment.Symptom FROM Appointment INNER JOIN SignUP ON Appointment.UserID = SignUp.UserID WHERE Status = ?");
            stmt.setString(1, "Past");  
            ResultSet rsTable = stmt.executeQuery();
            DefaultTableModel tb1Model = (DefaultTableModel)PastTable.getModel();
            tb1Model.setRowCount(0);
       
            while (rsTable.next()) {
                
                appointID = rsTable.getString("AppointmentID");
                userID = rsTable.getString("UserID");
                name = rsTable.getString("Name");
//                doctorID = rsTable.getString("DoctorID");
                doctorname = rsTable.getString("DoctorName");
                date = rsTable.getString("Date");
                time = rsTable.getString("Time");
                department = rsTable.getString("Department");
                symptom = rsTable.getString("Symptom");
                  
                String tbData[] = {appointID, userID, name, date, time, department,doctorID, doctorname, symptom};  
                tb1Model.addRow(tbData); 
            }
            rsTable.close();
            stmt.close();
            conn.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainboard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ViewFeedback = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        IncomingTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        PastTable = new javax.swing.JTable();
        CancelAppoint = new javax.swing.JToggleButton();
        topboard = new javax.swing.JPanel();
        Back = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainboard.setBackground(new java.awt.Color(174, 226, 255));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel1.setText("Incoming Appointments:");

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel3.setText("Past Appointments:");

        ViewFeedback.setText("View Feedback");
        ViewFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewFeedbackActionPerformed(evt);
            }
        });

        IncomingTable.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        IncomingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Appoint. ID", "User ID", "Patient Name", "Date", "Time", "Department", "Dr. ID", "Dr. Name", "Symptom"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        IncomingTable.getTableHeader().setReorderingAllowed(false);
        IncomingTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IncomingTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(IncomingTable);
        if (IncomingTable.getColumnModel().getColumnCount() > 0) {
            IncomingTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            IncomingTable.getColumnModel().getColumn(1).setPreferredWidth(20);
            IncomingTable.getColumnModel().getColumn(2).setPreferredWidth(45);
            IncomingTable.getColumnModel().getColumn(3).setPreferredWidth(25);
            IncomingTable.getColumnModel().getColumn(4).setPreferredWidth(25);
            IncomingTable.getColumnModel().getColumn(6).setPreferredWidth(20);
            IncomingTable.getColumnModel().getColumn(7).setResizable(false);
            IncomingTable.getColumnModel().getColumn(7).setPreferredWidth(35);
        }

        PastTable.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        PastTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Appoint. ID", "User ID", "Patient Name", "Date", "Time", "Department", "Dr. ID", "Dr. Name", "Symptom"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PastTable.getTableHeader().setReorderingAllowed(false);
        PastTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PastTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(PastTable);
        if (PastTable.getColumnModel().getColumnCount() > 0) {
            PastTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            PastTable.getColumnModel().getColumn(1).setPreferredWidth(20);
            PastTable.getColumnModel().getColumn(2).setPreferredWidth(45);
            PastTable.getColumnModel().getColumn(3).setPreferredWidth(25);
            PastTable.getColumnModel().getColumn(4).setPreferredWidth(25);
            PastTable.getColumnModel().getColumn(6).setPreferredWidth(20);
            PastTable.getColumnModel().getColumn(7).setResizable(false);
            PastTable.getColumnModel().getColumn(7).setPreferredWidth(35);
        }

        CancelAppoint.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        CancelAppoint.setText("Cancel Appointment");
        CancelAppoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelAppointActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainboardLayout = new javax.swing.GroupLayout(mainboard);
        mainboard.setLayout(mainboardLayout);
        mainboardLayout.setHorizontalGroup(
            mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainboardLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainboardLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CancelAppoint, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(mainboardLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ViewFeedback))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        mainboardLayout.setVerticalGroup(
            mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainboardLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainboardLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(mainboardLayout.createSequentialGroup()
                        .addGroup(mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(CancelAppoint, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(mainboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ViewFeedback)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
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
<<<<<<< HEAD
        AdminHome home= new AdminHome();
=======
        Dashboard.PatientHome home = new Dashboard.PatientHome();
>>>>>>> main
        home.show();
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void IncomingTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IncomingTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_IncomingTableMouseClicked

    private void ViewFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewFeedbackActionPerformed
        int view = PastTable.getSelectedRow();

        if (view == -1){
            JOptionPane.showMessageDialog(this, "Please choose the appointment!");
        } else {
            appointmentID = Integer.parseInt(PastTable.getValueAt(view, 0).toString());
            patientID = Integer.parseInt(PastTable.getValueAt(view, 1).toString());
            AdView1Feedback adviewfb = new AdView1Feedback();
            adviewfb.show();
            this.dispose();

        }  
    }//GEN-LAST:event_ViewFeedbackActionPerformed

    private void PastTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PastTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PastTableMouseClicked

    private void CancelAppointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelAppointActionPerformed
        // TODO add your handling code here:
        int view = IncomingTable.getSelectedRow();

        if (view == -1){
            JOptionPane.showMessageDialog(this, "Please choose the appointment!");
        } else {
            int choice = JOptionPane.showOptionDialog(this, "Are you sure to cancel this appointment?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"OK", "Discard"}, "OK");
            if (choice == JOptionPane.OK_OPTION){
                int appID = Integer.parseInt(IncomingTable.getValueAt(view, 0).toString());
                String date = IncomingTable.getValueAt(view, 3).toString();
                String time = IncomingTable.getValueAt(view, 4).toString();
                String doctorID = IncomingTable.getValueAt(view, 6).toString();

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
                    PreparedStatement stmt2 = conn.prepareStatement("UPDATE Timeslot SET Available = 1 WHERE Date = ? AND Time = ? AND DoctorID = ?");
                   
                    stmt2.setString(1, date);
                    stmt2.setString(2, time );
                    stmt2.setString(3, doctorID);
                    int i = stmt2.executeUpdate();
                    if (i > 0) {
                        System.out.println("Timeslot updated successfully.");
                    } else {
                        System.out.println("No timeslot found with the given id.");
                    }
                    conn.close();
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
                JOptionPane.showMessageDialog(this, "Appointment cancelled.");
            }
        }
        UpdateIncomingAppointment();
    }//GEN-LAST:event_CancelAppointActionPerformed
    
                           
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
            java.util.logging.Logger.getLogger(AdManageAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdManageAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdManageAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdManageAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdManageAppointment().setVisible(true);
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
    private javax.swing.JTable jTable2;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back;
    private javax.swing.JButton BackButton;
    private javax.swing.JToggleButton CancelAppoint;
    private javax.swing.JTable IncomingTable;
    private javax.swing.JTable PastTable;
    private javax.swing.JButton ViewFeedback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel mainboard;
    private javax.swing.JPanel topboard;
    // End of variables declaration//GEN-END:variables
}
