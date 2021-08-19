package ac.ttcu.controller;

import ac.ttcu.common.Message;
import ac.ttcu.common.Utils;
import ac.ttcu.common.enumerations.Constants;
import ac.ttcu.common.enumerations.PostTypes;
import ac.ttcu.common.enumerations.UserType;
import ac.ttcu.model.entity.dto.PostDTO;
import ac.ttcu.model.service.dao.PostService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/api")
public class PostUploadResource {
    private static Logger logger = LoggerFactory.getLogger(PostUploadResource.class);
    private final PostService postService;
    private final List<PostTypes> validPosts = new ArrayList<>();


    public PostUploadResource(PostService postService) {
        this.postService = postService;
        validPosts.add(PostTypes.ENTRANCE_EXAM_GUIDANCE);
        validPosts.add(PostTypes.MASTERS_NOTES);
        validPosts.add(PostTypes.STUDENT_SERVICES);
    }


    @RequestMapping(value = "/uploadPost", method = RequestMethod.POST)
    public ResponseEntity<Message> saveStudentPost(@Nullable @RequestPart("image") MultipartFile image,
                                                   @RequestBody PostDTO postDTO,
                                                   @RequestHeader HttpHeaders httpHeaders) {
        Message message;
        try {
            logger.info("Saving post: {}", postDTO);
            postDTO.setUserType(UserType.valueOf(Utils.fetchUserType()));
            if (postDTO.getUserType().equals(UserType.STUDENT) && !validPosts.contains(postDTO.getPostType())) {
                logger.info("Student invalid postType caught!");
                message = new Message(HttpStatus.FORBIDDEN, Constants.OPERATION_FAILED.name());
                return ResponseEntity.status(message.getHttpStatus()).body(message);
            }
            if (Objects.nonNull(image))
                postDTO.setImage(image);
            postDTO.setUsername(Utils.fetchUsername(httpHeaders));
            postService.save(postDTO);
            message = new Message(HttpStatus.OK, Constants.OPERATION_DONE_SUCCESSFULLY.name(), postDTO);

        } catch (NotFoundException nf) {
            message = new Message(HttpStatus.NOT_FOUND, Constants.NO_UNIMAJOR_FOUND.name());
        } catch (Exception e) {
            logger.error("Operation failed by error:{}", e.getMessage());
            if (e instanceof NotFoundException)
                message = new Message(HttpStatus.NOT_FOUND, e.getMessage());
            else
                message = new Message(HttpStatus.INTERNAL_SERVER_ERROR, Constants.OPERATION_FAILED.name());
        }
        return ResponseEntity.status(message.getHttpStatus()).body(message);
    }

}
