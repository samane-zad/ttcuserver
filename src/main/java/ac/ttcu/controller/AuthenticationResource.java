package ac.ttcu.controller;

import ac.ttcu.common.Message;
import ac.ttcu.common.Utils;
import ac.ttcu.common.enumerations.Constants;
import ac.ttcu.model.entity.dto.UserDTO;
import ac.ttcu.model.service.dao.UniMajorService;
import ac.ttcu.model.service.dao.UserService;
import ac.ttcu.security.JWTAuth;
import ac.ttcu.security.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthenticationResource {
    private static Logger logger = LoggerFactory.getLogger(AuthenticationResource.class);

    @Autowired
    private Utils utils;
    @Autowired
    private  JWTUtils jwtUtils;
    @Autowired
    private  AuthenticationManager manager;
    @Autowired
    private UserService userService;
    @Autowired
    private UniMajorService uniMajorService;



    @PostMapping(value = "/signUp")
    @ResponseBody
    private ResponseEntity<Message> signUp(@RequestBody UserDTO user) {
        Message message;
        try {
            logger.info("Request to save user ");

            userService.save(user);
            message = new Message(HttpStatus.OK, Constants.SIGN_UP_SUCCEEDED.name(), user);

        } catch (Exception e) {
            logger.error("Error while saving user info with cause:{} ", e.getMessage());
            logger.error(e.getMessage());
            message = new Message(HttpStatus.INTERNAL_SERVER_ERROR, Constants.SIGN_UP_FAILED.name());
        }
        return ResponseEntity.status(message.getHttpStatus()).body(message);
    }

    @PostMapping(value = "/login", produces = "application/json")
    @ResponseBody
    private ResponseEntity<Message> login(@RequestBody JWTAuth jwtAuth, HttpServletResponse response) {
        Message message;
        try {
            manager.authenticate(new UsernamePasswordAuthenticationToken(jwtAuth.getUsername(), jwtAuth.getPassword()));
            logger.info("Successfully authenticated {}", jwtAuth.getUsername());
            response.addHeader("Authorization", jwtUtils.generateToken(jwtAuth.getUsername()));
            message = new Message(HttpStatus.OK, Constants.LOGIN_SUCCEEDED.name());

        } catch (BadCredentialsException be) {
            logger.info("Bad credentials");
            message = new Message(HttpStatus.UNAUTHORIZED, Constants.LOGIN_FAILED.name());
        }
        return ResponseEntity.status(message.getHttpStatus()).body(message);

    }


}
