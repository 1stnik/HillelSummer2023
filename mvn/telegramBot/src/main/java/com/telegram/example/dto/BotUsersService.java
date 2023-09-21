package com.telegram.example.dto;

import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BotUsersService {

    private Set<Long> users = new HashSet<>();

    public boolean addUser(Long id){
        log.info("add new user with id {}", id);
        return users.add(id);
    }

    public Set<Long> getUsers(){
        return users;
    }

    public boolean isUserExist(Long id){
        return users.contains(id);
    }



}
