package com.reservatio.bookingservice.service;

import com.reservatio.bookingservice.dto.ReservationDto;
import java.util.List;

public interface UserBookingService {

  List<ReservationDto> listReservations(Long userId);

  ReservationDto getReservationById(Long userId, String reservationId);

  ReservationDto saveReservation(Long userId, ReservationDto reservation);
}
