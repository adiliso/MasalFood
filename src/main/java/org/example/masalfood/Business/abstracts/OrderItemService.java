package org.example.masalfood.Business.abstracts;

import org.example.masalfood.Business.Dto.Responses.Result.Result;
import org.example.masalfood.Entities.OrderItem;

public interface OrderItemService {
    void add(OrderItem orderItem);
}
