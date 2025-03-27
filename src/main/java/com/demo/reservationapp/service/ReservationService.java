package com.demo.reservationapp.service;

import com.demo.reservationapp.dtos.request.ReservationRequest;
import com.demo.reservationapp.dtos.response.ReservationResponse;

import java.util.List;

public interface ReservationService {
    void deleteReservationById(Long id);

    void deleteAllReservations();

    void createReservation(ReservationRequest reservationRequest);

    List<ReservationResponse> findAllReservations(int page, int size);

    ReservationResponse findReservationById(Long id);
}
