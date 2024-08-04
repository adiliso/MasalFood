package org.example.masalfood.DataAccess;

import org.example.masalfood.Entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface OrderItemDao extends JpaRepository<OrderItem, Integer> {
    Set<OrderItem> findAllByOrderId(int orderId);
}
