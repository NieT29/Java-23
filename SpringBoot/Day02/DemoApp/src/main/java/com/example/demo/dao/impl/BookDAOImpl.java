package com.example.demo.dao.impl;

import com.example.demo.dao.BookDAO;
import com.example.demo.databsae.BookDB;
import com.example.demo.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {


    @Override
    public List<Book> findAll() {
        return BookDB.books;
    }

    @Override
    public Book findById(int id) {
        for (Book book : BookDB.books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> sortBookByYear() {
        BookDB.books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getYear()-o2.getYear();
            }
        });
        return BookDB.books;
    }

    @Override
    public List<Book> searchBook(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : BookDB.books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public List<Book> searchBookByYear(int startYear, int endYear) {
        List<Book> result = new ArrayList<>();
        for (Book book : BookDB.books) {
            if (book.getYear() >= startYear && book.getYear() <= endYear) {
                result.add(book);
            }
        }
        return result;
    }
}
