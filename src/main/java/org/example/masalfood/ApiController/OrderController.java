package org.example.masalfood.ApiController;

import org.example.masalfood.Business.models.Requests.RequestOrder;
import org.example.masalfood.Business.models.Responses.ResponseOrder;
import org.example.masalfood.Business.models.Responses.Result.DataResult;
import org.example.masalfood.Business.models.Responses.Result.Result;
import org.example.masalfood.Business.abstracts.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Result create(@RequestBody RequestOrder requestOrder) {
        return orderService.create(requestOrder);
    }

    @GetMapping("/show-all-orders")
    public DataResult<Set<ResponseOrder>> getAllOrders() {
        return orderService.showAllOrders();
    }
}
