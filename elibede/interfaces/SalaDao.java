/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elibede.interfaces;

import java.sql.SQLException;
import elibede.model.Sala;

/**
 *
 * @author paulokim
 */
public interface SalaDao {
  public Sala criarSala(String NroId, String Area, String Localizacao) throws SQLException;
    
}
