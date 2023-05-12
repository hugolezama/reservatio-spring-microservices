package com.reservatio.hostservice.service;

import com.reservatio.hostservice.dto.ReservationDto;
import com.reservatio.hostservice.feign.BookingFeignClient;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HostBookingServiceImpl implements HostBookingService {

  private final BookingFeignClient bookingFeignClient;

  @Override
  public List<ReservationDto> getAllReservations(UUID hostId) {
    return bookingFeignClient.getAllHostReservation(hostId);
  }
}
