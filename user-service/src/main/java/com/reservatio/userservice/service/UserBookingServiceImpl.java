package com.reservatio.userservice.service;

import com.reservatio.userservice.dto.ReservationDto;
import com.reservatio.userservice.feign.BookingFeignClient;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserBookingServiceImpl implements UserBookingService {

  private final BookingFeignClient bookingFeignClient;

  @Override
  public List<ReservationDto> getAllReservations(String userId) {
    return bookingFeignClient.getAllUserReservation(userId);
  }


}
