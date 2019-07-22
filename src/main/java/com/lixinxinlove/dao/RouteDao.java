package com.lixinxinlove.dao;


import com.lixinxinlove.entity.Route;

import java.util.List;

/**
 * 旅游路线
 */
public interface RouteDao {

    int findTotalCount(int cid);

    /**
     * 根据cid查询总记录数
     */
    int findTotalCount(int cid, String rname);

    List<Route> findByPage(int cid, int start, int pageSize);

    /**
     * 根据cid，start,pageSize查询当前页的数据集合
     */
    List<Route> findByPage(int cid, int start, int pageSize, String rname);

    /**
     * 根据id查询
     *
     * @param rid
     * @return
     */
    Route findOne(String rid);
}
