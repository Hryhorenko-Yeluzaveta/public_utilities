package ua.com.public_utilities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.public_utilities.service.CategoryManagerService;

@Controller
public class HomeController {
    private  final CategoryManagerService categoryManagerService;

    @Autowired
    public HomeController(CategoryManagerService categoryManagerService) {
        this.categoryManagerService = categoryManagerService;
    }


    @GetMapping("/")
    public String getHome(){
        return "index";
    }

    @GetMapping("/rates")
    public String getRateAdmin(){
        return "rateAdminPage";
    }

    @GetMapping("/categories")
    public String getCategoryAdmin(){
        return "categoryAdminPage";
    }

    @GetMapping("/orders")
    public String getOrdersAdmin(){
        return "orders";
    }

    @GetMapping("/customers")
    public String getCustomersAdmin(){
        return "customers";
    }
}