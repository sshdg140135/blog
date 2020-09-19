package com.wm.mapper;

import com.wm.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUsernameAndPassword(User user);

    User findByUsername(String name);
}
