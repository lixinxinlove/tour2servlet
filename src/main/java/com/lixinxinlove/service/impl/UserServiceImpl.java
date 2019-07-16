package com.lixinxinlove.service.impl;

import com.lixinxinlove.dao.UserDao;
import com.lixinxinlove.dao.impl.UserDaoImpl;
import com.lixinxinlove.entity.User;
import com.lixinxinlove.service.UserService;
import com.lixinxinlove.utils.MailUtils;
import com.lixinxinlove.utils.UuidUtil;

public class UserServiceImpl implements UserService {


    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean register(User user) {

        User user1 = userDao.findByUsername(user.getUsername());
        if (user1 != null) {
            return false;
        }

        user.setCode(UuidUtil.getUuid());
        user.setStatus("N");
        userDao.insert(user);
        String content = "<a href='http://localhost/lee/activeUser?code=" + user.getCode() + "'>点击激活</a>";
        MailUtils.sendMail(user.getEmail(), content, "激活邮件");
        return true;
    }

    @Override
    public boolean active(String code) {
        if (code.isEmpty()) {
            return false;
        }
        User user = userDao.findByCode(code);
        if (user != null) {
            userDao.updateStatus(user);
            return true;
        }
        return false;
    }


}
