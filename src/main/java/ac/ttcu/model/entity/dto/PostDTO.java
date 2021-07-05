package ac.ttcu.model.entity.dto;

import ac.ttcu.common.enumerations.UserType;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

public class PostDTO implements Serializable {

    private long id;
    @NotNull
    private String username;
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @NotNull
    private UniMajorDTO uniMajor;
    @NotNull
    private ContentDTO content;

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

    public ContentDTO getContent() {
        return content;
    }

    public void setContent(ContentDTO content) {
        this.content = content;
    }
}
