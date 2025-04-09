package com.demo.reservationapp.service;

import com.demo.reservationapp.dtos.request.*;
import com.demo.reservationapp.dtos.response.TokenResponse;


public interface AuthService {
    TokenResponse login(LoginDTO loginDTO);

    void registerCategoryAdmin(RegistrationDTO registrationDTO);

    void registerCustomer(RegistrationDTO registrationDTO);

    void addDetailsCustomer(CustomerRequest customerRequest);

    void addDetailsCategoryAdmin(CategoryAdminRequest categoryAdminRequest);

    TokenResponse refresh(TokenRequest tokenRequest);
}
