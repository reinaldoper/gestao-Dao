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
  EntityManager em = emf.createEntityManager();

  /**
   * Metodo main.
   */

  @Override
  public void salvar(Jogador s) {
    /**
     * Atributos.
     * 
     **/
    EntityManager em = this.emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(s);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public List<Jogador> listar() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Jogador> cq = cb.createQuery(Jogador.class);
    Root<Jogador> rootEntry = cq.from(Jogador.class);
    CriteriaQuery<Jogador> all = cq.select(rootEntry);
    TypedQuery<Jogador> allQuery = em.createQuery(all);
    return allQuery.getResultList();
  }

  /**
   * Metodo main.
   */

  @Override
  public void deletar(Long id) {
    Jogador toBeDeleted = em.find(Jogador.class, id);
    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();
  }

  /**
   * Metodo main.
   */
  @Override
  public Jogador findById(Long id) {
    EntityManager em = emf.createEntityManager();
    Jogador doc = em.find(Jogador.class, id);
    em.close();
    return doc;
  }


}
