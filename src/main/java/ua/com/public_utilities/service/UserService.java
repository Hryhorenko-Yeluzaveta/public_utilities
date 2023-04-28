package ua.com.public_utilities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.public_utilities.entity.User;
import ua.com.public_utilities.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean getLoginByUsernameAndPassword(String username, String pass) {
        boolean login = false;

        if(!userRepository.findAllByUsernameAndPassword(username, pass).isEmpty()) {
            login = true;
        }

        return login;
    }

    public User getUserByUsernameAndPassword (String username, String pass) {
        User user;
        user = (User) userRepository.findByUsernameAndPassword(username, pass);

        return user;
    }
}
