package ac.ttcu.common.enumerations;

import org.springframework.security.core.GrantedAuthority;

public enum UserType implements GrantedAuthority {

    TEACHER,
    STUDENT,
    MASTER,
    ADMIN;


    @Override
    public String getAuthority() {
        return this.name();
    }
}
