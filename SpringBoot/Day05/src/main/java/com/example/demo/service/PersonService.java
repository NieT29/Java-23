package com.example.demo.service;

import com.example.demo.database.PersonDB;
import com.example.demo.model.Person;
import com.example.demo.response.PageResponse;

import java.util.List;

public interface PersonService {
    List<Person> getAll();
    PageResponse<Person> getAll(int page, int pageSize);
}
