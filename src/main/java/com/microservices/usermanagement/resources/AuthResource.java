package com.microservices.usermanagement.resources;


import com.microservices.usermanagement.dto.LoginRequestDTO;
import com.microservices.usermanagement.dto.ResponseDTO;
import com.microservices.usermanagement.dto.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RequestMapping("/api/v1/auth")
@Validated
public interface AuthResource {

    @PostMapping("/register")
    ResponseEntity<ResponseDTO> register(@Valid @RequestBody UserDTO request);

    @PostMapping("/authenticate")
    ResponseEntity<ResponseDTO> authenticate(@Valid @RequestBody LoginRequestDTO request);

    @PostMapping("/refresh-token")
    void refreshToken(HttpServletRequest request, HttpServletResponse respons) throws IOException;
}
