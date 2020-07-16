/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elibede.database;

import java.sql.*;

/**
 *
 * @author paulokim
 */
public class MySql {
  public static Connection createConnection() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/teste"; // Nome da base de dados
    String user = "root"; // nome do usuário do MySQL
    String password = "pjskimkr"; // senha do MySQL

    Connection conexao = DriverManager.getConnection(url, user, password);

    return conexao;
  }

  public static int executeUpdate(Connection conn, String query) throws SQLException {
    Statement st = conn.createStatement();
    int result = st.executeUpdate(query);
    return result;
  }
  
  public static ResultSet executeQuery(Connection conn, String query) throws SQLException {
    Statement st = conn.createStatement();
    ResultSet result = st.executeQuery(query);
    return result;
  }
    
}
