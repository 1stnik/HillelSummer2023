package lesson_07.HW.service.impl;

import lesson_07.HW.dto.User;
import lesson_07.HW.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void print(User[] users) {
        for (User u : users) System.out.println(u);
    }
}
