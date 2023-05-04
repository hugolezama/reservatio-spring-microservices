package com.reservatio.userservice.service;

import com.reservatio.userservice.dto.ReservationDto;
import java.util.List;

public interface UserBookingService {
  List<ReservationDto> getAllReservations(String userId);
}
