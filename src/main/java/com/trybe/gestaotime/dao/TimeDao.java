package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Time;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TimeDao extends GenericDao<Time, Integer> {

  /**
   * Metodo main.
   */

  @Override
  public List<Time> listar() {
    EntityManager em = emf.createEntityManager();

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Time> cq = cb.createQuery(Time.class);
    Root<Time> rootEntry = cq.from(Time.class);
    CriteriaQuery<Time> all = cq.select(rootEntry);

    TypedQuery<Time> allQuery = em.createQuery(all);
    return allQuery.getResultList();
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
    return em.find(Time.class, id);
  }

}
