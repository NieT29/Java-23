package com.example.demo.service.impl;

import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;
    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    public Product getBookById(int id) {
        return productDAO.getProductById(id);
    }

    @Override
    public List<Product> searchProduct(String keyWord) {
        return productDAO.searchProduct(keyWord);
    }
}
