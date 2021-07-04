package ac.ttcu.model.entity.table;

import ac.ttcu.common.enumerations.PostTypes;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "content")
@Entity
public class Content implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
