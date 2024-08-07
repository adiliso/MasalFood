package org.example.masalfood.Business.models.Requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestOrderItem {
    @NotBlank(message = "Product is required.")
    private String productId;
    private int quantity;
}
