package ir.moke.spring.model.repository;

import ir.moke.spring.model.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private EntityManagerFactory entityManagerFactory ;

    public void insert(Person person) {
        em.persist(person);
    }

    public void update(Person person) {
        em.merge(person);
    }

    public void delete(Person person) {
        em.remove(person);
    }

    public void delete(long id) {
        EntityManager em = entityManagerFactory.createEntityManager() ;
        System.out.println("Executed ...");
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Person p where p.id=:x").setParameter("x", id).executeUpdate();
        em.getTransaction().commit();
    }

    public Person select(long id) {
        return em.find(Person.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Person> select() {
        return em.createQuery("SELECT e FROM Person e").getResultList();
    }
}
