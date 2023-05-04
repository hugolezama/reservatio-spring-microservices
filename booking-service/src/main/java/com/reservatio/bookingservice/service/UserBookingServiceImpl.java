package com.reservatio.bookingservice.service;

import com.reservatio.bookingservice.domain.Reservation;
import com.reservatio.bookingservice.dto.ReservationDto;
import com.reservatio.bookingservice.mapper.ReservationMapper;
import com.reservatio.bookingservice.repository.ReservationRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserBookingServiceImpl implements UserBookingService {

  private static final ReservationMapper mapper = ReservationMapper.INSTANCE;
  private final ReservationRepository reservationRepository;

  @Override
  public List<ReservationDto> listReservations(String userId) {
    return mapper.toDto(reservationRepository.findByUserId(UUID.fromString(userId))
        .orElseThrow());
  }

  @Override
  public ReservationDto getReservationById(String userId, String reservationId) {
    Reservation found = reservationRepository.findByReservationIdAndUserId(UUID.fromString(reservationId), UUID.fromString(userId))
        .orElseThrow();
    return mapper.toDto(found);
  }

  @Override
  public ReservationDto saveReservation(String userId, ReservationDto reservationDto) {
    return mapper.toDto(reservationRepository.save(mapper.toEntity(reservationDto.withUserId(UUID.fromString(userId)))));
  }
}
