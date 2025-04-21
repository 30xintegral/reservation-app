package com.demo.reservationapp.dtos.response;

import com.demo.reservationapp.enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationResponse {
    private Long id;

    private boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime scheduledTime;

    private Category category;

    private Long customerId;

    private String customerEmail;

    private String customerFirstname;

    private String customerLastname;

}
