package com.example.demo.controller;

import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("getAll", productService.getAll());
        return "index";
    }

    @GetMapping("/product/{id}")
    public String getProductById(Model model, @PathVariable int id) {
        model.addAttribute("getProductById", productService.getBookById(id));
        return "productDetail";
    }

    @GetMapping("/search/{keyword}")
    public String searchProduct(@PathVariable String keyword, Model model) {
        model.addAttribute("getAll", productService.searchProduct(keyword));
        return "index";
    }
}
