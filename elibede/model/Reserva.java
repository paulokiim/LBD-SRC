/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elibede.model;

import java.util.Date;

/**
 *
 * @author paulokim
 */
public class Reserva {
  private Date Data;
  private String NroSocio;
  private String NroId;

  public Reserva(Date Data, String NroSocio, String NroId) {
    this.Data = Data;
    this.NroSocio = NroSocio;
    this.NroId = NroId;
  }

  public Date getData() {
    return Data;
  }

  public void getData(Date Data) {
    this.Data = Data;
  }

  public String getNroSocio() {
    return NroSocio;
  }

  public void setSocio(String NroSocio) {
    this.NroSocio = NroSocio;
  }

  public String getNroId() {
    return NroId;
  }

  public void setNroId(String NroId) {
    this.NroId = NroId;
  }
    
}
