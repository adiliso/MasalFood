package org.example.masalfood.ApiController;

import org.example.masalfood.Business.models.Requests.RequestCustomer;
import org.example.masalfood.Business.models.Responses.Result.Result;
import org.example.masalfood.Business.abstracts.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/add-order")
    public HttpStatus addOrder(@Validated @RequestBody RequestCustomer requestCustomer, @RequestParam String productId,
                           @RequestParam int quantity) {
        Result result = orderService.addOrder(requestCustomer, productId, quantity);
        if(!result.isSuccess()){
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
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
