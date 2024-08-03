package org.example.masalfood.DataAccess;

import org.example.masalfood.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer> {
}
