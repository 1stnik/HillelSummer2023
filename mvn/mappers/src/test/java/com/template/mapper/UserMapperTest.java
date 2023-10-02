package com.template.mapper;

import static org.junit.jupiter.api.Assertions.*;

import com.template.dto.UserDto;
import com.template.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserMapperTest {

    @Test
    void testMapiing(){
        UserMapper userMapper = new UserMapperImpl();

        UserDto dto = UserDto.builder()
                .firstName("Oleksandr")
                .lastName("Stepurko")
                .email("email@email.com")
                .phone("050694569")
                .build();

        User user = userMapper.fromDto(dto);

        Assertions.assertNotNull(user);
        Assertions.assertEquals(dto.getFirstName(), user.getFirstName());
        Assertions.assertEquals(dto.getLastName(), user.getLastName());
        Assertions.assertEquals(dto.getFirstName() + " " + user.getLastName(), user.getFullName());
        Assertions.assertEquals(dto.getPhone(), user.getMobilePhone());
        Assertions.assertEquals(dto.getEmail(), user.getLogin());
        Assertions.assertNull(user.getPassword());
    }

}
