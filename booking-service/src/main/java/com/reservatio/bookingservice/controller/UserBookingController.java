package com.reservatio.bookingservice.controller;

import com.reservatio.bookingservice.domain.ReservationStatusEnum;
import com.reservatio.bookingservice.dto.ReservationDto;
import com.reservatio.bookingservice.service.UserBookingService;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user/{userId}/reservation")
public class UserBookingController {

  private final UserBookingService userBookingService;

  @GetMapping
  public ResponseEntity<List<ReservationDto>> getAllUserReservation(@PathVariable Long userId) {
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
  public ResponseEntity<ReservationDto> getById(@PathVariable("userId") Long userId, @PathVariable("reservationId") String reservationId) {
    return ResponseEntity.ok(userBookingService.getReservationById(userId, reservationId));
  }

  @PostMapping
  public ResponseEntity<ReservationDto> save(@PathVariable("userId") Long userId, @RequestBody @Valid ReservationDto reservationDto) {
    ReservationDto saved = userBookingService.saveReservation(userId, reservationDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }

}