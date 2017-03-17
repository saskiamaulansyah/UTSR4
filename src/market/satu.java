/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market;

/**
 *
 * @author A455L
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class satu extends javax.swing.JFrame {


    public satu() {
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

        nama = new javax.swing.JTextField();
        login = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        register = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        nama.setFont(new java.awt.Font("FISH&CHIPS", 0, 24)); // NOI18N
        nama.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nama.setBorder(null);
        getContentPane().add(nama);
        nama.setBounds(180, 120, 400, 60);

        login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });
        getContentPane().add(login);
        login.setBounds(110, 320, 170, 40);

        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(420, 320, 200, 40);

        pass.setFont(new java.awt.Font("FISH&CHIPS", 0, 24)); // NOI18N
        pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pass.setBorder(null);
        getContentPane().add(pass);
        pass.setBounds(180, 220, 400, 60);

        register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
        });
        getContentPane().add(register);
        register.setBounds(200, 400, 260, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/market/LOGIN.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 660, 460);

        setSize(new java.awt.Dimension(675, 496));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
        Connection connection;
        PreparedStatement ps;
        
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_pbo?zeroDateTimeBehavior=convertToNull", "root", "");
            ps=connection.prepareStatement("SELECT * FROM tb_akun WHERE user = ? AND pass = ?");
            ps.setString(1, nama.getText());
            ps.setString(2, pass.getText());
            ResultSet result = ps.executeQuery();
            if(result.next()){
                new dua().show();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Salah!");
                pass.setText("");
                nama.requestFocus();
                
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "gagal!");
        }
    }//GEN-LAST:event_loginMouseClicked

    private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked
          String username = nama.getText();
          String password = pass.getText();
          
          try{
              try(Statement statement = (Statement) file_koneksi.GetConnection().createStatement()){
                  statement.executeUpdate("insert into tb_akun(user, pass)VALUES('"+username+"','"+password+"');");
              }
              JOptionPane.showMessageDialog(null, "Selamat! anda berhasil SignUp!");
              
          }catch (Exception t){
              JOptionPane.showMessageDialog(null, "Mohon maaf, ulangi lagi");
          }
    }//GEN-LAST:event_registerMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
      dispose();
    }//GEN-LAST:event_exitMouseClicked

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
            java.util.logging.Logger.getLogger(satu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(satu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(satu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(satu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new satu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel login;
    private javax.swing.JTextField nama;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel register;
    // End of variables declaration//GEN-END:variables
}
