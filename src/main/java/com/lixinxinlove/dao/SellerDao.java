package com.lixinxinlove.dao;


import com.lixinxinlove.entity.Seller;

public interface SellerDao {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Seller findById(int id);
}
