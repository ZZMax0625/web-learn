package com.zzmax.exercise.web;

import java.io.*;
import java.util.List;

import com.zzmax.exercise.enerty.Brand;
import com.zzmax.exercise.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 调用BrandService完成查询
        List<Brand> brands = brandService.selectAll();
        //2. 存入request域中
        request.setAttribute("brands", brands);
        //3. 转发到brand.jsp
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}