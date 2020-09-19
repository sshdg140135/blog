package com.wm.service;

import com.wm.po.User;

public interface UserService {
    User login(User user);
    User login2(String username);
}
