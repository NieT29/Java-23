package com.example.demo.database;

import com.example.demo.model.Person;
import com.example.demo.utils.IFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDB implements CommandLineRunner {
    @Autowired
    private IFileReader iFileReader;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Khởi tạo dữ liệu");
        PersonDB.people = iFileReader.readFile("people.json");

        // In ra danh sách các sách
        for (Person person : PersonDB.people) {
            System.out.println(person);
        }

        System.out.println("Số lượng người: " + PersonDB.people.size());
    }
}
