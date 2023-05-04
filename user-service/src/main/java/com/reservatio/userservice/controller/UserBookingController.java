package com.reservatio.userservice.controller;

import com.reservatio.userservice.dto.ReservationDto;
import com.reservatio.userservice.service.UserBookingService;
import java.util.List;
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
@RequestMapping("/booking")
public class UserBookingController {

  private final UserBookingService service;

  @GetMapping("/reservation")
  public ResponseEntity<List<ReservationDto>> getAllReservations(@RequestHeader String userId) {
    log.info("getAllReservations");
    return ResponseEntity.ok(service.getAllReservations(userId));
  }

}
