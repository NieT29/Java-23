package com.example.demo.controller;

import com.example.demo.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("products")
@RestController
public class ProductController {
    private List<Product> products;

    public ProductController() {
        products = new ArrayList<>();
        products.add(new Product("1", "Iphone 11", "Mobile", 500, "Apple"));
        products.add(new Product("2", "Iphone 12", "Mobile", 600, "Apple"));
        products.add(new Product("3", "Iphone 13", "Mobile", 700, "Apple"));
        products.add(new Product("4", "Samsung S23", "Mobile", 800, "Samsung"));
        products.add(new Product("5", "Iphone S24", "Mobile", 850, "Samsung"));
    }

    @GetMapping
    public List<Product> getProducts() {
        return products;
    }
}
