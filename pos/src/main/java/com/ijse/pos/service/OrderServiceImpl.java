package com.ijse.pos.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pos.dto.OrderDto;
import com.ijse.pos.entity.Item;
import com.ijse.pos.entity.Order;
import com.ijse.pos.repository.ItemRepository;
import com.ijse.pos.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
    
    
 @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(OrderDto orderDto) {
          
        List<Long>productsIds=orderDto.getItems();

        Set<Item> items = new HashSet<>();
        
        Double total=0.0;
       
        for (Long productId : productsIds) {
            Item item=itemRepository.findById(productId).orElse(null);
           
                items.add(item);
               total=total+item.getPrice();
            
            
        }
       
        LocalDateTime dateTime = LocalDateTime.now();
        Order order=new Order();
        
        order.setTotal(total);
        
        order.setOrderTime(dateTime);
        order.setItems(items);
      
        
       
return orderRepository.save(order);   
       
      
        
       

    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
    
}
