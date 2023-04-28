package ua.com.public_utilities.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ua.com.public_utilities.entity.Category;
import ua.com.public_utilities.entity.Rate;
import ua.com.public_utilities.repository.RateRepository;

import java.util.List;

@Service
public class RateService {
    private final RateRepository rateRepository;

    @Autowired
    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @Cacheable(cacheNames = "rates", key = "#category.getId()")
    public List<Rate> getRatesByCategory(Category category){
        return rateRepository.findAllByCategories(category);
    }
}
