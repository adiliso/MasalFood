package org.example.masalfood.ApiController;

import org.example.masalfood.Business.Dto.Requests.RequestOrderItem;
import org.example.masalfood.Business.Dto.Responses.Result.Result;
import org.example.masalfood.Business.Dto.Responses.Result.SuccessResult;
import org.example.masalfood.Business.abstracts.OrderItemService;
import org.example.masalfood.DataAccess.CustomerDao;
import org.example.masalfood.DataAccess.OrderItemDao;
import org.example.masalfood.DataAccess.ProductDao;
import org.example.masalfood.Entities.OrderItem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order-item")
public class OrderItemController {
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    ModelMapper modelMapper;
    @PostMapping("/add")
    public Result add(@RequestBody RequestOrderItem requestOrderItem) {
        OrderItem orderItem = new OrderItem();
        orderItem.setCustomer(customerDao.getReferenceById(requestOrderItem.getCustomerId()));
        orderItem.setQuantity(requestOrderItem.getQuantity());
        orderItem.setProduct(productDao.getReferenceById(requestOrderItem.getProductId()));
        orderItemService.add(orderItem);
        return new SuccessResult();
    }
}
