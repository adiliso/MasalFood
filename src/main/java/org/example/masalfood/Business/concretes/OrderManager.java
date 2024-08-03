package org.example.masalfood.Business.concretes;

import org.aspectj.weaver.ast.Or;
import org.example.masalfood.Business.Dto.Requests.RequestOrder;
import org.example.masalfood.Business.Dto.Responses.Result.ErrorResult;
import org.example.masalfood.Business.Dto.Responses.Result.Result;
import org.example.masalfood.Business.Dto.Responses.Result.SuccessDataResult;
import org.example.masalfood.Business.Dto.Responses.Result.SuccessResult;
import org.example.masalfood.Business.abstracts.OrderService;
import org.example.masalfood.DataAccess.CustomerDao;
import org.example.masalfood.DataAccess.OrderDao;
import org.example.masalfood.Entities.Customer;
import org.example.masalfood.Entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderManager implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CustomerDao customerDao;
    @Override
    public Result create(RequestOrder requestOrder) {
        Order order = new Order();
        Optional<Customer> customer = customerDao.findById(requestOrder.getCustomer_id());
        if(!customer.isPresent()) {
            return new ErrorResult("Customer not found");
        }
        order.setCustomer(customer.get());
        orderDao.save(order);
        return new SuccessResult("Order created");
    }
}
