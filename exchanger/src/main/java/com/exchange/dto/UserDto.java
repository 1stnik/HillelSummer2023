package com.exchange.dto;

import com.exchange.model.User;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private Date dateOfBirth;
    private boolean active;

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .id(user.getId())
                .fullName(user.getFirstName().concat(" ").concat(user.getLastName()))
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .dateOfBirth(user.getDateOfBirth())
                .active(user.isStatus())
                .build();


    }
}
