package ac.ttcu.controller;

import ac.ttcu.common.Message;
import ac.ttcu.common.Utils;
import ac.ttcu.common.enumerations.Constants;
import ac.ttcu.model.entity.dto.PasswordDTO;
import ac.ttcu.model.entity.dto.PostDTO;
import ac.ttcu.model.entity.dto.UserDTO;
import ac.ttcu.model.entity.dto.UsernameDTO;
import ac.ttcu.model.service.PostService;
import ac.ttcu.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserUpdateResource {
    private Logger logger = LoggerFactory.getLogger(UserUpdateResource.class);
    private final UserService userService;
    private final PostService postService;

    public UserUpdateResource(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @PostMapping("/updateUsername")
    private ResponseEntity<Message> updateUsername(@Valid @RequestBody UsernameDTO userDTO, @RequestHeader HttpHeaders headers) {
        Message message;
        try {
            String username = Utils.fetchUsername(headers);
            if (userDTO.getOldUsername().equals(username)) {
                userService.updateUsername(userDTO);
                List<PostDTO> postDTOS = postService.findAllForUser(username);
                for (PostDTO p : postDTOS) {
                    postService.updatePostUsername(p, userDTO.getNewUsername());
                }
                message = new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name());
            } else {
                message = new Message(HttpStatus.FORBIDDEN, Constants.OPERATION_FAILED.name());
            }

        }catch (Exception e)
        {
            logger.error("Update user failed by error {}", e.getMessage());
            message = new Message(HttpStatus.INTERNAL_SERVER_ERROR, Constants.OPERATION_FAILED.name());
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
            logger.error("Update user failed by error {}", e.getMessage());
            message = new Message(HttpStatus.INTERNAL_SERVER_ERROR, Constants.OPERATION_FAILED.name());
        }
        return  ResponseEntity.status(message.getHttpStatus()).body(message);
    }

    @PostMapping("/updateUser")
    private ResponseEntity<Message> updateUser(@RequestBody UserDTO userDTO, @RequestHeader HttpHeaders headers)
    {
        Message message;
        try {
            userDTO.setUsername(Utils.fetchUsername(headers));
            userService.updateUser(userDTO);
            message = new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name());

        }catch (Exception e)
        {
            logger.error("Update user failed by error {}", e.getMessage());
            message = new Message(HttpStatus.INTERNAL_SERVER_ERROR, Constants.OPERATION_FAILED.name());
        }
        return  ResponseEntity.status(message.getHttpStatus()).body(message);
    }


}
