package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Documento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DocumentoDao extends GenericDao<Documento, Integer> {

  /**
   * Metodo main.
   */

  @Override
  public void salvar(Documento s) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(s);
    em.getTransaction().commit();
    em.close();

  }

  @Override
  public void editar(Documento s) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(s);
    em.getTransaction().commit();

    em.close();

  }

  @Override
  public void deletar(Long id) {
    EntityManager em = emf.createEntityManager();

    // Recupera se a entidade a ser deletada
    Documento toBeDeleted = em.find(Documento.class, id);

    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();

    em.close();

  }

  @Override
  public List<Documento> listar() {
    EntityManager em = emf.createEntityManager();


    /*
     * CriteriaBuilder cb = em.getCriteriaBuilder(); CriteriaQuery<Aplicacao> cq =
     * cb.createQuery(Aplicacao.class); Root<Aplicacao> rootEntry = cq.from(Aplicacao.class);
     * CriteriaQuery<Aplicacao> all = cq.select(rootEntry);
     * 
     * TypedQuery<Aplicacao> allQuery = em.createQuery(all);
     */

    Query allQuery = em.createQuery("from Documento");
    return allQuery.getResultList();
  }

  @Override
  public Documento findById(Integer id) {
    EntityManager em = emf.createEntityManager();
    return em.find(Documento.class, id);
  }


}
