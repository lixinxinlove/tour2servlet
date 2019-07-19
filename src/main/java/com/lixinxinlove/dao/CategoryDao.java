package com.lixinxinlove.dao;


import com.lixinxinlove.entity.Category;

import java.util.List;

public interface CategoryDao {
    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll();
}
