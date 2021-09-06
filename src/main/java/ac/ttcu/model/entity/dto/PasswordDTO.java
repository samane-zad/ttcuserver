package ac.ttcu.model.entity.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class PasswordDTO extends Entity implements Serializable {

    private String username;
    @NotNull
    private String oldPassword;
    @NotNull
    private String newPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
