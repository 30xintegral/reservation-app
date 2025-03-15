package com.demo.reservationapp.entity;

import com.demo.reservationapp.enums.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "categoryAdmins")
@Getter
@Setter
public class CategoryAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstname;

    private String lastname;

    private LocalDateTime registeredAt;

    private LocalDateTime updatedAt;

    private Category category;

    @OneToOne
    private User user;
}
