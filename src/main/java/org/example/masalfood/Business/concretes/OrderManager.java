package org.example.masalfood.Business.concretes;

import org.example.masalfood.Business.Dto.Requests.RequestOrder;
import org.example.masalfood.Business.Dto.Responses.ResponseOrder;
import org.example.masalfood.Business.Dto.Responses.ResponseOrderItem;
import org.example.masalfood.Business.Dto.Responses.Result.*;
import org.example.masalfood.Business.abstracts.OrderService;
import org.example.masalfood.DataAccess.CustomerDao;
import org.example.masalfood.DataAccess.OrderDao;
import org.example.masalfood.DataAccess.OrderItemDao;
import org.example.masalfood.Entities.Customer;
import org.example.masalfood.Entities.Order;
import org.example.masalfood.Entities.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderManager implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private OrderItemDao orderItemDao;
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

    @Override
    public DataResult<List<ResponseOrder>> showAllOrders() {
        List<ResponseOrder> responseOrders = new ArrayList<>();
        List<Order> orders = orderDao.findAll();
        for(Order order : orders) {
            ResponseOrder responseOrder = new ResponseOrder();
            responseOrder.setOrder_id(order.getId());
            responseOrder.setCustomer(order.getCustomer());
            List<ResponseOrderItem> responseOrderItems = new ArrayList<>();
            assert order.getOrderItems() != null;
            for(OrderItem orderItem : order.getOrderItems()) {
                ResponseOrderItem responseOrderItem = new ResponseOrderItem();
                responseOrderItem.setProductName(orderItem.getProduct().getName());
                responseOrderItem.setQuantity(orderItem.getQuantity());
                responseOrderItems.add(responseOrderItem);
            }
            responseOrder.setOrder_items(responseOrderItems);
            responseOrders.add(responseOrder);
        }

        return new SuccessDataResult<>(responseOrders);
    }
}
