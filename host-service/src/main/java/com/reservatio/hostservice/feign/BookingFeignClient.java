package com.reservatio.hostservice.feign;

import com.reservatio.hostservice.dto.ReservationDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "booking-service", path = "/api/host")
public interface BookingFeignClient {

  String BOOKING_CB = "bookingCB";

  @CircuitBreaker(name = BOOKING_CB, fallbackMethod = "getAllUserReservationFallback")
  @Retry(name = BOOKING_CB)
  @GetMapping("/{hostId}/reservation")
  List<ReservationDto> getAllHostReservation(@PathVariable UUID hostId);

  @GetMapping("/{hostId}/reservation/{reservationId}")
  ReservationDto getById(@PathVariable("hostId") UUID hostId, @PathVariable("reservationId") UUID reservationId);

  default List<ReservationDto> getAllUserReservationFallback(Exception e) {
    return new ArrayList<>();
  }
}
