package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Jogador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JogadorDao extends GenericDao<Jogador, Integer> {

  /**
   * Metodo main.
   */

  @Override
  public void salvar(Jogador s) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(s);
    em.getTransaction().commit();
    em.close();

  }

  @Override
  public void editar(Jogador s) {
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
    Jogador toBeDeleted = em.find(Jogador.class, id);

    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();

    em.close();

  }

  @Override
  public List<Jogador> listar() {
    EntityManager em = emf.createEntityManager();


    /*
     * CriteriaBuilder cb = em.getCriteriaBuilder(); CriteriaQuery<Aplicacao> cq =
     * cb.createQuery(Aplicacao.class); Root<Aplicacao> rootEntry = cq.from(Aplicacao.class);
     * CriteriaQuery<Aplicacao> all = cq.select(rootEntry);
     * 
     * TypedQuery<Aplicacao> allQuery = em.createQuery(all);
     */

    Query allQuery = em.createQuery("from Jogador");
    return allQuery.getResultList();
  }

  @Override
  public Jogador findById(Integer id) {
    EntityManager em = emf.createEntityManager();
    return em.find(Jogador.class, id);
  }


}
