package com.hillel.validator;

public class UserService {

    private UserCalculate uc;

    public UserService(UserCalculate uc) {
        this.uc = uc;
    }

    public String getFullname(People people){
        System.out.println("run getFullname");
        return uc.calculateFullName(people.getFirstName(), people.getLastName());
    }

}
