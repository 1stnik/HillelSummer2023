package com.sparkjava;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import com.google.gson.Gson;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class OrderService {

    private static List<Order> orderList = new ArrayList<>();

    public static void main(String[] args) {

        //get all orders
        get("/order", (request, response) -> {
            response.type("application/json");
            return new Gson().toJsonTree(orderList);
        });

        // get order by id
        get("/order/:uuid", (request, response) -> {
            response.type("application/json");
            UUID uuid = UUID.fromString(request.params(":uuid"));

            return new Gson().toJsonTree(orderList.stream()
                    .filter(o -> o.getUuid().equals(uuid))
                    .findFirst().get());
        });

        // create order
        post("/order", (request, response)  -> {
            response.type("application/json");

            // receive product from UI
            Product product = new Gson().fromJson(request.body(), Product.class);
            product.setUUID(UUID.randomUUID());

            // we dont have order yet -> we create order and put product inside
            Order order = new Order();
            order.setUuid(UUID.randomUUID());
            order.setCreateAt(new Timestamp(System.currentTimeMillis()));
            order.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            // add product
            order.getProducts().add(product);
            // calculate total cost
            order.setCost(order.getProducts().stream().mapToDouble(Product::getCost).sum());

            orderList.add(order);
            return new Gson().toJsonTree(order);
        });


        // create order
        post("/orders", (request, response)  -> {
            response.type("application/json");

            // receive product from UI
            Product[] products = new Gson().fromJson(request.body(), Product[].class);

            for (Product product : products) {
                product.setUUID(UUID.randomUUID());
            }

            // we dont have order yet -> we create order and put product inside
            Order order = new Order();
            order.setUuid(UUID.randomUUID());
            order.setCreateAt(new Timestamp(System.currentTimeMillis()));
            order.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            // add product
            order.getProducts().addAll(Arrays.asList(products));
            // calculate total cost
            order.setCost(order.getProducts().stream().mapToDouble(Product::getCost).sum());

            orderList.add(order);
            return new Gson().toJsonTree(order);
        });

        // update order
        put("/order/:uuid", (request, response)  -> {
            response.type("application/json");

            UUID uuid = UUID.fromString(request.params(":uuid"));

            Order order = orderList.stream()
                    .filter(o -> o.getUuid().equals(uuid))
                    .findFirst().get();

            order.setUpdateAt(new Timestamp(System.currentTimeMillis()));


            Product product = new Gson().fromJson(request.body(), Product.class);
            product.setUUID(UUID.randomUUID());
            order.getProducts().add(product);
            order.setCost(order.getProducts().stream().mapToDouble(Product::getCost).sum());

            return new Gson().toJsonTree(order);
        });

        delete("/order/:uuidOrder/:uuidProduct", (request, response)  -> {
            response.type("application/json");

            UUID uuidOrder = UUID.fromString(request.params(":uuidOrder"));
            UUID uuidProduct = UUID.fromString(request.params(":uuidProduct"));

            // first search order
            // them search and delete product

            return null;
        });
    }
}
