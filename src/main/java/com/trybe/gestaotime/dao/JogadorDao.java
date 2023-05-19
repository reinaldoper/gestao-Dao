package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Jogador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JogadorDao extends GenericDao<Jogador, Long> {

  /**
   * Metodo main.
   */

  @Override
  public void salvar(Jogador s) {
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
  public void editar(Jogador s) {
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
  public List<Jogador> listar() {
    EntityManager em = emf.createEntityManager();

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Jogador> cq = cb.createQuery(Jogador.class);
    Root<Jogador> rootEntry = cq.from(Jogador.class);
    CriteriaQuery<Jogador> all = cq.select(rootEntry);
    TypedQuery<Jogador> allQuery = em.createQuery(all);
    List<Jogador> listar = allQuery.getResultList();
    em.close();

    return listar;
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
    Jogador jog = em.find(Jogador.class, id);
    em.close();
    return jog;
  }

}
