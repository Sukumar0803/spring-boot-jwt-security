package com.microservices.usermanagement.repository;

import com.microservices.usermanagement.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = "select t.* from token t " +
            "INNER join users u on t.user_id =u.id " +
            "where u.id =:Id " +
            "and (t.expired = false OR t.revoked = false)", nativeQuery = true)
    List<Token> findAllValidTokenByUser(@Param("Id") Integer id);

    Optional<Token> findByToken(String token);
}