package org.example.masalfood.Business.Dto.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.masalfood.Entities.Customer;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOrder {
    private int order_id;
    private Customer customer;
    private List<ResponseOrderItem> order_items;
}
