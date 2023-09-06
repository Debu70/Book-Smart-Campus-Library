/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class IssueBook extends javax.swing.JFrame {

     /**
      * Creates new form IssueBook
      */
     public IssueBook() {
          initComponents();
     }
//to fetch the book_details from database
     public void getBookDetails(){
          int  book_id = Integer.parseInt(txt_bookID.getText());
          try {
               Connection con = DBConnection.getConnection();
               PreparedStatement pst = con.prepareStatement("select * from book_details where book_id=?");
               pst.setInt(1, book_id);
               ResultSet rs = pst.executeQuery();
               
               if(rs.next()){
                    lbl_bookId.setText(rs.getString("book_id"));
                    lbl_bookName.setText(rs.getString("book_name"));
                    lbl_author.setText(rs.getString("author_name"));
                    lbl_quantity.setText(rs.getString("quantity"));
               }else{
                    lbl_bookError.setText("Invalid Book Details");
               }
               
          } catch (Exception e) {
               e.printStackTrace();
          }
          
     }
     
     //to fetch the Student_details from database
     public void getStudentDetails(){
          int  student_id = Integer.parseInt(txt_StudentId.getText());
          try {
               Connection con = DBConnection.getConnection();
               PreparedStatement pst = con.prepareStatement("select * from student_details where student_id=?");
               pst.setInt(1, student_id);
               ResultSet rs = pst.executeQuery();
               
               if(rs.next()){
                    lbl_StudentID.setText(rs.getString("student_id"));
                    lbl_StudentName.setText(rs.getString("student_name"));
                    lbl_course.setText(rs.getString("course"));
                    lbl_branch.setText(rs.getString("branch"));
               }else{
                    lbl_studentError.setText("Invalid Student Details");
               }
               
          } catch (Exception e) {
               e.printStackTrace();
          }
          
     }
     
     //insert issue_book_details to database
     public  boolean  issueBook(){
          boolean isIssued =  false;
          
          int  book_id = Integer.parseInt(txt_bookID.getText());
           int  student_id = Integer.parseInt(txt_StudentId.getText());
           String book_name = lbl_bookName .getText();
            String student_name = lbl_StudentName.getText();
            
            java.util.Date  uissueDate = date_issueDate.getDatoFecha();
            java.util.Date  udueDate = date_dueDate.getDatoFecha();
            
            Long l1 = uissueDate.getTime();
            Long l2 = udueDate.getTime();
                    
            
            java.sql.Date  sissueDate = new  java.sql.Date(l1);
            java.sql.Date  sdueDate = new  java.sql.Date(l2);
            
            try {
               Connection con = DBConnection.getConnection();
               String sql = "insert into issue_book_details(book_id,book_name,student_id,student_name,issue_date,due_date,status) values(?,?,?,?,?,?,?)";
               PreparedStatement pst = con.prepareStatement(sql);
               pst.setInt(1, book_id);
               pst.setString(2, book_name);
               pst.setInt(3, student_id);
               pst.setString(4, student_name);
               pst.setDate(5, sissueDate);
               pst.setDate(6, sdueDate);
               pst.setString(7, "Pending");
               
               int rowCount = pst.executeUpdate();
               if(rowCount>0){
                    isIssued = true;
               }else{
                    isIssued = false;
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
            return isIssued;
}
     
     //updating the book Quantity
     public void UpdateBookQuantity(){
     int  book_id = Integer.parseInt(txt_bookID.getText());
          try {
               Connection con =DBConnection.getConnection();
               String sql = "update book_details set quantity= quantity-1 where book_id = ?";
                PreparedStatement pst = con.prepareStatement(sql);
               pst.setInt(1, book_id);
               

               int rowCount =   pst.executeUpdate();
               if(rowCount>0){
                    JOptionPane.showMessageDialog(this, "Book Quantity Updated ");
                    int intialCount = Integer.parseInt(lbl_quantity.getText());
                    lbl_quantity .setText(Integer.toString(intialCount - 1));
               }else{
                    JOptionPane.showMessageDialog(this, "Book Not Found ");
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
     }
     
     //check Duplicate book alloted
     public boolean isAlreadyIssued(){
          boolean isAlreadyIssued = false;
          int  book_id = Integer.parseInt(txt_bookID.getText());
          int  student_id = Integer.parseInt(txt_StudentId.getText());
          
          try {
               Connection con =DBConnection.getConnection();
               String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
               PreparedStatement pst = con.prepareStatement(sql);
               pst.setInt(1, book_id);
               pst.setInt(2, student_id);
               pst.setString(3, "Pending");
               ResultSet rs = pst.executeQuery();
               if(rs.next()){
                    isAlreadyIssued = true;
               }else{
                    isAlreadyIssued = false;
               }
          } catch (Exception e) {
               
               e.printStackTrace();
          }
          return isAlreadyIssued;
     }
     
     /**
      * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
      */
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          panel_main = new javax.swing.JPanel();
          jPanel1 = new javax.swing.JPanel();
          jPanel2 = new javax.swing.JPanel();
          jLabel1 = new javax.swing.JLabel();
          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          jLabel5 = new javax.swing.JLabel();
          jLabel6 = new javax.swing.JLabel();
          jLabel7 = new javax.swing.JLabel();
          lbl_quantity = new javax.swing.JLabel();
          jLabel9 = new javax.swing.JLabel();
          lbl_bookId = new javax.swing.JLabel();
          lbl_bookName = new javax.swing.JLabel();
          lbl_author = new javax.swing.JLabel();
          lbl_bookError = new javax.swing.JLabel();
          jPanel3 = new javax.swing.JPanel();
          jLabel15 = new javax.swing.JLabel();
          jLabel16 = new javax.swing.JLabel();
          jLabel17 = new javax.swing.JLabel();
          jLabel18 = new javax.swing.JLabel();
          lbl_branch = new javax.swing.JLabel();
          jLabel20 = new javax.swing.JLabel();
          lbl_StudentID = new javax.swing.JLabel();
          lbl_StudentName = new javax.swing.JLabel();
          lbl_course = new javax.swing.JLabel();
          lbl_studentError = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          jLabel8 = new javax.swing.JLabel();
          txt_bookID = new app.bolivia.swing.JCTextField();
          jLabel10 = new javax.swing.JLabel();
          jLabel11 = new javax.swing.JLabel();
          txt_StudentId = new app.bolivia.swing.JCTextField();
          jLabel12 = new javax.swing.JLabel();
          jLabel13 = new javax.swing.JLabel();
          btn_issueBook = new rojerusan.RSMaterialButtonCircle();
          date_dueDate = new rojeru_san.componentes.RSDateChooser();
          date_issueDate = new rojeru_san.componentes.RSDateChooser();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setUndecorated(true);
          getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          panel_main.setBackground(new java.awt.Color(255, 255, 255));
          panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jPanel1.setBackground(new java.awt.Color(102, 255, 102));
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
          jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jLabel1MouseClicked(evt);
               }
          });
          jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 100, 40));

          jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcon/icons8_Rewind_48px.png"))); // NOI18N
          jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

          jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 50));

          jLabel3.setFont(new java.awt.Font("Goudy Old Style", 1, 48)); // NOI18N
          jLabel3.setText("Book Details");
          jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 300, 60));

          jLabel5.setFont(new java.awt.Font("Goudy Old Style", 1, 24)); // NOI18N
          jLabel5.setText("Book ID ::");
          jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 120, 40));

          jLabel6.setFont(new java.awt.Font("Goudy Old Style", 1, 24)); // NOI18N
          jLabel6.setText("Book Name::");
          jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 140, 40));

          jLabel7.setFont(new java.awt.Font("Goudy Old Style", 1, 24)); // NOI18N
          jLabel7.setText("Author Name ::");
          jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 160, 40));

          lbl_quantity.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
          jPanel1.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 550, 230, 50));

          jLabel9.setFont(new java.awt.Font("Goudy Old Style", 1, 24)); // NOI18N
          jLabel9.setText("Quantity ::");
          jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 240, 40));

          lbl_bookId.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
          jPanel1.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 230, 50));

          lbl_bookName.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
          jPanel1.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 230, 50));

          lbl_author.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
          jPanel1.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 230, 50));

          lbl_bookError.setFont(new java.awt.Font("Segoe UI Variable", 0, 36)); // NOI18N
          lbl_bookError.setForeground(new java.awt.Color(204, 0, 0));
          jPanel1.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 670, 420, 60));

          panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 1080));

          jPanel3.setBackground(new java.awt.Color(102, 255, 102));
          jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel15.setFont(new java.awt.Font("Goudy Old Style", 1, 48)); // NOI18N
          jLabel15.setText("Student Details");
          jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 320, 60));

          jLabel16.setFont(new java.awt.Font("Goudy Old Style", 1, 24)); // NOI18N
          jLabel16.setText("Student ID ::");
          jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 140, 40));

          jLabel17.setFont(new java.awt.Font("Goudy Old Style", 1, 24)); // NOI18N
          jLabel17.setText("Student Name::");
          jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 160, 40));

          jLabel18.setFont(new java.awt.Font("Goudy Old Style", 1, 24)); // NOI18N
          jLabel18.setText("Course ::");
          jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 160, 40));

          lbl_branch.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
          jPanel3.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 550, 230, 50));

          jLabel20.setFont(new java.awt.Font("Goudy Old Style", 1, 24)); // NOI18N
          jLabel20.setText("Branch ::");
          jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 240, 40));

          lbl_StudentID.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
          jPanel3.add(lbl_StudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 230, 50));

          lbl_StudentName.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
          jPanel3.add(lbl_StudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 230, 50));

          lbl_course.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
          jPanel3.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 230, 50));

          lbl_studentError.setFont(new java.awt.Font("Segoe UI Variable", 0, 36)); // NOI18N
          lbl_studentError.setForeground(new java.awt.Color(204, 0, 0));
          jPanel3.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 660, 440, 60));

          panel_main.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 650, 1080));

          jLabel4.setFont(new java.awt.Font("Goudy Old Style", 1, 48)); // NOI18N
          jLabel4.setText("Issue Books");
          panel_main.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 300, 240, 90));

          jLabel8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 48)); // NOI18N
          jLabel8.setText("X");
          jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jLabel8MouseClicked(evt);
               }
          });
          panel_main.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1880, 0, 110, 40));

          txt_bookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));
          txt_bookID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txt_bookID.setPlaceholder("Enter Book ID");
          txt_bookID.addFocusListener(new java.awt.event.FocusAdapter() {
               public void focusLost(java.awt.event.FocusEvent evt) {
                    txt_bookIDFocusLost(evt);
               }
          });
          panel_main.add(txt_bookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 480, 260, 70));

          jLabel10.setFont(new java.awt.Font("Goudy Old Style", 0, 36)); // NOI18N
          jLabel10.setText("Book ID ::");
          jLabel10.setIconTextGap(5);
          panel_main.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 500, 150, -1));

          jLabel11.setFont(new java.awt.Font("Goudy Old Style", 0, 36)); // NOI18N
          jLabel11.setText("Issue Date :: ");
          jLabel11.setIconTextGap(5);
          panel_main.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 730, 180, -1));

          txt_StudentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));
          txt_StudentId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txt_StudentId.setPlaceholder("Enter Student ID");
          txt_StudentId.addFocusListener(new java.awt.event.FocusAdapter() {
               public void focusLost(java.awt.event.FocusEvent evt) {
                    txt_StudentIdFocusLost(evt);
               }
          });
          panel_main.add(txt_StudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 590, 260, 70));

          jLabel12.setFont(new java.awt.Font("Goudy Old Style", 0, 36)); // NOI18N
          jLabel12.setText("Student ID :: ");
          jLabel12.setIconTextGap(5);
          panel_main.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 610, 180, -1));

          jLabel13.setFont(new java.awt.Font("Goudy Old Style", 0, 36)); // NOI18N
          jLabel13.setText("Due Date :: ");
          jLabel13.setIconTextGap(5);
          panel_main.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 820, 180, -1));

          btn_issueBook.setText("Issue Book");
          btn_issueBook.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btn_issueBookActionPerformed(evt);
               }
          });
          panel_main.add(btn_issueBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 910, 300, -1));

          date_dueDate.setColorBackground(new java.awt.Color(102, 255, 102));
          date_dueDate.setColorForeground(new java.awt.Color(0, 0, 0));
          date_dueDate.setPlaceholder("Book Due Date");
          panel_main.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, 810, 250, 50));

          date_issueDate.setColorBackground(new java.awt.Color(102, 255, 102));
          date_issueDate.setColorForeground(new java.awt.Color(0, 0, 0));
          date_issueDate.setPlaceholder("Book Issue Date");
          panel_main.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, 730, 250, 50));

          getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1970, 1080));

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
          Lobby lob1= new Lobby();
          lob1.setVisible(true);
          dispose();
     }//GEN-LAST:event_jPanel2MouseClicked

     private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
          System.exit(0);
     }//GEN-LAST:event_jLabel8MouseClicked

     private void txt_bookIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIDFocusLost
         if(!txt_bookID.getText().equals("")){
              getBookDetails();
         }
          
     }//GEN-LAST:event_txt_bookIDFocusLost

     private void txt_StudentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_StudentIdFocusLost
