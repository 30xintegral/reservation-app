package com.demo.reservationapp.service.impl;

import com.demo.reservationapp.dtos.request.*;
import com.demo.reservationapp.dtos.response.TokenResponse;
import com.demo.reservationapp.entity.User;
import com.demo.reservationapp.entity.UserPrincipal;
import com.demo.reservationapp.enums.Role;
import com.demo.reservationapp.exceptions.TerminatedException;
import com.demo.reservationapp.exceptions.UserNotFoundException;
import com.demo.reservationapp.repository.CategoryAdminRepository;
import com.demo.reservationapp.repository.CustomerRepository;
import com.demo.reservationapp.repository.UserRepository;
import com.demo.reservationapp.security.JwtTokenProvider;
import com.demo.reservationapp.service.AuthService;
import com.demo.reservationapp.service.CategoryAdminService;
import com.demo.reservationapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final CustomerService customerService;
    private final CategoryAdminService categoryAdminService;

    @Override
    public TokenResponse login(LoginDTO loginDTO) {
        User user =  userRepository.findByEmail(loginDTO.getEmail()).orElseThrow(() -> new UserNotFoundException("User not found. Probably not registered yet"));
        if(user.getDeleted() || user.getLocked()){
            throw new UserNotFoundException("User locked or deleted");
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtTokenProvider.generateToken(authentication);
    }

    @Override
    public void registerCategoryAdmin(RegistrationDTO registrationDTO) {
        try{
            User user = new User();
            user.setEmail(registrationDTO.getEmail());
            user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
            user.setDeleted(false);
            user.setLocked(false);
            user.setRole(Role.CATEGORYADMIN);
            userRepository.save(user);
        }
        catch(Exception e){
            throw new TerminatedException("Error while creating user");
        }

    }

    @Override
    public void registerCustomer(RegistrationDTO registrationDTO) {
        try{
            User user = new User();
            user.setEmail(registrationDTO.getEmail());
            user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
            user.setDeleted(false);
            user.setLocked(false);
            user.setRole(Role.CUSTOMER);
            userRepository.save(user);
        }
        catch(Exception e){
            throw new TerminatedException("Error while creating user");
        }
    }

    @Override
    public void addDetailsCustomer(CustomerRequest customerRequest) {
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userRepository.findById(principal.getId()).isEmpty()) throw new UserNotFoundException("User not found. Probably not registered yet");
        customerService.save(customerRequest);
    }

    @Override
    public void addDetailsCategoryAdmin(CategoryAdminRequest categoryAdminRequest) {
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userRepository.findById(principal.getId()).isEmpty()) throw new UserNotFoundException("User not found. Probably not registered yet");
        categoryAdminService.save(categoryAdminRequest);
    }

    @Override
    public TokenResponse refresh(TokenRequest tokenRequest) {
        return jwtTokenProvider.refreshToken(tokenRequest.getRefreshToken());
    }
}
