package com.example.demo.dao.impl;

import com.example.demo.dao.ProductDAO;
import com.example.demo.database.ProductDB;
import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductDaoImpl implements ProductDAO {
    @Override
    public List<Product> getAll() {
        return ProductDB.products;
    }

    @Override
    public Product getProductById(int id) {
        return ProductDB.products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Product> searchProduct(String keyWord) {
        return ProductDB.products.stream()
                .filter(product -> product.getName().toLowerCase().contains(keyWord.toLowerCase()))
                .toList();
    }
}
