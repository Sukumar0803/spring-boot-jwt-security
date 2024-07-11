package com.microservices.usermanagement.resources;

import com.microservices.usermanagement.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/v1/users")
public interface UserResource {

    @GetMapping("/all")
    ResponseEntity<List<UserDTO>> getAllUsers();
}
