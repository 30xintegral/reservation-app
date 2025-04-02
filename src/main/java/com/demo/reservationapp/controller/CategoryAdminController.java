package com.demo.reservationapp.controller;

import com.demo.reservationapp.service.CategoryAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ca")
public class CategoryAdminController {
    private final CategoryAdminService categoryAdminService;


}
