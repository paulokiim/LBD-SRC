/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elibede.interfaces;

import elibede.model.Reserva;
import elibede.model.SalaSquash;
import elibede.model.Socio;

import java.util.Date;
import java.sql.*;

/**
 *
 * @author paulokim
 */
public interface ReservaDao {
  public Reserva criarReserva(Date Data, String NroSocio, String NroId) throws SQLException;

  public String getReservasFromSocios(String socio) throws SQLException;
    
}
