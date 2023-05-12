package com.reservatio.hostservice.service;

import com.reservatio.hostservice.dto.ReservationDto;
import java.util.List;
import java.util.UUID;

public interface HostBookingService {

  List<ReservationDto> getAllReservations(UUID hostId);
}
