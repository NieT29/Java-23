package com.example.demo.utils;

import com.example.demo.model.Book;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVFileReader implements IFileReader{

    @Override
    public List<Book> readFile(String path) {
        System.out.println("Đọc file CSV");
        List<Book> books = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] line;
            // Đọc từng dòng trong file CSV
            while ((line = reader.readNext()) != null) {
                // Xây dựng đối tượng Book từ dòng hiện tại
                Book book = new Book();
                book.setId(Integer.parseInt(line[0]));
                book.setTitle(line[1]);
                book.setAuthor(line[2]);
                book.setYear(Integer.parseInt(line[3]));

                // Thêm sách vào danh sách
                books.add(book);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }

        return books;
    }
}
