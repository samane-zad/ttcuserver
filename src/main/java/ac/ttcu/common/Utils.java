package ac.ttcu.common;

import ac.ttcu.controller.AuthenticationController;
import ac.ttcu.security.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class Utils {
    private static Logger logger = LoggerFactory.getLogger(AuthenticationController.class);


    public static String fetchUsername(HttpHeaders httpHeaders) {
        String username = JWTUtils.getUsername(httpHeaders.get("Authorization").get(0));
        return username;
    }

}
