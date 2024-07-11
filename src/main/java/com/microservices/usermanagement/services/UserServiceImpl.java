package com.microservices.usermanagement.services;

import com.microservices.usermanagement.dto.UserDTO;
import com.microservices.usermanagement.entity.User;
import com.microservices.usermanagement.mapper.UserMapper;
import com.microservices.usermanagement.repository.UserRepository;
import com.microservices.usermanagement.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Value("${test_user}")
    private String user;

    /**
     * @param username username Or Email
     * @return user
     */
    @Override
    public Optional<User> getUserByUserNameOrEmail(String username) {
        if (isEmail(username)) {
            return userRepository.findByEmail(username);
        } else {
            return userRepository.findByUsername(username);
        }
    }

    /**
     * @return list of users
     */
    @Override
    public List<UserDTO> getAllUsers() {
        System.out.println(user);
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }

    /**
     * Helper method to check if a string is an email address
     *
     * @param str input userName
     * @return true if it's email else false
     */
    private boolean isEmail(String str) {
        // Basic email validation using regex
        return str != null && str.matches(Constants.EMAIL_REGEX_EXP);
    }
}
