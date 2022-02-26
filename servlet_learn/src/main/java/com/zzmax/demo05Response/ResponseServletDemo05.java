package com.zzmax.demo05Response;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/responseDemo05")
public class ResponseServletDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String info = "javaWeb的开发1";

        response.setContentType("text/plain;charset=utf-8");

        OutputStream outputStream = response.getOutputStream();
        outputStream.write(info.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
