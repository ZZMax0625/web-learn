package com.zzmax.demo05Response;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/responseDemo01")
public class ResponseServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("responseDemo01");
        // 1.设置状态码 302 重定向
//        response.setStatus(302);
//
//        request.setAttribute("msg","hello response");
//
//        response.setHeader("location","/demo05_war_exploded/responseDemo03");
        // 2.设置响应头
//        response.setHeader("location","https://www.baidu.com");
//        // 简单的写法，重定向，可以跨域
//        response.sendRedirect("https://www.baidu.com");
//        response.setHeader("msg","hello");
//        // page->request->session->application
        request.setAttribute("msg","hello response");
        request.getRequestDispatcher("responseDemo03").forward(request,response);
    }
}
