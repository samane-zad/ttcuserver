package ac.ttcu.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtils {

    private final String SECRET = "secret";

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + (60 * 60 * 5)))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }
}
