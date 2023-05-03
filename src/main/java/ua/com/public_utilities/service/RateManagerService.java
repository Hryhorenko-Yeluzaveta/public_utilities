package ua.com.public_utilities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.public_utilities.entity.Category;
import ua.com.public_utilities.entity.Rate;
import ua.com.public_utilities.repository.RateRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RateManagerService {

    private final RateRepository rateRepository;

    @Autowired
    public RateManagerService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public void saveNewRateToDB(String name, String image, BigDecimal price, Category category){

        Rate rate = new Rate();
        rate.setName(name);
        rate.setImages(image);
        rate.setPrice(price);
        rate.setCategories(category);

        rateRepository.save(rate);
    }

    public void updateRate(Long id, String name, String image, BigDecimal price, Category category){
        Rate rate = new Rate();
        rate.setId(id);
        rate.setName(name);
        rate.setImages(image);
        rate.setPrice(price);
        rate.setCategories(category);

        rateRepository.save(rate);
    }


    public void deleteRateById(Long id){
        rateRepository.deleteById(id);
    }

    public void deleteAllRate(){
        rateRepository.deleteAll();
    }

    public List<Rate> findAllRate(){
        return rateRepository.findAll();
    }

    public Rate findRateById(Long id){
        return rateRepository.findById(id).get();
    }

    public Rate findRateByName(String name){
        return rateRepository.findByName(name);
    }

    public boolean sizeRateByCategory(Category category){
        List<Rate> rates  = rateRepository.findAllByCategories(category);
        if(rates.size()>0){
            return true;
        } else {
            return false;
        }
    }
}