package org.example.masalfood.Business.concretes;

import org.example.masalfood.ApiController.CustomerController;
import org.example.masalfood.Business.models.Requests.RequestCustomer;
import org.example.masalfood.Business.models.Responses.Result.*;
import org.example.masalfood.Business.abstracts.OrderService;
import org.example.masalfood.DataAccess.CustomerDao;
import org.example.masalfood.DataAccess.OrderDao;
import org.example.masalfood.DataAccess.ProductDao;
import org.example.masalfood.Entities.Customer;
import org.example.masalfood.Entities.Order;
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
    CustomerController customerController;

    @Override
    public Result addOrder(RequestCustomer requestCustomer, String productId, int quantity) {
        Order order = new Order();
        Customer customer = modelMapper.map(requestCustomer, Customer.class);
        customerDao.save(customer);
        order.setCustomer(customer);
        Optional<Product> product = productDao.findById(productId);
        if (product.isEmpty()) {
            return new ErrorResult("Product not found");
        }
        productDao.save(product.get());
        order.setProduct(product.get());
        order.setQuantity(quantity);
        orderDao.save(order);
        return new SuccessResult("Order added");
    }
}
