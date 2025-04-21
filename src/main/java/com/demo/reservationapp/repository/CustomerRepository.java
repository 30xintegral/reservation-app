package com.demo.reservationapp.repository;

import com.demo.reservationapp.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Override
    Optional<Customer> findById(Long id);

    Page<Customer> findAll(Pageable pageable);

    Optional<Customer> findByUserId(Long userId);
}
