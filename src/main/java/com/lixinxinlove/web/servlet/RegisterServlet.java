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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 用户注册
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ResultInfo info = new ResultInfo();
        ObjectMapper mapper = new ObjectMapper();

        //判断验证码
        String check = request.getParameter("check");

        HttpSession session = request.getSession();
        String checkServer = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");

        if (!check.equalsIgnoreCase(checkServer)) {
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }


        Map<String, String[]> map = request.getParameterMap();
        User user = new User();

        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(user.toString());


        UserService userService = new UserServiceImpl();


        boolean flag = userService.register(user);

        if (flag) {
            info.setFlag(true);

        } else {
            info.setFlag(false);
            info.setErrorMsg("用户有");
        }

        String json = mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

}
