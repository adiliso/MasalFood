package org.example.masalfood.Business.abstracts;

import org.example.masalfood.Business.models.Requests.RequestOrderItem;
import org.example.masalfood.Business.models.Responses.Result.Result;

public interface OrderItemService {
    Result add(RequestOrderItem requestOrderItem);
}
