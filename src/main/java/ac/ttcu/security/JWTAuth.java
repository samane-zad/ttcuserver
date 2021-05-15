package ac.ttcu.security;


public class JWTAuth {
    private String username;
    private String password;

    public JWTAuth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public JWTAuth() {
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
}
