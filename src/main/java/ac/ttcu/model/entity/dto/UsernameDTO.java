package ac.ttcu.model.entity.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UsernameDTO extends Entity implements Serializable {

    @NotNull
    private String newUsername;
    @NotNull
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
