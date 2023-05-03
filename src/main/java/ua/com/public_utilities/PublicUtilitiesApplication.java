package ua.com.public_utilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.com.public_utilities.entity.Role;
import ua.com.public_utilities.repository.RoleRepository;

@SpringBootApplication
public class PublicUtilitiesApplication {

    private final RoleRepository roleRepository;

    public PublicUtilitiesApplication(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(PublicUtilitiesApplication.class, args);
    }


    @Bean
    public void saveRolesToDB() {

        if (roleRepository.findAll().isEmpty()) {
            roleRepository.save(new Role(1L, "ROLE_User"));
            roleRepository.save(new Role(2L, "ROLE_Manager"));
            roleRepository.save(new Role(3L, "ROLE_Admin"));
        }
    }

}
