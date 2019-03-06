package com.example.ssm.service;

import com.example.ssm.domain.User;

import java.util.List;

public interface UserService {
    int getUser(User user);


    User userlogin(User user);
    int findUserCount();
    List<User> showPage(int start,int pageSize);
    int deleteUser(User user);
}
