package org.example.masalfood.DataAccess;

import org.example.masalfood.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
