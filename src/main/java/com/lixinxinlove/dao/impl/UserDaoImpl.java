package com.lixinxinlove.dao.impl;

import com.lixinxinlove.dao.UserDao;
import com.lixinxinlove.entity.User;
import com.lixinxinlove.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {


    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            String sql = "select * from tab_user where username=?";
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByCode(String code) {
        User user = null;
        try {
            String sql = "select * from tab_user where code=?";
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int insert(User user) {

        String sql = "insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code) value(?,?,?,?,?,?,?,?,?)";
        int i = jdbcTemplate.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode()
        );

        return i;
    }

    @Override
    public int updateStatus(User user) {
        String sql = "update tab_user set status='Y' where uid=?";
        int i = jdbcTemplate.update(sql, user.getUid());
        return i;
    }

}
