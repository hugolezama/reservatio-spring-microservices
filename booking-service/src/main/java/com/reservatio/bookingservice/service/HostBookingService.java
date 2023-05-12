package com.reservatio.bookingservice.service;

import com.reservatio.bookingservice.dto.ReservationDto;
import java.util.List;
import java.util.UUID;

public interface HostBookingService {

  List<ReservationDto> listReservations(UUID hostId);

  ReservationDto getReservationById(UUID hostId, UUID reservationId);

}
