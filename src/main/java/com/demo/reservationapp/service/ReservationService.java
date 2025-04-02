package com.demo.reservationapp.service;

import com.demo.reservationapp.dtos.request.ReservationRequest;
import com.demo.reservationapp.dtos.response.ReservationResponse;

import java.util.List;
import java.util.Set;

public interface ReservationService {
    void deleteReservationById(Long id);

    void deleteAllReservations();

    void createReservation(ReservationRequest reservationRequest);

    List<ReservationResponse> findAllReservations(int page, int size);

    ReservationResponse findReservationById(Long id);

    Set<ReservationResponse> findAllReservationsByCustomerId(Long customerId, int page, int size);
}
