package ua.com.public_utilities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.public_utilities.entity.Client;
import ua.com.public_utilities.entity.Role;
import ua.com.public_utilities.entity.User;
import ua.com.public_utilities.repository.ClientRepository;
import ua.com.public_utilities.repository.RoleRepository;
import ua.com.public_utilities.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
public class UserManagerService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final RoleRepository roleRepository;
    @Autowired
    public UserManagerService(UserRepository userRepository, ClientRepository clientRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
        this.roleRepository = roleRepository;
    }


    public boolean getLogicByUser(String username) {

//        boolean logic = false;
//        if(!userRepository.findAllByUsername(username).isEmpty()) logic=true;
//        return logic;

        return (!userRepository.findAllByUsername(username).isEmpty()) ? true : false;
    }


    public User saveNewUserToDB(User user){

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_User")));
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));


//        Users user1 = userRepository.save(user);
//        return user1;

        return userRepository.save(user);
    }


    public List<Client> getClientList() {
        return clientRepository.findAll();
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {

        User user1 = userRepository.findByUsername(username);

        System.out.println(user1);

        if(user1==null){
            throw new UsernameNotFoundException("User not found!!!");
        }

        return user1;
    }
}
