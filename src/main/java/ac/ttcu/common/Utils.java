package ac.ttcu.common;

import ac.ttcu.controller.AuthenticationController;
import ac.ttcu.model.entity.table.User;
import ac.ttcu.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Utils {
    private static Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    UserService userService;

    public Boolean isUserAlreadyDefined(String username) throws Exception {
        User user = (User) userService.loadUserByUsername(username);
        if (user != null) {
            logger.info("Username already defined");
            return true;
        }
        else {
            logger.info("Safe username");
            return false;
        }
    }
}
