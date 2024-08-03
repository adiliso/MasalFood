package org.example.masalfood.Business.concretes;

import lombok.AllArgsConstructor;
import org.example.masalfood.Business.Dto.Requests.RequestOrderItem;
import org.example.masalfood.Business.abstracts.OrderItemService;
import org.example.masalfood.DataAccess.CustomerDao;
import org.example.masalfood.DataAccess.OrderItemDao;
import org.example.masalfood.DataAccess.ProductDao;
import org.example.masalfood.Entities.OrderItem;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderItemManager implements OrderItemService {
    OrderItemDao orderItemDao;
    CustomerDao customerDao;
    ProductDao productDao;
    @Override
    public void add(OrderItem orderItem) {
//        OrderItem orderItem = new OrderItem();
//        orderItem.setCustomer(customerDao.findById(requestOrderItem.getCustomerId()));
        orderItemDao.save(orderItem);
    }
}
