package ua.com.public_utilities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.public_utilities.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
