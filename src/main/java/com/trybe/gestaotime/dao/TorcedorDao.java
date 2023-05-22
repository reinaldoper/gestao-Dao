package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Torcedor;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TorcedorDao extends GenericDao<Torcedor, Integer> {
  /**
   * Metodo main.
   */

  /**
   * Metodo main.
   */

  @Override
  public List<Torcedor> listar() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Torcedor> cq = cb.createQuery(Torcedor.class);
    Root<Torcedor> rootEntry = cq.from(Torcedor.class);
    CriteriaQuery<Torcedor> all = cq.select(rootEntry);
    TypedQuery<Torcedor> allQuery = em.createQuery(all);
    return allQuery.getResultList();
  }
  /**
   * Metodo main.
   */

  @Override
  public void deletar(Long id) {
    Torcedor toBeDeleted = em.find(Torcedor.class, id);
    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();
  }
  /**
   * Metodo main.
   */

  @Override
  public Torcedor buscarPorId(Long id) {
    return em.find(Torcedor.class, id);

  }

}
