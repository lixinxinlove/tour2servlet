package com.lixinxinlove.dao.impl;


import com.lixinxinlove.dao.CategoryDao;
import com.lixinxinlove.entity.Category;
import com.lixinxinlove.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Category> findAll() {
        String sql = "select * from tab_category ";
        return template.query(sql,new BeanPropertyRowMapper<>(Category.class));
    }
}
