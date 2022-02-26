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
@WebServlet(urlPatterns = "/context02")
public class ServletContext02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jakarta.servlet.ServletContext context2 = this.getServletContext();

        String fileName = "test.exe";

        String mimeType = context2.getMimeType(fileName);

        System.out.println(mimeType);

    }
}
