package ac.ttcu.controller;

import ac.ttcu.common.Message;
import ac.ttcu.common.enumerations.Constants;
import ac.ttcu.model.entity.dto.UniMajorDTO;
import ac.ttcu.model.entity.dto.UserDTO;
import ac.ttcu.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersInquiryResource {
    private final UserService userService;
    private Logger logger = LoggerFactory.getLogger(UsersInquiryResource.class);


    public UsersInquiryResource(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/findUsers")
    private ResponseEntity<Message> findUsers(@RequestBody UniMajorDTO uniMajorDTO, @RequestHeader HttpHeaders headers) {
        Message message;
        try {
            List<UserDTO> userDTOS = userService.findUsersOfUniMajor(uniMajorDTO);
            if (!userDTOS.isEmpty())
                message = new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name(), userDTOS);
            else message = new Message(HttpStatus.NOT_FOUND, Constants.NO_USERS_FOUND.name());


        } catch (Exception e) {
            logger.error("Finding user failed by error {}", e.getMessage());
            message = new Message(HttpStatus.INTERNAL_SERVER_ERROR, Constants.OPERATION_FAILED.name());
        }
        return ResponseEntity.status(message.getHttpStatus()).body(message);
    }
}
