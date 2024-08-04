package org.example.masalfood.Business.abstracts;

import org.example.masalfood.Business.models.Requests.RequestOrder;
import org.example.masalfood.Business.models.Responses.ResponseOrder;
import org.example.masalfood.Business.models.Responses.Result.DataResult;
import org.example.masalfood.Business.models.Responses.Result.Result;

import java.util.List;
import java.util.Set;

public interface OrderService {
    Result create(RequestOrder requestOrder);
    DataResult<Set<ResponseOrder>> showAllOrders();
}
