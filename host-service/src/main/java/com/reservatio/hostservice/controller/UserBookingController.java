package com.reservatio.hostservice.controller;

import com.reservatio.hostservice.dto.ReservationDto;
import com.reservatio.hostservice.service.HostBookingService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/host-booking")
public class UserBookingController {

  private final HostBookingService service;

  @GetMapping("/reservation")
  public ResponseEntity<List<ReservationDto>> getAllReservations(@RequestHeader UUID hostId) {
    log.info("getAllReservations");
    return ResponseEntity.ok(service.getAllReservations(hostId));
  }

}
