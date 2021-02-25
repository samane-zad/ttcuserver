package ac.ttcu.common;

public enum UserType {

    ADMIN("ROLE_ADMIN"),
    STUDENT("ROLE_STUDENT");

    public final String UserType;

    private UserType(String UserType) {
        this.UserType = UserType;
    }
}
