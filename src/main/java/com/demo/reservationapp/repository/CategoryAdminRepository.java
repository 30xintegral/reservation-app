package com.demo.reservationapp.repository;

import com.demo.reservationapp.entity.CategoryAdmin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryAdminRepository extends JpaRepository<CategoryAdmin, Long> {
    @Override
    Optional<CategoryAdmin> findById(Long id);

    Page<CategoryAdmin> findAll(Pageable pageable);



}
