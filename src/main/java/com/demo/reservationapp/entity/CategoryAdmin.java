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
    private Long id;

    private String firstname;

    private String lastname;

    private LocalDateTime registeredAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToOne
    private User user;

    public void setUser(User user) {
        this.user = user;
    }
}
