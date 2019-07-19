package com.lixinxinlove.service;

import com.lixinxinlove.entity.PageEntity;
import com.lixinxinlove.entity.Route;

public interface RouteService {

    PageEntity<Route> pageQuery(int cid,int currentPage,int pageSize);

    PageEntity<Route> pageQuery(int cid,int currentPage,int pageSize,String cname);

    Route findOne(String rid);

}
