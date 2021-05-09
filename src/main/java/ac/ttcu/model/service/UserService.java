package ac.ttcu.model.service;

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

@Service
@Transactional
public class UserService implements UserDetailsService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);


    @Autowired
    UserRepository userRepository;


    public User userFindOne(String username,String password) throws Exception {
        logger.info("FindOne Entity:User");
        return userRepository.userFindOne(username,password);
    }


    public void save(User user) throws Exception {
        logger.info("Save Entity " + user.getfName() + " " + user.getlName());
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.userFindByUsername(s);
    }
}
