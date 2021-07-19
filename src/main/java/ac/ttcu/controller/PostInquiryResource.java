package ac.ttcu.controller;

import ac.ttcu.common.Message;
import ac.ttcu.common.enumerations.Constants;
import ac.ttcu.model.entity.dto.PostDTO;
import ac.ttcu.model.service.dao.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostInquiryResource {
    private final PostService postService;
    Logger logger = LoggerFactory.getLogger(PostInquiryResource.class);

    public PostInquiryResource(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/postInquiry", method = RequestMethod.POST)
    public ResponseEntity<Message> fetchPosts(@RequestBody PostDTO postDTO) {
        Message message;
        try {
            logger.info("Fetch postList: {}", postDTO);

            List<PostDTO> postDTOList = postService.findAll(postDTO);
            message = new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name(), postDTOList);

        } catch (Exception e) {
            logger.error("Operation failed by error:{}", e.getMessage());
            message = new Message(HttpStatus.INTERNAL_SERVER_ERROR, Constants.OPERATION_FAILED.name());
        }
        return ResponseEntity.status(message.getHttpStatus()).body(message);
    }

    @RequestMapping(value = "/userPostInquiry", method = RequestMethod.POST)
    public ResponseEntity<Message> fetchUserPosts(@RequestBody PostDTO postDTO) {
        Message message;
        try {
            logger.info("Fetch postList: {}", postDTO);

            List<PostDTO> postDTOList = postService.findAllForUser(postDTO);
            message = new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name(), postDTOList);

        } catch (Exception e) {
            logger.error("Operation failed by error:{}", e.getMessage());
            message = new Message(HttpStatus.INTERNAL_SERVER_ERROR, Constants.OPERATION_FAILED.name());
        }
        return ResponseEntity.status(message.getHttpStatus()).body(message);
    }
}
