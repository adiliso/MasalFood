package org.example.masalfood.Business.Dto.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.masalfood.Entities.Order;
import org.example.masalfood.Entities.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestOrderItem {
    private int orderId;
    private String productId;
    private int quantity;
}
