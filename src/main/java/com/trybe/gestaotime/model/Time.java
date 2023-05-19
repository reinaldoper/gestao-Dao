package com.trybe.gestaotime.model;

import java.util.ArrayList;
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

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(name = "relacionamento_times_jogadores", joinColumns = {@JoinColumn(name = "time_id")},
      inverseJoinColumns = {@JoinColumn(name = "torcedor_id")})
  private List<Torcedor> torcedores;

  /**
   * Classe Time.
   **/
  public Time() {
    super();
    this.jogadores = new ArrayList<Jogador>();
    this.torcedores = new ArrayList<Torcedor>();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Classe Time.
   **/
  public void setJogadores(List<Jogador> jogador) {
    this.jogadores.clear();
    for (Jogador jogadors : jogadores) {
      this.jogadores.add(jogadors);
    }
  }

  /**
   * Classe Time.
   **/
  public void setTorcedores(List<Torcedor> torcedor) {
    this.torcedores.clear();
    for (Torcedor torcedors : torcedores) {
      this.torcedores.add(torcedors);
    }
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Torcedor> getTorcedores() {
    return torcedores;
  }

  public List<Jogador> getJogadores() {
    return jogadores;
  }

  /**
   * Métodos.
   **/

}
