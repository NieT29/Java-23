package com.example.demo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    int id;
    String title;
    String author;
    int year;
}
