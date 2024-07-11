package com.microservices.usermanagement.services;

import com.microservices.usermanagement.dto.LoginRequestDTO;
import com.microservices.usermanagement.dto.ResponseDTO;
import com.microservices.usermanagement.dto.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthService {
    ResponseDTO register(UserDTO request);
    ResponseDTO authenticate(LoginRequestDTO request);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
