package com.shop.service;

import com.shop.dto.OrderDto;
import com.shop.dto.OrderResponse;
import com.shop.dto.ProductDto;
import com.shop.entity.Order;
import com.shop.entity.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    Long addOrder(OrderDto product);

    Order getOrderById(Long id);

    Order updateOrder(Order order);

    void deleteOrderById(Long id);

    List<Order> getAllOrders();

    List<Order> getOrdersByUsername(String username);

}
