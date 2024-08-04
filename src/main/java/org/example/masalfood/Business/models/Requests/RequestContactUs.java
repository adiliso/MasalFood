package org.example.masalfood.Business.models.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.masalfood.Business.Validation.RealEmail;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestContactUs {
    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name should not exceed 100 characters")
    private String fullName;
    @NotBlank(message = "Email is mandatory")
    @RealEmail
    @Size(max = 100, message = "Email should not exceed 100 characters")
    private String email;
    @NotNull(message = "Subject required")
    private String subject;
    @NotNull(message = "Message required")
    private String message;
}
