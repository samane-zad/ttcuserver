package ac.ttcu.model.entity.dto;

import ac.ttcu.model.entity.table.UniMajor;
import com.sun.istack.NotNull;

import java.io.Serializable;

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
    private String userType;
    private String adminCode;
    private UniMajor uniMajor;

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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public UniMajor getUniMajor() {
        return uniMajor;
    }

    public void setUniMajor(UniMajor uniMajor) {
        this.uniMajor = uniMajor;
    }
}
