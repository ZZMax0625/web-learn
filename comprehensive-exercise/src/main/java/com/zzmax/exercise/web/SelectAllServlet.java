package com.zzmax.exercise.web;

import com.alibaba.fastjson.JSON;
import com.zzmax.exercise.enerty.Brand;
import com.zzmax.exercise.service.BrandService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/SelectAllServlet")
public class SelectAllServlet extends HttpServlet {

    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 调用Service查询
        List<Brand> brands = brandService.selectAll();
        // 2. 将集合转换为JSON数据->序列化
        String jsonString = JSON.toJSONString(brands);
        // 3. 响应数据 application/json
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
