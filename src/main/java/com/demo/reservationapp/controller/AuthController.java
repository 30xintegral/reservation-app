package com.demo.reservationapp.controller;

import com.demo.reservationapp.dtos.request.LoginDTO;
import com.demo.reservationapp.dtos.request.RegistrationDTO;
import com.demo.reservationapp.dtos.request.TokenRequest;
import com.demo.reservationapp.dtos.response.TokenResponse;
import com.demo.reservationapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register/ca")
    public void register(@RequestBody RegistrationDTO registrationDTO) {
        authService.registerCategoryAdmin(registrationDTO);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginDTO loginDTO) {
        return authService.login(loginDTO);
    }

    @PostMapping("/refresh")
    public TokenResponse refresh(@RequestBody TokenRequest tokenRequest) {
        return authService.refresh(tokenRequest);
    }
}
