package com.microservices.usermanagement.resources;

import com.microservices.usermanagement.dto.LoginRequestDTO;
import com.microservices.usermanagement.dto.ResponseDTO;
import com.microservices.usermanagement.dto.UserDTO;
import com.microservices.usermanagement.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AuthResourceImpl implements AuthResource {

    private final AuthService authService;

    /**
     * @param request
     * @return
     */
    @Override
    public ResponseEntity<ResponseDTO> register(UserDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(authService.register(request));
    }

    /**
     * @param request
     * @return
     */
    @Override
    public ResponseEntity<ResponseDTO> authenticate(LoginRequestDTO request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(authService.authenticate(request));
    }

    /**
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        authService.refreshToken(request, response);
    }
}
