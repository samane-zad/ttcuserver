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
    }

    public void update(T t) throws Exception {

        entityManager.merge(t);
    }

    public void delete(T t) throws Exception {

        t = entityManager.merge(t);
        entityManager.remove(t);
    }

    public T findOne(Class<T> tClass, I id) throws Exception {
        Query query = entityManager.createQuery("select entity from " + tClass.getName() + " entity where entity.id=?1");
        query.setParameter(1, id);
        return (T) query.getSingleResult();
    }

    public List<T> findAll(Class<T> tClass) throws Exception {
        Query query = entityManager.createQuery("select entity from " + tClass.getAnnotation(Entity.class).name() + " entity");
        return query.getResultList();
    }

    public List<T> findAll(Class<T> tClass, String property, String value) throws Exception {
        Query query = entityManager.createQuery("select entity from " + tClass.getAnnotation(Entity.class).name() + " entity where entity." + property + "='" + value + "'");
        return query.getResultList();
    }



}
