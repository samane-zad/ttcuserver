package ac.ttcu.controller;

import ac.ttcu.common.Message;
import ac.ttcu.common.Utils;
import ac.ttcu.common.enumerations.Constants;
import ac.ttcu.model.entity.dto.UserDTO;
import ac.ttcu.model.entity.mapper.UserMapper;
import ac.ttcu.model.entity.table.User;
import ac.ttcu.model.service.dao.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api")
public class UserInfoInquiryResource {
    private static Logger logger = LoggerFactory.getLogger(UserInfoInquiryResource.class);
    final UserService userService;

    public UserInfoInquiryResource(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public ResponseEntity<Message> getUserInfo(@RequestHeader HttpHeaders httpHeaders) {
        Message message;
        try {
            String username = Utils.fetchUsername(httpHeaders);
            logger.info("Fetching user info for user: {}", username);

            User user = (User) userService.loadUserByUsername(username);
            UserDTO userDTO = UserMapper.INSTANCE.toDTO(user);
            userDTO.setPassword(null);
            message = new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name(), userDTO);
        } catch (Exception e) {
            logger.error("Operation failed by error:{}", e.getMessage());
            message = new Message(HttpStatus.INTERNAL_SERVER_ERROR, Constants.OPERATION_FAILED.name());
        }
        return ResponseEntity.status(message.getHttpStatus()).body(message);

    }

}
