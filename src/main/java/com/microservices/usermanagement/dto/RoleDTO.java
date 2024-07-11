package com.microservices.usermanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.microservices.usermanagement.entity.Permission;
import lombok.*;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RoleDTO {
    private Integer id;
    private String name;
    private Set<Permission> permissions;
}
