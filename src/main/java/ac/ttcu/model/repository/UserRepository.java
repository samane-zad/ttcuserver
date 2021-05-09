package ac.ttcu.model.repository;

import ac.ttcu.model.entity.table.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(name = "loginQuery", value = "select u from User  u where u.username= ?1 and u.password=?2")
    User userFindOne(String username, String password) throws Exception;


    @Query(name ="signUpQuery",value="select u from User u where u.username=?1")
    User userFindByUsername(String username);

    @Modifying
    @Query(value = "update User u set u.fName = ?1, u.lName = ?2,u.userType=?3 , u.username = ?4 , u.password=?5 where u.id=?6")
    void userUpdate(String fName, String lName, String userType, String username, String password, long id);

}
