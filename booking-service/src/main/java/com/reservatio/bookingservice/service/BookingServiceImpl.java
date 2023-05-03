package com.reservatio.bookingservice.service;

import com.reservatio.bookingservice.dto.AvailableCity;
import com.reservatio.bookingservice.dto.AvailableCityDto;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {

  public List<AvailableCityDto> searchAvailableOffices(LocalDate startDate, LocalDate endDate, Long propertyId, AvailableCity city) {
    return null;
  }
}
