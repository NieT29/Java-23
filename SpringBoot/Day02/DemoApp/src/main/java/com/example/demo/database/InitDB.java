package com.example.demo.database;

import com.example.demo.model.Book;
import com.example.demo.utils.IFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDB implements CommandLineRunner {
    @Qualifier("jsonFileReader")
    @Autowired
    private IFileReader fileReader;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Khởi tạo dữ liệu");
        BookDB.books = fileReader.readFile("books.json");

        // In ra danh sách các sách
        for (Book book : BookDB.books) {
            System.out.println(book);
        }

        System.out.println("Số lượng sách: " + BookDB.books.size());
    }
}
