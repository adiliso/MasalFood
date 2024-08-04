package org.example.masalfood.DataAccess;

import org.example.masalfood.Entities.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactUsDao extends JpaRepository<ContactUs, Integer> {
}
