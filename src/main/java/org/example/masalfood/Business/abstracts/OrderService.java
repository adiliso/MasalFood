package org.example.masalfood.Business.abstracts;

import org.example.masalfood.Business.Dto.Requests.RequestOrder;
import org.example.masalfood.Business.Dto.Responses.Result.Result;
import org.example.masalfood.Entities.Order;

public interface OrderService {
    Result create(RequestOrder requestOrder);
}
