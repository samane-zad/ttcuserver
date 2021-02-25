package ac.ttcu.controller;

import ac.ttcu.common.Constants;
import ac.ttcu.common.Log4j;
import ac.ttcu.model.entity.User;
import ac.ttcu.model.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @PostMapping(value = "/signUp")
    @ResponseBody
    private String signUp(@RequestBody User user) {
        try {
            UserService.getUserService().save(user);
            return Constants.SIGN_UP_SUCCEEDED;
        } catch (Exception e) {
            Log4j.getLog().error("Error occur saving user info ");
            Log4j.getLog().trace(e.getMessage());
            return Constants.SIGN_UP_FAILED;
        }
    }

    @RequestMapping("/login")
    private ResponseEntity<User> login(@ModelAttribute User user) {
        try {
            UserService.getUserService().userfindOne(user);
        } catch (Exception e) {

        }
        return ResponseEntity.ok(user);
    }
}
