package org.example.masalfood.Business.abstracts;

import org.example.masalfood.Business.Dto.Requests.RequestOrderItem;
import org.example.masalfood.Business.Dto.Responses.Result.Result;

public interface OrderItemService {
    Result add(RequestOrderItem requestOrderItem);
}
