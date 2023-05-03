package com.reservatio.bookingservice.service;

import com.reservatio.bookingservice.dto.AvailableCity;
import com.reservatio.bookingservice.dto.AvailableCityDto;
import java.time.LocalDate;
import java.util.List;

public interface BookingService {

  List<AvailableCityDto> searchAvailableOffices(LocalDate startDate, LocalDate endDate, Long propertyId, AvailableCity city);

}
