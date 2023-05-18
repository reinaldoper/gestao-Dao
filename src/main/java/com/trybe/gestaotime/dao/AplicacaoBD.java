package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Jogador;
import com.trybe.gestaotime.model.Time;

/**
 * Classe AplicacaoBD.
 **/

public class AplicacaoBD {

  /**
   * Atributos.
   **/
  public static void main(String[] args) {
    AplicacaoBD ab = new AplicacaoBD();

    ab.run();
  }

  /**
   * Atributos.
   **/

  public void run() {
    /**
     * Atributos.
     **/

    Jogador jogador = new Jogador();
    jogador.setNome("Jogador 12");
    JogadorDao jogadorDao = new JogadorDao();
    jogadorDao.salvar(jogador);
    for (Jogador j : jogadorDao.listar()) {
      System.out.println(j.getNome());
    }

    /**
     * Métodos.
     **/

    Time time = new Time();
    time.setNome("Time Timao");
    time.setJogadores(jogadorDao.listar());
    for (Jogador j : time.getJogadores()) {
      System.out.println(j.getId());
    }
    TimeDao timeDao = new TimeDao();
    timeDao.salvar(time);
  }
  /**
   * Métodos.
   **/

}
