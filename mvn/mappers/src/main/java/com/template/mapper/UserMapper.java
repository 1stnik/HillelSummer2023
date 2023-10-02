package com.template.mapper;

import com.template.dto.UserDto;
import com.template.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "mobilePhone", source = "phone")
    @Mapping(target = "login", source = "email")
    @Mapping(target = "fullName", expression = "java(getFullName(userDto))")
    User fromDto (UserDto userDto);

    UserDto fromEntity(User user);

    default String getFullName(UserDto user) {
        return user.getFirstName() + " " + user.getLastName();
    }

}
