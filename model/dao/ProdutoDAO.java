package model.dao;

import control.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.object.Produto;

/**
 *
 * @author Cotrim
 */
public class ProdutoDAO {

  private Connection conecta;

  public ProdutoDAO() {
    this.conecta = ConnectionFactory.getConnection();
  }

  public void cadastrarProduto(Produto p) {
    try {

      //Comando sql
      String cmdsql = "INSERT INTO produto (quantidade, descricao, preco) VALUES (?,?,?) ";
      PreparedStatement stmt = conecta.prepareStatement(cmdsql);
      stmt.setInt(1, p.getQuantidade());
      stmt.setString(2, p.getDescricao());
      stmt.setDouble(3, p.getPreco());

      stmt.execute();

      stmt.close();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  public List<Produto> listarProdutos() {
    try {
      List<Produto> lista = new ArrayList<Produto>();

      //Comando sql
      String cmdsql = "SELECT * FROM produto";
      PreparedStatement stmt = conecta.prepareStatement(cmdsql);

      ResultSet rs = stmt.executeQuery();

      //enquanto tiver registo ele consegue andar pelo banco
      while (rs.next()) {
        Produto p = new Produto();
        p.setId(rs.getInt("id"));
        p.setDescricao(rs.getString("descricao"));
        p.setPreco(rs.getDouble("preco"));
        p.setQuantidade(rs.getInt("quantidade"));

        lista.add(p);

      }

      return lista;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  public void atualizar(Produto p) {
    try {

      //Comando sql
      String cmdsql = "UPDATE produto set quantidade=?,descricao=?,preco=? WHERE id=?";
      PreparedStatement stmt = conecta.prepareStatement(cmdsql);
      stmt.setInt(1, p.getQuantidade());
      stmt.setString(2, p.getDescricao());
      stmt.setDouble(3, p.getPreco());
      stmt.setInt(4, p.getId());

      stmt.execute();

      stmt.close();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  public void excluir(Produto p){
    try {

      //Comando sql
      String cmdsql = "DELETE FROM produto WHERE id=? ";
      PreparedStatement stmt = conecta.prepareStatement(cmdsql);
      stmt.setInt(1, p.getId());

      stmt.execute();
      stmt.close();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  
  
}
