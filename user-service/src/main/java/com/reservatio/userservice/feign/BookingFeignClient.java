package com.reservatio.userservice.feign;

import com.reservatio.userservice.dto.ReservationDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import java.util.ArrayList;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "booking-service", path = "/api/user")
public interface BookingFeignClient {

  String BOOKING_CB = "bookingCB";

  @CircuitBreaker(name = BOOKING_CB, fallbackMethod = "getAllUserReservationFallback")
  @Retry(name = BOOKING_CB)
  @GetMapping("/{userId}/reservation")
  List<ReservationDto> getAllUserReservation(@PathVariable String userId);

  @CircuitBreaker(name = BOOKING_CB)
  @GetMapping("/{userId}/reservation/{reservationId}")
  ReservationDto getById(@PathVariable("userId") String userId, @PathVariable("reservationId") String reservationId);

  @CircuitBreaker(name = BOOKING_CB)
  @PostMapping("/{userId}/reservation")
  ReservationDto createReservation(@PathVariable("userId") String userId, ReservationDto reservationDto);

  default List<ReservationDto> getAllUserReservationFallback(Exception e) {
    return new ArrayList<>();
  }
}
