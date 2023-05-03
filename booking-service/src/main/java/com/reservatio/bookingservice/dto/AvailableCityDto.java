package com.reservatio.bookingservice.dto;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;
import lombok.Builder;
import lombok.With;

@With
@Builder
public record AvailableCityDto(
    Long officeId,
    List<LocalTime> availableTimes
) implements Serializable {

}
