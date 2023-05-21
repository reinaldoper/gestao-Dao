package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Documento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DocumentoDao extends GenericDao<Documento, Integer> {

  /**
   * Metodo main.
   */
  EntityManager em = emf.createEntityManager();

  @Override
  public List<Documento> listar() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Documento> cq = cb.createQuery(Documento.class);
    Root<Documento> rootEntry = cq.from(Documento.class);
    CriteriaQuery<Documento> all = cq.select(rootEntry);
    TypedQuery<Documento> allQuery = em.createQuery(all);
    return allQuery.getResultList();
  }
  /**
   * Metodo main.
   */

  @Override
  public void deletar(Long id) {
    Documento toBeDeleted = em.find(Documento.class, id);
    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();
  }
  /**
   * Metodo main.
   */

  @Override
  public Documento findById(Long id) {
    EntityManager em = emf.createEntityManager();
    Documento doc = em.find(Documento.class, id);
    em.close();
    return doc;
  }

}
