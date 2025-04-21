package com.demo.reservationapp.service.impl;

import com.demo.reservationapp.entity.User;
import com.demo.reservationapp.entity.UserPrincipal;
import com.demo.reservationapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found"));

        UserPrincipal userPrincipal = new UserPrincipal();

        userPrincipal.setId(user.getId());
        userPrincipal.setEmail(user.getEmail());
        userPrincipal.setPassword(user.getPassword());
        userPrincipal.setUser(user);
        userPrincipal.setRole(user.getRole());
        userPrincipal.setLocked(user.getLocked());

        return userPrincipal;
    }
    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserPrincipal userPrincipal = new UserPrincipal();
        userPrincipal.setPassword(user.getPassword());
        userPrincipal.setId(user.getId());
        userPrincipal.setRole(user.getRole());
        userPrincipal.setLocked(user.getLocked());
        userPrincipal.setEmail(user.getEmail());
        userPrincipal.setUser(user);

        return userPrincipal;
    }

}
