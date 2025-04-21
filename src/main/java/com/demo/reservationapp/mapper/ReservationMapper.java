package com.demo.reservationapp.mapper;

import com.demo.reservationapp.dtos.request.CustomerRequest;
import com.demo.reservationapp.dtos.request.ReservationRequest;
import com.demo.reservationapp.dtos.response.CustomerResponse;
import com.demo.reservationapp.dtos.response.ReservationResponse;
import com.demo.reservationapp.entity.Customer;
import com.demo.reservationapp.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public abstract class ReservationMapper {
    public static final ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    public abstract Reservation requestToEntity(ReservationRequest reservationRequest);

    public abstract ReservationResponse entityToResponse(Reservation response);
}
