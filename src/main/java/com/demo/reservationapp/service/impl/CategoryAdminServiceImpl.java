package com.demo.reservationapp.service.impl;

import com.demo.reservationapp.dtos.request.CategoryAdminRequest;
import com.demo.reservationapp.dtos.response.CategoryAdminResponse;
import com.demo.reservationapp.entity.CategoryAdmin;
import com.demo.reservationapp.exceptions.NotFoundException;
import com.demo.reservationapp.mapper.CategoryAdminMapper;
import com.demo.reservationapp.repository.CategoryAdminRepository;
import com.demo.reservationapp.service.CategoryAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryAdminServiceImpl implements CategoryAdminService {
    private final CategoryAdminRepository categoryAdminRepository;

    @Override
    public void save(CategoryAdminRequest categoryAdminRequest) {
        CategoryAdmin categoryAdmin = CategoryAdminMapper.INSTANCE.requestToEntity(categoryAdminRequest);
        categoryAdminRepository.save(categoryAdmin);
    }

    @Override
    public void updateCategoryAdminById(Long id, CategoryAdminRequest categoryAdminRequest) {
        CategoryAdmin categoryAdmin = categoryAdminRepository.findById(id).orElseThrow(()-> new NotFoundException("Category Admin not found"));
        categoryAdmin = CategoryAdminMapper.INSTANCE.requestToEntity(categoryAdminRequest);
        categoryAdminRepository.save(categoryAdmin);
    }

    @Override
    public void deleteCategoryAdminById(Long id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public CategoryAdminResponse findCategoryAdminById(Long id) {
        CategoryAdmin categoryAdmin = categoryAdminRepository.findById(id).orElseThrow(()-> new NotFoundException("Category Admin not found"));
        return CategoryAdminMapper.INSTANCE.entityToResponse(categoryAdmin);
    }

    @Override
    public List<CategoryAdminResponse> findAllCategoryAdmins(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<CategoryAdminResponse> categoryAdminResponses = new ArrayList<>();
        Page<CategoryAdmin> categoryAdmins = categoryAdminRepository.findAll(pageable);
        for (CategoryAdmin categoryAdmin : categoryAdmins) {
            CategoryAdminResponse categoryAdminResponse = CategoryAdminMapper.INSTANCE.entityToResponse(categoryAdmin);
        }
        return categoryAdminResponses;
    }
}
