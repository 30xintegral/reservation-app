package com.demo.reservationapp.service;

import com.demo.reservationapp.dtos.request.CategoryAdminRequest;
import com.demo.reservationapp.dtos.response.CategoryAdminResponse;

import java.util.List;

public interface CategoryAdminService {
    void save(CategoryAdminRequest categoryAdminRequest);

    void updateCategoryAdminById(Long id, CategoryAdminRequest categoryAdminRequest);

    void deleteCategoryAdminById(Long id);

    void deleteAll();

    CategoryAdminResponse findCategoryAdminById(Long id);

    List<CategoryAdminResponse> findAllCategoryAdmins(int page, int size);

}
