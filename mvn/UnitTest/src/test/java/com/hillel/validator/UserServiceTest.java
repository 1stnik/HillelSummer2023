package com.hillel.validator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class UserServiceTest {

    @Test
    void getFullname() {
        People user= new People("1", "2");
        assertEquals("1 2", new UserService(new UserCalculate()).getFullname(user));
    }

    @Test
    void getFullnameMock() {
        UserCalculate uc = mock(UserCalculate.class);
        when(uc.calculateFullName(any(), any())).thenReturn("alex");
        People user= new People("1", "2");
        assertEquals("alex", new UserService(uc).getFullname(user));
    }

    @Test
    void getFullnameMock_1() {
        UserCalculate uc = mock(UserCalculate.class);
        when(uc.calculateFullName(any(), any())).thenReturn("alex");
        when(uc.calculateFullName(eq("Alex"), any())).thenReturn("Oleksandr");
        People user= new People("1", "2");
        assertEquals("alex", new UserService(uc).getFullname(user));
         user= new People("Alex", "2");
        assertEquals("Oleksandr", new UserService(uc).getFullname(user));
    }
}
