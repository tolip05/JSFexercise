package regapp.domein.enteties.repositoris;

import regapp.domein.enteties.Employe;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final EntityManager entityManager;

    @Inject
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employe save(Employe entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public List<Employe> findAll() {
        this.entityManager.getTransaction().begin();
        List<Employe>employes =
                this.entityManager.createQuery("SELECT e FROM employes e",Employe.class)
                .getResultList();
        this.entityManager.getTransaction().commit();
        return employes;
    }

    @Override
    public Employe findById(String id) {
        this.entityManager.getTransaction().begin();
        Employe employe =
                this.entityManager.createQuery("SELECT e FROM employes e WHERE e.id =: id",Employe.class)
                 .setParameter("id",id)
                .getSingleResult();
        this.entityManager.getTransaction().commit();

        return employe;
    }

    @Override
    public void remove(String id) {
        this.entityManager.getTransaction().begin();
        this.entityManager.createQuery("DELETE FROM employes e WHERE e.id =:id")
                .setParameter("id",id)
        .executeUpdate();

        this.entityManager.getTransaction().commit();
    }
}
