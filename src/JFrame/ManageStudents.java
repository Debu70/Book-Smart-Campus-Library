/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.jar.Attributes.Name;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Dell
 */
public class ManageStudents extends javax.swing.JFrame {

     /**
      * Creates new form Managestudents
      */
     public ManageStudents() {
          initComponents();
          setStudentDetailsToTable();
     }
     String  student_name,course,branch;
     int student_id;
     DefaultTableModel model;
     
     
     //to set the student details to table
     public void setStudentDetailsToTable(){
          try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/library_ms","root","");
               Statement st = con.createStatement();
               ResultSet  rs = st.executeQuery("select * from student_details");
               
               while(rs.next()){
                    String  student_id = rs.getString("student_id");
                    String student_name = rs.getString("student_name");
                    String course =  rs.getString("course");
                    String branch = rs.getString("branch");
                    
                    Object[]  obj = {student_id,student_name,course,branch};
                    model=(DefaultTableModel)tbl_studentDetails.getModel();
                    model.addRow(obj);
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
     }
     
       //To add student details to the table
     public boolean addStudent(){
          boolean isAdded = false;
         student_id = Integer.parseInt(txt_studentID.getText());
          student_name = txt_studentName.getText();
          course =ComboCourse.getSelectedItem().toString();
          branch = ComboBranch.getSelectedItem().toString();
                  
         
          try {
               Connection con = DBConnection.getConnection();
               String sql = "insert into student_details values(?,?,?,?)";
               PreparedStatement  pst = con.prepareStatement(sql);
               pst.setInt(1, student_id);
               pst.setString(2, student_name);
               pst.setString(3, course);
               pst.setString(4, branch);
               
               int rowCount = pst.executeUpdate();
               if (rowCount>0) {
                    isAdded=true;
               }else{
                    isAdded=false;
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
          return isAdded;
     }
     
     //to update student detaols
     
     public boolean  updateStudent(){
            boolean isUpdated = false;
          student_id = Integer.parseInt(txt_studentID.getText());
          student_name = txt_studentName.getText();
          course =ComboCourse.getSelectedItem().toString();
          branch = ComboBranch.getSelectedItem().toString();
               
               try {
               Connection con = DBConnection.getConnection();
               String sql = "update student_details set student_name=?,course=?,branch=? where student_name =?";
               PreparedStatement pst = con.prepareStatement(sql);
              
               pst.setInt(1, student_id);
               pst.setString(2, student_name);
               pst.setString(3, course);
               pst.setString(4, branch);
               
               
               
               int rowCount = pst.executeUpdate();
                    if (rowCount > 0) {
                         isUpdated = true;
                    }else{
                         isUpdated = false;
                    }
          } catch (Exception e) {
               e.printStackTrace();
          }
               return isUpdated;
     }
     
     //clear table
     public void clearTable(){
          DefaultTableModel model =(DefaultTableModel ) tbl_studentDetails.getModel();
          model.setRowCount(0);
     }
     
     // to delete the row ofstudent table
     public boolean deleteStudent(){
          boolean isDeleted = false;
          student_id = Integer.parseInt(txt_studentID.getText());
          
          try {
               Connection con = DBConnection.getConnection();
               String sql = "delete from student_details where student_id = ?";
               PreparedStatement pst = con.prepareStatement(sql);
                 pst.setInt(1, student_id);
               int rowCount =  pst.executeUpdate();
               
               if (rowCount > 0) {
                    isDeleted = true;
               }else{
                    isDeleted = false;
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
          return  isDeleted;
     }
     

     /**
      * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
      */
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jPanel1 = new javax.swing.JPanel();
          jPanel2 = new javax.swing.JPanel();
          jLabel1 = new javax.swing.JLabel();
          jLabel2 = new javax.swing.JLabel();
          jLabel7 = new javax.swing.JLabel();
          jLabel5 = new javax.swing.JLabel();
          txt_studentID = new app.bolivia.swing.JCTextField();
          jLabel8 = new javax.swing.JLabel();
          jLabel6 = new javax.swing.JLabel();
          txt_studentName = new app.bolivia.swing.JCTextField();
          jLabel9 = new javax.swing.JLabel();
          jLabel10 = new javax.swing.JLabel();
          jLabel11 = new javax.swing.JLabel();
          jLabel12 = new javax.swing.JLabel();
          DeleteBTN = new rojerusan.RSMaterialButtonCircle();
          AddBTN = new rojerusan.RSMaterialButtonCircle();
          UpdateBTN = new rojerusan.RSMaterialButtonCircle();
          ComboBranch = new javax.swing.JComboBox<>();
          ComboCourse = new javax.swing.JComboBox<>();
          jLabel3 = new javax.swing.JLabel();
          jPanel3 = new javax.swing.JPanel();
          jScrollPane2 = new javax.swing.JScrollPane();
          tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
          jLabel4 = new javax.swing.JLabel();
          jPanel4 = new javax.swing.JPanel();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setUndecorated(true);
          getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jPanel1.setBackground(new java.awt.Color(51, 255, 51));
          jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jPanel2.setBackground(new java.awt.Color(204, 204, 204));
          jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jPanel2MouseClicked(evt);
               }
          });
          jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel1.setFont(new java.awt.Font("Javanese Text", 1, 24)); // NOI18N
          jLabel1.setText("BACK");
          jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 100, 40));

          jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcon/icons8_Rewind_48px.png"))); // NOI18N
          jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

          jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 50));

          jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcon/icons8_Contact_26px.png"))); // NOI18N
          jLabel7.setPreferredSize(new java.awt.Dimension(30, 20));
          jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, -1, 30));

          jLabel5.setFont(new java.awt.Font("Goudy Old Style", 0, 36)); // NOI18N
          jLabel5.setText("Student ID");
          jLabel5.setIconTextGap(5);
          jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, -1, -1));

          txt_studentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));
          txt_studentID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txt_studentID.setPlaceholder("Enter Student ID");
          txt_studentID.addFocusListener(new java.awt.event.FocusAdapter() {
               public void focusLost(java.awt.event.FocusEvent evt) {
                    txt_studentIDFocusLost(evt);
               }
          });
          jPanel1.add(txt_studentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 260, 70));

          jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcon/icons8_Moleskine_26px.png"))); // NOI18N
          jLabel8.setPreferredSize(new java.awt.Dimension(30, 20));
          jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, -1, 30));

          jLabel6.setFont(new java.awt.Font("Goudy Old Style", 0, 36)); // NOI18N
          jLabel6.setText("Student Name");
          jLabel6.setIconTextGap(5);
          jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, -1, -1));

          txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));
          txt_studentName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txt_studentName.setPlaceholder("Enter Student Name");
          txt_studentName.addFocusListener(new java.awt.event.FocusAdapter() {
               public void focusLost(java.awt.event.FocusEvent evt) {
                    txt_studentNameFocusLost(evt);
               }
          });
          jPanel1.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 260, 70));

          jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcon/icons8_Collaborator_Male_26px.png"))); // NOI18N
          jLabel9.setPreferredSize(new java.awt.Dimension(30, 20));
          jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, -1, 30));

          jLabel10.setFont(new java.awt.Font("Goudy Old Style", 0, 36)); // NOI18N
          jLabel10.setText("Course");
          jLabel10.setIconTextGap(5);
          jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, -1, -1));

          jLabel11.setFont(new java.awt.Font("Goudy Old Style", 0, 36)); // NOI18N
          jLabel11.setText("Branch");
          jLabel11.setIconTextGap(5);
          jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 620, -1, -1));

          jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcon/icons8_Unit_26px.png"))); // NOI18N
          jLabel12.setPreferredSize(new java.awt.Dimension(30, 20));
          jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 630, -1, 30));

          DeleteBTN.setBackground(new java.awt.Color(204, 204, 204));
          DeleteBTN.setForeground(new java.awt.Color(0, 0, 0));
          DeleteBTN.setText("DELETE");
          DeleteBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          DeleteBTN.setFont(new java.awt.Font("Goudy Old Style", 1, 36)); // NOI18N
          DeleteBTN.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    DeleteBTNMouseClicked(evt);
               }
          });
          jPanel1.add(DeleteBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 750, 270, 90));

          AddBTN.setBackground(new java.awt.Color(204, 204, 204));
          AddBTN.setForeground(new java.awt.Color(0, 0, 0));
          AddBTN.setText("ADD");
          AddBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          AddBTN.setFont(new java.awt.Font("Goudy Old Style", 1, 36)); // NOI18N
          AddBTN.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    AddBTNActionPerformed(evt);
               }
          });
          jPanel1.add(AddBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 750, 270, 90));

          UpdateBTN.setBackground(new java.awt.Color(204, 204, 204));
          UpdateBTN.setForeground(new java.awt.Color(0, 0, 0));
          UpdateBTN.setText("UPDATE");
          UpdateBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          UpdateBTN.setFont(new java.awt.Font("Goudy Old Style", 1, 36)); // NOI18N
          UpdateBTN.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    UpdateBTNMouseClicked(evt);
               }
          });
          jPanel1.add(UpdateBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 750, 270, 90));

          ComboBranch.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
          ComboBranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select your branch --", "CSE", "CSIT", "MECH", "CIVIL", "ECE", "EEE", "EE", "BCA", "MCA", "MSC", " " }));
          ComboBranch.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ComboBranchActionPerformed(evt);
               }
          });
          jPanel1.add(ComboBranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 610, 260, 70));

          ComboCourse.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
          ComboCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select your course --", "B.TECH", "MEDICAL", " " }));
          ComboCourse.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ComboCourseActionPerformed(evt);
               }
          });
          jPanel1.add(ComboCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 520, 260, 70));

          getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 1100));

          jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 48)); // NOI18N
          jLabel3.setText("X");
          jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jLabel3MouseClicked(evt);
               }
          });
          getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1880, 0, 40, 50));

          jPanel3.setBackground(new java.awt.Color(255, 255, 255));
          jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {

               },
               new String [] {
                    "Student ID", "Student Name", "Course", "Branch"
               }
          ));
          tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(51, 255, 51));
          tbl_studentDetails.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
          tbl_studentDetails.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
          tbl_studentDetails.setColorForegroundHead(new java.awt.Color(0, 0, 0));
          tbl_studentDetails.setColorSelBackgound(new java.awt.Color(153, 255, 0));
          tbl_studentDetails.setColorSelForeground(new java.awt.Color(0, 0, 0));
          tbl_studentDetails.setFuenteHead(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
          tbl_studentDetails.setRowHeight(40);
          tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tbl_studentDetailsMouseClicked(evt);
               }
          });
          jScrollPane2.setViewportView(tbl_studentDetails);

          jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 900, 590));

          jLabel4.setFont(new java.awt.Font("Goudy Old Style", 1, 36)); // NOI18N
          jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcon/icons8_Student_Male_100px.png"))); // NOI18N
          jLabel4.setText(" Manage Students");
          jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 410, 100));

          jPanel4.setBackground(new java.awt.Color(255, 51, 0));
          jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
          jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 350, 5));

          getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 1090, 1100));

          setSize(new java.awt.Dimension(1986, 1099));
          setLocationRelativeTo(null);
     }// </editor-fold>//GEN-END:initComponents

     private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
          System.exit(0);
     }//GEN-LAST:event_jLabel3MouseClicked

     private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
          Lobby lob1= new Lobby();
          lob1.setVisible(true);
          dispose();
     }//GEN-LAST:event_jPanel2MouseClicked

     private void txt_studentIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIDFocusLost

     }//GEN-LAST:event_txt_studentIDFocusLost

     private void txt_studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentNameFocusLost
          // TODO add your handling code here:
     }//GEN-LAST:event_txt_studentNameFocusLost

     private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
          int rowNo = tbl_studentDetails.getSelectedRow();
          TableModel model = tbl_studentDetails.getModel();
          
          txt_studentID.setText(model.getValueAt(rowNo, 0).toString());
          txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
         ComboCourse.setSelectedItem(model.getValueAt(rowNo, 2).toString());
         ComboBranch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
     }//GEN-LAST:event_tbl_studentDetailsMouseClicked

     private void AddBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBTNActionPerformed
          if (addStudent() == true) {
               //JOptionPane.showMessageDialog(this, "student Added");
               clearTable();
               setStudentDetailsToTable();
          }else{
               JOptionPane.showMessageDialog(this, "Please check Yourself , student not added");
          }
     }//GEN-LAST:event_AddBTNActionPerformed

     private void UpdateBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBTNMouseClicked
            if (updateStudent()== true) {
               JOptionPane.showMessageDialog(this, "Student Details Updated");
               
               setStudentDetailsToTable();
               clearTable();
          }else{
               JOptionPane.showMessageDialog(this, "Please check Yourself , Student not updated");
          }
     }//GEN-LAST:event_UpdateBTNMouseClicked

     private void DeleteBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBTNMouseClicked
          if (deleteStudent()== true) {
               JOptionPane.showMessageDialog(this, "Student Delete");
               clearTable();
               setStudentDetailsToTable();
          }else{
               JOptionPane.showMessageDialog(this, "Please check Yourself , student not Delete");
          }
     
     }//GEN-LAST:event_DeleteBTNMouseClicked

     private void ComboBranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBranchActionPerformed
          // TODO add your handling code here:
     }//GEN-LAST:event_ComboBranchActionPerformed

     private void ComboCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCourseActionPerformed
          // TODO add your handling code here:
     }//GEN-LAST:event_ComboCourseActionPerformed

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
               java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>
          //</editor-fold>

          /* Create and display the form */
          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    new ManageStudents().setVisible(true);
               }
          });
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private rojerusan.RSMaterialButtonCircle AddBTN;
     private javax.swing.JComboBox<String> ComboBranch;
     private javax.swing.JComboBox<String> ComboCourse;
     private rojerusan.RSMaterialButtonCircle DeleteBTN;
     private rojerusan.RSMaterialButtonCircle UpdateBTN;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel10;
     private javax.swing.JLabel jLabel11;
     private javax.swing.JLabel jLabel12;
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
     private javax.swing.JPanel jPanel4;
     private javax.swing.JScrollPane jScrollPane2;
     private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
     private app.bolivia.swing.JCTextField txt_studentID;
     private app.bolivia.swing.JCTextField txt_studentName;
     // End of variables declaration//GEN-END:variables
}
