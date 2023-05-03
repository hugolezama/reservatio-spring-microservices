package com.reservatio.bookingservice.dto;

import com.reservatio.bookingservice.domain.ReservationStatusEnum;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
import lombok.Builder;
import lombok.With;

@With
@Builder
public record ReservationDto(
    UUID reservationId,
    Long userId,
    Long officeId,
    LocalDate date,
    LocalTime startTime,
    LocalTime endTime,
    ReservationStatusEnum status
) implements Serializable {

}
