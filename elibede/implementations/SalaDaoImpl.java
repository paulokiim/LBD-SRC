/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elibede.implementations;

import java.sql.*;
import elibede.interfaces.SalaDao;
import elibede.model.Sala;
import elibede.database.MySql;

/**
 *
 * @author paulokim
 */
public class SalaDaoImpl implements SalaDao{
  public Sala criarSala(String NroId, String Area, String Localizacao) throws SQLException {
    Connection conn = MySql.createConnection();
    String query = String.format("INSERT INTO teste.Sala (NroId, Area, Localizacao) VALUES ('%s','%s','%s');", NroId, Area, Localizacao);
//    System.out.println(query);
//    String query = "SELECT * FROM teste.Sala;";
//    ResultSet result = MySql.executeQuery(conn, query);
    int createCount = MySql.executeUpdate(conn, query);
    
    Sala novaSala = null;
    
    if (createCount > 0) {
        novaSala = new Sala(NroId, Area, Localizacao);
    }

    return novaSala;
  }
    
}
