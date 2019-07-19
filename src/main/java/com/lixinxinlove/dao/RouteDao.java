package com.lixinxinlove.dao;


import com.lixinxinlove.entity.Route;

import java.util.List;

/**
 * 旅游路线
 */
public interface RouteDao {

    int findTotalCount(int cid);

    List<Route> findByPage(int cid, int start, int pageSize);
}
