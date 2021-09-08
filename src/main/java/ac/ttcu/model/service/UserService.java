package ac.ttcu.model.service;

import ac.ttcu.common.enumerations.Constants;
import ac.ttcu.model.entity.dto.PasswordDTO;
import ac.ttcu.model.entity.dto.UniMajorDTO;
import ac.ttcu.model.entity.dto.UserDTO;
import ac.ttcu.model.entity.dto.UsernameDTO;
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

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements UserDetailsService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);


    @Autowired
    UserRepository userRepository;
    @Autowired
    UniMajorService uniMajorService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.userFindByUsername(s);
    }

    public List<UserDTO> findUsersOfUniMajor(UniMajorDTO uniMajorDTO) throws Exception {
        UniMajor uniMajor = UniMajorMapper.INSTANCE.toEntity(uniMajorService.findUniMajor(uniMajorDTO).get());
        List<User> users = userRepository.findByUniMajor(uniMajor);
        return UserMapper.INSTANCE.toDTO(users);
    }

    public void save(UserDTO userDTO) throws Exception {
        logger.info("Save Entity " + userDTO.getfName() + " " + userDTO.getlName());
        Optional<UniMajorDTO> uniMajorDTO = uniMajorService.findUniMajor(userDTO.getUniMajor());
        User user = UserMapper.INSTANCE.toEntity(userDTO);
        user.setUniMajor(UniMajorMapper.INSTANCE.toEntity(uniMajorDTO.get()));
        userRepository.save(user);
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

    @Transactional
    public void updateUsername(UsernameDTO usernameDTO) {
        logger.info("Update User '{}'", usernameDTO.getOldUsername());
        User user = userRepository.userFindByUsername(usernameDTO.getOldUsername());
        userRepository.updateUsername(usernameDTO.getNewUsername(), user.getId());
        userRepository.updateUserRoll(usernameDTO.getNewUsername(), usernameDTO.getOldUsername());
    }

    public void updatePassword(PasswordDTO passwordDTO) {
        logger.info("Update User '{}' Password", passwordDTO.getUsername());
        User user = userRepository.userFindByUsername(passwordDTO.getUsername());
        userRepository.updatePassword(passwordDTO.getNewPassword(), user.getId());
    }

    public void updateUser(UserDTO userDTO) {
        logger.info("Update User '{}' Info", userDTO.getUsername());
        User user = userRepository.userFindByUsername(userDTO.getUsername());
        userRepository.updateUser(userDTO.getfName(), userDTO.getlName(), user.getId());
    }
}
