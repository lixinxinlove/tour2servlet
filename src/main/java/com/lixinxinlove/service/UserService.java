package com.lixinxinlove.service;

import com.lixinxinlove.entity.User;

public interface UserService {
    boolean register(User user);

    boolean active(String code);
}
