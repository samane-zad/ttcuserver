package ac.ttcu.controller;

import ac.ttcu.common.Message;
import ac.ttcu.common.Utils;
import ac.ttcu.common.enumerations.Constants;
import ac.ttcu.model.entity.dto.PasswordDTO;
import ac.ttcu.model.entity.dto.UserDTO;
import ac.ttcu.model.entity.dto.UsernameDTO;
import ac.ttcu.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserUpdateResource {
    private Logger logger= LoggerFactory.getLogger(UserUpdateResource.class);
    private final UserService userService;

    public UserUpdateResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/updateUsername")
    private ResponseEntity<Message> updateUsername(@RequestBody UsernameDTO userDTO, @RequestHeader HttpHeaders headers)
    {
        Message message;
        try {
            if(userDTO.getOldUsername().equals(Utils.fetchUsername(headers))) {
                userService.updateUsername(userDTO);
                message = new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name());
            }
            else
            {
                message=new Message(HttpStatus.FORBIDDEN, Constants.OPERATION_FAILED.name());
            }

        }catch (Exception e)
        {
            logger.error("Delete user failed by error {}",e.getMessage());
            message=new Message(HttpStatus.INTERNAL_SERVER_ERROR,Constants.OPERATION_FAILED.name());
        }
        return  ResponseEntity.status(message.getHttpStatus()).body(message);
    }


    @PostMapping("/updatePassword")
    private ResponseEntity<Message> updatePassword(@RequestBody PasswordDTO passwordDTO, @RequestHeader HttpHeaders headers)
    {
        Message message;
        try {
           passwordDTO.setUsername(Utils.fetchUsername(headers));
            if(passwordDTO.getOldPassword().equals(Utils.fetchPassword())) {
                userService.updatePassword(passwordDTO);
                message = new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name());
            }
            else
            {
                message=new Message(HttpStatus.FORBIDDEN, Constants.OPERATION_FAILED.name());
            }

        }catch (Exception e)
        {
            logger.error("Delete user failed by error {}",e.getMessage());
            message=new Message(HttpStatus.INTERNAL_SERVER_ERROR,Constants.OPERATION_FAILED.name());
        }
        return  ResponseEntity.status(message.getHttpStatus()).body(message);
    }

    @PostMapping("/updateUser")
    private ResponseEntity<Message> updateUser(@RequestBody UserDTO userDTO, @RequestHeader HttpHeaders headers)
    {
        Message message;
        try {
            userDTO.setUsername(Utils.fetchUsername(headers));

            userService.updatePassword(passwordDTO);
            message = new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name());


        }catch (Exception e)
        {
            logger.error("Delete user failed by error {}",e.getMessage());
            message=new Message(HttpStatus.INTERNAL_SERVER_ERROR,Constants.OPERATION_FAILED.name());
        }
        return  ResponseEntity.status(message.getHttpStatus()).body(message);
    }


}
