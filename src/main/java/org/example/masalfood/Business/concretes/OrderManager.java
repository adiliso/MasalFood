package org.example.masalfood.Business.concretes;

import jakarta.transaction.Transactional;
import org.example.masalfood.Business.abstracts.OrderService;
import org.example.masalfood.Business.models.Requests.RequestCustomer;
import org.example.masalfood.Business.models.Requests.RequestOrder;
import org.example.masalfood.Business.models.Requests.RequestOrderItem;
import org.example.masalfood.Business.models.Responses.Result.*;
import org.example.masalfood.DataAccess.CustomerDao;
import org.example.masalfood.DataAccess.OrderDao;
import org.example.masalfood.DataAccess.OrderItemDao;
import org.example.masalfood.DataAccess.ProductDao;
import org.example.masalfood.Entities.Customer;
import org.example.masalfood.Entities.Order;
import org.example.masalfood.Entities.OrderItem;
import org.example.masalfood.Entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderManager implements OrderService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    OrderDao orderDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    OrderItemDao orderItemDao;

    @Transactional
    @Override
    public Result addOrder(RequestCustomer requestCustomer, List<RequestOrderItem> orderItems) {
        // Save customer if it does not exist
        List<OrderItem> items = new ArrayList<>();
        Customer customer = modelMapper.map(requestCustomer, Customer.class);
        customerDao.save(customer);
        Order order = new Order();
        order.setCustomer(customer);
        orderDao.save(order);

        for (RequestOrderItem item : orderItems) {
            OrderItem orderItem = new OrderItem();
            Product product = productDao.findById(item.getProductId()).get();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(item.getQuantity());
            items.add(orderItem);
        }
        order.setOrderItems(items);
        orderDao.save(order);
        return new SuccessResult("Order added successfully");
    }

    @Override
    public DataResult<List<ResponseOrder>> getAllOrders() {
        List<Order> orders = orderDao.findAll();
        List<ResponseOrder> responseOrders = new ArrayList<>();
        for (Order order : orders) {
            ResponseOrder responseOrder = new ResponseOrder();
            responseOrder.setCustomer(order.getCustomer());
            List<ResponseOrderItem> responseOrderItems = new ArrayList<>();
            for (OrderItem orderItem : order.getOrderItems()) {
                ResponseOrderItem responseOrderItem = new ResponseOrderItem();
                responseOrderItem.setProductName(orderItem.getProduct().getName());
                responseOrderItem.setQuantity(orderItem.getQuantity());
                responseOrderItems.add(responseOrderItem);
            }
            responseOrder.setOrderItems(responseOrderItems);
            responseOrders.add(responseOrder);
        }
        return new SuccessDataResult<>(responseOrders);
    }

    @Override
    public Result deleteOrder(int orderId) {
        Optional<Order> order = orderDao.findById(orderId);
        if (order.isEmpty()) {
            return new ErrorResult("Order not found");
        }
        orderDao.delete(order.get());
        return new SuccessResult("Order deleted");
    }
}
