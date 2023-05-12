package com.reservatio.bookingservice.service;

import com.reservatio.bookingservice.dto.ReservationDto;
import java.util.List;
import java.util.UUID;

public interface UserBookingService {

  List<ReservationDto> listReservations(UUID userId);

  ReservationDto getReservationById(UUID userId, UUID reservationId);

  ReservationDto saveReservation(UUID userId, ReservationDto reservation);
}
