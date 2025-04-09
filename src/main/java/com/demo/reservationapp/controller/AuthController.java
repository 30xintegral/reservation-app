package com.demo.reservationapp.controller;

import com.demo.reservationapp.dtos.request.*;
import com.demo.reservationapp.dtos.response.TokenResponse;
import com.demo.reservationapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register/ca")
    public void register(@RequestBody RegistrationDTO registrationDTO) {
        authService.registerCategoryAdmin(registrationDTO);
    }

    @PostMapping("/register/c")
    public void registerCustomer(@RequestBody RegistrationDTO registrationDTO) {
        authService.registerCustomer(registrationDTO);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginDTO loginDTO) {
        return authService.login(loginDTO);
    }

    @PostMapping("/refresh")
    public TokenResponse refresh(@RequestBody TokenRequest tokenRequest) {
        return authService.refresh(tokenRequest);
    }

    @PostMapping("/add-details/ca")
    public void addDetailsCategoryAdmin(@RequestBody CategoryAdminRequest categoryAdminRequest) {
        authService.addDetailsCategoryAdmin(categoryAdminRequest);
    }
    @PostMapping("/add-details/c")
    public void addDetailsCustomer(@RequestBody CustomerRequest customerRequest) {
        authService.addDetailsCustomer(customerRequest);
    }
}
