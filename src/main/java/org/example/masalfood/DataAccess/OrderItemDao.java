package org.example.masalfood.DataAccess;

import org.example.masalfood.Entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemDao extends JpaRepository<OrderItem, Integer> {
}
