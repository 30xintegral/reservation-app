package com.demo.reservationapp.dtos.request;

import com.demo.reservationapp.enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationRequest {
    private LocalDateTime scheduledTime;

    private Category category;
}
