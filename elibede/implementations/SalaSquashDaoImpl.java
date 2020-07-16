/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elibede.implementations;

import java.sql.*;
import elibede.interfaces.SalaSquashDao;
import elibede.model.SalaSquash;
import elibede.database.MySql;
import elibede.model.Socio;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author paulokim
 */
public class SalaSquashDaoImpl implements SalaSquashDao{
  public SalaSquash criarSalaSquash(String Codigo, String Estado, String NroId) throws SQLException {
    Connection conn = MySql.createConnection();
    String query = String.format("INSERT INTO teste.SalaSquash (Codigo, Estado, NroId) VALUES ('%s','%s','%s')", Codigo, Estado, NroId);
//    System.out.println(query);
    int createCount = MySql.executeUpdate(conn, query);
    
    SalaSquash novaSalaSquash = null;
    
    if (createCount > 0) {
        novaSalaSquash = new SalaSquash(Codigo, Estado, NroId);
    }

    return novaSalaSquash;
  }
  
  public boolean reservarSalaSquash(Socio socio, String codigo, String data, String hora) throws SQLException{
      return true;
  }
  
  public String getSalasDisponiveis() throws SQLException{
    Connection conn = MySql.createConnection();
    String query = "SELECT SS.NroId, R.Data\n" +
                    "FROM teste.SalaSquash AS SS\n" +
                    "LEFT JOIN teste.Reserva AS R\n" +
                    "ON SS.NroId = R.NroId\n" +
                    "LIMIT 1000;";
    Statement st = conn.createStatement();
    ResultSet result = st.executeQuery(query);
    
    HashMap<String, ArrayList<String>> listaSalaSquash = new HashMap<String, ArrayList<String>>();
    
    while(result.next()) {
//        listaSalaSquash.put("1", "10:30");
        String NroId = result.getString(1);
        String Hora = result.getString(2);
        ArrayList<String> reservas = listaSalaSquash.get(NroId);
//        System.out.println("==> " + reservas);
        
        if (reservas == null) {
            reservas = new ArrayList<String>();
        }
        
        if (Hora != null) {
//            System.out.println("==> " + Hora);
            reservas.add(Hora);
            listaSalaSquash.put(NroId, reservas);
        }
        else {
            listaSalaSquash.put(NroId, reservas);
        }
    }
    
//    System.out.println("==> " + listaSalaSquash);
    HashMap<String, String> horariosDisponiveis = new HashMap<String, String>();
    String resultadoFinal = "";
    for (Map.Entry<String,ArrayList<String>> entry : listaSalaSquash.entrySet()) {
//        System.out.println("Key = " + entry.getKey() + 
//                             ", Value = " + entry.getValue());
        String resultadoHorarios = "Horarios reservados: ";
        
        if (entry.getValue().size() == 0) {
            resultadoHorarios = "Todos horarios disponiveis\n";
        }
        
        for (String horario : entry.getValue()) {
            resultadoHorarios += horario + "\n\t\t\t     ";
        }
        
        horariosDisponiveis.put(entry.getKey(), resultadoHorarios);
        resultadoFinal += entry.getKey() + " => " + resultadoHorarios + "\n";
    }
//    System.out.println(horariosDisponiveis);
//    System.out.println(resultadoFinal);
    return resultadoFinal;
  }

}
