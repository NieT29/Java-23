package com.example.demo.utils;

import com.example.demo.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Component
public class JsonFileReader implements IFileReader {
    @Override
    public List<Product> readFile(String path) {
        System.out.println("Đọc file Json");
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new JavaTimeModule());
        try {
            return mapper.readValue(Paths.get(path).toFile(), new TypeReference<List<Product>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
