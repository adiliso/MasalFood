package org.example.masalfood.ApiController;

import lombok.AllArgsConstructor;
import org.example.masalfood.Business.models.Requests.RequestCustomer;
import org.example.masalfood.Business.abstracts.CustomerService;
import org.example.masalfood.Entities.Customer;
import org.example.masalfood.Business.models.Responses.Result.Result;
import org.example.masalfood.Business.models.Responses.Result.SuccessResult;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    ModelMapper modelMapper;

    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public Result add(@Validated @RequestBody RequestCustomer requestCustomer) {
        Customer customer = modelMapper.map(requestCustomer, Customer.class);
        customerService.add(customer);
        return new SuccessResult("Customer added successfully");
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
