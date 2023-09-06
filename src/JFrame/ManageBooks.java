/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.awt.print.Book;
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
public class ManageBooks extends javax.swing.JFrame {

     /**
      * Creates new form ManageBooks
      */
     public ManageBooks() {
          initComponents();
          setBookDetailsToTable();
     }
     String  book_name,authorname;
     int book_id,quantity;
     DefaultTableModel model;
     
     
     //to set the book details to table
     public void setBookDetailsToTable(){
          try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/library_ms","root","");
               Statement st = con.createStatement();
               ResultSet  rs = st.executeQuery("select * from book_details");
               
               while(rs.next()){
                    String  book_id = rs.getString("book_id");
                    String book_name = rs.getString("book_name");
                    String athorname =  rs.getString("author_name");
                    int quantity = rs.getInt("quantity");
                    
                    Object[]  obj = {book_id,book_name,athorname,quantity};
                    model=(DefaultTableModel)tbl_bookDetails.getModel();
                    model.addRow(obj);
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
     }
     
       //To add book details to the table
     public boolean addBook(){
          boolean isAdded = false;
          book_id = Integer.parseInt(txt_bookID.getText());
          book_name = txt_bookName.getText();
          authorname=txt_authorName.getText();
          quantity=Integer.parseInt(txt_quantity.getText());
          try {
               Connection con = DBConnection.getConnection();
               String sql = "insert into book_details values(?,?,?,?)";
               PreparedStatement  pst = con.prepareStatement(sql);
               pst.setInt(1, book_id);
               pst.setString(2, book_name);
               pst.setString(3, authorname);
               pst.setInt(4, quantity);
               
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
     
     //to update book detaols
     
     public boolean  updateBook(){
            boolean isUpdated = false;
               book_id = Integer.parseInt(txt_bookID.getText());
               book_name = txt_bookName.getText();
               authorname=txt_authorName.getText();
               quantity=Integer.parseInt(txt_quantity.getText());
               
               try {
               Connection con = DBConnection.getConnection();
               String sql = "update book_details set book_name=?,author_name=?,quantity=? where book_id =?";
               PreparedStatement pst = con.prepareStatement(sql);
               
               pst.setString(1, book_name);
               pst.setString(2, authorname);
               pst.setInt(3, quantity);
               pst.setInt(4, book_id);
               
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
          DefaultTableModel model =(DefaultTableModel ) tbl_bookDetails.getModel();
          model.setRowCount(0);
     }
     
     // to delete the row ofbook table
     public boolean deleteBook(){
          boolean isDeleted = false;
          book_id = Integer.parseInt(txt_bookID.getText());
          
          try {
               Connection con = DBConnection.getConnection();
               String sql = "delete from book_details where book_id = ?";
               PreparedStatement pst = con.prepareStatement(sql);
               pst.setInt(1, book_id);
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
          txt_bookID = new app.bolivia.swing.JCTextField();
          jLabel8 = new javax.swing.JLabel();
          jLabel6 = new javax.swing.JLabel();
          txt_bookName = new app.bolivia.swing.JCTextField();
          jLabel9 = new javax.swing.JLabel();
          txt_authorName = new app.bolivia.swing.JCTextField();
          jLabel10 = new javax.swing.JLabel();
          txt_quantity = new app.bolivia.swing.JCTextField();
          jLabel11 = new javax.swing.JLabel();
          jLabel12 = new javax.swing.JLabel();
          DeleteBTN = new rojerusan.RSMaterialButtonCircle();
          AddBTN = new rojerusan.RSMaterialButtonCircle();
          UpdateBTN = new rojerusan.RSMaterialButtonCircle();
          jLabel3 = new javax.swing.JLabel();
          jPanel3 = new javax.swing.JPanel();
          jScrollPane2 = new javax.swing.JScrollPane();
          tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
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
          jLabel5.setText("Book ID");
          jLabel5.setIconTextGap(5);
          jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, -1, -1));

          txt_bookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));
          txt_bookID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txt_bookID.setPlaceholder("Enter Book ID");
          txt_bookID.addFocusListener(new java.awt.event.FocusAdapter() {
               public void focusLost(java.awt.event.FocusEvent evt) {
                    txt_bookIDFocusLost(evt);
               }
          });
          jPanel1.add(txt_bookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 260, 70));

          jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcon/icons8_Moleskine_26px.png"))); // NOI18N
          jLabel8.setPreferredSize(new java.awt.Dimension(30, 20));
          jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, -1, 30));

          jLabel6.setFont(new java.awt.Font("Goudy Old Style", 0, 36)); // NOI18N
          jLabel6.setText("Books Name");
          jLabel6.setIconTextGap(5);
          jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, -1, -1));

          txt_bookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));
          txt_bookName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txt_bookName.setPlaceholder("Enter Book Name");
          txt_bookName.addFocusListener(new java.awt.event.FocusAdapter() {
               public void focusLost(java.awt.event.FocusEvent evt) {
                    txt_bookNameFocusLost(evt);
               }
          });
          jPanel1.add(txt_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 260, 70));

          jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcon/icons8_Collaborator_Male_26px.png"))); // NOI18N
          jLabel9.setPreferredSize(new java.awt.Dimension(30, 20));
          jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, -1, 30));

          txt_authorName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));
          txt_authorName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txt_authorName.setPlaceholder("Enter Author Name");
          txt_authorName.addFocusListener(new java.awt.event.FocusAdapter() {
               public void focusLost(java.awt.event.FocusEvent evt) {
                    txt_authorNameFocusLost(evt);
               }
          });
          jPanel1.add(txt_authorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 520, 260, 70));

          jLabel10.setFont(new java.awt.Font("Goudy Old Style", 0, 36)); // NOI18N
          jLabel10.setText("Author Name");
          jLabel10.setIconTextGap(5);
          jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, -1, -1));

          txt_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));
          txt_quantity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          txt_quantity.setPlaceholder("Enter Quantity");
          txt_quantity.addFocusListener(new java.awt.event.FocusAdapter() {
               public void focusLost(java.awt.event.FocusEvent evt) {
                    txt_quantityFocusLost(evt);
               }
          });
          jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 610, 260, 70));

          jLabel11.setFont(new java.awt.Font("Goudy Old Style", 0, 36)); // NOI18N
          jLabel11.setText("Quantity");
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

          tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {

               },
               new String [] {
                    "Book ID", "Book Name", "Author", "Quantity"
               }
          ));
          tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(51, 255, 51));
          tbl_bookDetails.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
          tbl_bookDetails.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
          tbl_bookDetails.setColorForegroundHead(new java.awt.Color(0, 0, 0));
          tbl_bookDetails.setColorSelBackgound(new java.awt.Color(153, 255, 0));
          tbl_bookDetails.setColorSelForeground(new java.awt.Color(0, 0, 0));
          tbl_bookDetails.setFuenteHead(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
          tbl_bookDetails.setRowHeight(40);
          tbl_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tbl_bookDetailsMouseClicked(evt);
               }
          });
          jScrollPane2.setViewportView(tbl_bookDetails);

          jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 900, 590));

          jLabel4.setFont(new java.awt.Font("Goudy Old Style", 1, 36)); // NOI18N
          jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcon/icons8_Book_50px_1.png"))); // NOI18N
          jLabel4.setText(" Manage Books");
          jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 280, 50));

          jPanel4.setBackground(new java.awt.Color(255, 51, 0));
          jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
          jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 330, 5));

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

     private void txt_bookIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIDFocusLost

     }//GEN-LAST:event_txt_bookIDFocusLost

     private void txt_bookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookNameFocusLost
          // TODO add your handling code here:
     }//GEN-LAST:event_txt_bookNameFocusLost

     private void txt_authorNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_authorNameFocusLost
          // TODO add your handling code here:
     }//GEN-LAST:event_txt_authorNameFocusLost

     private void txt_quantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantityFocusLost
          // TODO add your handling code here:
     }//GEN-LAST:event_txt_quantityFocusLost

     private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked
          int rowNo = tbl_bookDetails.getSelectedRow();
          TableModel model = tbl_bookDetails.getModel();
          
          txt_bookID.setText(model.getValueAt(rowNo, 0).toString());
          txt_bookName.setText(model.getValueAt(rowNo, 1).toString());
          txt_authorName.setText(model.getValueAt(rowNo, 2).toString());
          txt_quantity.setText(model.getValueAt(rowNo, 3).toString());
     }//GEN-LAST:event_tbl_bookDetailsMouseClicked

     private void AddBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBTNActionPerformed
          if (addBook() == true) {
               //JOptionPane.showMessageDialog(this, "Book Added");
               clearTable();
               setBookDetailsToTable();
          }else{
               JOptionPane.showMessageDialog(this, "Please check Yourself , book not added");
          }
     }//GEN-LAST:event_AddBTNActionPerformed

     private void UpdateBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBTNMouseClicked
            if (updateBook()== true) {
               JOptionPane.showMessageDialog(this, "Book Details Updated");
               clearTable();
               setBookDetailsToTable();
          }else{
               JOptionPane.showMessageDialog(this, "Please check Yourself , book not updated");
          }
     }//GEN-LAST:event_UpdateBTNMouseClicked

     private void DeleteBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBTNMouseClicked
          if (deleteBook()== true) {
               JOptionPane.showMessageDialog(this, "Book Delete");
               clearTable();
               setBookDetailsToTable();
          }else{
               JOptionPane.showMessageDialog(this, "Please check Yourself , book not updated");
          }
     
     }//GEN-LAST:event_DeleteBTNMouseClicked

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
               java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          /* Create and display the form */
          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    new ManageBooks().setVisible(true);
               }
          });
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private rojerusan.RSMaterialButtonCircle AddBTN;
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
     private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
     private app.bolivia.swing.JCTextField txt_authorName;
     private app.bolivia.swing.JCTextField txt_bookID;
     private app.bolivia.swing.JCTextField txt_bookName;
     private app.bolivia.swing.JCTextField txt_quantity;
     // End of variables declaration//GEN-END:variables
}
