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
        logger.info("Save Entity " + postDTO.getTitle() + " " + postDTO.getPostType());
        Optional<UniMajorDTO> uniMajorDTO = uniMajorService.findUniMajor(postDTO.getUniMajor());
        Post post = PostMapper.INSTANCE.toEntity(postDTO);
        post.setUniMajor(UniMajorMapper.INSTANCE.toEntity(uniMajorDTO.get()));
        postRepository.save(post);
    }
}
