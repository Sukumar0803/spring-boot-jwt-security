package com.microservices.usermanagement.utils;

public class Constants {

    public static class SecurityConstants {
        public static final String JWT_HEADER = "Authorization";
    }

    public static class TypeErrorCode {
        public static final String INVALID_METHOD_ARGUMENTS = "INVALID_METHOD_ARGUMENTS";
        public static final String TECHNICAL_ERROR_TYPE_ID = "TECHNICAL_ERROR";
        public static final String BAD_CREDNETIALS_TYPE_ID ="BAD_TOKEN_ERROR";
    }

    public static class SystemErrorCode {
        public static final String SYSTEM_EXCEPTION_ERROR_CODE = "T001";
        public static final String VALIDATION_EXCEPTION_ERROR_CODE = "B001";
        public static final String USER_NOT_FOUND_EXCEPTION_ERROR_CODE = "B002";
        public static final String USER_ALREADY_EXISTS_EXCEPTION_ERROR_CODE = "B003";
        public static final String ILLEGAL_METHOD_ARGUMENTS_EXCEPTION_ERROR_CODE = "B004";
    }

    public static final String STATUS_CODE_201 = "201";
    public static final String MESSAGE_FOR_201 =  "%s Created Successfully";

    public static final String USER_ALREADY_EXISTS_ERROR_MESSAGE = "User %s already exists, please try different";



    private Constants() {
    }

    public static final String EMAIL_REGEX_EXP ="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
}
