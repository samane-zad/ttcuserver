package ac.ttcu.model.service.dao;

import ac.ttcu.model.entity.dto.PostDTO;
import ac.ttcu.model.entity.mapper.PostMapper;
import ac.ttcu.model.entity.table.Post;
import ac.ttcu.model.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final Logger logger = LoggerFactory.getLogger(PostService.class);
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public void save(PostDTO postDTO) throws Exception {
        logger.info("Save Entity " + postDTO.getTitle() + " " + postDTO.getPostType());
        Post post = PostMapper.INSTANCE.toEntity(postDTO);
        postRepository.save(post);
    }
}
