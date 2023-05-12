package com.reservatio.bookingservice.repository;

import com.reservatio.bookingservice.domain.HostOffice;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostOfficeRepository extends JpaRepository<HostOffice, Long> {

  Optional<List<HostOffice>> findByHostId(UUID userId);

}
