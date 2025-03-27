package com.demo.reservationapp.service;

import com.demo.reservationapp.dtos.request.LoginDTO;
import com.demo.reservationapp.dtos.request.RegistrationDTO;
import com.demo.reservationapp.dtos.request.TokenRequest;
import com.demo.reservationapp.dtos.response.TokenResponse;


public interface AuthService {
    TokenResponse login(LoginDTO loginDTO);

    void register(RegistrationDTO registrationDTO);

    void addDetails(RegistrationDTO registrationDTO);

    TokenResponse refresh(TokenRequest tokenRequest);
}
