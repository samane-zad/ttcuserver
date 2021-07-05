package ac.ttcu.model.service.dao;

import ac.ttcu.model.entity.dto.ContentDTO;
import ac.ttcu.model.entity.dto.UniMajorDTO;
import ac.ttcu.model.entity.mapper.UniMajorMapper;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContentService {
    private static Logger logger = LoggerFactory.getLogger(ContentService.class);


    public void save(ContentDTO contentDTO) throws Exception {
        logger.info("Save Entity " + contentDTO.getfName() + " " + userDTO.getlName());
        Optional<UniMajorDTO> uniMajorDTO=uniMajorService.findUniMajor(userDTO.getUniMajor());
        User user= UserMapper.INSTANCE.toEntity(userDTO);
        user.setUniMajor(UniMajorMapper.INSTANCE.toEntity(uniMajorDTO.get()));
        userRepository.save(user);
    }
}
