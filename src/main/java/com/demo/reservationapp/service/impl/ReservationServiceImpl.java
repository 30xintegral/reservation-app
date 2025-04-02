package com.demo.reservationapp.service.impl;

import com.demo.reservationapp.dtos.request.ReservationRequest;
import com.demo.reservationapp.dtos.response.ReservationResponse;
import com.demo.reservationapp.entity.Reservation;
import com.demo.reservationapp.mapper.ReservationMapper;
import com.demo.reservationapp.repository.ReservationRepository;
import com.demo.reservationapp.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    @Override
    public void deleteReservationById(Long id) {

    }

    @Override
    public void deleteAllReservations() {

    }

    @Override
    public void createReservation(ReservationRequest reservationRequest) {

    }

    @Override
    public List<ReservationResponse> findAllReservations(int page, int size) {
        return List.of();
    }

    @Override
    public ReservationResponse findReservationById(Long id) {
        return null;
    }

    @Override
    public Set<ReservationResponse> findAllReservationsByCustomerId(Long customerId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Set<ReservationResponse> reservationResponses = new HashSet<>();
        Page<Reservation> reservations = reservationRepository.findAllByCustomerId(customerId, pageable);
        for (Reservation reservation : reservations.getContent()) {
            ReservationResponse reservationResponse = ReservationMapper.INSTANCE.entityToResponse(reservation);
            reservationResponses.add(reservationResponse);
        }
        return reservationResponses;
    }
}
