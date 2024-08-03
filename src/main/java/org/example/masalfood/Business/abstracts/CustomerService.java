package org.example.masalfood.Business.abstracts;

import org.example.masalfood.Business.Dto.Responses.Result.DataResult;
import org.example.masalfood.Entities.Customer;
import org.example.masalfood.Business.Dto.Responses.Result.Result;

public interface CustomerService {
    Result add (Customer customer);
    DataResult<Customer> getById(int id);
}
