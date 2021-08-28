package ac.ttcu.controller;

import ac.ttcu.common.Message;
import ac.ttcu.common.Utils;
import ac.ttcu.common.enumerations.Constants;
import ac.ttcu.model.entity.dto.UserDTO;
import ac.ttcu.model.entity.dto.UsernameDTO;
import ac.ttcu.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserUpdateResource {
    private Logger logger= LoggerFactory.getLogger(UserUpdateResource.class);
    private final UserService userService;

    public UserUpdateResource(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/updateUsername")
    private ResponseEntity<Message> updateUsername(@RequestBody UsernameDTO userDTO, @RequestHeader HttpHeaders headers)
    {
        Message message;
        try {
            if(userDTO.getOldUsername().equals(Utils.fetchUsername(headers)))
                 userService.delete(userDTO);
            message=new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name());

        }catch (Exception e)
        {
            logger.error("Delete user failed by error {}",e.getMessage());
            message=new Message(HttpStatus.INTERNAL_SERVER_ERROR,Constants.OPERATION_FAILED.name());
        }
        return  ResponseEntity.status(message.getHttpStatus()).body(message);
    }
}
