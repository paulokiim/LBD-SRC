/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elibede.interfaces;

import java.sql.SQLException;
import elibede.model.Socio;

/**
 *
 * @author paulokim
 */
public interface SocioDao {
  public Socio criarSocio(String NroSocio, String Nome, String Telefone, String Endereco, String Profissao,
      String DocsBancarios) throws SQLException;
    
}
