package pl.coderslab.DatabaseNF.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.DatabaseNF.entity.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ServiceDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Service service)
    {
        entityManager.persist(service);
    }

    public Service merge (Service service) {
        return entityManager.merge(service);
    }

    public Service findById(long id) {
        return entityManager.find(Service.class, id);
    }

    public void remove(long id) {
        Service service = findById(id);
        entityManager.remove(entityManager.contains(service) ? service : entityManager.merge(service));
    }

    public List<Service> findAll() {
        Query query = entityManager.createQuery("SELECT s from Service s");
        return query.getResultList();
    }


}
