package com.zzmax.exercise.service;

import com.zzmax.exercise.enerty.User;
import org.junit.Test;


public  class UserServiceTest {

    @Test
    public void login() {
        UserService userService = new UserService();
        User user = userService.login("lisi","234");
        System.out.println(user);
    }
}