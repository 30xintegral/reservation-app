package com.demo.reservationapp.repository;

import com.demo.reservationapp.entity.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Page<Reservation> findAll(Pageable pageable);

    Optional<Reservation> findById(Long id);

    @Modifying
    @Query(value = "update reservations set active = true where id=:id", nativeQuery = true)
    String enableReservation(@Param(value = "id") Long id);
}
