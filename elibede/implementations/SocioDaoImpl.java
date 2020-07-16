/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elibede.implementations;

import elibede.database.MySql;
import java.sql.SQLException;
import elibede.interfaces.SocioDao;
import elibede.model.Socio;
import java.sql.Connection;

/**
 *
 * @author paulokim
 */
public class SocioDaoImpl implements SocioDao {
  public Socio criarSocio(String NroSocio, String Nome, String Telefone, String Endereco, String Profissao,
      String DocsBancarios) throws SQLException {
    Connection conn = MySql.createConnection();
    String query = String.format("INSERT INTO teste.Socio (NroSocio, Nome, Telefone, Endereco, Profissao, DocsBancarios) VALUES ('%s','%s','%s','%s','%s','%s');", NroSocio, Nome, Telefone, Endereco, Profissao, DocsBancarios);
//    System.out.println(query);
//    String query = "SELECT * FROM teste.SalaSquash;";
//    ResultSet result = MySql.executeQuery(conn, query);
    int createCount = MySql.executeUpdate(conn, query);
    Socio novoSocio = null;
    if (createCount > 0) {
         novoSocio = new Socio(NroSocio, Nome, Telefone, Endereco, Profissao, DocsBancarios);
         return novoSocio;
    }

    return novoSocio;
  }
    
}
