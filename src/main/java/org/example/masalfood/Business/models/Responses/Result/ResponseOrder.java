package org.example.masalfood.Business.models.Responses.Result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.masalfood.Entities.Customer;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOrder {
    private int orderID;
    private Customer customer;
    private List<ResponseOrderItem> orderItems;
}
