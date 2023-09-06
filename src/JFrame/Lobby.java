/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import static JFrame.DBConnection.con;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Dell
 */
public class Lobby extends javax.swing.JFrame {

     /**
      * Creates new form Lobby
      */
     Color mouseEnterColor = new Color(51, 255, 51);
     Color mouseExitColor = new Color(242, 242, 242);
     DefaultTableModel model;
     public Lobby() {
          initComponents();
          showPieChart();
          setStudentDetailsToTable();
          setBookDetailsToTable();
          
     }
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
     
     //show no on cards 
   /*  public void setDataToCards(){
         Statement  st = null;
          ResultSet rs  = null;
          long l = System.currentTimeMillis();
          Date todaysDate = new Date(l);
                      
          try {
              st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
              st =  con.createStatement();       
              
              rs = st.executeQuery("select * from book_details");
              rs.last();
              lbl_noofBooks.setText(Integer.toString(rs.getRow()));
              
              rs =  st.executeQuery("select * from student_details");
              rs.last();
              lbl_noofStudents.setText(Integer.toString(rs.getRow()));
              
              rs =  st.executeQuery("select * from issue_book_details");
              rs.last();
              lbl_noofIssueBooks.setText(Integer.toString(rs.getRow()));
              
              rs =  st.executeQuery("select * from issue_book_details where due_date < '"+todaysDate+"' and status = '"+"Pending"+"'");
              rs.last();
            lbl_noofDefaulter.setText(Integer.toString(rs.getRow()));
              
              
          } catch (Exception e) {
               e.printStackTrace();
          }
     }*/

//create dataset
     public void showPieChart() {
          DefaultPieDataset barDataset = new DefaultPieDataset();
          try {
               Connection con = DBConnection.getConnection();
               String sql = "select book_name , count(*) as issue_count from issue_book_details group by book_id";
               Statement st = con.createStatement();
               ResultSet rs  = st.executeQuery(sql);
               while(rs.next()){
                    barDataset.setValue(rs.getString("book_name") , Double.valueOf(rs.getDouble("issue_count")));
               }
          } catch (SQLException e) {
               e.printStackTrace();
          }

          //create chart
          JFreeChart piechart = ChartFactory.createPieChart("Books Issued By Students", barDataset, true, true, true);//explain

          PiePlot piePlot = (PiePlot) piechart.getPlot();

          //changing pie chart blocks colors
          
          piePlot.setBackgroundPaint(Color.white);

          //create chartPanel to display chart(graph)
          ChartPanel barChartPanel = new ChartPanel(piechart);
          PanelPiChart.removeAll();
          PanelPiChart.add(barChartPanel, BorderLayout.CENTER);
          PanelPiChart.validate();
     }

