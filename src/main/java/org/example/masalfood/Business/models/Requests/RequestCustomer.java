package org.example.masalfood.Business.models.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.masalfood.Business.validation.RealEmail;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCustomer {
    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name should not exceed 100 characters")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @RealEmail
    @Size(max = 100, message = "Email should not exceed 100 characters")
    private String email;

    @NotBlank(message = "City is mandatory")
    @Size(max = 50, message = "City should not exceed 50 characters")
    private String city;

    @NotBlank(message = "Street is mandatory")
    @Size(max = 100, message = "Street should not exceed 100 characters")
    private String street;
}

