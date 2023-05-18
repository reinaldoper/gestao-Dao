package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Torcedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TorcedorDao extends GenericDao<Torcedor, Integer> {
  /**
   * Metodo main.
   */
  @Override
  public List<Torcedor> listar() {
    EntityManager em = emf.createEntityManager();
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Torcedor> cq = cb.createQuery(Torcedor.class);
    Root<Torcedor> rootEntry = cq.from(Torcedor.class);
    CriteriaQuery<Torcedor> all = cq.select(rootEntry);

    TypedQuery<Torcedor> allQuery = em.createQuery(all);
    return allQuery.getResultList();
  }

  @Override
  public void deletar(Long id) {
    EntityManager em = emf.createEntityManager();
    Torcedor toBeDeleted = em.find(Torcedor.class, id);

    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();
  }

}
