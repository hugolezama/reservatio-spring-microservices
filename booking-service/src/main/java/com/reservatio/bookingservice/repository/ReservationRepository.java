package com.reservatio.bookingservice.repository;

import com.reservatio.bookingservice.domain.Reservation;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

  Optional<Reservation> findByReservationIdAndUserId(UUID reservationId, UUID userId);

  Optional<List<Reservation>> findByUserId(UUID userId);

  Optional<List<Reservation>> findByOfficeIdIn(List<Long> officeIds);


}
