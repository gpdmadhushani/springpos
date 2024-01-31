package com.ijse.pos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pos.dto.OrderDto;
import com.ijse.pos.entity.Order;

@Service
public interface OrderService {
     List<Order> getAllOrders();
    Order createOrder(OrderDto orderDto);
    Order getOrderById(Long id);
}
