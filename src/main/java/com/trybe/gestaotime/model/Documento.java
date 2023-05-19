package com.trybe.gestaotime.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe Documento.
 */

@Entity
public class Documento {
  /**
   * Atributos.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String numeroCarteiraTrabalho;

  private String cpf;

  private String cbf;

  /**
   * Métodos.
   * 
   */


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumeroCarteiraTrabalho() {
    return numeroCarteiraTrabalho;
  }

  public void setNumeroCarteiraTrabalho(String numeroCarteiraTrabalho) {
    this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNumeroCbf() {
    return cbf;
  }

  public void setNumeroCbf(String cbf) {
    this.cbf = cbf;
  }

}
