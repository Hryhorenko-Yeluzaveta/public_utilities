package ua.com.public_utilities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.public_utilities.entity.Client;
import ua.com.public_utilities.entity.User;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByUser (User user);
}
