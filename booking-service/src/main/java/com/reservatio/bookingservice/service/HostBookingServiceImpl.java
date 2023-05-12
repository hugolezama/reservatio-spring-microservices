package com.reservatio.bookingservice.service;

import com.reservatio.bookingservice.domain.HostOffice;
import com.reservatio.bookingservice.dto.ReservationDto;
import com.reservatio.bookingservice.mapper.ReservationMapper;
import com.reservatio.bookingservice.repository.HostOfficeRepository;
import com.reservatio.bookingservice.repository.ReservationRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class HostBookingServiceImpl implements HostBookingService {

  private static final ReservationMapper mapper = ReservationMapper.INSTANCE;
  private final ReservationRepository reservationRepository;
  private final HostOfficeRepository hostOfficeRepository;

  @Override
  public List<ReservationDto> listReservations(UUID hostId) {
    List<HostOffice> hostOffices = hostOfficeRepository.findByHostId(hostId).orElseThrow();
    List<Long> officeIds = hostOffices.stream().map(HostOffice::getOfficeId).toList();
    return mapper.toDto(reservationRepository.findByOfficeIdIn(officeIds).orElseThrow());
  }

  @Override
  public ReservationDto getReservationById(UUID hostId, UUID reservationId) {
    return null;
  }
}
