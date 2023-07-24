package com.sparkjava;

import static spark.Spark.*;

public class HelloWorldService {
    public static void main(String[] args) {
        //http://localhost:4567/hello
        get("/hello", (req, res) -> "Hello, hillel user");

        //http://localhost:4567/hello/alex
        get("/hello/:name", (req, res) -> {
            return "Hello: " + req.params(":name");
        });
    }
}
