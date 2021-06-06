package ac.ttcu.model.service;

import ac.ttcu.model.entity.dto.UniMajorDTO;
import ac.ttcu.model.entity.dto.UserDTO;
import ac.ttcu.model.entity.mapper.UniMajorMapper;
import ac.ttcu.model.entity.mapper.UserMapper;
import ac.ttcu.model.entity.table.UniMajor;
import ac.ttcu.model.entity.table.User;
import ac.ttcu.model.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService implements UserDetailsService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);


    @Autowired
    UserRepository userRepository;
    @Autowired
    UniMajorService uniMajorService;




    public User userFindOne(String username,String password) throws Exception {
        logger.info("FindOne Entity:User");

        return userRepository.userFindOne(username,password);
    }


    public void save(UserDTO userDTO) throws Exception {
        logger.info("Save Entity " + userDTO.getfName() + " " + userDTO.getlName());
        Optional<UniMajorDTO> uniMajorDTO=uniMajorService.findUniMajor(userDTO.getUniMajor());
        User user=UserMapper.INSTANCE.toEntity(userDTO);
        user.setUniMajor(UniMajorMapper.INSTNCE.toEntity(uniMajorDTO.get()));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.userFindByUsername(s);
    }
}
