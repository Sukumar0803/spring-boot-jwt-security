package com.microservices.usermanagement.services;

import com.microservices.usermanagement.dto.UserDTO;
import com.microservices.usermanagement.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserByUserNameOrEmail(String username);

    List<UserDTO> getAllUsers();
}
