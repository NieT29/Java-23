package com.example.demo.dao;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAll();
    Product getProductById(int id);
    List<Product> searchProduct(String keyWord);
}
