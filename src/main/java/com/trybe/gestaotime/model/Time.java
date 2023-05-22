package com.trybe.gestaotime.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Classe Time.
 **/

@Entity
public class Time {

  /**
   * Atributos.
   **/
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @OneToMany(mappedBy = "time", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Jogador> jogadores;

  @ManyToMany
  @JoinTable(name = "time_torcedor", joinColumns = @JoinColumn(name = "time_id"),
      inverseJoinColumns = @JoinColumn(name = "torcedor_id"))
  private List<Torcedor> torcedores;

  /**
   * Classe Time.
   **/


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Classe Time.
   **/
  public void setJogadores(List<Jogador> jogadores) {
    this.jogadores = jogadores;
  }

  /**
   * Classe Time.
   **/
  public void setTorcedores(List<Torcedor> torcedores) {
    this.torcedores = torcedores;
  }

  /**
   * Classe Time.
   **/

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public List<Torcedor> getTorcedores() {
    return this.torcedores;
  }

  public List<Jogador> getJogadores() {
    return this.jogadores;
  }

  /**
   * Métodos.
   **/

}
