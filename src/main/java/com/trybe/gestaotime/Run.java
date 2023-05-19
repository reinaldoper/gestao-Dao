package com.trybe.gestaotime;

import com.trybe.gestaotime.dao.DocumentoDao;
import com.trybe.gestaotime.model.Documento;

/**
 * Classe Run.
 */

public class Run {

  /**
   * Atributos.
   */
  public static void main(String[] args) {
    Documento documento = new Documento();
    documento.setCpf("00023405123");
    DocumentoDao dao = new DocumentoDao();
    dao.salvar(documento);

  }
  /**
   * Métodos.
   */

}
