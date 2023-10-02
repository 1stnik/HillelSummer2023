package com.template.mapper;

import com.template.dto.UserDto;
import com.template.entity.User;

public class ObjectMapper {

    public User fromDto (UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .fullName(userDto.getFirstName() + " " + userDto.getLastName())
                .mobilePhone(userDto.getPhone())
                .login(userDto.getEmail())
                .build();
    }

}
