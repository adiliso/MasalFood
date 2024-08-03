package org.example.masalfood.DataAccess;

import org.example.masalfood.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, String> {
}
