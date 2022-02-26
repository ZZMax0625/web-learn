package com.zzmax.servletContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 *  功能：
 *  获取mime对象
 *  共享数据
 *  获取服务器的真实路径
 */
@WebServlet(urlPatterns = "/context03")
public class ServletContext03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jakarta.servlet.ServletContext context = this.getServletContext();

        Person person = new Person("zzmax",21);
        context.setAttribute("person",person);

        resp.sendRedirect("/demo05_war_exploded/TestServlet");
    }
}
