package ac.ttcu.model.entity.dto;

import ac.ttcu.common.enumerations.UserType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class UserDTO extends Entity implements Serializable {
    private long id;
    @NotNull
    @NotBlank
    private String fName;
    @NotNull
    @NotBlank
    private String lName;
    @NotNull
    @NotBlank
    @Size(min = 8)
    private String username;
    @NotNull
    @NotBlank
    @Size(min = 8)
    private String password;
    @NotNull
    private List<UserType> userType;
    @NotNull
    private UniMajorDTO uniMajor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setUserType(List<UserType> userType) {
        this.userType = userType;
    }

    public List<UserType> getUserType() {
        return userType;
    }

    public UniMajorDTO getUniMajor() {
        return uniMajor;
    }

    public void setUniMajor(UniMajorDTO uniMajor) {
        this.uniMajor = uniMajor;
    }

}
