package org.example.masalfood.Business.concretes;

import lombok.AllArgsConstructor;
import org.example.masalfood.Business.Dto.Requests.RequestOrderItem;
import org.example.masalfood.Business.Dto.Responses.Result.ErrorResult;
import org.example.masalfood.Business.Dto.Responses.Result.Result;
import org.example.masalfood.Business.Dto.Responses.Result.SuccessResult;
import org.example.masalfood.Business.abstracts.OrderItemService;
import org.example.masalfood.DataAccess.CustomerDao;
import org.example.masalfood.DataAccess.OrderDao;
import org.example.masalfood.DataAccess.OrderItemDao;
import org.example.masalfood.DataAccess.ProductDao;
import org.example.masalfood.Entities.Order;
import org.example.masalfood.Entities.OrderItem;
import org.example.masalfood.Entities.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderItemManager implements OrderItemService {
    OrderItemDao orderItemDao;
    CustomerDao customerDao;
    ProductDao productDao;
    OrderDao orderDao;
    @Override
    public Result add(RequestOrderItem requestOrderItem) {
        OrderItem orderItem = new OrderItem();
        Optional<Order> order = orderDao.findById(requestOrderItem.getOrderId());
        if (order.isEmpty()) {
            return new ErrorResult("Order not found");
        }
        orderItem.setOrder(order.get());
        Optional<Product> product = productDao.findById(requestOrderItem.getProductId());
        if (product.isEmpty()) {
            return new ErrorResult("Product not found");
        }
        orderItem.setProduct(product.get());
        orderItem.setQuantity(requestOrderItem.getQuantity());
        orderItemDao.save(orderItem);
        Order order1 = order.get();
        List<OrderItem> list = new ArrayList<>();;
        list.add(orderItem);
        order1.setOrderItems(list);
        orderDao.save(order1);
        return new SuccessResult("Order item added");
    }
}
