package pl.coderslab.DatabaseNF.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.DatabaseNF.entity.Therapist;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TherapistDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Therapist therapist)
    {
        entityManager.persist(therapist);
    }

    public Therapist merge (Therapist therapist) {
        return entityManager.merge(therapist);
    }

    public Therapist findById(long id) {
        return entityManager.find(Therapist.class, id);
    }

    public void remove(long id) {
        Therapist therapist = findById(id);
        entityManager.remove(entityManager.contains(therapist) ? therapist : entityManager.merge(therapist));
    }

    public List<Therapist> findAll() {
        Query query = entityManager.createQuery("SELECT t from Therapist t");
        return query.getResultList();
    }
}
