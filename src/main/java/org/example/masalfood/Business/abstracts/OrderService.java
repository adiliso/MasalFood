package org.example.masalfood.Business.abstracts;

import org.example.masalfood.Business.models.Requests.RequestCustomer;
import org.example.masalfood.Business.models.Responses.Result.Result;

public interface OrderService {
    Result addOrder(RequestCustomer requestCustomer, String productId, int quantity);
}
