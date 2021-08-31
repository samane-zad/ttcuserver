package ac.ttcu.controller;

import ac.ttcu.common.Message;
import ac.ttcu.common.Utils;
import ac.ttcu.common.enumerations.Constants;
import ac.ttcu.model.entity.dto.UserDTO;
import ac.ttcu.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserDeleteResource {
    private Logger logger= LoggerFactory.getLogger(UserDeleteResource.class);
    private final UserService userService;

    public UserDeleteResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/deleteUser")
    private ResponseEntity<Message> deleteUser( @RequestHeader HttpHeaders headers)
    {
        Message message;
       try {
           UserDTO userDTO=new UserDTO();
           userDTO.setUsername(Utils.fetchUsername(headers));
           userService.delete(userDTO);
           message=new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name());

       }catch (Exception e)
       {
           logger.error("Delete user failed by error {}",e.getMessage());
           if(e.getMessage().equals(Constants.UNMANAGEABLE_USER.name()))
               message=new Message(HttpStatus.FORBIDDEN,e.getMessage());
           else
               message=new Message(HttpStatus.INTERNAL_SERVER_ERROR,Constants.OPERATION_FAILED.name());
       }
       return  ResponseEntity.status(message.getHttpStatus()).body(message);
    }

    @PostMapping("/admin/deleteUser")
    private ResponseEntity<Message> deleteUserByAdmin(@RequestBody UserDTO userDTO, @RequestHeader HttpHeaders headers)
    {
        Message message;
        try {
            userService.delete(userDTO,Utils.fetchUsername(headers));
            message=new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name());

        }catch (Exception e)
        {
            logger.error("Delete user failed by error {}",e.getMessage());
            message=new Message(HttpStatus.INTERNAL_SERVER_ERROR,Constants.OPERATION_FAILED.name());
        }
        return  ResponseEntity.status(message.getHttpStatus()).body(message);
    }


}
