package com.project.shopapp.services;

import java.util.List;

import com.project.shopapp.dtos.OrderDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.models.Order;

public interface IOrderService {
    
    Order createOrder(OrderDTO orderDTO) throws DataNotFoundException;

    Order getOrder(Long id);

    Order updateOrder(Long id, OrderDTO orderDTO);

    void deleteOrder(Long id);

    List<Order> getAllOrders(Long userId);
}
