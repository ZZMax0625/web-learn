package com.zzmax.exercise.web;

import com.zzmax.exercise.enerty.User;
import com.zzmax.exercise.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获得用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 是否勾选了记住我
        String remember = request.getParameter("remember");



        // 2.调用servive
        User user = userService.login(username, password);

        // 3.判断
        if (null != user){
            //非空

            //是否勾选了记住我
            if("on".equals(remember)){
                System.out.println("需要记录cookie");

                // 1.创建Cookie对象
                Cookie cUserName = new Cookie("username", username);
                Cookie cPassword = new Cookie("password", username);

                // 2.设置存活时间
                cUserName.setMaxAge(60*60*24*7);
                cPassword.setMaxAge(60*60*24*7);
                // 3.发送
                response.addCookie(cUserName);
                response.addCookie(cPassword);
            }

            // 将用户信息记在session中
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/index");

        }
        else {
            // 登陆失败
            request.setAttribute("msg","用户名或密码错误");
            // 转发
            request.getRequestDispatcher("result.jsp").forward(request,response);
        }

    }
}
