package com.zzmax.cookie_session_learn;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletA", value = "/ServletA")
public class ServletA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 发送cookie
        // 1.创建cookie对象
        Cookie cookie = new Cookie("username","zzmax");
        // 2.对cookie持久化
        cookie.setMaxAge(60 * 60 * 24 * 7);
        // 3.通过response发送cookie
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
