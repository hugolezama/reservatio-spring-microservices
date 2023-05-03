package com.reservatio.bookingservice.mapper;

import com.reservatio.bookingservice.domain.Reservation;
import com.reservatio.bookingservice.dto.ReservationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapper extends EntityMapper<ReservationDto, Reservation> {

  ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

}