/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class ViewAllRecord extends javax.swing.JFrame {

     /**
      * Creates new form ViewAllRecord
      */
     public ViewAllRecord() {
          initComponents();
          setIssueBookDetailsToTable(); 
     }
   DefaultTableModel model;
     
      //to set the student details to table
     public void setIssueBookDetailsToTable(){
          try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/library_ms","root","");
               Statement st = con.createStatement();
               ResultSet  rs = st.executeQuery("select * from issue_book_details");
               
               while(rs.next()){
                    String id = rs.getString("id");
                    String book_name = rs.getString("book_name");
                    String student_name = rs.getString("student_name");
                    String issueDate =  rs.getString("issue_date");
                    String dueDate = rs.getString("due_date");
                    String status = rs.getString("status");
                    
                    Object[]  obj = {id,book_name,student_name,issueDate,dueDate,status};
                    model=(DefaultTableModel)tbl_issueBookDetails.getModel();
                    model.addRow(obj);
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
     }
     
          //clear table
     public void clearTable(){
          DefaultTableModel model =(DefaultTableModel ) tbl_issueBookDetails.getModel();
          model.setRowCount(0);
     }
     
     //code for search btn
     public void search(){
          Date uFromDate = date_fromDate.getDatoFecha();
          Date uToDate = date_toDate.getDatoFecha();
          
          long l1 = uFromDate.getTime();
          long l2 = uToDate.getTime();
          
          java.sql.Date fromDate = new java.sql.Date(l1);
          java.sql.Date toDate = new java.sql.Date(l2);
          
          try {
               Connection con = DBConnection.getConnection();
               String sql = "select * from issue_book_details where issue_date between ? and ?";
               PreparedStatement pst = con.prepareStatement(sql);
               pst.setDate(1, fromDate);
               pst.setDate(2, toDate);
               ResultSet rs =  pst.executeQuery();
               
               while(rs.next()){
                    String id = rs.getString("id");
                    String book_name = rs.getString("book_name");
                    String student_name = rs.getString("student_name");
                    String issueDate =  rs.getString("issue_date");
                    String dueDate = rs.getString("due_date");
                    String status = rs.getString("status");
                    
                    Object[]  obj = {id,book_name,student_name,issueDate,dueDate,status};
                    model=(DefaultTableModel)tbl_issueBookDetails.getModel();
                    model.addRow(obj);   
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

          jPanel1 = new javax.swing.JPanel();
          jLabel1 = new javax.swing.JLabel();
          jLabel11 = new javax.swing.JLabel();
          date_fromDate = new rojeru_san.componentes.RSDateChooser();
          date_toDate = new rojeru_san.componentes.RSDateChooser();
          jLabel13 = new javax.swing.JLabel();
          rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
          jPanel3 = new javax.swing.JPanel();
          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          btn_search = new rojerusan.RSMaterialButtonCircle();
          jPanel2 = new javax.swing.JPanel();
          jScrollPane2 = new javax.swing.JScrollPane();
          tbl_issueBookDetails = new rojeru_san.complementos.RSTableMetro();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setMaximumSize(new java.awt.Dimension(1990, 1080));
          setUndecorated(true);
          getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jPanel1.setBackground(new java.awt.Color(102, 255, 102));
          jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel1.setFont(new java.awt.Font("Goudy Old Style", 1, 36)); // NOI18N
          jLabel1.setText("View All Record");
          jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 250, 110));

          jLabel11.setFont(new java.awt.Font("Goudy Old Style", 0, 36)); // NOI18N
          jLabel11.setText("Issue Date :: ");
          jLabel11.setIconTextGap(5);
          jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 180, -1));

          date_fromDate.setColorBackground(new java.awt.Color(0, 0, 0));
          date_fromDate.setColorForeground(new java.awt.Color(0, 0, 0));
          date_fromDate.setPlaceholder("Book Issue Date");
          jPanel1.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 250, 50));

          date_toDate.setColorBackground(new java.awt.Color(0, 0, 0));
          date_toDate.setColorForeground(new java.awt.Color(0, 0, 0));
          date_toDate.setPlaceholder("Book Due Date");
          jPanel1.add(date_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 260, 250, 50));

          jLabel13.setFont(new java.awt.Font("Goudy Old Style", 0, 36)); // NOI18N
          jLabel13.setText("Due Date :: ");
          jLabel13.setIconTextGap(5);
          jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 260, 180, -1));

          rSMaterialButtonCircle1.setText("ALL");
          rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rSMaterialButtonCircle1ActionPerformed(evt);
               }
          });
          jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1650, 250, 190, 70));

          jPanel3.setBackground(new java.awt.Color(204, 204, 204));
          jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jPanel3MouseClicked(evt);
               }
          });
          jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel2.setFont(new java.awt.Font("Javanese Text", 1, 24)); // NOI18N
          jLabel2.setText("BACK");
          jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jLabel2MouseClicked(evt);
               }
          });
          jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 100, 40));

          jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcon/icons8_Rewind_48px.png"))); // NOI18N
          jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

          jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, -1));

          jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 48)); // NOI18N
          jLabel4.setText("X");
          jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jLabel4MouseClicked(evt);
               }
          });
          jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1880, 0, 40, 50));

          btn_search.setText("Search");
          btn_search.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btn_searchActionPerformed(evt);
               }
          });
          jPanel1.add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 250, 190, 70));

          getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2180, 430));

          jPanel2.setBackground(new java.awt.Color(255, 255, 255));
          jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          tbl_issueBookDetails.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {

               },
               new String [] {
                    "ID", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
               }
          ));
          tbl_issueBookDetails.setColorBackgoundHead(new java.awt.Color(51, 255, 51));
          tbl_issueBookDetails.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
          tbl_issueBookDetails.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
          tbl_issueBookDetails.setColorForegroundHead(new java.awt.Color(0, 0, 0));
          tbl_issueBookDetails.setColorSelBackgound(new java.awt.Color(153, 255, 0));
          tbl_issueBookDetails.setColorSelForeground(new java.awt.Color(0, 0, 0));
          tbl_issueBookDetails.setFuenteHead(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
          tbl_issueBookDetails.setRowHeight(40);
          tbl_issueBookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tbl_issueBookDetailsMouseClicked(evt);
               }
          });
          jScrollPane2.setViewportView(tbl_issueBookDetails);

          jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 1220, 290));

          getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 430, 2230, 680));

          pack();
          setLocationRelativeTo(null);
     }// </editor-fold>//GEN-END:initComponents

     private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
          // TODO add your handling code here:
     }//GEN-LAST:event_jLabel2MouseClicked

     private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
          Lobby lob1= new Lobby();
          lob1.setVisible(true);
          dispose();
     }//GEN-LAST:event_jPanel3MouseClicked

     private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
          System.exit(0);
     }//GEN-LAST:event_jLabel4MouseClicked

     private void tbl_issueBookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_issueBookDetailsMouseClicked

     }//GEN-LAST:event_tbl_issueBookDetailsMouseClicked

     private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
          clearTable();
          setIssueBookDetailsToTable();
     }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

     private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
              if(date_fromDate.getDatoFecha() != null && date_toDate.getDatoFecha() != null){
          clearTable();
          search();
          }
          else{
               JOptionPane.showMessageDialog(this, "Please Select a Date !");
          }
     }//GEN-LAST:event_btn_searchActionPerformed

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
               java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          /* Create and display the form */
          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    new ViewAllRecord().setVisible(true);
               }
          });
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private rojerusan.RSMaterialButtonCircle btn_search;
     private rojeru_san.componentes.RSDateChooser date_fromDate;
     private rojeru_san.componentes.RSDateChooser date_toDate;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel11;
     private javax.swing.JLabel jLabel13;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JPanel jPanel3;
     private javax.swing.JScrollPane jScrollPane2;
     private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
     private rojeru_san.complementos.RSTableMetro tbl_issueBookDetails;
     // End of variables declaration//GEN-END:variables
}
