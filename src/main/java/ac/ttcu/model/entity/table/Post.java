package ac.ttcu.model.entity.table;

import ac.ttcu.common.enumerations.PostTypes;
import ac.ttcu.common.enumerations.UserType;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;


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
    private String title;
    @NotNull
    private String description;
    @Lob
    private byte[] image;
    private String contact;
    @NotNull
    @Enumerated(EnumType.STRING)
    private PostTypes postType;
    private String pDate;
    private String pTime;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public PostTypes getPostType() {
        return postType;
    }

    public void setPostType(PostTypes postType) {
        this.postType = postType;
    }

    public String getpDate() {
        return pDate;
    }

    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    public String getpTime() {
        return pTime;
    }

    public void setpTime(String pTime) {
        this.pTime = pTime;
    }
}
