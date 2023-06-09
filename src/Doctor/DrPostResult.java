/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Doctor;
import Dashboard.*;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 */
public class DrPostResult extends javax.swing.JFrame {

    /**
     * Creates new form DrPostResult
     */
 
    int appointmentID;
    String filename = null;
    byte[] prescription_image = null;
    public DrPostResult() {
        initComponents();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainBack = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        patientInfo = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        AppID = new javax.swing.JTextField();
        Gender = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        DOB = new javax.swing.JTextField();
        chooseAddress = new javax.swing.JTextField();
        AppDate = new javax.swing.JTextField();
        conclusionBox = new javax.swing.JTextField();
        resultBox = new javax.swing.JTextField();
        AppTime = new javax.swing.JTextField();
        viewAppointment = new javax.swing.JButton();
        chooseImg = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        appID = new javax.swing.JLabel();
        patName = new javax.swing.JLabel();
        appDate = new javax.swing.JLabel();
        dob = new javax.swing.JLabel();
        appTime = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        res = new javax.swing.JLabel();
        con = new javax.swing.JLabel();
        pre = new javax.swing.JLabel();
        image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainBack.setBackground(new java.awt.Color(174, 226, 255));

        topPanel.setBackground(new java.awt.Color(39, 123, 192));

        patientInfo.setFont(new java.awt.Font("Bodoni MT", 0, 36)); // NOI18N
        patientInfo.setForeground(new java.awt.Color(255, 255, 255));
        patientInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicons/list.png"))); // NOI18N
        patientInfo.setText("Patient's medical information");

        BackButton.setBackground(new java.awt.Color(0, 129, 201));
        BackButton.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        BackButton.setForeground(new java.awt.Color(255, 255, 255));
        BackButton.setText("Home");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(patientInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(BackButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientInfo)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        AppID.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        AppID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppIDActionPerformed(evt);
            }
        });

        Gender.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        Gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenderActionPerformed(evt);
            }
        });

        name.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        DOB.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        DOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DOBActionPerformed(evt);
            }
        });

        chooseAddress.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N

        AppDate.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N

        conclusionBox.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        conclusionBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conclusionBoxActionPerformed(evt);
            }
        });

        resultBox.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        resultBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultBoxActionPerformed(evt);
            }
        });

        AppTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppTimeActionPerformed(evt);
            }
        });

        viewAppointment.setBackground(new java.awt.Color(39, 123, 192));
        viewAppointment.setText("Find");
        viewAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAppointmentActionPerformed(evt);
            }
        });

        chooseImg.setBackground(new java.awt.Color(39, 123, 192));
        chooseImg.setText("Choose");
        chooseImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseImgActionPerformed(evt);
            }
        });

        submitButton.setBackground(new java.awt.Color(39, 123, 192));
        submitButton.setFont(new java.awt.Font("Cambria", 0, 17)); // NOI18N
        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        appID.setText("Appointment ID:");

        patName.setText("Patient Name:");

        appDate.setText("Date:");

        dob.setText("Date of Birth:");

        appTime.setText("Time:");

        gender.setText("Gender:");

        address.setText("Address:");

        res.setText("Result:");

        con.setText("Conclusion:");

        pre.setText("Prescription:");

        image.setText("Image");

        javax.swing.GroupLayout mainBackLayout = new javax.swing.GroupLayout(mainBack);
        mainBack.setLayout(mainBackLayout);
        mainBackLayout.setHorizontalGroup(
            mainBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainBackLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(mainBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainBackLayout.createSequentialGroup()
                        .addComponent(res)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pre)
                        .addGap(197, 197, 197)
                        .addComponent(chooseImg))
                    .addGroup(mainBackLayout.createSequentialGroup()
                        .addGroup(mainBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(address)
                            .addComponent(appID)
                            .addComponent(patName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chooseAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainBackLayout.createSequentialGroup()
                                .addGroup(mainBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(AppID, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(viewAppointment)
                                .addGap(18, 18, 18)
                                .addGroup(mainBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dob)
                                    .addComponent(appDate))
                                .addGap(18, 18, 18)
                                .addGroup(mainBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AppDate, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(mainBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(appTime))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Gender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AppTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(17, 17, 17))
                    .addGroup(mainBackLayout.createSequentialGroup()
                        .addGroup(mainBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(conclusionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resultBox, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(con))
                        .addGroup(mainBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainBackLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96))
                            .addGroup(mainBackLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 17, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        mainBackLayout.setVerticalGroup(
            mainBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainBackLayout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AppID)
                    .addComponent(viewAppointment)
                    .addComponent(appDate)
                    .addComponent(AppDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appTime)
                    .addComponent(AppTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patName)
                    .addComponent(dob)
                    .addComponent(gender))
                .addGap(18, 18, 18)
                .addGroup(mainBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(address)
                    .addComponent(chooseAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(res)
                    .addComponent(pre)
                    .addComponent(chooseImg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainBackLayout.createSequentialGroup()
                        .addComponent(resultBox, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(con)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(conclusionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainBackLayout.createSequentialGroup()
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AppIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AppIDActionPerformed

    private void GenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenderActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void DOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DOBActionPerformed

    private void conclusionBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conclusionBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conclusionBoxActionPerformed

    private void AppTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AppTimeActionPerformed

    private void viewAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAppointmentActionPerformed
        // TODO add your handling code here:
        appointmentID = Integer.parseInt(AppID.getText());  
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            PreparedStatement stmt = con.prepareStatement("SELECT Appointment.UserID, Appointment.Date, Appointment.Time, SignUp.Name, SignUp.DOB, SignUp.Gender, SignUp.Address FROM Appointment INNER JOIN SignUp ON Appointment.UserID = SignUp.UserID WHERE AppointmentID = ?"); 
            stmt.setInt(1, appointmentID);
            ResultSet rsfill = stmt.executeQuery();
            
            if (rsfill.next()){
                name.setText(rsfill.getString("Name"));
                DOB.setText(rsfill.getString("DOB"));
                Gender.setText(rsfill.getString("Gender"));
                chooseAddress.setText(rsfill.getString("Address"));
                AppDate.setText(rsfill.getString("Date"));
                AppTime.setText(rsfill.getString("Time"));
            }
            stmt.close();
            con.close();
        } catch(ClassNotFoundException | NumberFormatException | SQLException e){
            JOptionPane.showMessageDialog(this, "Appointment is not exist!");
        }
    }//GEN-LAST:event_viewAppointmentActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        appointmentID = Integer.parseInt(AppID.getText());  
        String conclusion, result;
        conclusion = conclusionBox.getText();
        result = resultBox.getText();


        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\test.sqlite");
            String sqlupdate = "UPDATE Appointment SET Result=?, Conclusion=?, Prescription=? WHERE AppointmentID=?";
            PreparedStatement pst = con.prepareStatement(sqlupdate);
            
            pst.setString(1,result);
            pst.setString(2,conclusion);
            pst.setBytes(3,prescription_image);
            pst.setInt(4,appointmentID);
            int i = pst.executeUpdate();
            if(i>0){
                JOptionPane.showMessageDialog(this, "Result Updated");
            } else {
                JOptionPane.showMessageDialog(this, "Result not Updated");
            }
            pst.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void chooseImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseImgActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH));
        image.setIcon(imageIcon);
        try{
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum;(readNum = fis.read(buf)) != -1;){
                bos.write(buf, 0, readNum);
                
            }
            prescription_image = bos.toByteArray();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_chooseImgActionPerformed

    private void resultBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resultBoxActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        AdminHome h = new AdminHome();
        h.show();
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DrPostResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DrPostResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DrPostResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DrPostResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DrPostResult().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AppDate;
    private javax.swing.JTextField AppID;
    private javax.swing.JTextField AppTime;
    private javax.swing.JButton BackButton;
    private javax.swing.JTextField DOB;
    private javax.swing.JTextField Gender;
    private javax.swing.JLabel address;
    private javax.swing.JLabel appDate;
    private javax.swing.JLabel appID;
    private javax.swing.JLabel appTime;
    private javax.swing.JTextField chooseAddress;
    private javax.swing.JButton chooseImg;
    private javax.swing.JLabel con;
    private javax.swing.JTextField conclusionBox;
    private javax.swing.JLabel dob;
    private javax.swing.JLabel gender;
    private javax.swing.JLabel image;
    private javax.swing.JPanel mainBack;
    private javax.swing.JTextField name;
    private javax.swing.JLabel patName;
    private javax.swing.JLabel patientInfo;
    private javax.swing.JLabel pre;
    private javax.swing.JLabel res;
    private javax.swing.JTextField resultBox;
    private javax.swing.JButton submitButton;
    private javax.swing.JPanel topPanel;
    private javax.swing.JButton viewAppointment;
    // End of variables declaration//GEN-END:variables
}
