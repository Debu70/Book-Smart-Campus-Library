/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;
import java.*;
import static JFrame.DBConnection.con;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class SignUpPage extends javax.swing.JFrame {

     /**
      * Creates new form SignUpPage
      */
     public SignUpPage() {
          initComponents();
     }
     
     public void insertSignupDetails(){
          String name = txt_username.getText();
          String password = txt_password.getText();
          String email = txt_email.getText();
          String contact = txt_contact.getText();

          try {
               Connection con = DBConnection.getConnection();
               String sql = "insert into users(name,password,email,contact) values(?,?,?,?)";
               PreparedStatement  pst = con.prepareStatement(sql);
               
               pst.setString(1, name);
               pst.setString(2, password);
               pst.setString(3, email);
               pst.setString(4, contact);
               
             int updateRowCount =   pst.executeUpdate();
               if (updateRowCount > 0) {
                    JOptionPane.showMessageDialog(this, "Recorded Inserted Successfully");
                    LoginPage logpage = new LoginPage();
                    logpage.setVisible(true);
                    
               }
               else{
                    JOptionPane.showMessageDialog(this, "Recorded IInsertion Failure");
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
          
     }
     
     //vallidation 
     public boolean validateSignup(){
          String name = txt_username.getText();
          String password = txt_password.getText();
          String email = txt_email.getText();
          String contact = txt_contact.getText();
          
          if(name.equals("")){
               JOptionPane.showMessageDialog(this, "Please Enter UserName");
               return false;
          }
          if(name.equals("")){
               JOptionPane.showMessageDialog(this, "Please Enter Password");
               return false;
          }
          if (email.equals("") || !email.matches("^.+@.+\\..+$")) {
               JOptionPane.showMessageDialog(this, "Please Enter a valid EmailID");
          }
          if(contact.equals("")){
               JOptionPane.showMessageDialog(this, "Please Enter Password");
               return false;
          }
          return  true;
     }
     //check duplicate users
     public boolean checkDuplicateUser(){
          String name = txt_username.getText();
          boolean isExist=false;
          try {
               Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
            
            PreparedStatement pst = con.prepareStatement("select * from signupPage where name = ?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
               if (rs.next()) {
                    isExist = true;
               }else{
                    isExist=false;
               }
          } catch (Exception e) {
          }
                  return isExist;
     }

     /**
      * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
      */
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          rSPasswordTextPlaceHolderBeanInfo1 = new rojerusan.RSPasswordTextPlaceHolderBeanInfo();
          jPanel2 = new javax.swing.JPanel();
          jLabel1 = new javax.swing.JLabel();
          jLabel2 = new javax.swing.JLabel();
          jPanel1 = new javax.swing.JPanel();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          jLabel5 = new javax.swing.JLabel();
          txt_username = new app.bolivia.swing.JCTextField();
          jLabel6 = new javax.swing.JLabel();
          jLabel7 = new javax.swing.JLabel();
          jLabel8 = new javax.swing.JLabel();
          jLabel9 = new javax.swing.JLabel();
          txt_password = new app.bolivia.swing.JCTextField();
          jLabel10 = new javax.swing.JLabel();
          jLabel11 = new javax.swing.JLabel();
          txt_email = new app.bolivia.swing.JCTextField();
          jLabel12 = new javax.swing.JLabel();
          jLabel13 = new javax.swing.JLabel();
          txt_contact = new app.bolivia.swing.JCTextField();
          rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
          rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
          jLabel14 = new javax.swing.JLabel();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setUndecorated(true);
          getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jPanel2.setBackground(new java.awt.Color(255, 255, 255));
          jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel1.setBackground(new java.awt.Color(255, 255, 255));
          jLabel1.setFont(new java.awt.Font("Gabriola", 1, 48)); // NOI18N
          jLabel1.setForeground(new java.awt.Color(255, 51, 51));
          jLabel1.setText("My Library");
          jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 200, 50));

          jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/signup-library-icon.png"))); // NOI18N
          jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 820, 620));

          getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 990, 1090));

          jPanel1.setBackground(new java.awt.Color(255, 255, 255));

          jLabel3.setBackground(new java.awt.Color(255, 255, 255));
          jLabel3.setFont(new java.awt.Font("Goudy Old Style", 0, 48)); // NOI18N
          jLabel3.setForeground(new java.awt.Color(255, 51, 51));
          jLabel3.setText("Signup Page");

          jLabel4.setBackground(new java.awt.Color(255, 255, 255));
          jLabel4.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
          jLabel4.setText("Create a New Account");

          jLabel5.setFont(new java.awt.Font("Goudy Old Style", 0, 36)); // NOI18N
          jLabel5.setText("UserName");
          jLabel5.setIconTextGap(5);

          txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));
          txt_username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txt_username.setPlaceholder("Enter Your Name");
          txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
               public void focusLost(java.awt.event.FocusEvent evt) {
                    txt_usernameFocusLost(evt);
               }
          });

          jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile.png"))); // NOI18N
          jLabel7.setPreferredSize(new java.awt.Dimension(30, 20));

          jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/padlock (1).png"))); // NOI18N
          jLabel8.setPreferredSize(new java.awt.Dimension(30, 20));

          jLabel9.setFont(new java.awt.Font("Goudy Old Style", 0, 36)); // NOI18N
          jLabel9.setText("Password");
          jLabel9.setIconTextGap(5);

          txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));
          txt_password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txt_password.setPlaceholder("Enter Your Password");

          jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/email (1).png"))); // NOI18N
          jLabel10.setPreferredSize(new java.awt.Dimension(30, 20));

          jLabel11.setFont(new java.awt.Font("Goudy Old Style", 0, 36)); // NOI18N
          jLabel11.setText("Email");
          jLabel11.setIconTextGap(5);

          txt_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));
          txt_email.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txt_email.setPlaceholder("Enter Your Email");

          jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/phone (1).png"))); // NOI18N
          jLabel12.setPreferredSize(new java.awt.Dimension(30, 20));

          jLabel13.setFont(new java.awt.Font("Goudy Old Style", 0, 36)); // NOI18N
          jLabel13.setText("Contact");
          jLabel13.setIconTextGap(5);

          txt_contact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));
          txt_contact.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txt_contact.setPlaceholder("Enter Your Contact No.");

          rSMaterialButtonCircle1.setBackground(new java.awt.Color(153, 255, 153));
          rSMaterialButtonCircle1.setForeground(new java.awt.Color(0, 0, 0));
          rSMaterialButtonCircle1.setLabel("Login");
          rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rSMaterialButtonCircle1ActionPerformed(evt);
               }
          });

          rSMaterialButtonCircle2.setBackground(new java.awt.Color(51, 255, 51));
          rSMaterialButtonCircle2.setForeground(new java.awt.Color(0, 0, 0));
          rSMaterialButtonCircle2.setText("Signup");
          rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rSMaterialButtonCircle2ActionPerformed(evt);
               }
          });

          jLabel14.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 48)); // NOI18N
          jLabel14.setText("X");
          jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jLabel14MouseClicked(evt);
               }
          });

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addGap(337, 337, 337)
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addGap(366, 366, 366)
                              .addComponent(rSMaterialButtonCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addGap(264, 264, 264)
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                             .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addGap(21, 21, 21)
                                             .addComponent(jLabel13)
                                             .addGap(78, 78, 78)
                                             .addComponent(txt_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                             .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addGap(18, 18, 18)
                                             .addComponent(jLabel11)
                                             .addGap(103, 103, 103)
                                             .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addGap(42, 42, 42)
                                        .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addGap(64, 64, 64)
                                        .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(241, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                              .addComponent(jLabel6)
                              .addGap(869, 869, 869))
                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                              .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(77, 77, 77))))
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                         .addGap(367, 367, 367)
                         .addComponent(rSMaterialButtonCircle2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addContainerGap(488, Short.MAX_VALUE)))
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(129, 129, 129)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addComponent(jLabel6)
                              .addGap(429, 429, 429))
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addComponent(jLabel3)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(jLabel4)
                              .addGap(123, 123, 123)
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                   .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jLabel5)
                                   .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                              .addGap(18, 18, 18)
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                   .addComponent(jLabel11)
                                   .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGap(18, 18, 18)
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                   .addComponent(jLabel13)
                                   .addComponent(txt_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGap(130, 130, 130)))
                    .addComponent(rSMaterialButtonCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(183, Short.MAX_VALUE))
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                         .addContainerGap(724, Short.MAX_VALUE)
                         .addComponent(rSMaterialButtonCircle2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(280, 280, 280)))
          );

          getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 1110, 1080));

          setSize(new java.awt.Dimension(2008, 1080));
          setLocationRelativeTo(null);
     }// </editor-fold>//GEN-END:initComponents

     private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
          if (validateSignup()==true) {
               if (checkDuplicateUser() == false) {
                    insertSignupDetails();
               }
               else{
                    JOptionPane.showMessageDialog(this, "UserName already exist");
               }
          }
          
     }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

     private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
          System.exit(0);
     }//GEN-LAST:event_jLabel14MouseClicked

     private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
          if ( checkDuplicateUser()==true) {
               //JOptionPane.showMessageDialog(this, "UserName already exist");
          }
     }//GEN-LAST:event_txt_usernameFocusLost

     private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
          LoginPage l2 = new LoginPage();
          l2.setVisible(true);
          dispose();
     }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

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
               java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          /* Create and display the form */
          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    new SignUpPage().setVisible(true);
               }
          });
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel10;
     private javax.swing.JLabel jLabel11;
     private javax.swing.JLabel jLabel12;
     private javax.swing.JLabel jLabel13;
     private javax.swing.JLabel jLabel14;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JLabel jLabel6;
     private javax.swing.JLabel jLabel7;
     private javax.swing.JLabel jLabel8;
     private javax.swing.JLabel jLabel9;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
     private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
     private rojerusan.RSPasswordTextPlaceHolderBeanInfo rSPasswordTextPlaceHolderBeanInfo1;
     private app.bolivia.swing.JCTextField txt_contact;
     private app.bolivia.swing.JCTextField txt_email;
     private app.bolivia.swing.JCTextField txt_password;
     private app.bolivia.swing.JCTextField txt_username;
     // End of variables declaration//GEN-END:variables
}
