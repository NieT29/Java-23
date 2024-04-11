package com.example.demo.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private String id;
    private String name;
    private String description;
    private int price;
    private String brand;
}
