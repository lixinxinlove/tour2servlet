package com.lixinxinlove.service.impl;

import com.lixinxinlove.dao.RouteDao;
import com.lixinxinlove.dao.impl.RouteDaoImpl;
import com.lixinxinlove.entity.PageEntity;
import com.lixinxinlove.entity.Route;
import com.lixinxinlove.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {


    private RouteDao routeDao = new RouteDaoImpl();

    @Override
    public PageEntity<Route> pageQuery(int cid, int currentPage, int pageSize) {

        PageEntity<Route> pageEntity = new PageEntity<>();
        pageEntity.setCurrentPage(currentPage);

        int totalCount = routeDao.findTotalCount(cid);

        pageEntity.setTotalCount(totalCount);

        //开始的位置
        int start = (currentPage - 1) * pageSize;

        List<Route> routeList = routeDao.findByPage(cid, start, pageSize);
        pageEntity.setList(routeList);


        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize + 1);
        pageEntity.setTotalPage(totalPage);

        return pageEntity;
    }

    @Override
    public PageEntity<Route> pageQuery(int cid, int currentPage, int pageSize, String cname) {
        return null;
    }

    @Override
    public Route findOne(String rid) {
        return null;
    }
}
