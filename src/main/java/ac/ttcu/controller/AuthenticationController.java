package ac.ttcu.controller;

import ac.ttcu.TtcuApplication;
import ac.ttcu.common.Constants;
import ac.ttcu.model.entity.User;
import ac.ttcu.model.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private static Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

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
            logger.error(e.getMessage());
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
