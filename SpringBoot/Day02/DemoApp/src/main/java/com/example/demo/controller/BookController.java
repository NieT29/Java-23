package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/*
* @Controller: Trả về template. Ngoài ra có thể trả về dữ liệu ở dạng JSON, XML
* @RestController: Trả về dữ liệu ở dạng JSON, XML,....
* @RestController = @Controller + @ResponseBody
* Class ResponseEntity<T>: Đại diện cho một HTTP Response, bao gồm status code, headers và body
 */
@Controller
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookeService bookeService;

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
