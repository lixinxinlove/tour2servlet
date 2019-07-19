package com.lixinxinlove.dao.impl;

import com.lixinxinlove.dao.RouteDao;
import com.lixinxinlove.entity.Route;
import com.lixinxinlove.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


/**
 * Route
 */
public class RouteDaoImpl implements RouteDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount(int cid) {
        String sql = "select count(*) from tab_route where cid=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, cid);
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize) {

        String sql = "select * from tab_route where cid=? limit ?,?";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Route.class), cid, start, pageSize);
    }


}
