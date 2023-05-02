package com.reservatio.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.Builder;
import lombok.With;

@With
@Builder
public record UserDto(
    Long id,
    String name,
    @Email
    @NotNull
    @NotEmpty
    String email
) implements Serializable {

}
