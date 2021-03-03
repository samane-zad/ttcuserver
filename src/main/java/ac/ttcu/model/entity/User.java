package ac.ttcu.model.entity;

import ac.ttcu.common.UserType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "users")
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "fName", columnDefinition = "NVARCHAR2(20)")
    private String fName;
    @Column(name = "lName", columnDefinition = "NVARCHAR2(30)")
    private String lName;
    @Column(name = "username", columnDefinition = "NVARCHAR2(10)")
    private String username;
    @Column(name = "password", columnDefinition = "NVARCHAR2(8)")
    private String password;
    @Column(name = "userType", columnDefinition = "NVARCHAR2(12)")
    private UserType userType;



    public User() {
    }


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

}
