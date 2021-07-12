package ac.ttcu.model.entity.dto;

import ac.ttcu.common.enumerations.PostTypes;
import ac.ttcu.common.enumerations.UserType;
import com.sun.istack.NotNull;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

public class PostDTO extends Entity implements Serializable {

    private long id;
    @NotNull
    private String username;
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @NotNull
    private UniMajorDTO uniMajor;
    @NotNull
    private String title;
    @NotNull
    private String description;
    private MultipartFile image;
    private String contact;
    @NotNull
    @Enumerated(EnumType.STRING)
    private PostTypes postType;

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

    public UniMajorDTO getUniMajor() {
        return uniMajor;
    }

    public void setUniMajor(UniMajorDTO uniMajor) {
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
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

    @Override
    public String toString() {
        return "PostDTO{" +
                "id=" + getId() +
                ", username='" + getUsername() + "'" +
                ", userType='" + getUserType() + "'" +
                ", uniMajor='" + getUniMajor() + "'" +
                ", title='" + getTitle() + "'" +
                ", description='" + getDescription() + "'" +
                ", contact='" + getContact() + "'" +
                ", image='" + getImage() + "'" +
                ", postType='" + getPostType() + "'"+
                "}";

    }

    }
