package com.example.demo.service.impl;

import com.example.demo.dao.BookDAO;
import com.example.demo.model.Book;
import com.example.demo.service.BookeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookeService {
    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookDAO.findById(id);
    }

    @Override
    public List<Book> sortBooksByYear() {
        return bookDAO.sortBookByYear();
    }

    @Override
    public List<Book> searchBook(String keyword) {
        return bookDAO.searchBook(keyword);
    }

    @Override
    public List<Book> searchBookByYear(int startYear, int endYear) {
        return bookDAO.searchBookByYear(startYear, endYear);
    }
}
