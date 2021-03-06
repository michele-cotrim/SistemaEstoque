/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.mysql.jdbc.Connection;
import control.ConnectionFactory;
import javax.swing.JOptionPane;
import model.dao.UsuarioDAO;

/**
 *
 * @author Cotrim
 */
public class Login extends javax.swing.JFrame {

  /**
   * Creates new form Login
   */
  public Login() {
    initComponents();
    this.setVisible(true);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    btEntrar = new javax.swing.JButton();
    txLogin = new javax.swing.JTextField();
    txSenha = new javax.swing.JPasswordField();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    btCadastrar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Control");
    setAlwaysOnTop(true);
    setBounds(new java.awt.Rectangle(200, 350, 250, 300));
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setName("frameLogin"); // NOI18N
    setPreferredSize(new java.awt.Dimension(400, 270));
    setResizable(false);
    setSize(new java.awt.Dimension(500, 300));
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel1.setPreferredSize(new java.awt.Dimension(400, 270));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    btEntrar.setText("Entrar");
    btEntrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btEntrarActionPerformed(evt);
      }
    });
    jPanel1.add(btEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));

    txLogin.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txLoginActionPerformed(evt);
      }
    });
    jPanel1.add(txLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 53, 182, -1));

    txSenha.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txSenhaActionPerformed(evt);
      }
    });
    jPanel1.add(txSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 107, 182, -1));

    jLabel1.setText("Login");
    jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 56, -1, -1));

    jLabel2.setText("Senha");
    jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 110, -1, -1));

    btCadastrar.setText("Cadastrar");
    btCadastrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btCadastrarActionPerformed(evt);
      }
    });
    jPanel1.add(btCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 29, -1, -1));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void txSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSenhaActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_txSenhaActionPerformed

  private void txLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txLoginActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_txLoginActionPerformed

  private void btEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarActionPerformed
    try {
      //lendo login e senha
      String login, senha;
      login = txLogin.getText();
      senha = txSenha.getText();
      UsuarioDAO dao = new UsuarioDAO();
            
      if(dao.efetuarLogin(login, senha)){
        TabelaProdutos tb = new TabelaProdutos();
        tb.setVisible(true);
        this.dispose();
      } else{
        JOptionPane.showMessageDialog(null, "Login ou senhas incorretos");
      }
      
      
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    }
  }//GEN-LAST:event_btEntrarActionPerformed

  private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
    Cadastro cd = new Cadastro();
    this.dispose();
    
    
  }//GEN-LAST:event_btCadastrarActionPerformed

  
  public static void main(String[] args) {

    try {
      JOptionPane.showMessageDialog(null, "Testando conex??o");
      Connection con = new ConnectionFactory().getConnection();
      JOptionPane.showMessageDialog(null, "Sucesso");
      Login lg = new Login();
      
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Fracasso" + e);
    }

  }
 

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btCadastrar;
  private javax.swing.JButton btEntrar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JTextField txLogin;
  private javax.swing.JPasswordField txSenha;
  // End of variables declaration//GEN-END:variables
}
