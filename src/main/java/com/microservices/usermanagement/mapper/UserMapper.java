package com.microservices.usermanagement.mapper;

import com.microservices.usermanagement.dto.UserDTO;
import com.microservices.usermanagement.entity.User;

public class UserMapper {

    public static UserDTO toDTO(final User user) {

        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .roles(user.getRoles())
                .createdBy(user.getCreatedBy())
                .createdTimestamp(user.getCreatedTimestamp())
                .modifiedBy(user.getModifiedBy())
                .modifiedTimestamp(user.getModifiedTimestamp())
                .build();

    }
}
