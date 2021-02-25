package ac.ttcu.model.repository;

import ac.ttcu.common.Log4j;
import ac.ttcu.model.entity.User;
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

    public User findOne(String username, String password) throws Exception {

        Log4j.getLog().info("FindOne Entity:User");
        Query query = entityManager.createQuery("select entity from user entity where entity.username=? and entity.password=?");
        query.setParameter(0, username);
        query.setParameter(1, password);

        if (query.getMaxResults() > 0) {
            Log4j.getLog().info("User Found");
            return (User) query.getSingleResult();
        } else {
            Log4j.getLog().info("User Not Found");
            throw new Exception("User Not Found");
        }
    }

}
