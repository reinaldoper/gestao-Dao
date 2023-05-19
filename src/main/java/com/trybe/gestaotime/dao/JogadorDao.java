package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Jogador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JogadorDao extends GenericDao<Jogador, Integer> {

  /**
   * Metodo main.
   */
  @Override
  public List<Jogador> listar() {
    EntityManager em = emf.createEntityManager();

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Jogador> cq = cb.createQuery(Jogador.class);
    Root<Jogador> rootEntry = cq.from(Jogador.class);
    CriteriaQuery<Jogador> all = cq.select(rootEntry);

    TypedQuery<Jogador> allQuery = em.createQuery(all);
    return allQuery.getResultList();
  }

  @Override
  public void deletar(Long id) {
    EntityManager em = emf.createEntityManager();

    Jogador toBeDeleted = em.find(Jogador.class, id);

    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();

    em.close();
  }

  @Override
  public Jogador findById(Long id) {
    EntityManager em = emf.createEntityManager();
    return em.find(Jogador.class, id);
  }

}
