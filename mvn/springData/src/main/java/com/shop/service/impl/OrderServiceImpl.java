package com.shop.service.impl;

import com.shop.dto.OrderDto;
import com.shop.dto.OrderResponse;
import com.shop.dto.ProductDto;
import com.shop.entity.Order;
import com.shop.entity.Product;
import com.shop.exceptions.OrderNotFoundException;
import com.shop.repository.OrderRepository;
import com.shop.repository.ProductRepository;
import com.shop.service.OrderService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final ProductRepository productRepository;

    @Override
    public Long addOrder(OrderDto orderDto) {
        String products = orderDto.getProducts().stream().map(String::valueOf).collect(Collectors.joining(","));
        Order order = new Order()
                .setUserName(orderDto.getUserName())
                .setProducts(products);

        return repository.save(order).getId();
    }

    @Override
    public OrderResponse getOrderById(Long id) {

        Order order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException("ORDER_NOT_FOUND"));
        
        OrderResponse orderDto = new OrderResponse();
        orderDto.setName(order.getUserName());

        List<Long> list = Arrays.stream(order.getProducts().split(",")).map(Long::valueOf).toList();

        List<Product> products = productRepository
                .findAllById(list);

        List<ProductDto> productDto = products.stream().map(prod ->
                ProductDto.builder().name(prod.getName()).price(prod.getPrice()).build()).toList();
        orderDto.setProducts(productDto);
        double sum = products.stream().mapToDouble(Product::getPrice).sum();
        orderDto.setSumm(sum);


        return orderDto;
    }
}
