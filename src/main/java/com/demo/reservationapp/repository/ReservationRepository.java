package com.demo.reservationapp.repository;

import com.demo.reservationapp.entity.Customer;
import com.demo.reservationapp.entity.Reservation;
import com.demo.reservationapp.enums.Status;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Page<Reservation> findAll(Pageable pageable);

    Optional<Reservation> findById(Long id);


    @Modifying
    @Transactional
    @Query("UPDATE Reservation r SET r.status = :status WHERE r.id = :id")
    int updateReservationStatus(@Param("id") Long id, @Param("status") Status status);

    Page<Reservation> findAllByCustomerId(Long customerId, Pageable pageable);


    @Query("SELECT r FROM Reservation r WHERE r.status = :status AND r.customer.id = :id")
    List<Reservation> findByStatusAndCustomerId(@Param("id") Long id, @Param("status") Status status);


}
