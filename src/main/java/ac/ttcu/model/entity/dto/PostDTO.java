package ac.ttcu.model.entity.dto;

import ac.ttcu.common.Utils;
import ac.ttcu.common.enumerations.PostTypes;
import ac.ttcu.common.enumerations.UserType;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;


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

    public String getpDate() {
        if(Objects.isNull(this.pDate))
            return Utils.getPersianDate(Date.from(Instant.now()));
        else return this.pDate;
    }

    public String getpTime() {
        if(Objects.isNull(this.pTime))
            return Utils.getPersianTime(Date.from(Instant.now()));
        else return this.pTime;
    }

    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    public void setpTime(String pTime) {
        this.pTime = pTime;
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
