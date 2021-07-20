package ac.ttcu.controller;

import ac.ttcu.common.Message;
import ac.ttcu.common.Utils;
import ac.ttcu.common.enumerations.Constants;
import ac.ttcu.model.entity.dto.PostDTO;
import ac.ttcu.model.service.dao.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class PostInquiryResource {
    private final PostService postService;
    Logger logger = LoggerFactory.getLogger(PostInquiryResource.class);

    public PostInquiryResource(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/postInquiry", method = RequestMethod.GET)
    public ResponseEntity<Message> fetchPosts(@RequestBody PostDTO postDTO) {
        Message message;
        try {
            logger.info("Fetch postList: {}", postDTO);

            List<PostDTO> postDTOList = postService.findAll(postDTO);
            message = new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name(), postDTOList);

        } catch (NoSuchElementException ne) {
            message = new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name(), "No Posts Found");
            return ResponseEntity.status(message.getHttpStatus()).body(message);
        } catch (Exception e) {
            logger.error("Operation failed by error:{}", e.getMessage());
            message = new Message(HttpStatus.INTERNAL_SERVER_ERROR, Constants.OPERATION_FAILED.name());
        }
        return ResponseEntity.status(message.getHttpStatus()).body(message);
    }

    @RequestMapping(value = "/userPostInquiry", method = RequestMethod.GET)
    public ResponseEntity<Message> fetchUserPosts(@RequestHeader HttpHeaders httpHeaders) {
        Message message;
        try {
            String username = Utils.fetchUsername(httpHeaders);
            logger.info("Fetch postList: {}", username);

            List<PostDTO> postDTOList = postService.findAllForUser(username);
            if (postDTOList == null) {
                message = new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name(), "No Posts Found");
                return ResponseEntity.status(message.getHttpStatus()).body(message);
            }
            message = new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name(), postDTOList);

        } catch (NoSuchElementException ne) {
            message = new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name(), "No Posts Found");
            return ResponseEntity.status(message.getHttpStatus()).body(message);
        } catch (Exception e) {
            logger.error("Operation failed by error:{}", e.getMessage());
            message = new Message(HttpStatus.INTERNAL_SERVER_ERROR, Constants.OPERATION_FAILED.name());
        }
        return ResponseEntity.status(message.getHttpStatus()).body(message);
    }
}
