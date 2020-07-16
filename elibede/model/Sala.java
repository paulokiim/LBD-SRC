/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elibede.model;

/**
 *
 * @author paulokim
 */
public class Sala {
  private String NroId;
  private String Area;
  private String Localizacao;

  public Sala(String NroId, String Area, String Localizacao) {
    this.NroId = NroId;
    this.Area = Area;
    this.Localizacao = Localizacao;
  }

  public String getNroId() {
    return NroId;
  }

  public void setNroId(String NroId) {
    this.NroId = NroId;
  }

  public String getArea() {
    return Area;
  }

  public void setArea(String Area) {
    this.Area = Area;
  }

  public String getLocalizacao() {
    return Localizacao;
  }

  public void setLocalizacao(String Localizacao) {
    this.Localizacao = Localizacao;
  }
    
}
