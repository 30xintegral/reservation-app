package com.demo.reservationapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
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
    private Set<Reservation> reservations = new HashSet<>();
    public void setReservations(Reservation reservation) {
        this.reservations.add(reservation);
    }

}
