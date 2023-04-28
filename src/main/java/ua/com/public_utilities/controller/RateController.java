package ua.com.public_utilities.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.public_utilities.bl.Cart;
import ua.com.public_utilities.entity.Category;
import ua.com.public_utilities.entity.Rate;
import ua.com.public_utilities.service.RateService;

import java.util.List;

@Controller
public class RateController {
    private final RateService rateService;

    @Autowired
    public RateController(RateService rateService) {
        this.rateService = rateService;
    }
    @GetMapping("/category/{id}")
    public String getAllRatesByCategory(@PathVariable(name = "id") Category category,
                                         Model model){

        List<Rate> rate = rateService.getRatesByCategory(category);
        model.addAttribute("allRatesByCategory", rate);

        return "ratesByCategory";
    }



    @PostMapping("/cart")
    public String addNewItemToCart(@RequestParam(name = "id") Rate rate,
                                   @RequestParam(name = "index") double index,
                                   HttpServletRequest request) {


        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if(cart == null) {
            cart = new Cart();
        }

        cart.addNewItemToCart(rate, index);

        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String getPageCart(HttpServletRequest request,
                              Model model) {
        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        model.addAttribute("itemCart", cart.getCart());
        model.addAttribute("totelEl", cart.getTotalVal());


        return "cart";
    }

    @PostMapping("/deleteItem")
    public String deleteItemCart (@RequestParam(name="id") Rate rate,
                                  HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart==null) {
            cart = new Cart();
        }

        cart.deleteItem(rate);


        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

}
