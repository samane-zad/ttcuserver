package ac.ttcu.model.entity.dto;

import ac.ttcu.common.UserType;
import ac.ttcu.model.entity.table.UniMajor;
import com.sun.istack.NotNull;

import javax.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private List<UserType> userType;
    private String adminCode;
    private UniMajor uniMajor;
}
