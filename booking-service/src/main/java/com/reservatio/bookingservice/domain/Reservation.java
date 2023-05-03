package com.reservatio.bookingservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reservation {

  @Id
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @GeneratedValue(generator = "UUID")
  private UUID reservationId;
  private Long userId;
  private Long officeId;
  private LocalDate date;
  private LocalTime startTime;
  private LocalTime endTime;
  @Enumerated(value = EnumType.STRING)
  private ReservationStatusEnum status;

}
