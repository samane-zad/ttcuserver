package ac.ttcu.common.enumerations;

public enum Constants {
    SIGN_UP_SUCCEEDED("User signed up successfully"),
    SIGN_UP_FAILED("Error occurred while signing up user"),
    LOGIN_SUCCEEDED("User logged in successfully"),
    LOGIN_FAILED("Error occurred while login");
    private final String message;

    Constants(String message) {
        this.message = message;
    }
}
