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
public class SalaSquash {
  private String Codigo;
  private String Estado;
  private String NroId;

  public SalaSquash(String Codigo, String Estado, String NroId) {
    this.Codigo = Codigo;
    this.Estado = Estado;
    this.NroId = NroId;
  }

  public String getCodigo() {
    return Codigo;
  }

  public void setCodigo(String Codigo) {
    this.Codigo = Codigo;
  }

  public String getEstado() {
    return Estado;
  }

  public void setEstado(String Estado) {
    this.Estado = Estado;
  }

  public String getNroId() {
    return NroId;
  }

  public void setNroId(String NroId) {
    this.NroId = NroId;
  }
    
}
