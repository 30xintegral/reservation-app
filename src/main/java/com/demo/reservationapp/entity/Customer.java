package com.demo.reservationapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private LocalDateTime registeredAt;

    private LocalDateTime updatedAt;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "customer")
    private Set<Reservations> reservations = new HashSet<>();
    public void setReservations(Reservations reservation) {
        this.reservations.add(reservation);
    }

}
