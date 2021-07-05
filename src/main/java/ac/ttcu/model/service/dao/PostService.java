package ac.ttcu.model.service.dao;

import ac.ttcu.model.entity.dto.PostDTO;
import ac.ttcu.model.entity.dto.UniMajorDTO;
import ac.ttcu.model.entity.dto.UserDTO;
import ac.ttcu.model.entity.mapper.UniMajorMapper;
import ac.ttcu.model.entity.mapper.UserMapper;
import ac.ttcu.model.entity.table.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    private final Logger logger= LoggerFactory.getLogger(PostService.class);

    public void save(PostDTO postDTO) throws Exception {
        logger.info("Save Entity " + postDTO.getTitle() + " " + postDTO.getPostType());
        Optional<UniMajorDTO> uniMajorDTO=uniMajorService.findUniMajor(userDTO.getUniMajor());
        User user= UserMapper.INSTANCE.toEntity(userDTO);
        user.setUniMajor(UniMajorMapper.INSTANCE.toEntity(uniMajorDTO.get()));
        userRepository.save(user);
    }
}