if(!txt_StudentId.getText().equals("")){
              getStudentDetails();
         }          // TODO add your handling code here:
     }//GEN-LAST:event_txt_StudentIdFocusLost

     private void btn_issueBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_issueBookActionPerformed
         if(lbl_quantity.getText().equals("0")){
              JOptionPane.showMessageDialog(this, "Book is Not Available Now ");
         }
         else{
                   if (isAlreadyIssued() == false){
               if(issueBook()==true){
                    JOptionPane.showMessageDialog(this, "Book Issued Successfully !");
                    UpdateBookQuantity();
               }else{
                    JOptionPane.showMessageDialog(this, "Can't Issue the Book !");
               }
          }else{
               JOptionPane.showMessageDialog(this, "This Student Already issue this Book");
               }
         }

     }//GEN-LAST:event_btn_issueBookActionPerformed

     private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
          // TODO add your handling code here:
     }//GEN-LAST:event_jLabel1MouseClicked

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
               java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          /* Create and display the form */
          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    new IssueBook().setVisible(true);
               }
          });
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private rojerusan.RSMaterialButtonCircle btn_issueBook;
     private rojeru_san.componentes.RSDateChooser date_dueDate;
     private rojeru_san.componentes.RSDateChooser date_issueDate;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel10;
     private javax.swing.JLabel jLabel11;
     private javax.swing.JLabel jLabel12;
     private javax.swing.JLabel jLabel13;
     private javax.swing.JLabel jLabel15;
     private javax.swing.JLabel jLabel16;
     private javax.swing.JLabel jLabel17;
     private javax.swing.JLabel jLabel18;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel20;
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
     private javax.swing.JLabel lbl_StudentID;
     private javax.swing.JLabel lbl_StudentName;
     private javax.swing.JLabel lbl_author;
     private javax.swing.JLabel lbl_bookError;
     private javax.swing.JLabel lbl_bookId;
     private javax.swing.JLabel lbl_bookName;
     private javax.swing.JLabel lbl_branch;
     private javax.swing.JLabel lbl_course;
     private javax.swing.JLabel lbl_quantity;
     private javax.swing.JLabel lbl_studentError;
     private javax.swing.JPanel panel_main;
     private app.bolivia.swing.JCTextField txt_StudentId;
     private app.bolivia.swing.JCTextField txt_bookID;
     // End of variables declaration//GEN-END:variables
}
