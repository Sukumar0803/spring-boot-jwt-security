package com.microservices.usermanagement.resources;

import com.microservices.usermanagement.dto.UserDTO;
import com.microservices.usermanagement.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserResourceImpl implements UserResource {

    private final UserService userService;

    /**
     * @return List of Users
     */
    @Override
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }
}
