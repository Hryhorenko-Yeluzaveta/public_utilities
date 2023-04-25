package ua.com.public_utilities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.public_utilities.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByUsernameAndPassword(String username, String password);

    User findByUsernameAndPassword(String username, String password);
}
