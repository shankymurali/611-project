/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cardlessatm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SUPER
 */
public class ATMlogin extends javax.swing.JFrame {
Connection conn = null;
ResultSet rs = null;
PreparedStatement ps;
  
    /**
     * Creates new form ATMlogin
     */
    public ATMlogin() {
        initComponents();
    
 
    }

    
    
    
    
   
    
    
    public int login(String n,String p,String t)
{
     if(t == "user")
        {
        
         try{
                
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","");
                String no = "1";
                String sname = n;
                 ps = conn.prepareStatement("select * from user where first_name =?");
                ps.setString(1, n);
               
                
               
           
                ResultSet rs1 = ps.executeQuery();
                if(rs1.next())
                {
                
                
                ps = conn.prepareStatement("select * from login where first_name =? AND  password =?");
                ps.setString(1, n);
                
                ps.setString(2, p);

                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {
                    //ps = conn.prepareStatement("select user.first_name from user where status ="Approved"";);
                   
                    String msg = jTextField1.getText();
                    
                String sql1 = "update session set sess_name = '"+msg+"' where sess_id = '"+no+"'";
                 Statement stm = conn.createStatement();

            stm.executeUpdate(sql1); 
            
                    
                    JOptionPane.showMessageDialog(this, "Successs");  
                    return 0;
                }else{
                    JOptionPane.showMessageDialog(this, "Wrong password");
                }
            }
                else
                {
                  JOptionPane.showMessageDialog(this, "You are not registered USer");  
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
     else
         try{
                
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","");
                String no = "1";
                String sname = n;
                 ps = conn.prepareStatement("select * from admin where first_name =?");
                ps.setString(1, n);
               
                
               
           
                ResultSet rs1 = ps.executeQuery();
                if(rs1.next())
                {
                
                
                ps = conn.prepareStatement("select * from login inner join admin on login.first_name = admin.first_name where first_name =? AND  password =?");
                ps.setString(1, n);
                
                ps.setString(2, p);

                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {
                    //ps = conn.prepareStatement("select user.first_name from user where status ="Approved"";);
                   
                    String msg = jTextField1.getText();
                    
                String sql1 = "update session set sess_name = '"+msg+"' where sess_id = '"+no+"'";
                 Statement stm = conn.createStatement();

            stm.executeUpdate(sql1); 
            
                    
                    JOptionPane.showMessageDialog(this, "Successs");  
                    return 0;
                }else{
                    JOptionPane.showMessageDialog(this, "Wrong password");
                }
            }
                else
                {
                  JOptionPane.showMessageDialog(this, "You are not registered admin");  
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        
    return 0;
        
}
        
        
    
  
    
    public void check()
{
         try
    {
        java.sql.Connection   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","");
        Statement stmt = con.createStatement();

     ResultSet rs,rs1;
    
 
    String x =jTextField1.getText();
    String y = "Not Approved";
    rs = stmt.executeQuery("SELECT user.u_id as emp_ID, user.first_name as first_name FROM user where user.first_name = '"+x+"' AND user.status='"+y+"';");
    
    while(rs.next())
    {
                String emp_ID = rs.getString("emp_ID");
                String first_name = rs.getString("first_name");
                 
                 JOptionPane.showMessageDialog(null, "Your Account Has Been Created.. but pls wait for the approval from bank");
            setVisible(false);
            
System.exit(0);

}
con.close();
  
    }        
                

    
    catch(Exception e)
    {
          JOptionPane.showMessageDialog(null,e); 
    } 
}   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/atm.jpg"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("User Type");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addComponent(jTextField1))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(391, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 225, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(159, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

             
         if(jComboBox1.getSelectedItem().toString() == "User")
        {
                check();    
            try{
                
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","");
                String no = "1";
                String sname = jTextField1.getText();
                 ps = conn.prepareStatement("select * from user where first_name =?");
                ps.setString(1, jTextField1.getText());
               
                
               
           
                ResultSet rs1 = ps.executeQuery();
                if(rs1.next())
                {
                
                
                ps = conn.prepareStatement("select * from login where first_name =? AND  password =?");
                ps.setString(1, jTextField1.getText());
                
                ps.setString(2, String.valueOf( jPasswordField1.getPassword()));

                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {
                    //ps = conn.prepareStatement("select user.first_name from user where status ="Approved"";);
                   
                    String msg = jTextField1.getText();
                    
                String sql1 = "update session set sess_name = '"+msg+"' where sess_id = '"+no+"'";
                 Statement stm = conn.createStatement();

            stm.executeUpdate(sql1); 
                    setVisible(false);
                    ATMhome uhp = new ATMhome();
                    uhp.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(this, "Wrong password");
                }
            }
                else
                {
                  JOptionPane.showMessageDialog(this, "You are not registered USer");  
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
        {
            try{
                
                
                
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","");
                
                  ps = conn.prepareStatement("select * from admin where first_name =?");
                ps.setString(1, jTextField1.getText());
               
                ResultSet rs1 = ps.executeQuery();
                if(rs1.next())
                {
                
                ps = conn.prepareStatement("select * from login where first_name =? AND  password =?");
                ps.setString(1, jTextField1.getText());
                ps.setString(2, String.valueOf( jPasswordField1.getPassword()));

                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {
                                   
                    
                    setVisible(false);
                    ATMadmin_home bhp = new ATMadmin_home();
                    bhp.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(this, "Wrong password");
                }
            }
                 else
                {
                  JOptionPane.showMessageDialog(this, "You are not registered Admin");  
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
   
    }//GEN-LAST:event_jButton1ActionPerformed

     
        
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        cardlessATM hp = new cardlessATM();
        hp.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ATMlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ATMlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ATMlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ATMlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ATMlogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
