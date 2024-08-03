package org.example.masalfood.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Products")
public class Product {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;
    @Column(name = "category")
    private String category;
    @Column(name = "rating")
    private int rating;
    @Column(name = "is_featured")
    private boolean isFeatured;
}
