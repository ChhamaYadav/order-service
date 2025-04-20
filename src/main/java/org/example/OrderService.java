package org.example;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final orderRepository orderrepository;

    public OrderService(orderRepository orderrepository) {
        this.orderrepository = orderrepository;
    }

    public Order placeOrder(Order order){
        order.setOrderDate(LocalDateTime.now());
        return orderrepository.save(order);
        }

    @Cacheable(value="orderCache")
    public List<Order> getAllOrders(){
        return orderrepository.findAll();
    }
}
