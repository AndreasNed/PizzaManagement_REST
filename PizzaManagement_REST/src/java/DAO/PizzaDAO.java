
package DAO;

import Entity.Pizza;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PizzaDAO {
    
    @PersistenceContext(name = "PU")
    EntityManager em;
    
    
    public void add(Pizza p){
        em.persist(p);
    }
    
    public void update(Pizza p){
        em.merge(p);
    }
    
    public void delete(Long id){
        em.remove(em.find(Pizza.class, id));
    }
    
    public Pizza find(Long id){
        return em.find(Pizza.class, id);
    }
    
    public List<Pizza> findAll(){
        return em.createQuery("SELECT p FROM Pizza p").getResultList();
    }
    
}
