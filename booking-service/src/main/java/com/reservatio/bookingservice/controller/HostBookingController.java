package com.reservatio.bookingservice.controller;

import com.reservatio.bookingservice.dto.ReservationDto;
import com.reservatio.bookingservice.service.HostBookingService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/host/{hostId}/reservation")
public class HostBookingController {

  private final HostBookingService hostBookingService;

  @GetMapping
  public ResponseEntity<List<ReservationDto>> getAllHostReservation(@PathVariable UUID hostId) {
    log.info("getAllHostReservation hostId: {}", hostId);
    return ResponseEntity.ok(hostBookingService.listReservations(hostId));
  }

  @GetMapping("/{reservationId}")
  public ResponseEntity<ReservationDto> getById(@PathVariable("hostId") UUID hostId,
      @PathVariable("reservationId") UUID reservationId) {
    return ResponseEntity.ok(hostBookingService.getReservationById(hostId, reservationId));
  }

}
