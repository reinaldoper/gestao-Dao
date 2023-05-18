package com.trybe.gestaotime.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe abstrata GenericDao.
 **/

public abstract class GenericDao<T, I extends Serializable> {

  /**
   * Atributos.
   **/
  EntityManagerFactory emf = Persistence.createEntityManagerFactory("crudHibernatePU");

  /**
   * Atributos.
   **/

  public void salvar(T s) {
    /**
     * Updates an instance of type T into the database.
     *
     * 
     */
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.persist(s);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Atributos.
   * 
   **/
  public void editar(T s) {
    /**
     * Updates an instance of type T into the database.
     *
     * 
     */
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.merge(s);
    em.getTransaction().commit();

    em.close();
  }

  abstract void deletar(Long id);

  abstract List<T> listar();
  /**
   * Métodos.
   **/

}
