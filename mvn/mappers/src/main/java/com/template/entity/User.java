package com.template.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {
    String firstName;
    String lastName;
    String fullName;
    String mobilePhone;
    String login;
    String password;
}
