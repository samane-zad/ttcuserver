package ac.ttcu.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtils {

    private final static String SECRET = "../resources/jwtRS256.key";

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + (60 * 60 * 500)))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public static String getUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
    }

    public static String getUserType() {
        String role = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return role;
    }

    public static String getPassword()
    {
        String pass = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getCredentials());
        return pass;
    }
}
