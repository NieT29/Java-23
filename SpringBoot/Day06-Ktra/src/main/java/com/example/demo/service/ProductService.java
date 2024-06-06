package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getBookById(int id);

    List<Product> searchProduct(String keyWord);
}
