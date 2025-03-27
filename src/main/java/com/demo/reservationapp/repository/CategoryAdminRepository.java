package com.demo.reservationapp.repository;

import com.demo.reservationapp.entity.CategoryAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryAdminRepository extends JpaRepository<CategoryAdmin, Long> {

}
