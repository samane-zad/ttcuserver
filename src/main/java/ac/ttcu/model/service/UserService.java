package ac.ttcu.model.service;

import ac.ttcu.common.enumerations.Constants;
import ac.ttcu.model.entity.dto.PasswordDTO;
import ac.ttcu.model.entity.dto.UniMajorDTO;
import ac.ttcu.model.entity.dto.UserDTO;
import ac.ttcu.model.entity.dto.UsernameDTO;
import ac.ttcu.model.entity.mapper.UniMajorMapper;
import ac.ttcu.model.entity.mapper.UserMapper;
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
import org.springframework.web.client.HttpClientErrorException;

import java.security.acl.NotOwnerException;
import java.util.Optional;

@Service
@Transactional
public class UserService implements UserDetailsService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);


    @Autowired
    UserRepository userRepository;
    @Autowired
    UniMajorService uniMajorService;




    public void save(UserDTO userDTO) throws Exception {
        logger.info("Save Entity " + userDTO.getfName() + " " + userDTO.getlName());
        Optional<UniMajorDTO> uniMajorDTO=uniMajorService.findUniMajor(userDTO.getUniMajor());
        User user=UserMapper.INSTANCE.toEntity(userDTO);
        user.setUniMajor(UniMajorMapper.INSTANCE.toEntity(uniMajorDTO.get()));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.userFindByUsername(s);
    }

    public void delete(UserDTO userDTO)
    {
        logger.info("Delete User '{}'" , userDTO.getUsername());
        User user=userRepository.userFindByUsername(userDTO.getUsername());
        userRepository.delete(user);
    }
    public void delete(UserDTO userDTO,String adminUsername) throws Exception {
        logger.info("Delete User '{}'" , userDTO.getUsername());
        User admin=userRepository.userFindByUsername(adminUsername);
        User user=userRepository.userFindByUsername(userDTO.getUsername());
        if(admin.getUniMajor().equals(user.getUniMajor()))
             userRepository.delete(user);
        else throw new Exception(Constants.UNMANAGEABLE_USER.name());
    }

    public void updateUsername(UsernameDTO usernameDTO)
    {
        logger.info("Update User '{}'" , usernameDTO.getOldUsername());
        User user=userRepository.userFindByUsername(usernameDTO.getOldUsername());
        userRepository.updateUsername(usernameDTO.getNewUsername(),user.getId());
    }
    public void updatePassword(PasswordDTO passwordDTO)
    {
        logger.info("Update User '{}' password" , passwordDTO.getUsername());
        User user=userRepository.userFindByUsername(passwordDTO.getUsername());
        userRepository.updatePassword(passwordDTO.getNewPassword(),user.getId());
    }
}
