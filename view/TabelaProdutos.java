package view;

import com.mysql.jdbc.Connection;
import control.ConnectionFactory;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.ProdutoDAO;
import model.object.Produto;

/**
 *
 * @author Cotrim
 */
public class TabelaProdutos extends javax.swing.JFrame {

  public TabelaProdutos() {
    initComponents();
    this.setVisible(true);
  }

  
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    txProduto = new javax.swing.JTextField();
    txQtd = new javax.swing.JTextField();
    txPreco = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tbProdutos = new javax.swing.JTable();
    btCadastrar = new javax.swing.JButton();
    btExcluir = new javax.swing.JButton();
    btAtualizar = new javax.swing.JButton();
    lbId = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setBounds(new java.awt.Rectangle(200, 200, 200, 200));
    setMinimumSize(new java.awt.Dimension(450, 450));
    setPreferredSize(new java.awt.Dimension(450, 450));
    setResizable(false);
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowOpened(java.awt.event.WindowEvent evt) {
        formWindowOpened(evt);
      }
    });
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    txProduto.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txProdutoActionPerformed(evt);
      }
    });
    getContentPane().add(txProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 26, 170, -1));

    txQtd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txQtdActionPerformed(evt);
      }
    });
    getContentPane().add(txQtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 26, 89, -1));
    getContentPane().add(txPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 26, 75, -1));

    jLabel1.setText("PRODUTO");
    getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 52, -1, -1));

    jLabel2.setText("PREÇO");
    getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 52, -1, -1));

    jLabel3.setText("QUANTIDADE");
    getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 52, -1, -1));

    tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "ID", "PRODUTO", "PREÇO", "QUANTIDADE"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    tbProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tbProdutosMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(tbProdutos);

    getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 413, 280));

    btCadastrar.setText("Cadastrar");
    btCadastrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btCadastrarActionPerformed(evt);
      }
    });
    getContentPane().add(btCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 77, -1, -1));

    btExcluir.setText("Excluir");
    btExcluir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btExcluirActionPerformed(evt);
      }
    });
    getContentPane().add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 77, 75, -1));

    btAtualizar.setText("Atualizar");
    btAtualizar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btAtualizarActionPerformed(evt);
      }
    });
    getContentPane().add(btAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 77, -1, -1));

    lbId.setText("          ");
    getContentPane().add(lbId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 26, -1, 20));

    jLabel4.setText("ID");
    getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  
  //apagar isso aqui
  private void txQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txQtdActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_txQtdActionPerformed

  private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
    try {
      Produto prod = new Produto();
      prod.setDescricao(txProduto.getText());
      prod.setPreco(Double.parseDouble(txPreco.getText()));
      prod.setQuantidade(Integer.parseInt(txQtd.getText()));
      prod.setId(Integer.parseInt(lbId.getText()));

      ProdutoDAO dao = new ProdutoDAO();
      dao.excluir(prod);
      JOptionPane.showMessageDialog(null, "Produto Excluido");
      listar();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Erro ao excluir produto" + e);
    }
  }//GEN-LAST:event_btExcluirActionPerformed

  private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
    try {
      Produto prod = new Produto();
      prod.setDescricao(txProduto.getText());
      prod.setPreco(Double.parseDouble(txPreco.getText()));
      prod.setQuantidade(Integer.parseInt(txQtd.getText()));

      ProdutoDAO dao = new ProdutoDAO();
      dao.cadastrarProduto(prod);
      JOptionPane.showMessageDialog(null, "Produto Cadastrado");
      listar();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Erro ao cadastrar" + e);
    }
    
  }//GEN-LAST:event_btCadastrarActionPerformed
  
  public void listar() {
    //usando o select

    ProdutoDAO dao = new ProdutoDAO();
    List<Produto> list = dao.listarProdutos();

    //colocando dados na tabela
    DefaultTableModel model = (DefaultTableModel) tbProdutos.getModel();
    model.setNumRows(0);

    for (Produto p : list) {
      model.addRow(new Object[]{
        p.getId(),
        p.getDescricao(),
        p.getPreco(),
        p.getQuantidade(),});
    }

  }
  
  private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    listar();
  }//GEN-LAST:event_formWindowOpened

  private void tbProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProdutosMouseClicked
    // pegando dados da tabela

  DefaultTableModel model = (DefaultTableModel) tbProdutos.getModel();
  int selectedIndex = tbProdutos.getSelectedRow();
  
  lbId.setText(model.getValueAt(selectedIndex, 0).toString());      
  txProduto.setText(model.getValueAt(selectedIndex, 1).toString());
  txPreco.setText(model.getValueAt(selectedIndex, 2).toString());
  txQtd.setText(model.getValueAt(selectedIndex, 3).toString());
  
  
    
  }//GEN-LAST:event_tbProdutosMouseClicked

  private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
    try {
      Produto prod = new Produto();
      prod.setDescricao(txProduto.getText());
      prod.setPreco(Double.parseDouble(txPreco.getText()));
      prod.setQuantidade(Integer.parseInt(txQtd.getText()));
      prod.setId(Integer.parseInt(lbId.getText()));

      ProdutoDAO dao = new ProdutoDAO();
      dao.atualizar(prod);
      JOptionPane.showMessageDialog(null, "Produto Atualizado");
      listar();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Erro ao atualizar" + e);
    }
  }//GEN-LAST:event_btAtualizarActionPerformed

  private void txProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txProdutoActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_txProdutoActionPerformed

  
  
  
  /*public static void main(String[] args) {

    try {
      JOptionPane.showMessageDialog(null, "Testando conexão");
      Connection con = new ConnectionFactory().getConnection();
      JOptionPane.showMessageDialog(null, "Sucesso");
      TabelaProdutos tp = new TabelaProdutos();
      
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Fracasso" + e);
    }

  }*/
  
  

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btAtualizar;
  private javax.swing.JButton btCadastrar;
  private javax.swing.JButton btExcluir;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel lbId;
  private javax.swing.JTable tbProdutos;
  private javax.swing.JTextField txPreco;
  private javax.swing.JTextField txProduto;
  private javax.swing.JTextField txQtd;
  // End of variables declaration//GEN-END:variables
}
