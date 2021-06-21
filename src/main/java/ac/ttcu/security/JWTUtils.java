package ac.ttcu.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtils {

    private final String SECRET = "../resources/jwtRS256.key";

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + (60 * 60 * 100)))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }
    public String getUsername(String token)
    {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
    }
}
