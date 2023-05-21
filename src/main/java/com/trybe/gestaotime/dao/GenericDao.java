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
   * 
   **/
  public void salvar(T s) {
    /**
     * Atributos.
     * 
     **/
    EntityManager em = this.emf.createEntityManager();
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
     * Atributos.
     * 
     **/
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(s);
    em.getTransaction().commit();
    em.close();
  }

  public abstract List<T> listar();

  public abstract void deletar(Long id);

  public T findById(Long id) {
    T responseT = null;
    return responseT;
  }
  /**
   * Métodos.
   **/

}
