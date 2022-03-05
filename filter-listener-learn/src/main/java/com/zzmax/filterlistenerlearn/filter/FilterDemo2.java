package com.zzmax.filterlistenerlearn.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class FilterDemo2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器1初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("4444444");
        // 放行
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("5555555");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器1销毁");
    }
}
