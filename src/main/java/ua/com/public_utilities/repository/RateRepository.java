package ua.com.public_utilities.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.public_utilities.entity.Category;
import ua.com.public_utilities.entity.Rate;

import java.util.List;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
    List<Rate> findAllByCategories(Category category);

    Rate findByName(String name);
}
