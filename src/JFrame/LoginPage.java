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
public class LoginPage extends javax.swing.JFrame {

     /**
      * Creates new form SignUpPage
      */
     public LoginPage() {
          initComponents();
     }
     
//validation
     public boolean validationLogin(){
          String name = txt_username.getText();
          String password = txt_password.getText();
          
          if (name.equals("")) {
               JOptionPane.showMessageDialog(this, "Please Enter Your Name");
          }
          if (password.equals("")) {
               JOptionPane.showMessageDialog(this, "Please Enter Your Password");
          }
          return true;
     }
  
     
     //verified 
     public void login(){
          String name = txt_username.getText();
          String password = txt_password.getText();
          
          try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/library_ms","root","");
               PreparedStatement pst = con.prepareStatement("select * from users where name = ? and password = ?");
               
               pst.setString(1, name);
               pst.setString(2, password);
               
               ResultSet rs = pst.executeQuery();
               if(rs.next()){
                    JOptionPane.showMessageDialog(this, "Login Successfully !");
                    Lobby lob = new Lobby();
                    lob.setVisible(true);
                    this.dispose();
               }else{
                    JOptionPane.showMessageDialog(this, "Incorrect Username or Password");
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
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
          jLabel5 = new javax.swing.JLabel();
          txt_username = new app.bolivia.swing.JCTextField();
          jLabel6 = new javax.swing.JLabel();
          jLabel7 = new javax.swing.JLabel();
          jLabel8 = new javax.swing.JLabel();
          jLabel9 = new javax.swing.JLabel();
          txt_password = new app.bolivia.swing.JCTextField();
          rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
          rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
          jLabel14 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          jPanel3 = new javax.swing.JPanel();
          jLabel10 = new javax.swing.JLabel();

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
          jLabel3.setText("Login Page");

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

          rSMaterialButtonCircle1.setBackground(new java.awt.Color(51, 255, 51));
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

          jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
          jLabel4.setText("Already have an Account ?");

          jPanel3.setBackground(new java.awt.Color(255, 255, 255));

          javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
          jPanel3.setLayout(jPanel3Layout);
          jPanel3Layout.setHorizontalGroup(
               jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 171, Short.MAX_VALUE)
          );
          jPanel3Layout.setVerticalGroup(
               jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 39, Short.MAX_VALUE)
          );

          jLabel10.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
          jLabel10.setForeground(new java.awt.Color(0, 51, 204));
          jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          jLabel10.setText("Create New ");
          jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jLabel10MouseClicked(evt);
               }
          });

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(211, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                              .addComponent(jLabel6)
                              .addGap(869, 869, 869))
                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                              .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(116, 116, 116))))
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(277, 277, 277)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addGap(99, 99, 99)
                              .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
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
                                   .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(18, 18, 18)
                              .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addGap(69, 69, 69)
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                   .addComponent(rSMaterialButtonCircle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(rSMaterialButtonCircle2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(119, 119, 119)
                    .addComponent(jLabel6)
                    .addGap(48, 48, 48)
                    .addComponent(jLabel3)
                    .addGap(46, 46, 46)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                         .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel5)
                         .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGap(33, 33, 33)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                         .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGap(18, 18, 18)
                    .addComponent(rSMaterialButtonCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(rSMaterialButtonCircle2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(354, Short.MAX_VALUE))
          );

          getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 1080, 1080));

          setSize(new java.awt.Dimension(1980, 1080));
          setLocationRelativeTo(null);
     }// </editor-fold>//GEN-END:initComponents

     private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
       SignUpPage spg = new SignUpPage();
       spg.setVisible(true);
          dispose();
          
     }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

     private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
          System.exit(0);
     }//GEN-LAST:event_jLabel14MouseClicked

     private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
          
     }//GEN-LAST:event_txt_usernameFocusLost

     private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
          if (validationLogin()) {
               login();
          }
     }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

     private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
          SignUpPage s3 = new SignUpPage();
          s3.setVisible(true);
          dispose();
     }//GEN-LAST:event_jLabel10MouseClicked

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
               java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>
          //</editor-fold>

          /* Create and display the form */
          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    new LoginPage().setVisible(true);
               }
          });
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel10;
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
     private javax.swing.JPanel jPanel3;
     private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
     private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
     private rojerusan.RSPasswordTextPlaceHolderBeanInfo rSPasswordTextPlaceHolderBeanInfo1;
     private app.bolivia.swing.JCTextField txt_password;
     private app.bolivia.swing.JCTextField txt_username;
     // End of variables declaration//GEN-END:variables
}
