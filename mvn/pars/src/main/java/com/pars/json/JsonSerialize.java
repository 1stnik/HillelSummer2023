package com.pars.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pars.User;
import com.pars.UserExt;
import com.pars.UserLittle;


public class JsonSerialize {
    public static void main(String[] args) throws JsonProcessingException {
        User user = new User().setFirstName("Alex").setLastName("Stepurko").setAge(33);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        UserLittle us = objectMapper.readValue(objectMapper.writeValueAsString(user), UserLittle.class);

        System.out.println(us);

    }
}
