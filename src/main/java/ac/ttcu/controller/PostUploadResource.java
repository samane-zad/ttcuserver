package ac.ttcu.controller;

import ac.ttcu.common.Message;
import ac.ttcu.common.enumerations.Constants;
import ac.ttcu.model.entity.dto.PostDTO;
import ac.ttcu.model.service.dao.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/teacher")
public class PostUploadResource {
    private static Logger logger = LoggerFactory.getLogger(PostUploadResource.class);
    private final PostService postService;

    public PostUploadResource(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/uploadPost", method = RequestMethod.POST)
    public ResponseEntity<Message> savePost(@RequestPart("image") MultipartFile image,
                                            @RequestPart("post") PostDTO postDTO) {
        Message message;
        try {
            logger.info("Saving post: {}", postDTO);
            postDTO.setImage(image);
            postService.save(postDTO);
            message = new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name(), postDTO);

        } catch (Exception e) {
            logger.error("Operation failed by error:{}", e.getMessage());
            message = new Message(HttpStatus.INTERNAL_SERVER_ERROR, Constants.OPERATION_FAILED.name());
        }
        return ResponseEntity.status(message.getHttpStatus()).body(message);
    }

}
