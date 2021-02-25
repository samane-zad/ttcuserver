package ac.ttcu.model.service;

import ac.ttcu.common.Log4j;
import ac.ttcu.model.entity.User;
import ac.ttcu.model.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static UserService userService;
    UserRepository userRepository;

    public static UserService getUserService() {
        return userService;
    }


    public User userfindOne(User user) throws Exception {
        Log4j.getLog().info("FindOne Entity:User");
        return userRepository.userfindOne(user.getUsername(), user.getPassword());
    }

    public void save(User user) throws Exception {
        Log4j.getLog().info("Save Entity " + user.getfName() + " " + user.getlName());
        userRepository.save(user);
    }
}
