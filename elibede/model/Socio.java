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
public class Socio {
  private String NroSocio;
  private String Nome;
  private String Telefone;
  private String Endereco;
  private String Profissao;
  private String DocsBancarios;

  public Socio(String NroSocio, String Nome, String Telefone, String Endereco, String Profissao, String DocsBancarios) {
    this.NroSocio = NroSocio;
    this.Nome = Nome;
    this.Telefone = Telefone;
    this.Endereco = Endereco;
    this.Profissao = Profissao;
    this.DocsBancarios = DocsBancarios;
  }

  public String getNroSocio() {
    return NroSocio;
  }

  public void setNroSocio(String NroSocio) {
    this.NroSocio = NroSocio;
  }

  public String getNome() {
    return Nome;
  }

  public void setNome(String Nome) {
    this.Nome = Nome;
  }

  public String getTelefone() {
    return Telefone;
  }

  public void setTelefone(String Telefone) {
    this.Telefone = Telefone;
  }

  public String getEndereco() {
    return Endereco;
  }

  public void setEndereco(String Endereco) {
    this.Endereco = Endereco;
  }

  public String getProfissao() {
    return Profissao;
  }

  public void setProfissao(String Profissao) {
    this.Profissao = Profissao;
  }

  public String getDocsBancarios() {
    return DocsBancarios;
  }

  public void setDocsBancarios(String DocsBancarios) {
    this.DocsBancarios = DocsBancarios;
  }
    
}
