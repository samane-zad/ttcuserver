package ac.ttcu.model.service;

import ac.ttcu.TtcuApplication;
import ac.ttcu.model.entity.User;
import ac.ttcu.model.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);


    @Autowired
    UserRepository userRepository;


    public User userFindOne(User user) throws Exception {
        logger.info("FindOne Entity:User");
        return userRepository.userFindOne(user.getUsername(), user.getPassword());
    }

    public User userFindByUsername(String username)throws Exception
    {
        logger.info("FindOne Entity:User By Username: "+username);
        return userRepository.userFindByUsername(username);
    }

    public void save(User user) throws Exception {
        logger.info("Save Entity " + user.getfName() + " " + user.getlName());
        userRepository.save(user);
    }
}
