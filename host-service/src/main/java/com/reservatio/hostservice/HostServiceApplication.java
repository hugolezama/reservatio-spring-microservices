package com.reservatio.hostservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HostServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(HostServiceApplication.class, args);
  }

}
