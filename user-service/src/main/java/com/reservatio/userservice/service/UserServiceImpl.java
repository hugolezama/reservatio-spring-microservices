package com.reservatio.userservice.service;

import com.reservatio.userservice.dto.UserDto;
import com.reservatio.userservice.entity.User;
import com.reservatio.userservice.mapper.UserMapper;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  public List<UserDto> listUsers() {
    List<User> users = Arrays.asList(
        User.builder()
            .id(1L).name("Hugo").email("hugo@mail.com")
            .build(),
        User.builder()
            .id(2L).name("Mia").email("mia@mail.com")
            .build(),
        User.builder()
            .id(3L).name("Leonel").email("leonel@mail.com")
            .build()
    );

    return UserMapper.INSTANCE.toDto(users);
  }

  public UserDto getUserById(Long userId) {
    return null;
  }

  public UserDto save(UserDto user) {
    return null;
  }
}
