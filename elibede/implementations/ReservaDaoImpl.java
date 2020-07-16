/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elibede.implementations;

import elibede.database.MySql;
import elibede.interfaces.ReservaDao;
import elibede.model.Reserva;
import elibede.model.Socio;
import elibede.model.SalaSquash;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author paulokim
 */
public class ReservaDaoImpl implements ReservaDao{
  public Reserva criarReserva(Date Data, String NroSocio, String NroId) throws SQLException {
    Connection conn = MySql.createConnection();
    PreparedStatement st = conn.prepareStatement("INSERT INTO teste.Reserva (Data, NroSocio, NroId) VALUES (?,?,?);");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String parsedData = sdf.format(Data);
    st.setString(1, parsedData);
    st.setString(2, NroSocio);
    st.setString(3, NroId);
    int createCount = st.executeUpdate();
//    System.out.println(createCount);
    Reserva novaReserva = null;
    if (createCount > 0) {
         novaReserva = new Reserva(Data, NroSocio, NroId);
         return novaReserva;
    }

    return novaReserva;
  }

  public String getReservasFromSocios(String socio) throws SQLException {
    Connection conn = MySql.createConnection();
    String query = "SELECT SS.Codigo\n" +
                    "  	,SS.Estado\n" +
                    "  	,SS.NroId\n" +
                    "  	,SC.Nome\n" +
                    "   ,RS.Data\n" +
                    "FROM SalaSquash SS\n" +
                    "INNER JOIN Reserva RS\n" +
                    "	ON RS.NroId = SS.NroId\n" +
                    "INNER JOIN Socio SC\n" +
                    "	ON SC.NroSocio = ?\n" +
                    "   AND SC.NroSocio = RS.NroSocio\n" +
                    "LIMIT 1000;";
    PreparedStatement pt = conn.prepareStatement(query);
    pt.setString(1, socio);
    ResultSet result = pt.executeQuery();
    String nomeSocio = "";
    
    HashMap<String, ArrayList<String>> listaSalaSquash = new HashMap<String, ArrayList<String>>();
    
    while (result.next()) {
        String NroId = result.getString(3);
        String Nome = result.getString(4);
        nomeSocio = Nome;
        String Data = result.getString(5);
        ArrayList<String> horarios = listaSalaSquash.get(NroId);
        
        if (horarios == null) {
            horarios = new ArrayList<String>();
        }
        
        horarios.add(Data);
        listaSalaSquash.put(NroId, horarios);
    }
    
    String keyValue = "";
    for (Map.Entry<String,ArrayList<String>> entry : listaSalaSquash.entrySet()) {
//        System.out.println("Key = " + entry.getKey() + 
//                             ", Value = " + entry.getValue());
        String resultadoHorarios = "";
        
        for (String horario : entry.getValue()) {
            resultadoHorarios += horario + "\n\t\t\t ";
        }
        
        keyValue += "Sala: " + entry.getKey() + " => Horários: " + resultadoHorarios + "\n";
    }
    
    String resultadoFinal = "Sócio: " + nomeSocio + "\n" + keyValue;
    return resultadoFinal;
  }
  
  public String getReservasFromSalas(String nroId) throws SQLException {
    Connection conn = MySql.createConnection();
    String query = "SELECT SS.Codigo\n" +
                    "  	,SS.Estado\n" +
                    "  	,SS.NroId\n" +
                    "   ,RS.Data\n" +
                    "FROM SalaSquash SS\n" +
                    "INNER JOIN Reserva RS\n" +
                    "   ON SS.NroId = ?\n" +
                    "	AND RS.NroId = SS.NroId\n" +
                    "LIMIT 1000;";
    PreparedStatement pt = conn.prepareStatement(query);
    pt.setString(1, nroId);
    ResultSet result = pt.executeQuery();
      
    HashMap<String, ArrayList<String>> listaSalaSquash = new HashMap<String, ArrayList<String>>();
    
    while (result.next()) {
        String NroId = result.getString(3);
        String Data = result.getString(4);
        ArrayList<String> horarios = listaSalaSquash.get(NroId);
        
        if (horarios == null) {
            horarios = new ArrayList<String>();
        }
        
        horarios.add(Data);
        listaSalaSquash.put(NroId, horarios);
    }
    
    String keyValue = "";
    for (Map.Entry<String,ArrayList<String>> entry : listaSalaSquash.entrySet()) {
//        System.out.println("Key = " + entry.getKey() + 
//                             ", Value = " + entry.getValue());
        String resultadoHorarios = "";
        
        for (String horario : entry.getValue()) {
            resultadoHorarios += horario + "\n\t\t\t ";
        }
        
        keyValue += "Sala: " + entry.getKey() + " => Horários: " + resultadoHorarios + "\n";
    }
    
    String resultadoFinal = keyValue;
    return resultadoFinal;
  }
    
}
