package com.demo.reservationapp.entity;

import com.demo.reservationapp.enums.Category;
import com.demo.reservationapp.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;

    private LocalDateTime scheduledTime;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Customer customer;
}
