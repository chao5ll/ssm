package com.example.ssm.repository;

import com.example.ssm.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface UserMapper {
    int saveUser(User user);
    User selectUser(User user);
    int findUserCount();
    List<User> showPage(int start,int pageSize);
    int deleteById(User user);
}
