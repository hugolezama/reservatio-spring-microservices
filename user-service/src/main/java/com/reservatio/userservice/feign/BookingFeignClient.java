package com.reservatio.userservice.feign;

import com.reservatio.userservice.dto.ReservationDto;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "booking-service", path = "/user")
public interface BookingFeignClient {

  @GetMapping("/{userId}/reservation")
  List<ReservationDto> getAllUserReservation(@PathVariable String userId);

  @GetMapping("/{userId}/reservation/{reservationId}")
  ReservationDto getById(@PathVariable("userId") String userId, @PathVariable("reservationId") String reservationId);

  @PostMapping("/{userId}/reservation")
  ReservationDto createReservation(@PathVariable("userId") String userId, ReservationDto reservationDto);
}
