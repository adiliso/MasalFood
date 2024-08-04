package org.example.masalfood.Business.abstracts;

import org.example.masalfood.Business.Dto.Requests.RequestOrder;
import org.example.masalfood.Business.Dto.Responses.ResponseOrder;
import org.example.masalfood.Business.Dto.Responses.Result.DataResult;
import org.example.masalfood.Business.Dto.Responses.Result.Result;
import org.example.masalfood.Entities.OrderItem;

import java.util.List;
import java.util.Set;

public interface OrderService {
    Result create(RequestOrder requestOrder);
    DataResult<List<ResponseOrder>> showAllOrders();
}
