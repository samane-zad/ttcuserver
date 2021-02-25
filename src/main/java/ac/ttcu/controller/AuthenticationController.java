package ac.ttcu.controller;

import ac.ttcu.common.Constants;
import ac.ttcu.model.entity.User;
import ac.ttcu.model.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private static Logger logger = Logger.getLogger(AuthenticationController.class);
    @Autowired
    UserService userService;

    @PostMapping(value = "/signUp")
    @ResponseBody
    private String signUp(@RequestBody User user) {
        try {
            logger.info("Request to save user ");
            userService.save(user);
            return Constants.SIGN_UP_SUCCEEDED;
        } catch (Exception e) {
            logger.error("Error while saving user info ");
            logger.trace(e.getMessage());
            return Constants.SIGN_UP_FAILED;
        }
    }

    @RequestMapping("/login")
    private ResponseEntity<User> login(@ModelAttribute User user) {
        try {
            userService.userfindOne(user);
        } catch (Exception e) {

        }
        return ResponseEntity.ok(user);
    }
}
