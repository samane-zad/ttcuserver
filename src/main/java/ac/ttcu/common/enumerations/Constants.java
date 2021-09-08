package ac.ttcu.common.enumerations;

public enum Constants {
    SIGN_UP_SUCCEEDED("User signed up successfully"),
    SIGN_UP_FAILED("Error occurred while signing up user"),
    LOGIN_SUCCEEDED("User logged in successfully"),
    LOGIN_FAILED("Error occurred while login"),
    OPERATION_DONE_SUCCESSFULLY("Operation is done successfully"),
    OPERATION_FAILED("Operation is failed by an error"),
    NO_POSTS_FOUND("No posts found"),
    NO_USERS_FOUND("No users found"),
    NO_UNIMAJOR_FOUND("Wrong university and major is selected"),
    UNMANAGEABLE_USER("User cannot be managed by this admin");
    private final String message;

    Constants(String message) {
        this.message = message;
    }
}
