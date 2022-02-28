package com.zzmax.cookie_session_learn;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet(name = "SessionDemo1", value = "/SessionDemo1")
@Slf4j
public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取session对象
        HttpSession httpSession = request.getSession();

        //打印session
        log.info(String.valueOf(httpSession));

        //存储数据
        httpSession.setAttribute("username","张三");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
