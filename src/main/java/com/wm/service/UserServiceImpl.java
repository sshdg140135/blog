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

    /**
     * 新的登录方法，配合shiro实现过滤
     * @return
     */
    @Override
    public User login2(String username) {
        return userMapper.findByUsername(username);
    }
}
