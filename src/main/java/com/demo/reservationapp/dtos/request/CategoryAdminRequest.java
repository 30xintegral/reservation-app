package com.demo.reservationapp.dtos.request;

import com.demo.reservationapp.enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class CategoryAdminRequest {
    private String firstname;

    private String lastname;


    private Category category;
}
