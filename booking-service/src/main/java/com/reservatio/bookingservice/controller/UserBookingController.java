package com.reservatio.bookingservice.controller;

import com.reservatio.bookingservice.dto.ReservationDto;
import com.reservatio.bookingservice.service.UserBookingService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user/{userId}/reservation")
public class UserBookingController {

  private final UserBookingService userBookingService;

  @GetMapping
  public ResponseEntity<List<ReservationDto>> getAllUserReservation(@PathVariable UUID userId) {
    log.info("getAllUserReservation userId: {}", userId);
    return ResponseEntity.ok(userBookingService.listReservations(userId));
  }

//  @GetMapping(value = "/paged-list", produces = "application/json;charset=utf-8")
//  public ResponseEntity<PageImpl<ReservationDto>> getAllUserReservationPagedList(
//      @PathVariable Long userId,
//      @RequestParam(defaultValue = "0") Integer pageNum,
//      @RequestParam(defaultValue = "50") Integer pageSize,
//      @RequestParam(required = false) String reservationIdFilter,
//      @RequestParam(required = false) String officeIdFilter,
//      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFilter,
//      @RequestParam(required = false) ReservationStatusEnum statusFilter
//  ) {
//    Pageable pageable = PageRequest.of(pageNum, pageSize);
//    Page<ReservationDto> page = userBookingService.findAll(
//        pageable,
//        reservationIdFilter,
//        officeIdFilter,
//        dateFilter,
//        statusFilter
//        );
//    return ResponseEntity.ok()
//        .body(
//            new PageImpl<>(
//                page.stream().map(mapper::toDto).collect(Collectors.toList()),
//                pageable,
//                page.getTotalElements()));
//  }

  @GetMapping("/{reservationId}")
  public ResponseEntity<ReservationDto> getById(@PathVariable("userId") UUID userId,
      @PathVariable("reservationId") UUID reservationId) {
    return ResponseEntity.ok(userBookingService.getReservationById(userId, reservationId));
  }

  @PostMapping
  public ResponseEntity<ReservationDto> createReservation(@PathVariable("userId") UUID userId,
      @RequestBody @Valid ReservationDto reservationDto) {
    ReservationDto saved = userBookingService.saveReservation(userId, reservationDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }

}
