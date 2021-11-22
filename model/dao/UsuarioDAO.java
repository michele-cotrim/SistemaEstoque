package model.dao;

import control.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.object.Usuario;

/**
 *
 * @author Cotrim
 */
public class UsuarioDAO {
  
  private Connection conecta;
  
  public UsuarioDAO() {
    this.conecta = ConnectionFactory.getConnection();
  }

  public void cadastrarUsuario(Usuario p) {
    try {

      //Comando sql
      String cmdsql = "INSERT INTO usuario (login, senha) VALUES (?,?) ";
      PreparedStatement stmt = conecta.prepareStatement(cmdsql);
      stmt.setString(1, p.getLogin());
      stmt.setString(2, p.getSenha());

      stmt.execute();

      stmt.close();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

 public boolean efetuarLogin(String login, String senha){
    try {
      //Comando sql
      String cmdsql = "SELECT * FROM usuario WHERE login=? AND senha=?";
      PreparedStatement stmt = conecta.prepareStatement(cmdsql);
      stmt.setString(1, login);
      stmt.setString(2, senha);
      
      //executando o comando
      ResultSet rs = stmt.executeQuery();
      
      //verificando se e correto
      if(rs.first()){
        return true;
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    
    return false;
   
 }
  
  
  
  
  
  
}
