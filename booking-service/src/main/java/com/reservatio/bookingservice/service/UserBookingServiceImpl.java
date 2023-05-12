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
  public List<ReservationDto> listReservations(UUID userId) {
    return mapper.toDto(reservationRepository.findByUserId(userId)
        .orElseThrow());
  }

  @Override
  public ReservationDto getReservationById(UUID userId, UUID reservationId) {
    Reservation found = reservationRepository.findByReservationIdAndUserId(reservationId, userId)
        .orElseThrow();
    return mapper.toDto(found);
  }

  @Override
  public ReservationDto saveReservation(UUID userId, ReservationDto reservationDto) {
    return mapper.toDto(reservationRepository.save(mapper.toEntity(reservationDto.withUserId(userId))));
  }
}
