package ua.com.public_utilities.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.public_utilities.entity.Order;
import ua.com.public_utilities.service.OrderManagerService;

@Controller
public class OrderManagerController {


    private final OrderManagerService orderManagerService;

    @Autowired
    public OrderManagerController(OrderManagerService orderManagerService) {
        this.orderManagerService = orderManagerService;
    }


    @GetMapping("/ordermanager")
    public String getAllOrderPage(Model model){
        model.addAttribute("order1", orderManagerService.findListOrderByStatus(false));
        model.addAttribute("order2", orderManagerService.findListOrderByStatus(true));
        return "orderAdmin";
    }

    @PostMapping("/updateOrder")
    public String updateOrder(@RequestParam(value = "id") Order order){
        orderManagerService.updateOrderNewStatus(order);

        return "redirect:/ordermanager";
    }
}