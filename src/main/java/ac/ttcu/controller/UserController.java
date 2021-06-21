package ac.ttcu.controller;

import ac.ttcu.common.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    public void getUserInfo()
    {
        System.out.println("Hello");
    }

}
