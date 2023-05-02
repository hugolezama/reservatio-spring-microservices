package com.reservatio.userservice.service;

import com.reservatio.userservice.dto.UserDto;
import java.util.List;

public interface UserService {

  List<UserDto> listUsers();

  UserDto getUserById(Long userId);

  UserDto save(UserDto user);
}
