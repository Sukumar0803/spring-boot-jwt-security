package com.microservices.usermanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LoginRequestDTO {

    @NotEmpty(message = "user Name is Mandatory")
    private String username;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).{5,}$", message = "Password must have at least 5 characters including 1 uppercase letter, 1 digit, and 1 special character")
    @NotEmpty(message = "password is mandatory field")
    private String password;
}
