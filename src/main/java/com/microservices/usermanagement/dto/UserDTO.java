package com.microservices.usermanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.microservices.usermanagement.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDTO {

    private Integer id;

    @NotEmpty(message = "user Name is Mandatory")
    private String username;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).{5,}$", message = "Password must have at least 5 characters including 1 uppercase letter, 1 digit, and 1 special character")
    @NotEmpty(message = "password is mandatory field")
    private String password;
    private String firstName;
    private String lastName;
    @Email(message = "Email format is not valid ")
    @NotEmpty(message = "Email field is Mandatory")
    private String email;
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String phone;
    private String createdBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/New_York")
    private LocalDateTime createdTimestamp;
    private String modifiedBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/New_York")
    private LocalDateTime modifiedTimestamp;
    Set<Role> roles;
}
