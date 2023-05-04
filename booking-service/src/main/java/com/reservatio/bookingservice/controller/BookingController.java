package com.reservatio.bookingservice.controller;

import com.reservatio.bookingservice.dto.AvailableCity;
import com.reservatio.bookingservice.dto.AvailableCityDto;
import com.reservatio.bookingservice.service.BookingService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/public/booking")
public class BookingController {

  private final BookingService bookingService;

  @GetMapping("/search")
  public ResponseEntity<List<AvailableCityDto>> getAll(LocalDate startDate, LocalDate endDate, Long propertyId, AvailableCity city) {
    log.info("getAllReservations");
    return ResponseEntity.ok(bookingService.searchAvailableOffices(startDate, endDate, propertyId, city));
  }


}
