package org.example.masalfood.Business.models.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.masalfood.Entities.Customer;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOrder {
    private int order_id;
    private Customer customer;
    private Set<ResponseOrderItem> order_items;
}
