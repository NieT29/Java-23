package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookService bookeService;

    // lấy danh sách tất cả book
    @GetMapping()
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED) //201
    public List<Book> getAllBooks() {
        return bookeService.getAllBooks();
    }

    @GetMapping("getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks1() {
        return new ResponseEntity<>(bookeService.getAllBooks(), HttpStatus.CREATED);
    }

    // lấy thông tin book theo id
    @GetMapping("/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable int id) {
        return bookeService.getBookById(id);
    }

    // sắp xếp theo năm
    @GetMapping("/sortByYear")
    @ResponseBody
    public List<Book> sortByYear() {return bookeService.sortBooksByYear();}

    // tìm theo keyword
    @GetMapping("/search/{keyword}")
    @ResponseBody
    public List<Book> searchBook(@PathVariable String keyword) {return bookeService.searchBook(keyword);}

    // tìm theo khoảng thời gian
    @GetMapping("/startYear/{startYear}/endYear/{endYear}")
    @ResponseBody
    public List<Book> searchBookByYear(@PathVariable int startYear, @PathVariable int endYear) {return bookeService.searchBookByYear(startYear, endYear);}
}
