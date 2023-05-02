package com.reservatio.userservice.controller;

import com.reservatio.userservice.dto.UserDto;
import com.reservatio.userservice.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @Value("${test.property}")
  String testProperty;

  @GetMapping
  public ResponseEntity<List<UserDto>> getAll() {

    log.info("testProperty: {}", testProperty);
    return ResponseEntity.ok(userService.listUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getById(@PathVariable("id") Long userId) {
    return ResponseEntity.ok(userService.getUserById(userId));
  }

  @PostMapping
  public ResponseEntity<UserDto> save(@RequestBody @Valid UserDto user) {
    UserDto saved = userService.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }

}
