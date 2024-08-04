package org.example.masalfood.Business.concretes;

import org.example.masalfood.Business.models.Requests.RequestOrder;
import org.example.masalfood.Business.models.Responses.ResponseOrder;
import org.example.masalfood.Business.models.Responses.ResponseOrderItem;
import org.example.masalfood.Business.models.Responses.Result.*;
import org.example.masalfood.Business.abstracts.OrderService;
import org.example.masalfood.DataAccess.CustomerDao;
import org.example.masalfood.DataAccess.OrderDao;
import org.example.masalfood.DataAccess.OrderItemDao;
import org.example.masalfood.Entities.Customer;
import org.example.masalfood.Entities.Order;
import org.example.masalfood.Entities.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        if(customer.isEmpty()) {
            return new ErrorResult("Customer not found");
        }
        order.setCustomer(customer.get());
        orderDao.save(order);
        return new SuccessResult("Order created");
    }

    @Override
    public DataResult<Set<ResponseOrder>> showAllOrders() {
        Set<ResponseOrder> responseOrders = new HashSet<>();
        List<Order> orders = orderDao.findAll();
        if(orders.isEmpty()) {
            return new ErrorDataResult<>("No orders found");
        }
        for(Order order : orders) {
            ResponseOrder responseOrder = new ResponseOrder();
            responseOrder.setOrder_id(order.getId());
            responseOrder.setCustomer(order.getCustomer());
            Set<ResponseOrderItem> responseOrderItems = new HashSet<>();
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
