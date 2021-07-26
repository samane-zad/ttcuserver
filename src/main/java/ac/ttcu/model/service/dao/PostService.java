package ac.ttcu.model.service.dao;

import ac.ttcu.model.entity.dto.PostDTO;
import ac.ttcu.model.entity.dto.UniMajorDTO;
import ac.ttcu.model.entity.mapper.PostMapper;
import ac.ttcu.model.entity.mapper.UniMajorMapper;
import ac.ttcu.model.entity.table.Post;
import ac.ttcu.model.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.acl.NotOwnerException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostService {
    private final Logger logger = LoggerFactory.getLogger(PostService.class);
    private final PostRepository postRepository;
    private final UniMajorService uniMajorService;

    public PostService(PostRepository postRepository, UniMajorService uniMajorService) {
        this.postRepository = postRepository;
        this.uniMajorService = uniMajorService;
    }


    public void save(PostDTO postDTO) throws Exception {
        logger.info("Save Post from " + postDTO.getUsername() + "with Title " + postDTO.getTitle());
        Optional<UniMajorDTO> uniMajorDTO = uniMajorService.findUniMajor(postDTO.getUniMajor());
        Post post = PostMapper.INSTANCE.toEntity(postDTO);
        post.setUniMajor(UniMajorMapper.INSTANCE.toEntity(uniMajorDTO.get()));
        postRepository.save(post);
    }

    public List<PostDTO> findAll(PostDTO postDTO) throws Exception {
        logger.info("Find All Posts for {}", postDTO);
        List<Post> postList;
        List<PostDTO> postDTOList;
        if (Objects.nonNull(postDTO.getUniMajor())) {
            Optional<UniMajorDTO> uniMajorDTO = uniMajorService.findUniMajor(postDTO.getUniMajor());
            if (Objects.nonNull(postDTO.getPostType())) {
                postList = postRepository.findByTypeAndUniMajor(postDTO.getPostType(),
                        UniMajorMapper.INSTANCE.toEntity(uniMajorDTO.get()));
            } else {
                postList = postRepository.findByUniMajor(UniMajorMapper.INSTANCE.toEntity(uniMajorDTO.get()));
            }
        } else {
            if (Objects.nonNull(postDTO.getPostType())) {
                postList = postRepository.findByType(postDTO.getPostType());
            } else {
                postDTOList = null;
                return postDTOList;
            }
        }
        postDTOList = PostMapper.INSTANCE.toDTO(postList);
        return postDTOList;
    }


    public List<PostDTO> findAllForUser(String username) {
        logger.info("Find All Posts for {}", username);
        List<Post> postList = postRepository.findByUsername(username);
        List<PostDTO> postDTOList = PostMapper.INSTANCE.toDTO(postList);
        return postDTOList;
    }

    public void deletePost(PostDTO postDTO, String username) throws NotOwnerException {
        logger.info("Delete post with id {}", postDTO.getId());
        Optional<Post> post = postRepository.findById(postDTO.getId());
        if (post.get().getUsername().contentEquals(username))
            postRepository.delete(post.get());
        else throw new NotOwnerException();
    }

    public void updatePost(PostDTO postDTO, String username) throws NotOwnerException {
        logger.info("Update post with id {}", postDTO.getId());
        Optional<Post> post = postRepository.findById(postDTO.getId());
        if (post.get().getUsername().contentEquals(username))
            postRepository.save(post.get());
        else throw new NotOwnerException();
    }
}
