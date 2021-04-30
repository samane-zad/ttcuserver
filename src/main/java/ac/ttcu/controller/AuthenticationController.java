package ac.ttcu.controller;

import ac.ttcu.common.Constants;
import ac.ttcu.common.Message;
import ac.ttcu.model.entity.UniMajor;
import ac.ttcu.model.entity.User;
import ac.ttcu.model.service.UniMajorService;
import ac.ttcu.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private static Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    UserService userService;
    @Autowired
    UniMajorService uniMajorService;

    @PostMapping(value = "/signUp",produces = "application/json")
    @ResponseBody
    private ResponseEntity<Message> signUp(@RequestBody User user) {
        Message message;
        try {
            logger.info("Request to save user ");
            UniMajor uniMajor = uniMajorService.findUniMajorById(user.getUniMajor().getId());
            user.setUniMajor(uniMajor);
            if (isUserAlreadyDefined(user.getUsername()) == true) {
                message=new Message(HttpStatus.NOT_ACCEPTABLE,Constants.USERNAME_ALREADY_DEFINED);
            } else {
                userService.save(user);
                message=new Message(HttpStatus.OK,Constants.SIGN_UP_SUCCEEDED,user);
            }
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            logger.error("Error while saving user info ");
            logger.error(e.getMessage());
            message=new Message(HttpStatus.INTERNAL_SERVER_ERROR,Constants.SIGN_UP_FAILED);
            return ResponseEntity.ok(message) ;
        }
    }

    @PostMapping(value = "/login",produces = "application/json")
    @ResponseBody
    private ResponseEntity<Message> login(@RequestBody Map<String ,String> params) {
        Message message;
        try {
            User user=userService.userFindOne(params.get("username"),params.get("password"));
            if(user!=null) {
                logger.info("User found");
                message=new Message(HttpStatus.OK,Constants.LOGIN_SUCCEEDED,user);
                return ResponseEntity.ok(message);
            }
            else {
                logger.info("Bad credentials");
                message=new Message(HttpStatus.UNAUTHORIZED,Constants.LOGIN_FAILED);
                return ResponseEntity.ok(message);
            }
        } catch (Exception e) {
            message=new Message(HttpStatus.INTERNAL_SERVER_ERROR,Constants.LOGIN_FAILED);
            return ResponseEntity.ok(message);
        }

    }





    private Boolean isUserAlreadyDefined(String username)throws Exception
    {
            User user=userService.userFindByUsername(username);
            if (user!=null) {
                logger.info("Username already defined");
                return true;
            }
            else {
                logger.info("Safe username");
                return false;
            }
    }
}
