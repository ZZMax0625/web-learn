package com.zzmax.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 *  获取文件的真实路径（服务器端路径，非客户端）
 */
@WebServlet(urlPatterns = "/path")
public class ServletContextDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.得到ServletContext对象
        ServletContext servletContext = this.getServletContext();
        //2.webapp目录资源访问
        String bPath = servletContext.getRealPath("/b.txt");
        System.out.println(bPath);
        //3.web-inf下的
        String cPath = servletContext.getRealPath("/WEB-INF/c.txt");
        System.out.println(cPath);
        // src目录或子目录的资源访问
        String aPath = servletContext.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(aPath);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
