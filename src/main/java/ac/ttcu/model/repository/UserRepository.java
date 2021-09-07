package ac.ttcu.model.repository;

import ac.ttcu.model.entity.table.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



    @Query(value="select u from User u where u.username=?1")
    User userFindByUsername(String username);

    @Modifying
    @Query(value = "update User u set u.fName = ?1, u.lName = ?2,u.userType=?3 , u.username = ?4 , u.password=?5 where u.id=?6")
    void userUpdate(String fName, String lName, String userType, String username, String password, long id);

    @Modifying
    @Query(value = "update User  u set u.username=?1 where u.id=?2")
    void updateUsername(String newUsername, Long id);

    @Modifying
    @Query(value = "update User  u set u.password=?1 where u.id=?2")
    void updatePassword(String newPassword, Long id);

    @Modifying
    @Query(value = "update User  u set u.fName=?1,u.lName=?2 where u.id=?3")
    void updateUser(String fName, String lName, Long id);

    @Modifying
    @Query(value = "update authorities set username=?1 where username=?2", nativeQuery = true)
    void updateUserRoll(String newUser, String OldUser);

}
