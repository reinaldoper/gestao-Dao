package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Torcedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TorcedorDao extends GenericDao<Torcedor, Integer> {
  /**
   * Metodo main.
   */

  @Override
  public void salvar(Torcedor s) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(s);
    em.getTransaction().commit();
    em.close();

  }

  @Override
  public void editar(Torcedor s) {
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
    Torcedor toBeDeleted = em.find(Torcedor.class, id);

    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();

    em.close();

  }

  @Override
  public List<Torcedor> listar() {
    EntityManager em = emf.createEntityManager();


    /*
     * CriteriaBuilder cb = em.getCriteriaBuilder(); CriteriaQuery<Aplicacao> cq =
     * cb.createQuery(Aplicacao.class); Root<Aplicacao> rootEntry = cq.from(Aplicacao.class);
     * CriteriaQuery<Aplicacao> all = cq.select(rootEntry);
     * 
     * TypedQuery<Aplicacao> allQuery = em.createQuery(all);
     */

    Query allQuery = em.createQuery("from Torcedor");
    return allQuery.getResultList();
  }

  @Override
  public Torcedor findById(Integer id) {
    EntityManager em = emf.createEntityManager();
    return em.find(Torcedor.class, id);
  }


}
