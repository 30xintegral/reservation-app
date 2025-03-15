package com.demo.reservationapp.entity;

import com.demo.reservationapp.enums.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Getter
@Setter
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime scheduledTime;

    private Category category;

    @ManyToOne
    private Customer customer;
}
