package ua.com.public_utilities.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.public_utilities.entity.Order;
import ua.com.public_utilities.repository.OrderRepository;

import java.util.List;

@Service
public class OrderManagerService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderManagerService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findListOrderByStatus(boolean status){
        return orderRepository.findByStatus(status);
    }

    public List<Order> findAllOrder(){
        return orderRepository.findAll();
    }


    public void updateOrderNewStatus(Order order){

        if(order.isStatus()){
            order.setStatus(false);
        } else {
            order.setStatus(true);
        }

        orderRepository.save(order);
    }


}