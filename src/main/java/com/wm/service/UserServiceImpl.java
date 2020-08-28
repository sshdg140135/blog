package com.wm.service;

import com.wm.mapper.UserMapper;
import com.wm.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        User user1 = userMapper.findByUsernameAndPassword(user);
        return user1;
    }
}
