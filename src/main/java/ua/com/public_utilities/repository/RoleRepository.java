package ua.com.public_utilities.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.public_utilities.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
