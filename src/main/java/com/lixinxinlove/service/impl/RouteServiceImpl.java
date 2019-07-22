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
    public PageEntity<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {
        //封装PageBean
        PageEntity<Route> pb = new PageEntity<>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);

        //设置总记录数
        int totalCount = routeDao.findTotalCount(cid,rname);
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int start = (currentPage - 1) * pageSize;//开始的记录数
        List<Route> list = routeDao.findByPage(cid,start,pageSize,rname);
        pb.setList(list);

        //设置总页数 = 总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize :(totalCount / pageSize) + 1 ;
        pb.setTotalPage(totalPage);


        return pb;
    }

    @Override
    public Route findOne(String rid) {
        return null;
    }
}
