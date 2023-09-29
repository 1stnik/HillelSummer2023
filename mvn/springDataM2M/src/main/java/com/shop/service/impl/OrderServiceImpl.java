package com.shop.service.impl;

import com.shop.dto.OrderDto;
import com.shop.dto.OrderResponse;
import com.shop.entity.Order;
import com.shop.entity.Product;
import com.shop.exceptions.OrderNotFoundException;
import com.shop.exceptions.ProductNotFoundException;
import com.shop.repository.OrderRepository;
import com.shop.repository.ProductRepository;
import com.shop.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final ProductRepository productRepository;

    @Override
    public Long addOrder(OrderDto orderDto) {

        List<Product> products = checkProductAvailability(orderDto.getProducts());

        Order order = new Order()
                .setUserName(orderDto.getUserName())
                .setProducts(products);
        return repository.save(order).getId();
    }

    @Override
    public Order getOrderById(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("ORDER_NOT_FOUND"));

        order.setCost(calculateOrderCost(order.getProducts()));
        return repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("ORDER_NOT_FOUND"));

    }

    @Override
    public Order updateOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public void deleteOrderById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    @Override
    public List<Order> getOrdersByUsername(String username) {
        return repository.findAllByUserName(username);
    }

    private Double calculateOrderCost(List<Product> products) {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    private List<Product> checkProductAvailability(List<Long> customerProductsList){

        List<Product> products = productRepository.findAllById(customerProductsList);

        List<Long> availableProductList = products.stream().map(Product::getId).toList();

        customerProductsList.removeAll(availableProductList);

        if (!customerProductsList.isEmpty()){
            throw new ProductNotFoundException("Could not found products with id: " + customerProductsList);
        }

        return products;
    }
}
