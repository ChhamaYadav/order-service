package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;


    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order placeOrder(@RequestBody Order order){
        return service.placeOrder(order);
    }

    @GetMapping
    public List<Order> getOrders(){
        return service.getAllOrders();
    }
}
