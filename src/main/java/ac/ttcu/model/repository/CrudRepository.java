package ac.ttcu.model.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CrudRepository<T, I> {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public void save(T t) throws Exception {

        entityManager.persist(t);
        System.out.println("Create new" + t + " Entity");
    }

    public void update(T t) throws Exception {

        entityManager.merge(t);
        System.out.println("Update " + t + " Entity");
    }

    public void delete(T t) throws Exception {

        t = entityManager.merge(t);
        entityManager.remove(t);
        System.out.println("Delete " + t + " Entity");
    }

    public List<T> findAll(Class<T> tClass) throws Exception {
        Query query = entityManager.createQuery("select entity from " + tClass.getAnnotation(Entity.class).name() + " entity");
        System.out.println("FindAll " + tClass.getName() + " Entity");
        return query.getResultList();
    }

    public List<T> findAll(Class<T> tClass, String property, String value) throws Exception {
        System.out.println("FindOne " + tClass.getName() + " Entity");
        Query query = entityManager.createQuery("select entity from " + tClass.getAnnotation(Entity.class).name() + " entity where entity." + property + "='" + value + "'");
        return query.getResultList();
    }



}
