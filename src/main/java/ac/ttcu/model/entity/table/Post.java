package ac.ttcu.model.entity.table;

import ac.ttcu.common.enumerations.UserType;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "posts")
@Entity
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String username;
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @NotNull
    @OneToOne(cascade = CascadeType.MERGE)
    private UniMajor uniMajor;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Content content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UniMajor getUniMajor() {
        return uniMajor;
    }

    public void setUniMajor(UniMajor uniMajor) {
        this.uniMajor = uniMajor;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
