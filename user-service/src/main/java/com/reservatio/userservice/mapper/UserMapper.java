package com.reservatio.userservice.mapper;

import com.reservatio.userservice.dto.UserDto;
import com.reservatio.userservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends EntityMapper<UserDto, User> {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

}