package org.example.masalfood.Business.concretes;

import jakarta.transaction.Transactional;
import org.example.masalfood.Business.abstracts.OrderService;
import org.example.masalfood.Business.models.Requests.RequestCustomer;
import org.example.masalfood.Business.models.Requests.RequestOrderItem;
import org.example.masalfood.Business.models.Responses.Result.*;
import org.example.masalfood.DataAccess.CustomerDao;
import org.example.masalfood.DataAccess.OrderDao;
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

    @Transactional
    @Override
    public Result addOrder(RequestCustomer requestCustomer, List<RequestOrderItem> requestOrderItems) {
        Optional<Customer> user = customerDao.findByEmail(requestCustomer.getEmail());
        Customer customer;
        if (user.isPresent()) {
            customer = user.get();
        } else {
            customer = modelMapper.map(requestCustomer, Customer.class);
            customerDao.save(customer);
        }
        Order order = new Order();
        order.setCustomer(customer);

        List<OrderItem> items = new ArrayList<>();
        for (RequestOrderItem requestOrderItem : requestOrderItems) {
            OrderItem item = new OrderItem();
            Optional<Product> product = productDao.findById(requestOrderItem.getProductId());
            if (product.isPresent()) {
                item.setProduct(product.get());
            } else return new ErrorResult("Product not found");
            item.setOrder(order);
            item.setQuantity(requestOrderItem.getQuantity());
            items.add(item);
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
            responseOrder.setOrderID(order.getId());
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
