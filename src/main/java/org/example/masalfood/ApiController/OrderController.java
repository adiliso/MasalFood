package org.example.masalfood.ApiController;

import org.example.masalfood.Business.models.Requests.RequestOrder;
import org.example.masalfood.Business.models.Responses.Result.DataResult;
import org.example.masalfood.Business.models.Responses.Result.ResponseOrder;
import org.example.masalfood.Business.models.Responses.Result.Result;
import org.example.masalfood.Business.abstracts.OrderService;
import org.example.masalfood.Business.models.Responses.Result.SuccessResult;
import org.example.masalfood.Entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @CrossOrigin(origins = "http://10.0.10.97")
    @PostMapping("/add-order")
    public ResponseEntity<Result> addOrder(@Validated @RequestBody RequestOrder requestOrder) {
        Result result = orderService.addOrder(requestOrder.getCustomer(), requestOrder.getOrderItems());
        if (!result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "http://10.0.10.97")
    @DeleteMapping("/delete-order")
    public ResponseEntity<Result> deleteOrder(@RequestParam int orderId) {
        Result result = orderService.deleteOrder(orderId);
        if (!result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "http://10.0.10.97")
    @GetMapping("/get-all-orders")
    public DataResult<List<ResponseOrder>> getAllOrders() {
        return orderService.getAllOrders();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
