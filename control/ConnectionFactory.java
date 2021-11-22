package control;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Cotrim
 */
public class ConnectionFactory {

  public static Connection getConnection() {

    try {

      return (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bdtrabalho", "root", "");

    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }

  }

  

  

}
