package com.demo.reservationapp.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDTO {
    private String email;

    private String password;
}
