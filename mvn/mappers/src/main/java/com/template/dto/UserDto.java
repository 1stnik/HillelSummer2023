package com.template.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {
    String firstName;
    String lastName;
    String phone;
    String email;
}
