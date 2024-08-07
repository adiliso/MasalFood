package org.example.masalfood.Business.models.Requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.masalfood.Entities.Customer;
import org.example.masalfood.Entities.OrderItem;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Data
public class RequestOrder {
    @NotNull
    @Valid
    private List<RequestOrderItem> orderItems;
    @NotNull
    @Valid
    private RequestCustomer customer;
}
