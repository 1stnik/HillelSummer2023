package com.hillel.lesson_14.steams;

import com.hillel.lesson_14.streamExample.businessObject.User;
import com.hillel.lesson_14.streamExample.businessObject.service.UserService;
import java.util.List;
import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        List<Optional> otp  = UserService.getOtpUserList();
        List<User> user = UserService.getUserList();
        user.set(10, null);
        System.out.println(otp);

        user.stream().filter(u -> u.getAge() > 15).forEach(System.out::println);
    }
}
