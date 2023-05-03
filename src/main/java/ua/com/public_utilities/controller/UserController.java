package ua.com.public_utilities.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.public_utilities.bl.Cart;
import ua.com.public_utilities.bl.ItemCart;
import ua.com.public_utilities.entity.*;
import ua.com.public_utilities.repository.*;
import ua.com.public_utilities.service.ClientService;
import ua.com.public_utilities.service.CustomerManagerService;
import ua.com.public_utilities.service.UserManagerService;
import ua.com.public_utilities.service.UserService;

import java.util.Date;

@Controller
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final ClientService clientService;
    private final ClientRepository clientRepository;
    private final OrderRepository orderRepository;
    private final RateHasOrderRepository rateHasOrderRepository;
    private final UserManagerService userManagerService;


    private final CustomerManagerService customerManagerService;
    @Autowired
    public UserController(UserRepository userRepository, UserService userService, ClientService clientService, ClientRepository clientRepository, OrderRepository orderRepository, RateHasOrderRepository rateHasOrderRepository, UserManagerService userManagerService, CustomerManagerService customerManagerService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.clientService = clientService;
        this.clientRepository = clientRepository;
        this.orderRepository = orderRepository;
        this.rateHasOrderRepository = rateHasOrderRepository;
        this.userManagerService = userManagerService;
        this.customerManagerService = customerManagerService;
    }





    @GetMapping("/order")
    public String getPageOrder(HttpServletRequest request, Model model){


        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");

//        if(user == null) {
//            return "redirect:/";
//        }


        if (cart==null) return "redirect:/";

        model.addAttribute("itemCart", cart.getCart());
        model.addAttribute("totalValue", cart.getTotalVal());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User users = userManagerService.loadUserByUsername(authentication.getName());

        model.addAttribute("client", customerManagerService.getClientById(users.getId()));

        Client client = clientService.getClientByUser(users);

        model.addAttribute("client", client);

//        Client client = clientService.getClientByUser(user);
//
//        model.addAttribute("client", client);

        return "order";
    }

    @PostMapping("/order")
    public String saveOrderToDB(@RequestParam(name = "payment") String payment,
                                @RequestParam(name = "status") boolean status,
                                HttpServletRequest request ){

        HttpSession session = request.getSession();

        Cart cart  = (Cart) session.getAttribute("cart");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User users = userManagerService.loadUserByUsername(authentication.getName());

        Client client = clientService.getClientByUser(users);

        Order order = new Order();
        order.setDate(new Date());
        order.setPayment(payment);
        order.setClient(client);
        order.setStatus(status);

        Order order1 = orderRepository.save(order);

        // save
        // Order + Id
        // Cart -> List<ItemCart>
        // foreach

        for (ItemCart el : cart.getCart()) {
            rateHasOrderRepository.save(new RateHasOrder(el.getRate(), order1));
        }

        return "thank";
    }

    @GetMapping("/thank")
    public String getPageThank() {
        return "thank";
    }


}
