package ua.com.public_utilities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.public_utilities.entity.Category;
import ua.com.public_utilities.entity.Rate;
import ua.com.public_utilities.service.CategoryManagerService;
import ua.com.public_utilities.service.RateManagerService;

import java.math.BigDecimal;

@Controller
public class RateManagerController {

    private final RateManagerService rateManagerService;

    private final CategoryManagerService categoryManagerService;

    @Autowired
    public RateManagerController(RateManagerService rateManagerService, CategoryManagerService categoryManagerService) {
        this.rateManagerService = rateManagerService;
        this.categoryManagerService = categoryManagerService;
    }

    @GetMapping("/ratemanager")
    public String getAllRate(Model model) {
        model.addAttribute("allRate", rateManagerService.findAllRate());
        model.addAttribute("allCategory", categoryManagerService.getCategoryList());
        return "rateAdminPage";
    }


    @PostMapping("/saveNewRate")
    public String saveNewRateToDB(@RequestParam(value = "name") String name,
                                     @RequestParam(value = "images") String images,
                                     @RequestParam(value = "price") BigDecimal price,
                                     @RequestParam(value = "categoryId") Category category
    ) {

        rateManagerService.saveNewRateToDB(name, images, price, category);

        return "redirect:/ratemanager";
    }

    @PostMapping("/updateRate")
    public String updateRate(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "images") String images,
            @RequestParam(value = "price") String price1,
            @RequestParam(value = "categoryId") Category category
    ) {


        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(price1.replaceAll("[^0-9]", "")));
        rateManagerService.updateRate(id,name, images, price, category);

        return "redirect:/ratemanager";
    }


    @PostMapping("/deleteRate")
    public String deleteRate(@RequestParam(value = "id") Long id){
        try {
            rateManagerService.deleteRateById(id);
            return "redirect:/ratemanager";
        } catch (Exception e) {
            return "redirect:/ratemanager";
        }
    }


    @PostMapping("/deleteAllRate")
    public String deleteAllRate(){
        try {
            rateManagerService.deleteAllRate();
            return "redirect:/ratemanager";
        } catch (Exception e) {
            return "redirect:/ratemanager";
        }
    }

    @GetMapping("/ratemanager/{id}")
    public String getCategoryPageById(@PathVariable("id") Long id,
                                      Model model){

        Rate rate = rateManagerService.findRateById(id);
        model.addAttribute("rate", rate);

        return "rateDet";
    }


}