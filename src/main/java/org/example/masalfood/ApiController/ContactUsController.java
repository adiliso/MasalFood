package org.example.masalfood.ApiController;

import lombok.AllArgsConstructor;
import org.example.masalfood.Business.models.Requests.RequestContactUs;
import org.example.masalfood.Business.models.Responses.Result.Result;
import org.example.masalfood.Business.models.Responses.Result.SuccessResult;
import org.example.masalfood.DataAccess.ContactUsDao;
import org.example.masalfood.Entities.ContactUs;
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
@RequestMapping("/api/contact-us")
@AllArgsConstructor
public class ContactUsController {
    @Autowired
    private ContactUsDao contactUsDao;
    @Autowired
    ModelMapper modelMapper;

    @CrossOrigin(origins = "http://10.0.10.97")
    @PostMapping("/add")
    public Result add(@Validated @RequestBody RequestContactUs requestContactUs) {
        ContactUs contactUs = modelMapper.map(requestContactUs, ContactUs.class);
        contactUsDao.save(contactUs);
        return new SuccessResult("Message sent successfully");
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
