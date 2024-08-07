package org.example.masalfood.Business.models.Responses.Result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOrderItem {
    private String productName;
    private int quantity;
}
