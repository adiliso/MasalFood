package org.example.masalfood.Business.concretes;

import lombok.AllArgsConstructor;
import org.example.masalfood.Business.Dto.Requests.RequestCustomer;
import org.example.masalfood.Business.Dto.Responses.Result.*;
import org.example.masalfood.Business.abstracts.CustomerService;
import org.example.masalfood.DataAccess.CustomerDao;
import org.example.masalfood.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public Result add(Customer customer) {
        customerDao.save(customer);
        return new SuccessResult();
    }

    @Override
    public DataResult<Customer> getById(int id) {
        Optional<Customer> customer = customerDao.findById(id);
        if(customer.isPresent()) {
            return new SuccessDataResult<>(customer.get());
        }
        return new ErrorDataResult<>("Customer not found");
    }

    private Customer customerMapper(RequestCustomer requestCustomer) {
        Customer customer = new Customer();
        customer.setName(requestCustomer.getName());
        customer.setEmail(requestCustomer.getEmail());
        customer.setCity(requestCustomer.getCity());
        customer.setStreet(requestCustomer.getStreet());
        return customer;
    }
}
