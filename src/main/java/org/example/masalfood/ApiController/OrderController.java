package org.example.masalfood.ApiController;

import org.example.masalfood.Business.Dto.Requests.RequestOrder;
import org.example.masalfood.Business.Dto.Responses.Result.Result;
import org.example.masalfood.Business.Dto.Responses.Result.SuccessResult;
import org.example.masalfood.Business.abstracts.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/create")
    public Result create(@RequestBody RequestOrder requestOrder) {
        return orderService.create(requestOrder);
    }
}
