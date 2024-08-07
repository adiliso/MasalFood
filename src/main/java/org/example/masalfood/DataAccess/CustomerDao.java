package org.example.masalfood.DataAccess;

import org.example.masalfood.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);
}
