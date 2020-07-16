/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elibede.interfaces;

import elibede.model.SalaSquash;
import elibede.model.Socio;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author paulokim
 */
public interface SalaSquashDao {
  public SalaSquash criarSalaSquash(String Codigo, String Estado, String NroId) throws SQLException;

  public String getSalasDisponiveis() throws SQLException;

  public boolean reservarSalaSquash(Socio socio, String codigo, String data, String hora) throws SQLException;
    
}
