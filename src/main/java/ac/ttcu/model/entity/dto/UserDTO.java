package ac.ttcu.model.entity.dto;

import ac.ttcu.common.UserType;
import ac.ttcu.model.entity.table.UniMajor;
import com.sun.istack.NotNull;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {
    private long id;
    @NotNull
    private String fName;
    @NotNull
    private String lName;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private List<UserType> userType;
    private String adminCode;
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

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public UniMajorDTO getUniMajor() {
        return uniMajor;
    }

    public void setUniMajor(UniMajorDTO uniMajor) {
        this.uniMajor = uniMajor;
    }
}