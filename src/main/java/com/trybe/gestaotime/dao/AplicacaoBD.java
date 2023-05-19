package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Jogador;

/**
 * Classe AplicacaoBD.
 **/

public class AplicacaoBD {

  /**
   * Atributos.
   **/
  public static void main(String[] args) {
    Jogador jogador = new Jogador();
    jogador.setNome("Jogador 12");
    JogadorDao jogadorDao = new JogadorDao();
    jogadorDao.salvar(jogador);
    for (Jogador j : jogadorDao.listar()) {
      System.out.println(j.getNome());
    }
  }

  /**
   * Atributos.
   **/

  /**
   * Métodos.
   **/

}
