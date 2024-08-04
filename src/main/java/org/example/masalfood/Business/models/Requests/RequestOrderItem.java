package org.example.masalfood.Business.models.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestOrderItem {
    private int orderId;
    private String productId;
    private int quantity;
}
