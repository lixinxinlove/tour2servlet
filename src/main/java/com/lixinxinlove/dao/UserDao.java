package com.lixinxinlove.dao;

import com.lixinxinlove.entity.User;

public interface UserDao {

    User findByUsername(String username);

    User findByCode(String code);

    int insert(User user);

    int updateStatus(User user);


}
