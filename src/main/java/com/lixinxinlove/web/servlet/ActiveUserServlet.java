package com.lixinxinlove.web.servlet;

import com.lixinxinlove.service.UserService;
import com.lixinxinlove.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/activeUser")
public class ActiveUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String code = req.getParameter("code");
        if (code != null) {
            UserService userService = new UserServiceImpl();
            boolean flag = userService.active(code);
            String msg;
            if (flag) {
                //激活成功
                msg = "激活成功，请<a href='login.html'>登录</a>";
            } else {
                msg = "激活失败";
            }

            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write(msg);
        }


    }

}



