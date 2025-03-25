package com.demo.reservationapp.dtos.response;

import com.demo.reservationapp.enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CategoryAdminResponse {
    private Long id;

    private String email; //pull from user data

    private String firstname;

    private String lastname;

    private LocalDateTime registeredAt;

    private LocalDateTime updatedAt;

    private Category category;
}
