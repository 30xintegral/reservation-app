package com.demo.reservationapp.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class CustomerResponse {
    private Long id;

    private String email;

    private String firstname;

    private String lastname;

    private LocalDateTime registeredAt;

    private LocalDateTime updatedAt;

}
