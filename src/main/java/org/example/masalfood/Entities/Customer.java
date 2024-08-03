package org.example.masalfood.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name should not exceed 100 characters")
    String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email should not exceed 100 characters")
    String email;

    @NotBlank(message = "City is mandatory")
    @Size(max = 50, message = "City should not exceed 50 characters")
    private String city;

    @NotBlank(message = "Street is mandatory")
    @Size(max = 100, message = "Street should not exceed 100 characters")
    String street;
}