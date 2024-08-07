package org.example.masalfood.Business.abstracts;

import org.example.masalfood.Business.models.Requests.RequestCustomer;
import org.example.masalfood.Business.models.Requests.RequestOrderItem;
import org.example.masalfood.Business.models.Responses.Result.DataResult;
import org.example.masalfood.Business.models.Responses.Result.ResponseOrder;
import org.example.masalfood.Business.models.Responses.Result.Result;
import org.example.masalfood.Entities.Customer;
import org.example.masalfood.Entities.Order;
import org.example.masalfood.Entities.OrderItem;

import java.util.List;
import java.util.Set;

public interface OrderService {
    Result addOrder(RequestCustomer customer, List<RequestOrderItem> orderItems);

    Result deleteOrder(int orderId);

    DataResult<List<ResponseOrder>> getAllOrders();
}