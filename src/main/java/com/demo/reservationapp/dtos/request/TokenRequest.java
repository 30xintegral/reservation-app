package com.demo.reservationapp.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenRequest {
    String refreshToken;
}
