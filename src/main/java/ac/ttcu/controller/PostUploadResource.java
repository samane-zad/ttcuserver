package ac.ttcu.controller;

import ac.ttcu.common.Message;
import ac.ttcu.model.entity.dto.PostDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/teacher")
public class PostUploadResource {
    private static Logger logger = LoggerFactory.getLogger(PostUploadResource.class);

    @RequestMapping(value = "/uploadPost", method = RequestMethod.POST)
    public ResponseEntity<Message> sendPost(@RequestBody PostDTO postDTO, @RequestHeader HttpHeaders httpHeaders) {
        Message message;

//        message = new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name(), userDTO);
        return ResponseEntity.status(message.getHttpStatus()).body(message);
    }
}
