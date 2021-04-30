package ac.ttcu.model.entity;

import ac.ttcu.common.UserType;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "users")
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String fName;
    @NotNull
    private String lName;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    @ElementCollection(targetClass = UserType.class)
    @CollectionTable(
            name = "authorities",
            joinColumns = @JoinColumn(name = "username", referencedColumnName = "username"))
    @Enumerated(EnumType.STRING)
    private List<UserType> userType;
    private String adminCode;
    @OneToOne(cascade = CascadeType.MERGE)
    private UniMajor uniMajor;


    public User() {
    }


    public long getId() {
        return id;
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

    public List<UserType> getUserType() {
        return userType;
    }

    public void setUserType(List<UserType> userType) {
        this.userType = userType;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public UniMajor getUniMajor() {
        return uniMajor;
    }

    public void setUniMajor(UniMajor uniMajor) {
        this.uniMajor = uniMajor;
    }
}
