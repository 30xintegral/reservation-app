package com.demo.reservationapp.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class UserNotFoundException extends GlobalException {
    private String message;

    public UserNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
        this.message = message;
    }
}