     /**
      * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
      */
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jLabel3 = new javax.swing.JLabel();
          jPanel1 = new javax.swing.JPanel();
          jLabel1 = new javax.swing.JLabel();
          jPanel2 = new javax.swing.JPanel();
          jLabel2 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          jLabel5 = new javax.swing.JLabel();
          jLabel6 = new javax.swing.JLabel();
          jPanel3 = new javax.swing.JPanel();
          jPanel4 = new javax.swing.JPanel();
          jLabel13 = new javax.swing.JLabel();
          jLabel10 = new javax.swing.JLabel();
          jPanel6 = new javax.swing.JPanel();
          jLabel11 = new javax.swing.JLabel();
          jLabel8 = new javax.swing.JLabel();
          jLabel14 = new javax.swing.JLabel();
          jPanel7 = new javax.swing.JPanel();
          jLabel15 = new javax.swing.JLabel();
          jLabel16 = new javax.swing.JLabel();
          jPanel5 = new javax.swing.JPanel();
          jLabel17 = new javax.swing.JLabel();
          jLabel18 = new javax.swing.JLabel();
          jPanel8 = new javax.swing.JPanel();
          jLabel19 = new javax.swing.JLabel();
          jLabel20 = new javax.swing.JLabel();
          jPanel18 = new javax.swing.JPanel();
          jLabel40 = new javax.swing.JLabel();
          jLabel41 = new javax.swing.JLabel();
          jPanel19 = new javax.swing.JPanel();
          jLabel42 = new javax.swing.JLabel();
          jLabel43 = new javax.swing.JLabel();
          jPanel20 = new javax.swing.JPanel();
          jLabel44 = new javax.swing.JLabel();
          jLabel45 = new javax.swing.JLabel();
          jPanel9 = new javax.swing.JPanel();
          jLabel22 = new javax.swing.JLabel();
          jLabel21 = new javax.swing.JLabel();
          jPanel10 = new javax.swing.JPanel();
          jLabel23 = new javax.swing.JLabel();
          jLabel24 = new javax.swing.JLabel();
          jPanel11 = new javax.swing.JPanel();
          jLabel27 = new javax.swing.JLabel();
          jLabel28 = new javax.swing.JLabel();
          jPanel12 = new javax.swing.JPanel();
          jLabel25 = new javax.swing.JLabel();
          jLabel26 = new javax.swing.JLabel();
          jPanel21 = new javax.swing.JPanel();
          jLabel46 = new javax.swing.JLabel();
          jLabel47 = new javax.swing.JLabel();
          jPanel22 = new javax.swing.JPanel();
          jLabel48 = new javax.swing.JLabel();
          jLabel49 = new javax.swing.JLabel();
          jPanel23 = new javax.swing.JPanel();
          jLabel50 = new javax.swing.JLabel();
          jLabel51 = new javax.swing.JLabel();
          jPanel24 = new javax.swing.JPanel();
          jLabel52 = new javax.swing.JLabel();
          jLabel53 = new javax.swing.JLabel();
          jPanel13 = new javax.swing.JPanel();
          jLabel29 = new javax.swing.JLabel();
          jScrollPane1 = new javax.swing.JScrollPane();
          tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
          jLabel39 = new javax.swing.JLabel();
          jScrollPane2 = new javax.swing.JScrollPane();
          tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
          PanelPiChart = new javax.swing.JPanel();

