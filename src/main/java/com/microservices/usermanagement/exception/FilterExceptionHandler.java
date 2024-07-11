package com.microservices.usermanagement.exception;

import com.microservices.usermanagement.utils.Constants;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Component
public class FilterExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        System.out.println("*****************************************88");
        if (ex instanceof IOException || ex instanceof ServletException || ex instanceof  BadCredentialsException
        || ex instanceof MalformedJwtException) {
            throw new BadCredentialsException(ex.getMessage(), Constants.TypeErrorCode.BAD_CREDNETIALS_TYPE_ID);
        }
        return null;
    }
}