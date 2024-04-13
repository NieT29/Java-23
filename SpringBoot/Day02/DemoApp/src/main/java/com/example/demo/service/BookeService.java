package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;

public interface BookeService {
    List<Book> getAllBooks();

    Book getBookById(int id);

    List<Book> sortBooksByYear();

    List<Book> searchBook(String keyword);

    List<Book> searchBookByYear(int startYear, int endYear);
}