          jLabel3.setText("jLabel3");

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setBackground(new java.awt.Color(255, 255, 255));
          setUndecorated(true);
          getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jPanel1.setBackground(new java.awt.Color(51, 255, 51));
          jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel1.setForeground(new java.awt.Color(204, 102, 255));
          jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminicon/icons8_menu_48px_1.png"))); // NOI18N
          jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 50, -1));

          jPanel2.setBackground(new java.awt.Color(0, 51, 0));
          jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
          jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 0, 70));

          jLabel2.setFont(new java.awt.Font("Garamond", 0, 24)); // NOI18N
          jLabel2.setText("Welcome, Admin");
          jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1740, 60, 170, -1));

          jLabel4.setFont(new java.awt.Font("Goudy Old Style", 1, 48)); // NOI18N
          jLabel4.setText("Library Mangement System");
          jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 550, 60));

          jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile.png"))); // NOI18N
          jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1710, 60, 30, 30));

          jLabel6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 48)); // NOI18N
          jLabel6.setText("X");
          jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jLabel6MouseClicked(evt);
               }
          });
          jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1880, 0, 110, 40));

          getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2000, 100));

          jPanel3.setBackground(new java.awt.Color(153, 153, 153));
          jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jPanel4.setBackground(new java.awt.Color(51, 255, 51));
          jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel13.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
          jLabel13.setText("Home Page");
          jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, 50));

          jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminicon/home_24px.png"))); // NOI18N
          jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 40));

          jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 330, 60));

          jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel11.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
          jLabel11.setText("LMS Dashboard");
          jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 200, 50));

          jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminicon/icons8_Library_26px_1.png"))); // NOI18N
          jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 40));

          jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 330, 60));

          jLabel14.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
          jLabel14.setText("Features :");
          jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 200, 30));

          jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jPanel7MouseClicked(evt);
               }
          });
          jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminicon/icons8_Book_26px.png"))); // NOI18N
          jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 40));

          jLabel16.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
          jLabel16.setText("Manage Books");
          jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jLabel16MouseClicked(evt);
               }
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                    jLabel16MouseEntered(evt);
               }
               public void mouseExited(java.awt.event.MouseEvent evt) {
                    jLabel16MouseExited(evt);
               }
          });
          jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 200, 50));

          jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 330, 60));

          jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                    jPanel5MouseEntered(evt);
               }
               public void mouseExited(java.awt.event.MouseEvent evt) {
                    jPanel5MouseExited(evt);
               }
          });
          jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel17.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
          jLabel17.setText("Issue Books");
          jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jLabel17MouseClicked(evt);
               }
          });
          jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 200, 50));

          jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminicon/icons8_Books_26px.png"))); // NOI18N
          jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 40));

          jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 330, 60));

          jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jPanel8MouseClicked(evt);
               }
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                    jPanel8MouseEntered(evt);
               }
               public void mouseExited(java.awt.event.MouseEvent evt) {
                    jPanel8MouseExited(evt);
               }
          });
          jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel19.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
          jLabel19.setText("Manage Students");
          jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 200, 50));

          jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile.png"))); // NOI18N
          jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 40));

          jPanel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                    jPanel18MouseEntered(evt);
               }
               public void mouseExited(java.awt.event.MouseEvent evt) {
                    jPanel18MouseExited(evt);
               }
          });
          jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel40.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
          jLabel40.setText("Return Books");
          jPanel18.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 200, 50));

          jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminicon/icons8_Return_Purchase_26px.png"))); // NOI18N
          jPanel18.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 40));

          jPanel8.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 330, 60));

          jPanel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jPanel19.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                    jPanel19MouseEntered(evt);
               }
               public void mouseExited(java.awt.event.MouseEvent evt) {
                    jPanel19MouseExited(evt);
               }
          });
          jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel42.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
          jLabel42.setText("Return Books");
          jPanel19.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 200, 50));

          jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminicon/icons8_Return_Purchase_26px.png"))); // NOI18N
          jPanel19.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 40));

          jPanel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                    jPanel20MouseEntered(evt);
               }
               public void mouseExited(java.awt.event.MouseEvent evt) {
                    jPanel20MouseExited(evt);
               }
          });
          jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel44.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
          jLabel44.setText("Return Books");
          jPanel20.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 200, 50));

          jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminicon/icons8_Return_Purchase_26px.png"))); // NOI18N
          jPanel20.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 40));

          jPanel19.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 330, 60));

          jPanel8.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 330, 60));

          jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 330, 60));

          jPanel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jPanel9MouseClicked(evt);
               }
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                    jPanel9MouseEntered(evt);
               }
               public void mouseExited(java.awt.event.MouseEvent evt) {
                    jPanel9MouseExited(evt);
               }
          });
          jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminicon/icons8_View_Details_26px.png"))); // NOI18N
          jPanel9.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 30, 40));

          jLabel21.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
          jLabel21.setText("View Records");
          jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 200, 50));

          jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 330, 60));

          jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jPanel10MouseClicked(evt);
               }
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                    jPanel10MouseEntered(evt);
               }
               public void mouseExited(java.awt.event.MouseEvent evt) {
                    jPanel10MouseExited(evt);
               }
          });
          jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel23.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
          jLabel23.setText("View Issue Books");
          jPanel10.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 200, 50));

          jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminicon/icons8_Sell_26px.png"))); // NOI18N
          jPanel10.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 30, 40));

          jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 330, 70));

          jPanel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jPanel11MouseClicked(evt);
               }
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                    jPanel11MouseEntered(evt);
               }
               public void mouseExited(java.awt.event.MouseEvent evt) {
                    jPanel11MouseExited(evt);
               }
          });
          jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel27.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
          jLabel27.setText("Defaulter List");
          jPanel11.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 200, 50));

          jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminicon/icons8_Conference_26px.png"))); // NOI18N
          jLabel28.setInheritsPopupMenu(false);
          jPanel11.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 30, 40));

          jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 690, 330, 70));

          jPanel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jPanel12MouseClicked(evt);
               }
          });
          jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel25.setFont(new java.awt.Font("Palatino Linotype", 1, 36)); // NOI18N
          jLabel25.setText("Logout");
          jPanel12.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 130, 50));

          jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminicon/icons8_Exit_26px.png"))); // NOI18N
          jLabel26.setInheritsPopupMenu(false);
          jPanel12.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 30, 40));

          jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 900, 330, 70));

          jPanel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jPanel21.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jPanel21MouseClicked(evt);
               }
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                    jPanel21MouseEntered(evt);
               }
               public void mouseExited(java.awt.event.MouseEvent evt) {
                    jPanel21MouseExited(evt);
               }
          });
          jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel46.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
          jLabel46.setText("Return Books");
          jPanel21.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 200, 50));

          jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminicon/icons8_Return_Purchase_26px.png"))); // NOI18N
          jPanel21.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 40));

          jPanel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jPanel22.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                    jPanel22MouseEntered(evt);
               }
               public void mouseExited(java.awt.event.MouseEvent evt) {
                    jPanel22MouseExited(evt);
               }
          });
          jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel48.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
          jLabel48.setText("Return Books");
          jPanel22.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 200, 50));

          jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminicon/icons8_Return_Purchase_26px.png"))); // NOI18N
          jPanel22.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 40));

          jPanel21.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 330, 60));

          jPanel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jPanel23.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                    jPanel23MouseEntered(evt);
               }
               public void mouseExited(java.awt.event.MouseEvent evt) {
                    jPanel23MouseExited(evt);
               }
          });
          jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel50.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
          jLabel50.setText("Return Books");
          jPanel23.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 200, 50));

          jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminicon/icons8_Return_Purchase_26px.png"))); // NOI18N
          jPanel23.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 40));

          jPanel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          jPanel24.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                    jPanel24MouseEntered(evt);
               }
               public void mouseExited(java.awt.event.MouseEvent evt) {
                    jPanel24MouseExited(evt);
               }
          });
          jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel52.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
          jLabel52.setText("Return Books");
          jPanel24.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 200, 50));

          jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminicon/icons8_Return_Purchase_26px.png"))); // NOI18N
          jPanel24.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 40));

          jPanel23.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 330, 60));

          jPanel21.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 330, 60));

          jPanel3.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 330, 60));

          getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 350, 1110));

          jPanel13.setBackground(new java.awt.Color(255, 255, 255));
          jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel29.setFont(new java.awt.Font("High Tower Text", 1, 24)); // NOI18N
          jLabel29.setText("Students Details Table :: ");
          jPanel13.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 270, 30));

          tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {

               },
               new String [] {
                    "Student ID", "Name", "Course", "Branch"
               }
          ));
          tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(51, 255, 51));
          tbl_studentDetails.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
          tbl_studentDetails.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
          tbl_studentDetails.setColorForegroundHead(new java.awt.Color(0, 0, 0));
          tbl_studentDetails.setColorSelBackgound(new java.awt.Color(255, 255, 255));
          tbl_studentDetails.setColorSelForeground(new java.awt.Color(0, 0, 0));
          tbl_studentDetails.setFuenteHead(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
          tbl_studentDetails.setRowHeight(40);
          jScrollPane1.setViewportView(tbl_studentDetails);

          jPanel13.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 790, 210));

          jLabel39.setFont(new java.awt.Font("High Tower Text", 1, 24)); // NOI18N
          jLabel39.setText("Books Details Table :: ");
          jPanel13.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 270, 30));

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
          tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 255, 255));
          tbl_bookDetails.setColorSelForeground(new java.awt.Color(0, 0, 0));
          tbl_bookDetails.setFuenteHead(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
          tbl_bookDetails.setRowHeight(40);
          jScrollPane2.setViewportView(tbl_bookDetails);

          jPanel13.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 800, 210));

          PanelPiChart.setBackground(new java.awt.Color(255, 255, 255));
          PanelPiChart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          PanelPiChart.setLayout(new javax.swing.BoxLayout(PanelPiChart, javax.swing.BoxLayout.LINE_AXIS));
          jPanel13.add(PanelPiChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 180, 690, 580));

          getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 1650, 1110));

          setSize(new java.awt.Dimension(1986, 1099));
          setLocationRelativeTo(null);
     }// </editor-fold>//GEN-END:initComponents

     private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
          System.exit(0);
     }//GEN-LAST:event_jLabel6MouseClicked

     private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
          ManageBooks mb = new ManageBooks();
          mb.setVisible(true);
          dispose();
     }//GEN-LAST:event_jLabel16MouseClicked

     private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
          // TODO add your handling code here:
     }//GEN-LAST:event_jPanel7MouseClicked

     private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
          jPanel7.setBackground(mouseEnterColor);
     }//GEN-LAST:event_jLabel16MouseEntered

     private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
          jPanel7.setBackground(mouseExitColor);
     }//GEN-LAST:event_jLabel16MouseExited

     private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
          jPanel5.setBackground(mouseEnterColor);
     }//GEN-LAST:event_jPanel5MouseEntered

     private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
          jPanel5.setBackground(mouseExitColor);
     }//GEN-LAST:event_jPanel5MouseExited

     private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
          jPanel8.setBackground(mouseEnterColor);
     }//GEN-LAST:event_jPanel8MouseEntered

     private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
          jPanel8.setBackground(mouseExitColor);
     }//GEN-LAST:event_jPanel8MouseExited

     private void jPanel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseEntered
          jPanel9.setBackground(mouseEnterColor);
     }//GEN-LAST:event_jPanel9MouseEntered

     private void jPanel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseExited
          jPanel9.setBackground(mouseExitColor);
     }//GEN-LAST:event_jPanel9MouseExited

     private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
          jPanel10.setBackground(mouseEnterColor);
     }//GEN-LAST:event_jPanel10MouseEntered

     private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
          jPanel10.setBackground(mouseExitColor);
     }//GEN-LAST:event_jPanel10MouseExited

     private void jPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseEntered
          jPanel11.setBackground(mouseEnterColor);
     }//GEN-LAST:event_jPanel11MouseEntered

     private void jPanel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseExited
          jPanel11.setBackground(mouseExitColor);
     }//GEN-LAST:event_jPanel11MouseExited

     private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
          IssueBook  ib = new IssueBook();
          ib.setVisible(true);
          dispose();          // TODO add your handling code here:
     }//GEN-LAST:event_jLabel17MouseClicked

     private void jPanel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseEntered
          // TODO add your handling code here:
     }//GEN-LAST:event_jPanel18MouseEntered

     private void jPanel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseExited
          // TODO add your handling code here:
     }//GEN-LAST:event_jPanel18MouseExited

     private void jPanel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseEntered
          // TODO add your handling code here:
     }//GEN-LAST:event_jPanel20MouseEntered

     private void jPanel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseExited
          // TODO add your handling code here:
     }//GEN-LAST:event_jPanel20MouseExited

     private void jPanel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseEntered
          // TODO add your handling code here:
     }//GEN-LAST:event_jPanel19MouseEntered

     private void jPanel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseExited
          // TODO add your handling code here:
     }//GEN-LAST:event_jPanel19MouseExited

     private void jPanel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseEntered
          // TODO add your handling code here:
     }//GEN-LAST:event_jPanel22MouseEntered

     private void jPanel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseExited
          // TODO add your handling code here:
     }//GEN-LAST:event_jPanel22MouseExited

     private void jPanel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseEntered
          // TODO add your handling code here:
     }//GEN-LAST:event_jPanel24MouseEntered

     private void jPanel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseExited
          // TODO add your handling code here:
     }//GEN-LAST:event_jPanel24MouseExited

     private void jPanel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseEntered
          // TODO add your handling code here:
     }//GEN-LAST:event_jPanel23MouseEntered

     private void jPanel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseExited
          // TODO add your handling code here:
     }//GEN-LAST:event_jPanel23MouseExited

     private void jPanel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseEntered
          // TODO add your handling code here:
     }//GEN-LAST:event_jPanel21MouseEntered

     private void jPanel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseExited
          // TODO add your handling code here:
     }//GEN-LAST:event_jPanel21MouseExited

     private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
          ManageStudents  ms = new ManageStudents();
          ms.setVisible(true);
          dispose();             // TODO add your handling code here:
     }//GEN-LAST:event_jPanel8MouseClicked

     private void jPanel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseClicked
        ReturnBook  rb = new ReturnBook();
          rb.setVisible(true);
          dispose();  
     }//GEN-LAST:event_jPanel21MouseClicked

     private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
          ViewAllRecord  vr = new ViewAllRecord();
          vr.setVisible(true);
          dispose();  
     }//GEN-LAST:event_jPanel9MouseClicked

     private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
          LoginPage  lp = new LoginPage();
          lp.setVisible(true);
          dispose();       }//GEN-LAST:event_jPanel12MouseClicked

     private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
           IssueBookDetails  ibd = new IssueBookDetails();
          ibd.setVisible(true);
          dispose(); 
     }//GEN-LAST:event_jPanel10MouseClicked

     private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
          DefaulterList  dl = new DefaulterList();
          dl.setVisible(true);
          dispose();
     }//GEN-LAST:event_jPanel11MouseClicked

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
               java.util.logging.Logger.getLogger(Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          /* Create and display the form */
          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    new Lobby().setVisible(true);
               }
          });
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JPanel PanelPiChart;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel10;
     private javax.swing.JLabel jLabel11;
     private javax.swing.JLabel jLabel13;
     private javax.swing.JLabel jLabel14;
     private javax.swing.JLabel jLabel15;
     private javax.swing.JLabel jLabel16;
     private javax.swing.JLabel jLabel17;
     private javax.swing.JLabel jLabel18;
     private javax.swing.JLabel jLabel19;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel20;
     private javax.swing.JLabel jLabel21;
     private javax.swing.JLabel jLabel22;
     private javax.swing.JLabel jLabel23;
     private javax.swing.JLabel jLabel24;
     private javax.swing.JLabel jLabel25;
     private javax.swing.JLabel jLabel26;
     private javax.swing.JLabel jLabel27;
     private javax.swing.JLabel jLabel28;
     private javax.swing.JLabel jLabel29;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel39;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel40;
     private javax.swing.JLabel jLabel41;
     private javax.swing.JLabel jLabel42;
     private javax.swing.JLabel jLabel43;
     private javax.swing.JLabel jLabel44;
     private javax.swing.JLabel jLabel45;
     private javax.swing.JLabel jLabel46;
     private javax.swing.JLabel jLabel47;
     private javax.swing.JLabel jLabel48;
     private javax.swing.JLabel jLabel49;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JLabel jLabel50;
     private javax.swing.JLabel jLabel51;
     private javax.swing.JLabel jLabel52;
     private javax.swing.JLabel jLabel53;
     private javax.swing.JLabel jLabel6;
     private javax.swing.JLabel jLabel8;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel10;
     private javax.swing.JPanel jPanel11;
     private javax.swing.JPanel jPanel12;
     private javax.swing.JPanel jPanel13;
     private javax.swing.JPanel jPanel18;
     private javax.swing.JPanel jPanel19;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JPanel jPanel20;
     private javax.swing.JPanel jPanel21;
     private javax.swing.JPanel jPanel22;
     private javax.swing.JPanel jPanel23;
     private javax.swing.JPanel jPanel24;
     private javax.swing.JPanel jPanel3;
     private javax.swing.JPanel jPanel4;
     private javax.swing.JPanel jPanel5;
     private javax.swing.JPanel jPanel6;
     private javax.swing.JPanel jPanel7;
     private javax.swing.JPanel jPanel8;
     private javax.swing.JPanel jPanel9;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JScrollPane jScrollPane2;
     private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
     private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
     // End of variables declaration//GEN-END:variables
}
