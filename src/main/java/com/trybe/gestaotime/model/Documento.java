package com.trybe.gestaotime.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "jogador_id")
  private Jogador jogador;

  public long getId() {
    return id;
  }

  public void setId(long id) {
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
