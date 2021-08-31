package ac.ttcu.model.entity.dto;

import java.io.Serializable;

public class UsernameDTO extends Entity implements Serializable {

    private String newUsername;
    private String oldUsername;

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public String getOldUsername() {
        return oldUsername;
    }

    public void setOldUsername(String oldUsername) {
        this.oldUsername = oldUsername;
    }
}
