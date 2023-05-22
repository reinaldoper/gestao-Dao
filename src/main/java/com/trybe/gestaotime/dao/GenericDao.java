package com.trybe.gestaotime.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Classe abstrata GenericDao.
 **/

public abstract class GenericDao<T, I extends Serializable> {

  /**
   * Atributos.
   **/
  public static final EntityManager em =
      Persistence.createEntityManagerFactory("crudHibernatePU").createEntityManager();

  /**
   * Atributos.
   * 
   **/

  /**
   * Atributos.
   * 
   **/
  public void salvar(T entity) {
    em.getTransaction().begin();
    em.persist(entity);
    em.getTransaction().commit();
  }

  /**
   * Métodos.
   **/
  public void editar(T entity) {
    em.getTransaction().begin();
    em.merge(entity);
    em.getTransaction().commit();
  }
  /**
   * Métodos.
   **/

  public abstract void deletar(Long id);

  public abstract List<T> listar();
  
  public abstract T buscarPorId(Long id);
  /**
   * Métodos.
   **/
}
  


