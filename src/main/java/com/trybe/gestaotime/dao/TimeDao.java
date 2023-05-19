package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Time;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TimeDao extends GenericDao<Time, Long> {

  /**
   * Metodo main.
   */

  @Override
  public void salvar(Time s) {
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

  @Override
  public void editar(Time s) {
    /**
     * Updates an instance of type T into the database.
     *
     * 
     */
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.merge(s);
    em.getTransaction().commit();
  }

  @Override
  public List<Time> listar() {
    EntityManager em = emf.createEntityManager();

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Time> cq = cb.createQuery(Time.class);
    Root<Time> rootEntry = cq.from(Time.class);
    CriteriaQuery<Time> all = cq.select(rootEntry);

    TypedQuery<Time> allQuery = em.createQuery(all);
    List<Time> listar = allQuery.getResultList();
    em.close();

    return listar;
  }

  @Override
  public void deletar(Long id) {
    EntityManager em = emf.createEntityManager();

    Time toBeDeleted = em.find(Time.class, id);

    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();

    em.close();
  }

  @Override
  public Time findById(Long id) {
    EntityManager em = emf.createEntityManager();
    Time time = em.find(Time.class, id);
    em.close();
    return time;
  }

}
