package pl.coderslab.DatabaseNF.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.DatabaseNF.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Person person)
    {
        entityManager.persist(person);
    }

    public Person merge (Person person) {
        return entityManager.merge(person);
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public void remove(long id) {
        Person person = findById(id);
        entityManager.remove(entityManager.contains(person) ? person : entityManager.merge(person));
    }

    public List<Person> findAll() {
        Query query = entityManager.createQuery("SELECT p from Person p");
        return query.getResultList();
    }

}
