package com.example.ssm.service.impl;

import com.example.ssm.domain.User;
import com.example.ssm.repository.UserMapper;
import com.example.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public int getUser(User user) {
        return userMapper.saveUser(user);
    }



    @Override
    public User userlogin(User user) {
        return userMapper.selectUser(user);
    }

    @Override
    public int findUserCount() {
        return userMapper.findUserCount();
    }

    @Override
    public List<User> showPage(int start, int pageSize) {
        return userMapper.showPage(start,pageSize);
    }

    @Override
    public int deleteUser(User user) {
       return userMapper.deleteById(user);
    }
}
