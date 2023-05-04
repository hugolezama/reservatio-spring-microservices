package com.reservatio.bookingservice.service;

import com.reservatio.bookingservice.dto.ReservationDto;
import java.util.List;

public interface UserBookingService {

  List<ReservationDto> listReservations(String userId);

  ReservationDto getReservationById(String userId, String reservationId);

  ReservationDto saveReservation(String userId, ReservationDto reservation);
}
