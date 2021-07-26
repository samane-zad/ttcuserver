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

import java.security.acl.NotOwnerException;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class PostUpdateResource {
    private final PostService postService;
    Logger logger = LoggerFactory.getLogger(PostUpdateResource.class);

    public PostUpdateResource(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/postUpdate", method = RequestMethod.POST)
    public ResponseEntity<Message> fetchPosts(@RequestBody PostDTO postDTO,
                                              @RequestHeader HttpHeaders httpHeaders) {
        Message message;
        try {
            logger.info("Update post: {}", postDTO.getId());
            String username = Utils.fetchUsername(httpHeaders);
            postService.updatePost(postDTO, username);
            message = new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name());

        } catch (NoSuchElementException ne) {
            message = new Message(HttpStatus.NOT_FOUND, Constants.OPERATION_FAILED.name());
        } catch (NotOwnerException noe) {
            message = new Message(HttpStatus.FORBIDDEN, Constants.OPERATION_FAILED.name());
        } catch (Exception e) {
            logger.error("Operation failed by error:{}", e.getMessage());
            message = new Message(HttpStatus.INTERNAL_SERVER_ERROR, Constants.OPERATION_FAILED.name());
        }
        return ResponseEntity.status(message.getHttpStatus()).body(message);
    }

}
