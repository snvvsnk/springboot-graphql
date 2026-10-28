package org.example.graphqldemo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private Integer stock;
    private Float price;
    private String category;

    public Product(String name, String category,  Float price, Integer stock) {
        this.name = name;

        this.stock = stock;
        this.price = price;
        this.category = category;
    }
}
