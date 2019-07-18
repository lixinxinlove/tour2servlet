package com.lixinxinlove.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lixinxinlove.entity.ResultInfo;
import com.lixinxinlove.entity.User;
import com.lixinxinlove.service.UserService;
import com.lixinxinlove.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //TODO 验证码校验


        Map<String, String[]> map = req.getParameterMap();

        User formUser = new User();

        try {
            BeanUtils.populate(formUser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        UserService userService = new UserServiceImpl();
        User user = userService.login(formUser);

        ResultInfo info = new ResultInfo();

        if (user == null) {
            //登录失败
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }

        if (user != null && !user.getStatus().equals("Y")) {
            info.setFlag(false);
            info.setErrorMsg("没有激活");
        }


        if (user != null && user.getStatus().equals("Y")) {
            req.getSession().setAttribute("user", user);
            info.setFlag(true);
        }

        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=utf-8");
        mapper.writeValue(resp.getOutputStream(), info);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
