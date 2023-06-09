package com.trybe.gestaotime.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Classe Jogador.
 **/

@Entity
public class Jogador {

  /**
   * Atributos.
   **/

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  private String posicao;

  /**
   * Métodos.
   * 
   */



  @OneToOne(fetch = FetchType.LAZY)
  private Documento documento;

  @ManyToOne
  @JoinColumn(name = "time_id")
  private Time time;

  /**
   * Métodos.
   * 
   */


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getPosicao() {
    return posicao;
  }

  public void setPosicao(String posicao) {
    this.posicao = posicao;
  }

  public Documento getDocumento() {
    return documento;
  }

  public void setDocumento(Documento documento) {
    this.documento = documento;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setTime(Time time) {
    this.time = time;
  }

  public Time getTime() {
    return time;
  }

  /**
   * Métodos.
   **/

}
