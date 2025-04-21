package com.demo.reservationapp.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CustomerResponse {
    private Long id;

    private String email;

    private String firstname;

    private String lastname;

    private LocalDateTime registeredAt;

    private LocalDateTime updatedAt;

    private Set<ReservationResponse> reservations = new HashSet<>();

}
