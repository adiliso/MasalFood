package org.example.masalfood.ApiController;

import org.example.masalfood.Business.Dto.Requests.RequestOrderItem;
import org.example.masalfood.Business.Dto.Responses.Result.Result;
import org.example.masalfood.Business.abstracts.OrderItemService;
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
    @PostMapping("/add")
    public Result add(@RequestBody RequestOrderItem requestOrderItem) {
        return orderItemService.add(requestOrderItem);
    }
}
